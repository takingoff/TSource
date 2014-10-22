package health_information.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 
 * 作用：利用jacob插件生成word 文件！
 * 
 * 
 */
public class DOCWriter
{
	
	
//	word
//	selection
//			range
//			MoveXXXX
//			TypeParagraph(回车)
//			HomeKey 文件首位置。
//			Find 查找器。
//				Execute 执行查找
//			Text 文本属性
//	documents
//		document
//			pageSetup
//			tables
//				table
//					cols
//						Count
//						clo
//							cell
//								Merge
//								Select
//					rows
//						Count
//						row
//							cell
//								Merge
//								Select
	

	/** 日志记录器 */
	static private Logger logger = Logger.getLogger(DOCWriter.class);

	/**
	 * word文档
	 * 
	 * 在本类中有两种方式可以进行文档的创建,<br>
	 * 第一种调用 createNewDocument 第二种调用 openDocument
	 */
	private Dispatch document = null;

	/** word运行程序对象 */
	private ActiveXComponent word = null;

	/** 所有word文档 */
	private Dispatch documents = null;

	/**
	 * Selection 对象 代表窗口或窗格中的当前所选内容。 所选内容代表文档中选定（或突出
	 * 
	 * 显示）的区域，如果文档中没有选定任何内容，则代表插入点。 每个文档窗格只能有一个Selection 对象，并且在整个应用程序中只能有一个活动的
	 * 
	 * Selection 对象。
	 */
	private Dispatch selection = null;

	/**
	 * 
	 * Range 对象 代表文档中的一个连续区域。 每个 Range 对象由一个起始字符位置和一个
	 * 
	 * 终止字符位置定义。 说明：与书签在文档中的使用方法类似，Range 对象在 Visual Basic 过程中用来标识文
	 * 
	 * 档的特定部分。 但与书签不同的是，Range对象只在定义该对象的过程运行时才存在。
	 * Range对象独立于所选内容。也就是说，您可以定义和处理一个范围而无需更改所选内
	 * 
	 * 容。还可以在文档中定义多个范围，但每个窗格中只能有一个所选内容。
	 */
	private Dispatch range = null;

	/**
	 * PageSetup 对象 该对象包含文档的所有页面设置属性（如左边距、下边距和纸张大小）
	 * 
	 * 。
	 */
	private Dispatch pageSetup = null;

	/** 文档中的所有表格对象 */
	private Dispatch tables = null;

	/** 一个表格对象 */
	private Dispatch table = null;

	/** 表格所有行对象 */
	private Dispatch rows = null;

	/** 表格所有列对象 */
	private Dispatch cols = null;

	/** 表格指定行对象 */
	private Dispatch row = null;

	/** 表格指定列对象 */
	private Dispatch col = null;

	/** 表格中指定的单元格 */
	private Dispatch cell = null;

	/** 字体 */
	private Dispatch font = null;

	/** 对齐方式 */
	private Dispatch alignment = null;

	/**
	 * 构造方法
	 */
	public DOCWriter()
	{

		if (this.word == null)
		{
			/* 初始化应用所要用到的对象实例 */
			this.word = new ActiveXComponent("Word.Application.11");
			// this.word = new ActiveXComponent("Word.Application");
			/* 设置Word文档是否可见，true-可见false-不可见 */
			this.word.setProperty("Visible", new Variant(true));
			/* 禁用宏 */
			// this.word.setProperty("AutomationSecurity", new Variant(3));
		}
		if (this.documents == null)
		{
			this.documents = word.getProperty("Documents").toDispatch();
		}
	}

	/**
	 * 打开文件
	 * 
	 * @param inputDoc
	 *            要打开的文件，全路径
	 * @return Dispatch 打开的文件
	 */
	public Dispatch openDocument(String inputDoc)
	{

		logger.debug("打开Word文档...");
		this.document = Dispatch.call(documents, "Open", inputDoc).toDispatch();
		this.getSelection();
		this.getRange();
		this.getAlignment();
		this.getFont();
		this.getPageSetup();
		return this.document;
	}

	/**
	 * 创建新的文件
	 * 
	 * @return Dispache 返回新建文件
	 */
	public Dispatch createNewDocument()
	{

		logger.debug("创建新的文件...");
		this.document = Dispatch.call(documents, "Add").toDispatch();
		this.getSelection();
		this.getRange();
		this.getPageSetup();
		this.getAlignment();
		this.getFont();
		return this.document;
	}

	/**
	 * 设置页面方向和页边距
	 * 
	 * @param orientation
	 *            可取值0或1，分别代表横向和纵向
	 * @param leftMargin
	 *            左边距的值
	 * @param rightMargin
	 *            右边距的值
	 * @param topMargin
	 *            上边距的值
	 * @param buttomMargin
	 *            下边距的值
	 */
	public void setPageSetup(int orientation, int leftMargin, int rightMargin, int topMargin, int

	buttomMargin)
	{

		logger.debug("设置页面方向和页边距...");
		if (this.pageSetup == null)
		{
			this.getPageSetup();
		}
		Dispatch.put(pageSetup, "Orientation", orientation);
		Dispatch.put(pageSetup, "LeftMargin", leftMargin);
		Dispatch.put(pageSetup, "RightMargin", rightMargin);
		Dispatch.put(pageSetup, "TopMargin", topMargin);
		Dispatch.put(pageSetup, "BottomMargin", buttomMargin);
	}

