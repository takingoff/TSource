/**
 *	2014年10月15日 下午4:36:37
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;

import java.util.List;

import com.jacob.com.Dispatch;

/**
 * @author TangLi 2014年10月15日下午4:36:37
 */
public class EntityWriter implements IEntityWriter
{
	@Override
	public void writeOut(List<Student> entityList)
	{

//		fakeWriter(entityList);
		writeToWord(entityList);
	}

	public void fakeWriter(List<Student> entityList)
	{
		for (Student s : entityList)
		{
			System.out.println(s.toString());
		}
	}


	public void writeToWord(List<Student> entityList)
	{
		
		DOCWriter writer = new DOCWriter();
		writer.createNewDocument();
		
		for(int i = 0;i <entityList.size() ;i++)
		{
			writer.moveEnd();
			writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\dd.docx");
			
			writer.getTables();
			System.out.println(writer.getTablesCount());
			writer.getTable(i+1);
			
			writeTocell(writer,2,2,"SS");
			
		}
		
		// writer.saveAsHtml("C:\\Users\\TangLi\\Desktop\\ww\\aa.html");
		writer.saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\aa.doc");
		// writer.close();
		
	}
	
	
	
	
	
	
	
	
}