/**
 *	2014年10月15日 下午4:39:00
 *	TangLi
 */
package health_information.util;

import health_information.model.Student;
import health_information.standard.EnduranceStandard;
import health_information.standard.Run50Standard;
import health_information.standard.SitBendStandard;
import health_information.standard.SitupStandard;
import health_information.standard.SkipStandard;
import health_information.standard.Standard;
import health_information.standard.VitalCapacityStandard;
import health_information.standard.WeightStandard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月15日下午4:39:00
 */
public class KernelProcess
{
	

	public static void process(List<Student> students)
	{
		sort(students);
		
		int beginIndex = 0;
		int endIndex=0;
		while(beginIndex<students.size())
		{
			/*--------------------------------------获取一组的索引--------------------------------------*/
			String grade = Common.identifyGrade(students.get(beginIndex).className);
			String sex = Common.identifySex(students.get(beginIndex).sex);
			
			
			int count =1;
			for(endIndex = beginIndex+1 ;endIndex <students.size();endIndex++)
			{
				if(Common.identifyGrade(students.get(endIndex).className).equals(grade) && Common.identifySex(students.get(endIndex).sex).equals(sex))
					count++;
				else
					break;
			}
			
			/*--------------------------------------生成--------------------------------------*/
			List<Integer> vitalCapacityValues =ValueGenerator.generateIntValue(count,VitalCapacityStandard.scaleMap.get(grade).get(sex),100,100);
			List<Integer> situpValues = null;
			if(grade.equals(Standard.GRADE3) || grade.equals(Standard.GRADE4)||grade.equals(Standard.GRADE5) || grade.equals(Standard.GRADE6))
			{
				situpValues =ValueGenerator.generateIntValue(count,SitupStandard.scaleMap.get(grade).get(sex),3,3);
			}
			List<Integer> skipValues =ValueGenerator.generateIntValue(count,SkipStandard.scaleMap.get(grade).get(sex),40,1);
			
			List<Double> sitBendvalues = ValueGenerator.generateDoubleValue(count,SitBendStandard.scaleMap.get(grade).get(sex),1,0.2,0.2);
			List<Double> run50values = ValueGenerator.generateDoubleValue(count,Run50Standard.scaleMap.get(grade).get(sex),1,0.1,0.2);
			
			
			List<Double> weightValues = ValueGenerator.generateWeightData(WeightStandard.scaleMap.get(grade).get(sex),count);
			List<Integer> enduranceValues = null;
			if(grade.equals(Standard.GRADE5) || grade.equals(Standard.GRADE6))
			{
				enduranceValues = ValueGenerator.generateEnduranceData(EnduranceStandard.scaleMap.get(grade).get(sex),count);
			}
			
			/*--------------------------------------得出结果--------------------------------------*/
			// beginIndex(include) endIndex(exclude)
			for(int i= beginIndex,j=0;i<endIndex;i++,j++)
			{
				Student student = students.get(i);
				student.vitalCapacityResult = VitalCapacityStandard.judge(vitalCapacityValues.get(j), grade, sex);
				student.skipResult = SkipStandard.judge(skipValues.get(j), grade, sex);
				student.sitBendResult = SitBendStandard.judge(sitBendvalues.get(j), grade, sex);
				student.run50Result= Run50Standard.judge(run50values.get(j), grade, sex);
				student.weightResult= WeightStandard.judge(weightValues.get(j), grade, sex);
				
				if(situpValues != null)
				{
					student.situpResult = SitupStandard.judge(situpValues.get(j), grade, sex);
				}
				if(enduranceValues != null)
				{
					student.enduranceResult = EnduranceStandard.judge(enduranceValues.get(j), grade, sex);
				}
				
			}
			
			/*--------------------------------------下一次循环--------------------------------------*/
			// beginIndex(include) endIndex(exclude)
			beginIndex = endIndex;
		}
	}

	private static void sort(List<Student> students)
	{
		/*--------------------------------------年级，性别排序--------------------------------------*/
		Collections.sort(students, new Comparator<Student>()
		{
			@Override
			public int compare(Student o1, Student o2)
			{
				try
				{
					int index = Integer.parseInt(Common.identifyGrade(o1.className))-Integer.parseInt(Common.identifyGrade(o2.className));
					if(index>0)
						return 1;
					else if(index<0)
						return -1;
					else
					{
						if(Common.identifySex(o1.sex).equals(Common.identifySex(o2.sex)))
							return 0;
						else if(Common.identifySex(o1.sex).equals(Standard.FEMALE))
							return 1;
						else
							return -1;
					}
				}catch(Exception e)
				{
					return -1;
				}
			}
			
		});
	}
	
	
	
	
	
}