	/**
	 * 获得当前文档的文档页面属性
	 */
	public Dispatch getPageSetup()
	{

		logger.debug("获得当前文档的文档页面属性...");
		if (this.document == null)
		{
			logger.warn("document对象为空...");
			return this.pageSetup;
		}
		this.pageSetup = Dispatch.get(this.document, "PageSetup").toDispatch();
		return this.pageSetup;
	}

	/**
	 * 选定内容
	 * 
	 * @return Dispatch 选定的范围或插入点
	 */
	public Dispatch getSelection()
	{

		logger.debug("获取选定范围的插入点...");
		this.selection = word.getProperty("Selection").toDispatch();
		return this.selection;
	}

	/**
	 * 获取当前Document内可以修改的部分
	 * <p>
	 * <br>
	 * 前提条件：选定内容必须存在
	 * 
	 * @param selectedContent
	 *            选定区域
	 * @return 可修改的对象
	 */
	public Dispatch getRange()
	{

		logger.debug("获取当前Document内可以修改的部分...");
		this.range = Dispatch.get(this.selection, "Range").toDispatch();
		return this.range;
	}

	/**
	 * 把插入点移动到文件最底部
	 * 
	 */
	public void moveEnd()
	{
		logger.debug("把选定内容或插入点移向最底部...");
		if (selection == null)
			selection = Dispatch.get(word, "Selection").toDispatch();
		Dispatch.call(selection, "EndKey", new Variant(6));
	}

	/**
	 * 把选定内容或插入点向上移动
	 * 
	 * @param count
	 *            移动的距离
	 */
	public void moveUp(int count)
	{

		logger.debug("把选定内容或插入点向上移动...");
		for (int i = 0; i < count; i++)
		{
			Dispatch.call(this.selection, "MoveUp");
		}
	}

	/**
	 * 把选定内容或插入点向下移动
	 * 
	 * @param count
	 *            移动的距离
	 */
	public void moveDown(int count)
	{

		logger.debug("把选定内容或插入点向下移动...");
		for (int i = 0; i < count; i++)
		{
			Dispatch.call(this.selection, "MoveDown");
		}
	}

	/**
	 * 把选定内容或插入点向左移动
	 * 
	 * @param count
	 *            移动的距离
	 */
	public void moveLeft(int count)
	{

		logger.debug("把选定内容或插入点向左移动...");
		for (int i = 0; i < count; i++)
		{
			Dispatch.call(this.selection, "MoveLeft");
		}
	}

	/**
	 * 把选定内容或插入点向右移动
	 * 
	 * @param count
	 *            移动的距离
	 */
	public void moveRight(int count)
	{

		logger.debug("把选定内容或插入点向右移动...");
		for (int i = 0; i < count; i++)
		{
			Dispatch.call(this.selection, "MoveRight");
		}
	}

	/**
	 * 回车键
	 */
	public void enterDown(int count)
	{

		logger.debug("按回车键...");
		for (int i = 0; i < count; i++)
		{
			Dispatch.call(this.selection, "TypeParagraph");
		}
	}

	/**
	 * 把插入点移动到文件首位置
	 */
	public void moveStart()
	{

		logger.debug("把插入点移动到文件首位置...");
		Dispatch.call(this.selection, "HomeKey", new Variant(6));
	}

	/**
	 * 从选定内容或插入点开始查找文本
	 * 
	 * @param selection
	 *            选定内容
	 * @param toFindText
	 *            要查找的文本
	 * @return boolean true-查找到并选中该文本，false-未查找到文本
	 */
	public boolean find(String toFindText)
	{

		logger.debug("从选定内容或插入点开始查找文本" + " 要查找内容：  " + toFindText);
		/* 从selection所在位置开始查询 */
		Dispatch find = Dispatch.call(this.selection, "Find").toDispatch();
		/* 设置要查找的内容 */
		Dispatch.put(find, "Text", toFindText);
		/* 向前查找 */
		Dispatch.put(find, "Forward", "True");
		/* 设置格式 */
		Dispatch.put(find, "Format", "True");
		/* 大小写匹配 */
		Dispatch.put(find, "MatchCase", "True");
		/* 全字匹配 */
		Dispatch.put(find, "MatchWholeWord", "True");
		/* 查找并选中 */
		return Dispatch.call(find, "Execute").getBoolean();
	}

	/**
	 * 把选定内容替换为设定文本
	 * 
	 * @param selection
	 *            选定内容
	 * @param newText
	 *            替换为文本
	 */
	public void replace(String newText)
	{

		logger.debug("把选定内容替换为设定文本...");
		/* 设置替换文本 */
		Dispatch.put(this.selection, "Text", newText);
	}

