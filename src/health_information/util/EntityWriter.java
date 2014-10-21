/**
 *	2014年10月15日 下午4:36:37
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;
import health_information.standard.Standard;

import java.util.ArrayList;
import java.util.List;

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
		List<DOCWriter> writers = new ArrayList<DOCWriter>();
		
		for(int i = 0 ;i <6;i++)
		{
			DOCWriter writer = new DOCWriter();
			writer.createNewDocument();
			writers.add(writer);
		}
		
		
		for(int i = 0;i <entityList.size() ;i++)
		{
			insertToTable(writers,entityList.get(i));
		}
		
		writers.get(0).saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\1final.doc");
		writers.get(1).saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\2final.doc");
		writers.get(2).saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\3final.doc");
		writers.get(3).saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\4final.doc");
		writers.get(4).saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\5final.doc");
		writers.get(5).saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\6final.doc");
		
		
//		DOCWriter writer = new DOCWriter();
//		writer.createNewDocument();
		
//		writer.saveAs("C:\\Users\\TangLi\\Desktop\\desktop\\aa.doc");
		// writer.saveAsHtml("C:\\Users\\TangLi\\Desktop\\ww\\aa.html");
		// writer.close();
		
	}
	
	
	public static void insertToTable(List<DOCWriter> writers,Student student)
	{
		
		String grade = Common.identifyGrade(student.className);
		
		if(grade.endsWith(Standard.GRADE1))
			insertToGrade1(writers.get(0),student);
		else if(grade.endsWith(Standard.GRADE2))
			insertToGrade2(writers.get(1),student);
		else if(grade.endsWith(Standard.GRADE3))
			insertToGrade3(writers.get(2),student);
		else if(grade.endsWith(Standard.GRADE4))
			insertToGrade4(writers.get(3),student);
		else if(grade.endsWith(Standard.GRADE5))
			insertToGrade5(writers.get(4),student);
		else if(grade.endsWith(Standard.GRADE6))
			insertToGrade6(writers.get(5),student);
		
	}
	
	public static void insertToGrade1(DOCWriter writer,Student student)
	{
		
		writer.moveEnd();
		writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\1-2.docx");
		writer.getTables();
		System.out.println(writer.getTablesCount());
		writer.getTable(writer.getTablesCount());
		
		writer.writeTocell(1,6,"————");
		writer.writeTocell(2,2,student.name);
		writer.writeTocell(2,4,student.sex);
		writer.writeTocell(2,6,student.studentCode);
		writer.writeTocell(3,2,student.className);
		writer.writeTocell(3,4,"汉族");
		writer.writeTocell(3,6,student.birthday);
		
		writer.writeTocell(6,2,student.weightResult.level);
		writer.writeTocell(6,3,student.weightResult.valueDouble.toString());
		writer.writeTocell(6,4,student.weightResult.score+"");
		
		writer.writeTocell(7,2,student.vitalCapacityResult.level);
		writer.writeTocell(7,3,student.vitalCapacityResult.valueInt.toString());
		writer.writeTocell(7,4,student.vitalCapacityResult.score+"");
		
		writer.writeTocell(8,2,student.run50Result.level);
		writer.writeTocell(8,3,student.run50Result.valueDouble.toString());
		writer.writeTocell(8,4,student.run50Result.score+"");
		
		writer.writeTocell(9,2,student.sitBendResult.level);
		writer.writeTocell(9,3,student.sitBendResult.valueDouble.toString());
		writer.writeTocell(9,4,student.sitBendResult.score+"");
		
		writer.writeTocell(10,2,student.skipResult.level);
		writer.writeTocell(10,3,student.skipResult.valueInt.toString());
		writer.writeTocell(10,4,student.skipResult.score+"");
		
		writer.writeTocell(11,2,"1标准");
		
		writer.writeTocell(13,2,student.skipResult.valueInt+"");
		writer.writeTocell(13,3,student.skipResult.extraScore+"");
		
		writer.writeTocell(14,2,"1年级总分");
		writer.writeTocell(15,2,"1年级等级");
		
			
	}
	public static void insertToGrade2(DOCWriter writer,Student student)
	{
		writer.moveEnd();
		writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\1-2.docx");
		writer.getTables();
		System.out.println(writer.getTablesCount());
		writer.getTable(writer.getTablesCount());
		
		writer.writeTocell(1,6,"————");                                         
		writer.writeTocell(2,2,student.name);                                   
		writer.writeTocell(2,4,student.sex);                                    
		writer.writeTocell(2,6,student.studentCode);                            
		writer.writeTocell(3,2,student.className);                              
		writer.writeTocell(3,4,"汉族");                                           
		writer.writeTocell(3,6,student.birthday);                               
		                                                                        
		writer.writeTocell(6,6,student.weightResult.level);                     
		writer.writeTocell(6,7,student.weightResult.valueDouble.toString());    
		writer.writeTocell(6,8,student.weightResult.score+"");                  
		                                                                        
		writer.writeTocell(7,6,student.vitalCapacityResult.level);              
		writer.writeTocell(7,7,student.vitalCapacityResult.valueInt.toString());
		writer.writeTocell(7,8,student.vitalCapacityResult.score+"");           
		                                                                        
		writer.writeTocell(8,6,student.run50Result.level);                      
		writer.writeTocell(8,7,student.run50Result.valueDouble.toString());     
		writer.writeTocell(8,8,student.run50Result.score+"");                   
		                                                                        
		writer.writeTocell(9,6,student.sitBendResult.level);                    
		writer.writeTocell(9,7,student.sitBendResult.valueDouble.toString());   
		writer.writeTocell(9,8,student.sitBendResult.score+"");                 
		
		writer.writeTocell(10,6,student.skipResult.level);              
		writer.writeTocell(10,7,student.skipResult.valueInt.toString());
		writer.writeTocell(10,8,student.skipResult.score+"");           
		                                                                
		writer.writeTocell(11,4,"2标准");                                 
		                                                                
		writer.writeTocell(13,5,student.skipResult.valueInt+"");        
		writer.writeTocell(13,6,student.skipResult.extraScore+"");      
		                                                                
		writer.writeTocell(14,4,"2年级总分");                               
		writer.writeTocell(15,4,"2年级等级");                               
	}
	public static void insertToGrade3(DOCWriter writer,Student student)
	{
		writer.moveEnd();
		writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\3-4.docx");
		writer.getTables();
		System.out.println(writer.getTablesCount());
		writer.getTable(writer.getTablesCount());
		
		writer.writeTocell(1,6,"————");               
		writer.writeTocell(2,2,student.name);         
		writer.writeTocell(2,4,student.sex);          
		writer.writeTocell(2,6,student.studentCode);  
		writer.writeTocell(3,2,student.className);    
		writer.writeTocell(3,4,"汉族");                 
		writer.writeTocell(3,6,student.birthday);     
		
		writer.writeTocell(6,2,student.weightResult.level);                     
		writer.writeTocell(6,3,student.weightResult.valueDouble.toString());    
		writer.writeTocell(6,4,student.weightResult.score+"");                  
		                                                                        
		writer.writeTocell(7,2,student.vitalCapacityResult.level);              
		writer.writeTocell(7,3,student.vitalCapacityResult.valueInt.toString());
		writer.writeTocell(7,4,student.vitalCapacityResult.score+"");           
		                                                                        
		writer.writeTocell(8,2,student.run50Result.level);                      
		writer.writeTocell(8,3,student.run50Result.valueDouble.toString());     
		writer.writeTocell(8,4,student.run50Result.score+"");                   
		                                                                        
		writer.writeTocell(9,2,student.sitBendResult.level);                    
		writer.writeTocell(9,3,student.sitBendResult.valueDouble.toString());   
		writer.writeTocell(9,4,student.sitBendResult.score+"");                 
		
		writer.writeTocell(10,2,student.skipResult.level);              
		writer.writeTocell(10,3,student.skipResult.valueInt.toString());
		writer.writeTocell(10,4,student.skipResult.score+"");           
		
		writer.writeTocell(11,2,student.situpResult.level);
		writer.writeTocell(11,3,student.situpResult.valueInt.toString());
		writer.writeTocell(11,4,student.situpResult.score+"");
		
		writer.writeTocell(12,2,"1标准");
		
		writer.writeTocell(14,2,student.skipResult.valueInt+"");  
		writer.writeTocell(14,3,student.skipResult.extraScore+"");
		
		
		writer.writeTocell(15,2,"1年级总分");
		writer.writeTocell(16,2,"1年级等级");
	}
	public static void insertToGrade4(DOCWriter writer,Student student)
	{
		writer.moveEnd();
		writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\3-4.docx");
		writer.getTables();
		System.out.println(writer.getTablesCount());
		writer.getTable(writer.getTablesCount());
		
		writer.writeTocell(1,6,"————");               
		writer.writeTocell(2,2,student.name);         
		writer.writeTocell(2,4,student.sex);          
		writer.writeTocell(2,6,student.studentCode);  
		writer.writeTocell(3,2,student.className);    
		writer.writeTocell(3,4,"汉族");                 
		writer.writeTocell(3,6,student.birthday);     
		
		writer.writeTocell(6,6,student.weightResult.level);                     
		writer.writeTocell(6,7,student.weightResult.valueDouble.toString());    
		writer.writeTocell(6,8,student.weightResult.score+"");                  
		                                                                        
		writer.writeTocell(7,6,student.vitalCapacityResult.level);              
		writer.writeTocell(7,7,student.vitalCapacityResult.valueInt.toString());
		writer.writeTocell(7,8,student.vitalCapacityResult.score+"");           
		                                                                        
		writer.writeTocell(8,6,student.run50Result.level);                      
		writer.writeTocell(8,7,student.run50Result.valueDouble.toString());     
		writer.writeTocell(8,8,student.run50Result.score+"");                   
		                                                                        
		writer.writeTocell(9,6,student.sitBendResult.level);                    
		writer.writeTocell(9,7,student.sitBendResult.valueDouble.toString());   
		writer.writeTocell(9,8,student.sitBendResult.score+"");                 
		
		writer.writeTocell(10,6,student.skipResult.level);              
		writer.writeTocell(10,7,student.skipResult.valueInt.toString());
		writer.writeTocell(10,8,student.skipResult.score+"");           
		
		writer.writeTocell(11,6,student.situpResult.level);              
		writer.writeTocell(11,7,student.situpResult.valueInt.toString());
		writer.writeTocell(11,8,student.situpResult.score+"");           
		
		writer.writeTocell(12,4,"2标准");
		
		writer.writeTocell(14,5,student.skipResult.valueInt+"");  
		writer.writeTocell(14,6,student.skipResult.extraScore+"");
		
		
		writer.writeTocell(15,4,"2年级总分");
		writer.writeTocell(16,4,"2年级等级");
	}
	public static void insertToGrade5(DOCWriter writer,Student student)
	{
		writer.moveEnd();
		writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\5-6.docx");
		writer.getTables();
		System.out.println(writer.getTablesCount());
		writer.getTable(writer.getTablesCount());
		
		writer.writeTocell(1,3,"————");               
		writer.writeTocell(2,2,student.name);         
		writer.writeTocell(2,4,student.sex);          
		writer.writeTocell(2,6,student.studentCode);  
		writer.writeTocell(3,2,student.className);    
		writer.writeTocell(3,4,"汉族");                 
		writer.writeTocell(3,6,student.birthday);     
		
		writer.writeTocell(6,2,student.weightResult.level);                     
		writer.writeTocell(6,3,student.weightResult.valueDouble.toString());    
		writer.writeTocell(6,4,student.weightResult.score+"");                  
		                                                                        
		writer.writeTocell(7,2,student.vitalCapacityResult.level);              
		writer.writeTocell(7,3,student.vitalCapacityResult.valueInt.toString());
		writer.writeTocell(7,4,student.vitalCapacityResult.score+"");           
		                                                                        
		writer.writeTocell(8,2,student.run50Result.level);                      
		writer.writeTocell(8,3,student.run50Result.valueDouble.toString());     
		writer.writeTocell(8,4,student.run50Result.score+"");                   
		                                                                        
		writer.writeTocell(9,2,student.sitBendResult.level);                    
		writer.writeTocell(9,3,student.sitBendResult.valueDouble.toString());   
		writer.writeTocell(9,4,student.sitBendResult.score+"");                 
		
		writer.writeTocell(10,2,student.skipResult.level);              
		writer.writeTocell(10,3,student.skipResult.valueInt.toString());
		writer.writeTocell(10,4,student.skipResult.score+"");           
		
		writer.writeTocell(11,2,student.situpResult.level);              
		writer.writeTocell(11,3,student.situpResult.valueInt.toString());
		writer.writeTocell(11,4,student.situpResult.score+"");           
		
		writer.writeTocell(12,2,student.enduranceResult.level);              
		writer.writeTocell(12,3,student.enduranceResult.valueInt.toString());
		writer.writeTocell(12,4,student.enduranceResult.score+"");           
		
		writer.writeTocell(13,2,"1标准分");
		
		writer.writeTocell(15,2,student.skipResult.valueInt+"");  
		writer.writeTocell(15,3,student.skipResult.extraScore+"");
		
		
		writer.writeTocell(16,2,"1年级总分");
		writer.writeTocell(17,2,"1年级等级");
		
		
		writer.writeTocell(6,8,"xx");
		writer.writeTocell(6,9,"xx");
	}
	public static void insertToGrade6(DOCWriter writer,Student student)
	{
		writer.moveEnd();
		writer.copyContentFromAnotherDoc("C:\\Users\\TangLi\\Desktop\\desktop\\5-6.docx");
		writer.getTables();
		System.out.println(writer.getTablesCount());
		writer.getTable(writer.getTablesCount());
		
		writer.writeTocell(1,3,"————");               
		writer.writeTocell(2,2,student.name);         
		writer.writeTocell(2,4,student.sex);          
		writer.writeTocell(2,6,student.studentCode);  
		writer.writeTocell(3,2,student.className);    
		writer.writeTocell(3,4,"汉族");                 
		writer.writeTocell(3,6,student.birthday);     
		
		writer.writeTocell(6,5,student.weightResult.level);                     
		writer.writeTocell(6,6,student.weightResult.valueDouble.toString());    
		writer.writeTocell(6,7,student.weightResult.score+"");                  
		                                                                        
		writer.writeTocell(7,5,student.vitalCapacityResult.level);              
		writer.writeTocell(7,6,student.vitalCapacityResult.valueInt.toString());
		writer.writeTocell(7,7,student.vitalCapacityResult.score+"");           
		                                                                        
		writer.writeTocell(8,5,student.run50Result.level);                      
		writer.writeTocell(8,6,student.run50Result.valueDouble.toString());     
		writer.writeTocell(8,7,student.run50Result.score+"");                   
		                                                                        
		writer.writeTocell(9,5,student.sitBendResult.level);                    
		writer.writeTocell(9,6,student.sitBendResult.valueDouble.toString());   
		writer.writeTocell(9,7,student.sitBendResult.score+"");                 
		
		writer.writeTocell(10,5,student.skipResult.level);              
		writer.writeTocell(10,6,student.skipResult.valueInt.toString());
		writer.writeTocell(10,7,student.skipResult.score+"");           
		
		writer.writeTocell(11,5,student.situpResult.level);              
		writer.writeTocell(11,6,student.situpResult.valueInt.toString());
		writer.writeTocell(11,7,student.situpResult.score+"");           
		
		writer.writeTocell(12,5,student.enduranceResult.level);
		writer.writeTocell(12,6,student.enduranceResult.valueInt.toString());
		writer.writeTocell(12,7,student.enduranceResult.score+"");
		
		writer.writeTocell(13,3,"2标准分");
		
		writer.writeTocell(15,4,student.skipResult.valueInt+"");  
		writer.writeTocell(15,5,student.skipResult.extraScore+"");
		
		
		writer.writeTocell(16,3,"2年级总分");
		writer.writeTocell(17,3,"2年级等级");
		
		
		writer.writeTocell(6,8,"xx");
		writer.writeTocell(6,9,"xx");
	}
	
	
	
	
	
	
	
}