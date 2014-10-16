package health_information.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordHandle
{
	// 运行时的Word程序
	private ActiveXComponent app;
	// word对象
	private Dispatch documents;
	// 当前的word文档
	private Dispatch doc;
	// 当前光标位置
	private Dispatch cursor;
	// 当前文档是否只读
	private boolean readOnly;
	// 当前文档中所有表格
	private Dispatch tables;
	// 当前所在表格
	private Dispatch table;
	private int count;

	public WordHandle()
	{
		////打开注册表收索  progId 找到wps对应的progId！！！！
//		this.app = new ActiveXComponent("WPS.Document.6");
//		this.app = new ActiveXComponent("KWPS.Document.9");
//		this.app = new ActiveXComponent("KWPS.Application.9");
		this.app = new ActiveXComponent("Word.Application.11");
//		this.app = new ActiveXComponent("Word.Application");
		this.app.setProperty("Visible", new Variant(false)); // 设置word不可见
		documents = this.app.getProperty("Documents").toDispatch();
		this.doc = null;
		this.cursor = null;
		this.readOnly = true;
		this.count = 0;
	}

	public boolean open(String fileName, boolean readOnly) throws Exception
	{
		if (doc != null)
		{
			System.out.println("当前文件未关闭");
			return false;
		}
		this.doc = Dispatch.invoke(this.documents, "Open", Dispatch.Method, new Object[] { fileName, new Variant(false), new Variant(readOnly) }, new int[1]).toDispatch();
		this.cursor = app.getProperty("Selection").toDispatch();
		this.tables = Dispatch.get(this.doc, "Tables").toDispatch();
		this.readOnly = readOnly;
		this.count = Dispatch.get(Dispatch.get(this.doc, "Words").toDispatch(), "Count").getInt() - 1;
		System.out.println("打开文件" + fileName + (readOnly ? " ReadOnly" : " Writable") +"-------字数:"+count);
		return true;
	}

	public boolean newFile() throws Exception
	{
		if (doc != null)
		{
			System.out.println("当前文件未关闭");
			return false;
		}
		this.doc = Dispatch.call(this.documents, "Add").toDispatch();
		this.readOnly = false;
		this.cursor = app.getProperty("Selection").toDispatch();
		this.tables = Dispatch.get(this.doc, "Tables").toDispatch();
		System.out.println("新建word文档");
		return true;
	}

	public boolean close()
	{
		String fileName = null;
		if (this.doc != null)
		{
			try
			{
				fileName = Dispatch.get(this.doc, "Name").getString();
				Dispatch.call(this.doc, "Close", new Variant(false));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				this.doc = null;
			}
		}
		System.out.println("关闭文件 " + fileName);
		return true;
	}

	public boolean quit()
	{
		try
		{
			this.app.invoke("Quit", new Variant[] {});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("退出word");
		return true;
	}

	public boolean saveAs(String fileName) throws Exception
	{
		if (this.doc == null)
		{
			System.out.println("当前无文件");
			return false;
		}
		else
		{
			Dispatch.call(this.doc, "SaveAs", fileName);
			System.out.println("另存为" + fileName);
			return true;
		}
	}

	public boolean save() throws Exception
	{
		if (this.doc == null)
		{
			System.out.println("当前无文档，无法保存");
			return false;
		}
		else
		{
			if (this.readOnly)
			{
				System.out.println("只读文档，保存失败");
				return false;
			}
			Dispatch.call(this.doc, "Save");
			System.out.println("保存完成");
			return true;
		}
	}

	public boolean moveRight(int steps) throws Exception
	{
		// int start = Dispatch.get(this.cursor, "Start").getInt();
		// Dispatch.put(this.cursor, "Start", start + steps);
		for (int i = 0; i < steps; i++)
		{
			Dispatch.call(cursor, "MoveRight");
		}
		return true;
	}

	public boolean moveLeft(int steps) throws Exception
	{
		for (int i = 0; i < steps; i++)
		{
			Dispatch.call(cursor, "MoveLeft");
		}
		return true;
	}

	public int search(String str) throws Exception
	{
		// 从cursor所在位置开始查询
		Dispatch find = Dispatch.call(this.cursor, "Find").toDispatch();
		// 设置要查找的内容
		Dispatch.put(find, "Text", str);
		// 向前查找
		Dispatch.put(find, "Forward", "True");
		// 设置格式
		Dispatch.put(find, "Format", "True");
		// 大小写匹配
		Dispatch.put(find, "MatchCase", "True");
		// 全字匹配
		Dispatch.put(find, "MatchWholeWord", "True");
		// 查找
		if (!Dispatch.call(find, "Execute").getBoolean())
			return 0;
		else
		{
			return Dispatch.get(this.cursor, "Start").getInt();
		}
	}

	public int searchOnly(String str) throws Exception
	{
		// 从cursor所在位置开始查询
		Dispatch find = Dispatch.call(this.cursor, "Find").toDispatch();
		// 设置要查找的内容
		Dispatch.put(find, "Text", str);
		// 向前查找
		Dispatch.put(find, "Forward", "True");
		// 大小写匹配
		Dispatch.put(find, "MatchCase", "True");
		// 全字匹配
		Dispatch.put(find, "MatchWholeWord", "True");
		if (!Dispatch.call(find, "Execute").getBoolean())
			return 0;
		else
		{
			int start = Dispatch.get(this.cursor, "Start").getInt();
			Dispatch.put(this.cursor, "End", this.count);
			// System.out.println(start);
			return start;
		}
	}

	public String getBetween(int start, int end) throws Exception
	{
		Dispatch range = Dispatch.get(this.cursor, "Range").toDispatch();
		Dispatch.call(range, "SetRange", start, end);
		return Dispatch.get(range, "Text").getString();
	}

	public String getLineAfter(int start) throws Exception
	{
		Dispatch.put(this.cursor, "Start", start);
		int length = Dispatch.call(this.cursor, "EndKey").getInt() + start;
		return getBetween(start, length);
	}

	public String getLine(int position) throws Exception
	{
		Dispatch.put(this.cursor, "Start", position);
		Dispatch.call(this.cursor, "SelectRow");
		int start = Dispatch.get(this.cursor, "Start").getInt();
		int end = Dispatch.get(this.cursor, "End").getInt();
		return getBetween(start, start + end);
	}

	public boolean gotoPage(int index) throws Exception
	{
		Dispatch.invoke(this.cursor, "Goto", Dispatch.Method, new Object[] { 1, 2, String.valueOf(index) }, new int[1]);
		// Dispatch.call(this.cursor, "GoTo", "wdGoToLine", "wdGoToNext",
		// String.valueOf(index), null);
		return true;
	}

	public int getCurrentCursor() throws Exception
	{
		return Dispatch.get(this.cursor, "Start").getInt();
	}

	public boolean setCursorMode() throws Exception
	{
		Dispatch.put(this.cursor, "End", Dispatch.get(this.cursor, "Start").getInt());
		return true;
	}

	public boolean gotoHome() throws Exception
	{
		Dispatch.put(this.cursor, "Start", 0);
		return true;
	}

	public boolean insert(int steps, String str) throws Exception
	{
		int start = Dispatch.get(this.cursor, "Start").getInt() + steps;
		Dispatch.put(this.cursor, "Start", start);
		Dispatch.call(this.cursor, "InsertBefore", str);
		// this.getCount();
		Dispatch.put(this.cursor, "Start", start + str.length());
		// System.out.println(Dispatch.get(this.cursor, "Start").getInt() +
		// "   " + (Dispatch.get(this.cursor,
		// "Start").getInt()+Dispatch.get(this.cursor, "End").getInt()));
		return true;
	}

	public boolean replace(String str) throws Exception
	{
		Dispatch.put(this.cursor, "Text", str);
		return true;
	}

	public int getTableNum() throws Exception
	{
		return Dispatch.get(this.tables, "Count").getInt();
	}

	public boolean setCurrentTable(int index) throws Exception
	{
		this.table = Dispatch.call(this.tables, "Item", new Variant(index)).toDispatch();
		Dispatch.call(this.table, "Select");
		return true;
	}

	public String getCell(int row, int col) throws Exception
	{
		Dispatch cell = Dispatch.call(table, "Cell", Integer.toString(row), Integer.toString(col)).toDispatch();
		Dispatch.call(cell, "Select");
		String tmp = Dispatch.get(this.cursor, "Text").getString();
		// System.out.println(".." + tmp);
		if (tmp.length() > 2)
		{
			return tmp.substring(0, tmp.length() - 2);
		}
		else
			return "";
	}

	public boolean replaceCell(int row, int col, String str) throws Exception
	{
		Dispatch cell = Dispatch.call(table, "Cell", Integer.toString(row), Integer.toString(col)).toDispatch();
		Dispatch.call(cell, "Select");
		Dispatch.put(this.cursor, "Text", str);
		return true;
	}
	
	
	 /** *//** 
     * 在当前文档指定的位置拷贝表格 
     *     
     * @param pos 当前文档指定的位置 
     * @param tableIndex 被拷贝的表格在word文档中所处的位置 
     */ 
    public void copyTable(String pos,int tableIndex) { 
            Dispatch tables = Dispatch.get(doc, "Tables").toDispatch(); 
            Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)) 
                            .toDispatch(); 
            Dispatch range = Dispatch.get(table, "Range").toDispatch(); 
            Dispatch.call(range, "Copy"); 
            Dispatch textRange = Dispatch.get(cursor, "Range").toDispatch(); 
            Dispatch.call(textRange, "Paste"); 
    } 
    
    /** *//** 
     * 从选定内容或插入点开始查找文本 
     *     
     * @param toFindText 要查找的文本 
     * @return boolean true-查找到并选中该文本，false-未查找到文本 
     */ 
    public boolean find(String toFindText) { 
            if (toFindText == null || toFindText.equals("")) 
                    return false; 
            // 从selection所在位置开始查询 
            Dispatch find = Dispatch.call(cursor, "Find").toDispatch(); 
            // 设置要查找的内容 
            Dispatch.put(find, "Text", toFindText); 
            // 向前查找 
            Dispatch.put(find, "Forward", "True"); 
            // 设置格式 
            Dispatch.put(find, "Format", "True"); 
            // 大小写匹配 
            Dispatch.put(find, "MatchCase", "True"); 
            // 全字匹配 
            Dispatch.put(find, "MatchWholeWord", "True"); 
            // 查找并选中 
            return Dispatch.call(find, "Execute").getBoolean(); 
    } 
    
    
    /** *//** 
     * 在当前插入点插入字符串 
     *     
     * @param newText 要插入的新字符串 
     */ 
    public void insertText(String newText) { 
            Dispatch.put(this.cursor, "Text", newText); 
    } 
    

	public static void main(String args[])
	{
		WordHandle word = new WordHandle();
		try
		{
			word.open("C:\\Users\\TangLi\\Desktop\\dd.docx", false);

			System.out.println(word.getTableNum());
			word.setCurrentTable(1);
//			word.replaceCell(1, 2, "old Name");
//			word.replaceCell(3, 1, "经营范围");
//			word.replaceCell(4, 2, "5654654747");
//			word.replaceCell(4, 4, "1111111111");
//
//			for(int i=  5;i <=18;i ++)
//			{
//				word.replaceCell(i, 2, "ddd"+"--"+i);
//			}
			
//			Dispatch textRange = Dispatch.get(word.cursor, "Range").toDispatch(); 
			
			for(int i = 0 ;i <10 ;i ++)
			{
				String tmp = Dispatch.get(word.cursor, "Text").getString();
				 Dispatch.call(word.cursor, "MoveDown"); // 游标往下一行 
				System.out.println(tmp);
//				 Dispatch.call(word.cursor, "MoveDown"); // 游标往下一行 
//				 Dispatch.call(word.cursor, "MoveDown"); // 游标往下一行 
//				 Dispatch.call(word.cursor, "MoveDown"); // 游标往下一行 
//				word.insertText("www");
//				Dispatch.call(word.cursor, "MoveUp"); // 游标往下一行 
//				Dispatch.call(word.cursor, "MoveUp"); // 游标往下一行 
//				word.copyTable("www",1);
			}
		  
			word.saveAs("C:\\Users\\TangLi\\Desktop\\cc.docx");
			word.close();
			word.quit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}