	/**
	 * 全局替换
	 * 
	 * @param selection
	 *            选定内容或起始插入点
	 * @param oldText
	 *            要替换的文本
	 * @param replaceObj
	 *            替换为文本
	 */
	public void replaceAll(String oldText, Object replaceObj)
	{

		logger.debug("全局替换...");
		/* 移动到文件开头 */
		moveStart();
		/* 表格替换方式 */
		String newText = (String) replaceObj;
		/* 图片替换方式 */
		if (oldText.indexOf("image") != -1 || newText.lastIndexOf(".bmp") != -1 ||

		newText.lastIndexOf(".jpg") != -1 || newText.lastIndexOf(".gif") != -1)
		{
			while (find(oldText))
			{
				insertImage(newText);
				Dispatch.call(this.selection, "MoveRight");
			}
			/* 正常替换方式 */
		}
		else
		{
			while (find(oldText))
			{
				replace(newText);
				Dispatch.call(this.selection, "MoveRight");
			}
		}
	}

	/**
	 * 插入图片
	 * 
	 * @param selection
	 *            图片的插入点
	 * @param imagePath
	 *            图片文件（全路径）
	 */
	public void insertImage(String imagePath)
	{

		logger.debug("插入图片...");
		Dispatch.call(this.selection, "TypeParagraph");
		Dispatch.call(Dispatch.get(this.selection, "InLineShapes").toDispatch

		(), "AddPicture", imagePath);
	}

	/**
	 * 合并表格
	 * 
	 * @param selection
	 *            操作对象
	 * @param tableIndex
	 *            表格起始点
	 * @param fstCellRowIdx
	 *            开始行
	 * @param fstCellColIdx
	 *            开始列
	 * @param secCellRowIdx
	 *            结束行
	 * @param secCellColIdx
	 *            结束列
	 */
	public void mergeCell(int tableIndex, int fstCellRowIdx, int fstCellColIdx, int

	secCellRowIdx, int secCellColIdx)
	{

		logger.debug("合并单元格...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return;
		}
		Dispatch fstCell = Dispatch.call(table, "Cell", new Variant(fstCellRowIdx), new Variant

		(fstCellColIdx)).toDispatch();
		Dispatch secCell = Dispatch.call(table, "Cell", new Variant(secCellRowIdx), new Variant

		(secCellColIdx)).toDispatch();
		Dispatch.call(fstCell, "Merge", secCell);
	}

	/**
	 * 想Table对象中插入数值
	 * <p>
	 * 参数形式：ArrayList<String[]>List.size()为表格的总行数<br>
	 * String[]的length属性值应该与所创建的表格列数相同
	 * 
	 * @param selection
	 *            插入点
	 * @param tableIndex
	 *            表格起始点
	 * @param list
	 *            数据内容
	 */
	public void insertToTable(List<String[]> list)
	{

		System.out.println("向Table对象中插入数据...");
		logger.debug("向Table对象中插入数据...");
		if (list == null || list.size() <= 0)
		{
			logger.warn("写出数据集为空...");
			return;
		}
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return;
		}
		for (int i = 0; i < list.size(); i++)
		{
			String[] strs = list.get(i);
			for (int j = 0; j < strs.length; j++)
			{
				/* 遍历表格中每一个单元格，遍历次数与所要填入的内容数量相同 */
				Dispatch cell = this.getCell(i + 1, j + 1);
				/* 选中此单元格 */
				Dispatch.call(cell, "Select");
				/* 写出内容到此单元格中 */
				Dispatch.put(this.selection, "Text", strs[j]);
				/* 移动游标到下一个位置 */
			}
			this.moveDown(1);
		}
		this.enterDown(1);
	}

	/**
	 * 在文档中正常插入文字内容
	 * 
	 * @param selection
	 *            插入点
	 * @param list
	 *            数据内容
	 */
	public void insertToDocument(List<String> list)
	{

		logger.debug("向Document对象中插入数据...");
		if (list == null || list.size() <= 0)
		{
			logger.warn("写出数据集为空...");
			return;
		}
		if (this.document == null)
		{
			logger.warn("document对象为空...");
			return;
		}
		for (String str : list)
		{
			/* 写出至word中 */
			this.applyListTemplate(3, 2);
			Dispatch.put(this.selection, "Text", str);
			this.moveDown(1);
			this.enterDown(1);
		}
	}

	/**
	 * 创建新的表格
	 * 
	 * @param selection
	 *            插入点
	 * @param document
	 *            文档对象
	 * @param rowCount
	 *            行数
	 * @param colCount
	 *            列数
	 * @param width
	 *            边框数值 0浅色1深色
	 * @return 新创建的表格对象
	 */
	public Dispatch createNewTable(int rowCount, int colCount, int width)
	{

		logger.debug("创建新的表格...");
		if (this.tables == null)
		{
			this.getTables();
		}
		this.getRange();
		if (rowCount > 0 && colCount > 0)
		{
			this.table = Dispatch.call(this.tables, "Add", this.range, new Variant(rowCount), new

			Variant(colCount), new Variant(width)).toDispatch();
		}
		/* 返回新创建表格 */
		return this.table;
	}

	/**
	 * 获取Document对象中的所有Table对象
	 * 
	 * @return 所有Table对象
	 */
	public Dispatch getTables()
	{

		logger.debug("获取所有表格对象...");
		if (this.document == null)
		{
			logger.warn("document对象为空...");
			return this.tables;
		}
		this.tables = Dispatch.get(this.document, "Tables").toDispatch();
		return this.tables;
	}

	/**
	 * 获取Document中Table的数量
	 * 
	 * @return 表格数量
	 */
	public int getTablesCount()
	{

		logger.debug("获取文档中表格数量...");
		if (this.tables == null)
		{
			this.getTables();
		}
		return Dispatch.get(tables, "Count").getInt();

	}

	/**
	 * 获取指定序号的Table对象
	 * 
	 * @param tableIndex
	 *            Table序列
	 * @return
	 */
	public Dispatch getTable(int tableIndex)
	{

		logger.debug("获取指定表格对象...");
		if (this.tables == null)
		{
			this.getTables();
		}
		if (tableIndex >= 0)
		{
			this.table = Dispatch.call(this.tables, "Item", new Variant(tableIndex)).toDispatch();

		}
		return this.table;
	}

	/**
	 * 获取表格的总列数
	 * 
	 * @return 总列数
	 */
	public int getTableColumnsCount()
	{

		logger.debug("获取表格总行数...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return 0;
		}
		return Dispatch.get(this.cols, "Count").getInt();
	}

	/**
	 * 获取表格的总行数
	 * 
	 * @return 总行数
	 */
	public int getTableRowsCount()
	{

		logger.debug("获取表格总行数...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return 0;
		}
		return Dispatch.get(this.rows, "Count").getInt();
	}

	/**
	 * 获取表格列对象
	 * 
	 * @return 列对象
	 */
	public Dispatch getTableColumns()
	{

		logger.debug("获取表格行对象...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return this.cols;
		}
		this.cols = Dispatch.get(this.table, "Columns").toDispatch();
		return this.cols;
	}

	/**
	 * 获取表格的行对象
	 * 
	 * @return 总行数
	 */
	public Dispatch getTableRows()
	{

		logger.debug("获取表格总行数...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return this.rows;
		}
		this.rows = Dispatch.get(this.table, "Rows").toDispatch();
		return this.rows;
	}

	/**
	 * 获取指定表格列对象
	 * 
	 * @return 列对象
	 */
	public Dispatch getTableColumn(int columnIndex)
	{

		logger.debug("获取指定表格行对象...");
		if (this.cols == null)
		{
			this.getTableColumns();
		}
		if (columnIndex >= 0)
		{
			this.col = Dispatch.call(this.cols, "Item", new Variant(columnIndex)).toDispatch();
		}
		return this.col;
	}

	/**
	 * 获取表格中指定的行对象
	 * 
	 * @param rowIndex
	 *            行序号
	 * @return 行对象
	 */
	public Dispatch getTableRow(int rowIndex)
	{

		logger.debug("获取指定表格总行数...");
		if (this.rows == null)
		{
			this.getTableRows();
		}
		if (rowIndex >= 0)
		{
			this.row = Dispatch.call(this.rows, "Item", new Variant(rowIndex)).toDispatch();
		}
		return this.row;
	}

	/**
	 * 自动调整表格
	 */
	public void autoFitTable()
	{

		logger.debug("自动调整表格...");
		int count = this.getTablesCount();
		for (int i = 0; i < count; i++)
		{
			Dispatch table = Dispatch.call(tables, "Item", new Variant(i + 1)).toDispatch();
			Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
			Dispatch.call(cols, "AutoFit");
		}
	}

	/**
	 * 获取当前文档中，表格中的指定单元格
	 * 
	 * @param CellRowIdx
	 *            单元格所在行
	 * @param CellColIdx
	 *            单元格所在列
	 * @return 指定单元格对象
	 */
	public Dispatch getCell(int cellRowIdx, int cellColIdx)
	{

		logger.debug("获取当前文档中，表格中的指定单元格...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return this.cell;
		}
		if (cellRowIdx >= 0 && cellColIdx >= 0)
		{
			this.cell = Dispatch.call(this.table, "Cell", new Variant(cellRowIdx), new Variant

			(cellColIdx)).toDispatch();
		}
		return this.cell;
	}

	/**
	 * 设置文档标题
	 * 
	 * @param title
	 *            标题内容
	 */
	public void setTitle(String title)
	{

		logger.debug("设置文档标题...");
		if (title == null || "".equals(title))
		{
			logger.warn("文档标题为空...");
			return;
		}
		Dispatch.call(this.selection, "TypeText", title);
	}

	/**
	 * 设置当前表格线的粗细
	 * 
	 * @param width
	 *            width范围：1<w<13,如果是0，就代表没有框
	 */
	public void setTableBorderWidth(int width)
	{

		logger.debug("设置当前表格线的粗细...");
		if (this.table == null)
		{
			logger.warn("table对象为空...");
			return;
		}
		/*
		 * 设置表格线的粗细 1：代表最上边一条线 2：代表最左边一条线 3：最下边一条线 4
		 * 
		 * ：最右边一条线 5：除最上边最下边之外的所有横线 6：除最左边最右边之外的所有竖线 7：从左上角到右下角的斜线 8：从左下角到右上
		 * 
		 * 角的斜线
		 */
		Dispatch borders = Dispatch.get(table, "Borders").toDispatch();
		Dispatch border = null;
		for (int i = 1; i < 7; i++)
		{
			border = Dispatch.call(borders, "Item", new Variant(i)).toDispatch();
			if (width != 0)
			{
				Dispatch.put(border, "LineWidth", new Variant(width));
				Dispatch.put(border, "Visible", new Variant(true));
			}
			else if (width == 0)
			{
				Dispatch.put(border, "Visible", new Variant(false));
			}
		}
	}

	/**
	 * 对当前selection设置项目符号和编号
	 * 
	 * @param tabIndex
	 *            1: 项目编号 2: 编号 3: 多级编号 4: 列表样式
	 * @param index
	 *            0:表示没有 ,其它数字代表的是该Tab页中的第几项内容
	 */
	public void applyListTemplate(int tabIndex, int index)
	{

		logger.debug("对当前selection设置项目符号和编号...");
		/* 取得ListGalleries对象列表 */
		Dispatch listGalleries = Dispatch.get(this.word, "ListGalleries").toDispatch();
		/* 取得列表中一个对象 */
		Dispatch listGallery = Dispatch.call(listGalleries, "Item", new Variant

		(tabIndex)).toDispatch();
		Dispatch listTemplates = Dispatch.get(listGallery, "ListTemplates").toDispatch();
		if (this.range == null)
		{
			this.getRange();
		}
		Dispatch listFormat = Dispatch.get(this.range, "ListFormat").toDispatch();
		Dispatch.call(listFormat, "ApplyListTemplate", Dispatch.call(listTemplates, "Item", new

		Variant(index)), new Variant(true), new Variant(1), new Variant(0));
	}

	/**
	 * 增加文档目录
	 * 
	 * 目前采用固定参数方式，以后可以动态进行调整
	 */
	public void addTablesOfContents()
	{
		/* 取得ActiveDocument、TablesOfContents、range对象 */
		Dispatch ActiveDocument = word.getProperty("ActiveDocument").toDispatch();
		Dispatch TablesOfContents = Dispatch.get

		(ActiveDocument, "TablesOfContents").toDispatch();
		Dispatch range = Dispatch.get(this.selection, "Range").toDispatch();
		/* 增加目录 */
		Dispatch.call(TablesOfContents, "Add", range, new Variant(true), new Variant(1), new

		Variant(3), new Variant(true), new Variant(""), new Variant(true), new Variant(true));

	}

	/**
	 * 设置当前Selection 位置方式
	 * 
	 * @param selectedContent
	 *            0－居左；1－居中；2－居右。
	 */
	public void setAlignment(int alignmentType)
	{

		logger.debug("设置当前Selection 位置方式...");
		if (this.alignment == null)
		{
			this.getAlignment();
		}
		Dispatch.put(this.alignment, "Alignment", alignmentType);
	}

	/**
	 * 获取当前选择区域的对齐方式
	 * 
	 * @return 对其方式对象
	 */
	public Dispatch getAlignment()
	{

		logger.debug("获取当前选择区域的对齐方式...");
		if (this.selection == null)
		{
			this.getSelection();
		}
		this.alignment = Dispatch.get(this.selection, "ParagraphFormat").toDispatch();
		return this.alignment;
	}

	/**
	 * 获取字体对象
	 * 
	 * @return 字体对象
	 */
	public Dispatch getFont()
	{

		logger.debug("获取字体对象...");
		if (this.selection == null)
		{
			this.getSelection();
		}
		this.font = Dispatch.get(this.selection, "Font").toDispatch();
		return this.font;
	}

	/**
	 * 设置选定内容的字体 注：在调用此方法前，选定区域对象selection必须存在
	 * 
	 * @param fontName
	 *            字体名称，例如 "宋体"
	 * @param isBold
	 *            粗体
	 * @param isItalic
	 *            斜体
	 * @param isUnderline
	 *            下划线
	 * @param rgbColor
	 *            颜色，例如"255,255,255"
	 * @param fontSize
	 *            字体大小
	 * @param Scale
	 *            字符间距，百分比值。例如 70代表缩放为70%
	 */
	public void setFontScale(String fontName, boolean isBold, boolean isItalic, boolean

	isUnderline, String rgbColor, int Scale, int fontSize)
	{

		logger.debug("设置字体...");
		Dispatch.put(this.font, "Name", fontName);
		Dispatch.put(this.font, "Bold", isBold);
		Dispatch.put(this.font, "Italic", isItalic);
		Dispatch.put(this.font, "Underline", isUnderline);
		Dispatch.put(this.font, "Color", rgbColor);
		Dispatch.put(this.font, "Scaling", Scale);
		Dispatch.put(this.font, "Size", fontSize);
	}

	/**
	 * 保存文件
	 * 
	 * @param outputPath
	 *            输出文件（包含路径）
	 */
	public void saveAs(String outputPath)
	{

		logger.debug("保存文件...");
		if (this.document == null)
		{
			logger.warn("document对象为空...");
			return;
		}
		if (outputPath == null || "".equals(outputPath))
		{
			logger.warn("文件保存路径为空...");
			return;
		}
		Dispatch.call(this.document, "SaveAs", outputPath);
	}

	public void saveAsHtml(String htmlFile)
	{
		Dispatch.invoke(this.document, "SaveAs", Dispatch.Method, new Object[] { htmlFile, new

		Variant(8) }, new int[1]);
	}

	/**
	 * 关闭文件
	 * 
	 * @param document
	 *            要关闭的文件
	 */
	public void close()
	{

		logger.debug("关闭文件...");
		if (document == null)
		{
			logger.warn("document对象为空...");
			return;
		}
		Dispatch.call(document, "Close", new Variant(0));
	}

	/**
	 * 列印word文件
	 * 
	 */
	public void printFile()
	{
		logger.debug("打印文件...");
		if (document == null)
		{
			logger.warn("document对象为空...");
			return;
		}
		Dispatch.call(document, "PrintOut");
	}

	/**
	 * 退出程序
	 */
	public void quit()
	{

		logger.debug("退出程序");
		word.invoke("Quit", new Variant[0]);
		ComThread.Release();
	}

	// 复制当前word所有内容到剪贴板
	public void copyWordContent()
	{
		Dispatch textRange = Dispatch.get(document, "Content").toDispatch(); // 取得当前文档的内容
		Dispatch.call(textRange, "Copy");
	}

	/**
	 * 在当前文档末尾拷贝来自另一个文档中的所有内容 *
	 * 
	 * @param anotherDocPath
	 *            另一个文档的磁盘路径
	 */
	public void copyContentFromAnotherDoc(String anotherDocPath)
	{
//		Dispatch wordContent = Dispatch.get(document, "Content").toDispatch(); // 取得当前文档的内容
//		Dispatch.call(wordContent, "InsertAfter", "#selection#");// 插入特殊符定位插入点
		copyContentFromAnotherDoc(anotherDocPath, "#selection#");
	}

	/**
	 * 在当前文档拷贝来自另一个文档中的所有内容 *
	 * 
	 * @param anotherDocPath
	 *            另一个文档的磁盘路径
	 * @param pos
	 *            当前文档指定的位置
	 */
	public void copyContentFromAnotherDoc(String anotherDocPath, String pos)
	{
		Dispatch doc2 = null;
		try
		{
			doc2 = Dispatch.call(documents, "Open", anotherDocPath).toDispatch();
			Dispatch range = Dispatch.get(doc2, "Content").toDispatch(); // 取得当前文档的内容
			Dispatch.call(range, "Copy");
			
//			if (this.find(pos))
//			{
				Dispatch textRange = Dispatch.get(this.selection, "Range").toDispatch();
				Dispatch.call(textRange, "Paste");
//			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (doc2 != null)
			{
//				Dispatch.call(doc2, "Close", new Variant(saveOnExit));
				doc2 = null;
			}
		}
	}

	
	public void writeTocell(int row,int col,String value)
	{
		this.cell = Dispatch.call(this.table, "Cell", new Variant(row), new Variant(col)).toDispatch();
		Dispatch.call(this.cell, "Select");
		Dispatch.put(this.selection, "Text", value);
	}
	
	public static void main(String args[])
	{
		try
		{
			
		
		DOCWriter writer = new DOCWriter();
		writer.createNewDocument();
		
		
//		List<String[]> listTable = new ArrayList<String[]>();
//		for (int i = 0; i < 10; i++)
//		{
//			String str[] = new String[4];
//			for (int j = 0; j < 4; j++)
//			{
//				str[j] = String.valueOf(j);
//			}
//			listTable.add(str);
//		}
//		writer.setFontScale("宋体", false, false, false, "1,1,1,1", 70, 14);
//		List<String> list = new ArrayList<String>();
//		list.add("忘记你我做不到");
//		list.add("不去天涯海角");
//		list.add("在我身边就好");
//		list.add("如果爱是痛苦的泥沼");
//		list.add("让我们一起逃");
//		list.add("忘记你我做不到");
//		list.add("不去天涯海角");
//		list.add("在我身边就好");
//		list.add("如果爱是痛苦的泥沼");
//		list.add("让我们一起逃");
//		writer.moveDown(3);
//		writer.setAlignment(0);
//		writer.setTitle("Test");
//		writer.setTitle("Test2");
//		writer.insertImage("C:\\Users\\TangLi\\Desktop\\desktop\\13.jpg");
//		writer.enterDown(1);
//		writer.insertToDocument(list);
//		writer.setFontScale("幼圆", true, true, true, "1,1,1,1", 70, 14);
//		writer.createNewTable(10, 5, 0);
//		writer.insertToTable(listTable);
//		writer.setFontScale("华文仿宋", true, true, false, "1,1,1,1", 70, 14);
//		writer.createNewTable(10, 5, 0);
//		writer.insertToTable(listTable);
//		writer.setFontScale("华文新魏", true, false, false, "100,1,1,1", 70, 14);
//		writer.insertToDocument(list);
		
		
		
		for(int i = 0;i <10 ;i++)
		{
			writer.moveEnd();
			
//			writer.enterDown(1);
			writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\1-2.docx");
//			writer.enterDown(1);
			
			writer.tables = Dispatch.get(writer.document, "Tables").toDispatch();
			System.out.println(Dispatch.get(writer.tables, "Count").getInt());
			writer.table = Dispatch.call(writer.tables, "Item", new Variant(1+i)).toDispatch();
			
//			writer.cell = Dispatch.call(writer.table, "Cell", new Variant(2), new Variant(2)).toDispatch();
//			Dispatch.call(writer.cell, "Select");
//			Dispatch.put(writer.selection, "Text", "this is from java");
			
			
			/*--------------------------------------mynote--------------------------------------*/
			
			writer.writeTocell(1,6,"school");
			writer.writeTocell(2,2,"name");
			writer.writeTocell(2,4,"sex");
			writer.writeTocell(2,6,"studentCode");
			writer.writeTocell(3,2,"className");
			writer.writeTocell(3,4,"nativeCode");
			writer.writeTocell(3,6,"birthDay");
			
			writer.writeTocell(6,2,"体重1年级等级");
			writer.writeTocell(6,3,"体重1年级成绩");
			writer.writeTocell(6,4,"体重1年级得分");
			writer.writeTocell(6,6,"体重2年级等级");
			writer.writeTocell(6,7,"体重2年级成绩");
			writer.writeTocell(6,8,"体重2年级得分");
			
			writer.writeTocell(7,2,"肺活量1年级等级");
			writer.writeTocell(7,3,"肺活量1年级成绩");
			writer.writeTocell(7,4,"肺活量1年级得分");
			writer.writeTocell(7,6,"肺活量2年级等级");
			writer.writeTocell(7,7,"肺活量2年级成绩");
			writer.writeTocell(7,8,"肺活量2年级得分");
			
			writer.writeTocell(8,2,"50m1年级等级");
			writer.writeTocell(8,3,"50m1年级成绩");
			writer.writeTocell(8,4,"50m1年级得分");
			writer.writeTocell(8,6,"50m2年级等级");
			writer.writeTocell(8,7,"50m2年级成绩");
			writer.writeTocell(8,8,"50m2年级得分");
			
			writer.writeTocell(9,2,"前屈1年级等级");
			writer.writeTocell(9,3,"前屈1年级成绩");
			writer.writeTocell(9,4,"前屈1年级得分");
			writer.writeTocell(9,6,"前屈2年级等级");
			writer.writeTocell(9,7,"前屈2年级成绩");
			writer.writeTocell(9,8,"前屈2年级得分");
			
			writer.writeTocell(10,2,"绳1年级等级");
			writer.writeTocell(10,3,"绳1年级成绩");
			writer.writeTocell(10,4,"绳1年级得分");
			writer.writeTocell(10,6,"绳2年级等级");
			writer.writeTocell(10,7,"绳2年级成绩");
			writer.writeTocell(10,8,"绳2年级得分");
			
			writer.writeTocell(11,2,"1标准");
			writer.writeTocell(11,4,"2标准");
			
			writer.writeTocell(13,2,"绳1年级成绩");
			writer.writeTocell(13,3,"绳1年级加分");
			writer.writeTocell(13,5,"绳2年级成绩");
			writer.writeTocell(13,6,"绳2年级加分");
			
			
			writer.writeTocell(14,2,"1年级总分");
			writer.writeTocell(14,4,"2年级总分");
			writer.writeTocell(15,2,"1年级等级");
			writer.writeTocell(15,4,"2年级等级");
			
			
			
			
			/*--------------------------------------mynote--------------------------------------*/
//			writer.writeTocell(1,6,"school");
//			writer.writeTocell(2,2,"name");
//			writer.writeTocell(2,4,"sex");
//			writer.writeTocell(2,6,"studentCode");
//			writer.writeTocell(3,2,"className");
//			writer.writeTocell(3,4,"nativeCode");
//			writer.writeTocell(3,6,"birthDay");
//			
//			writer.writeTocell(6,2,"体重1年级等级");
//			writer.writeTocell(6,3,"体重1年级成绩");
//			writer.writeTocell(6,4,"体重1年级得分");
//			writer.writeTocell(6,6,"体重2年级等级");
//			writer.writeTocell(6,7,"体重2年级成绩");
//			writer.writeTocell(6,8,"体重2年级得分");
//			
//			writer.writeTocell(7,2,"肺活量1年级等级");
//			writer.writeTocell(7,3,"肺活量1年级成绩");
//			writer.writeTocell(7,4,"肺活量1年级得分");
//			writer.writeTocell(7,6,"肺活量2年级等级");
//			writer.writeTocell(7,7,"肺活量2年级成绩");
//			writer.writeTocell(7,8,"肺活量2年级得分");
//			
//			writer.writeTocell(8,2,"50m1年级等级");
//			writer.writeTocell(8,3,"50m1年级成绩");
//			writer.writeTocell(8,4,"50m1年级得分");
//			writer.writeTocell(8,6,"50m2年级等级");
//			writer.writeTocell(8,7,"50m2年级成绩");
//			writer.writeTocell(8,8,"50m2年级得分");
//			
//			writer.writeTocell(9,2,"前屈1年级等级");
//			writer.writeTocell(9,3,"前屈1年级成绩");
//			writer.writeTocell(9,4,"前屈1年级得分");
//			writer.writeTocell(9,6,"前屈2年级等级");
//			writer.writeTocell(9,7,"前屈2年级成绩");
//			writer.writeTocell(9,8,"前屈2年级得分");
//			
//			writer.writeTocell(10,2,"绳1年级等级");
//			writer.writeTocell(10,3,"绳1年级成绩");
//			writer.writeTocell(10,4,"绳1年级得分");
//			writer.writeTocell(10,6,"绳2年级等级");
//			writer.writeTocell(10,7,"绳2年级成绩");
//			writer.writeTocell(10,8,"绳2年级得分");
//			
//			writer.writeTocell(11,2,"仰卧1年级等级");
//			writer.writeTocell(11,3,"仰卧1年级成绩");
//			writer.writeTocell(11,4,"仰卧1年级得分");
//			writer.writeTocell(11,6,"仰卧2年级等级");
//			writer.writeTocell(11,7,"仰卧2年级成绩");
//			writer.writeTocell(11,8,"仰卧2年级得分");
//			
//			writer.writeTocell(12,2,"1标准");
//			writer.writeTocell(12,4,"2标准");
//			
//			writer.writeTocell(14,2,"绳1年级成绩");
//			writer.writeTocell(14,3,"绳1年级加分");
//			writer.writeTocell(14,5,"绳2年级成绩");
//			writer.writeTocell(14,6,"绳2年级加分");
//			
//			
//			writer.writeTocell(15,2,"1年级总分");
//			writer.writeTocell(15,4,"2年级总分");
//			writer.writeTocell(16,2,"1年级等级");
//			writer.writeTocell(16,4,"2年级等级");
			
			
			/*--------------------------------------mynote--------------------------------------*/			
			
//			writer.writeTocell(1,3,"school");
//			writer.writeTocell(2,2,"name");
//			writer.writeTocell(2,4,"sex");
//			writer.writeTocell(2,6,"studentCode");
//			writer.writeTocell(3,2,"className");
//			writer.writeTocell(3,4,"nativeCode");
//			writer.writeTocell(3,6,"birthDay");
//			
//			writer.writeTocell(6,2,"体重1年级等级");
//			writer.writeTocell(6,3,"体重1年级成绩");
//			writer.writeTocell(6,4,"体重1年级得分");
//			writer.writeTocell(6,5,"体重2年级等级");
//			writer.writeTocell(6,6,"体重2年级成绩");
//			writer.writeTocell(6,7,"体重2年级得分");
//			
//			writer.writeTocell(7,2,"肺活量1年级等级");
//			writer.writeTocell(7,3,"肺活量1年级成绩");
//			writer.writeTocell(7,4,"肺活量1年级得分");
//			writer.writeTocell(7,5,"肺活量2年级等级");
//			writer.writeTocell(7,6,"肺活量2年级成绩");
//			writer.writeTocell(7,7,"肺活量2年级得分");
//			
//			writer.writeTocell(8,2,"50m1年级等级");
//			writer.writeTocell(8,3,"50m1年级成绩");
//			writer.writeTocell(8,4,"50m1年级得分");
//			writer.writeTocell(8,5,"50m2年级等级");
//			writer.writeTocell(8,6,"50m2年级成绩");
//			writer.writeTocell(8,7,"50m2年级得分");
//			
//			writer.writeTocell(9,2,"前屈1年级等级");
//			writer.writeTocell(9,3,"前屈1年级成绩");
//			writer.writeTocell(9,4,"前屈1年级得分");
//			writer.writeTocell(9,5,"前屈2年级等级");
//			writer.writeTocell(9,6,"前屈2年级成绩");
//			writer.writeTocell(9,7,"前屈2年级得分");
//			
//			writer.writeTocell(10,2,"绳1年级等级");
//			writer.writeTocell(10,3,"绳1年级成绩");
//			writer.writeTocell(10,4,"绳1年级得分");
//			writer.writeTocell(10,5,"绳2年级等级");
//			writer.writeTocell(10,6,"绳2年级成绩");
//			writer.writeTocell(10,7,"绳2年级得分");
//			
//			writer.writeTocell(11,2,"仰卧1年级等级");
//			writer.writeTocell(11,3,"仰卧1年级成绩");
//			writer.writeTocell(11,4,"仰卧1年级得分");
//			writer.writeTocell(11,5,"仰卧2年级等级");
//			writer.writeTocell(11,6,"仰卧2年级成绩");
//			writer.writeTocell(11,7,"仰卧2年级得分");
//			
//			writer.writeTocell(12,2,"耐力1年级等级");
//			writer.writeTocell(12,3,"耐力1年级成绩");
//			writer.writeTocell(12,4,"耐力1年级得分");
//			writer.writeTocell(12,5,"耐力2年级等级");
//			writer.writeTocell(12,6,"耐力2年级成绩");
//			writer.writeTocell(12,7,"耐力2年级得分");
//			
//			writer.writeTocell(13,2,"1标准分");
//			writer.writeTocell(13,3,"2标准分");
//			
//			writer.writeTocell(15,2,"绳1年级成绩");
//			writer.writeTocell(15,3,"绳1年级加分");
//			writer.writeTocell(15,4,"绳2年级成绩");
//			writer.writeTocell(15,5,"绳2年级加分");
//			
//			
//			writer.writeTocell(16,2,"1年级总分");
//			writer.writeTocell(16,3,"2年级总分");
//			writer.writeTocell(17,2,"1年级等级");
//			writer.writeTocell(17,3,"2年级等级");
//			
//			
//			writer.writeTocell(6,8,"xx");
//			writer.writeTocell(6,9,"xx");
			
			
		}
		
		
		// writer.saveAsHtml("C:\\Users\\TangLi\\Desktop\\ww\\aa.html");
		writer.saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\aa.doc");
		// writer.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}