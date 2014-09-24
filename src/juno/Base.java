package juno;

public class Base
{
	public void baseFunction()
	{
		System.out.println("this is base Function");
		innerBaseFunction();
		System.out.println(field);
		
	}
	protected void innerBaseFunction()
	{
		System.out.println("this is inner base FUnction");
	}
	
	protected String field = "this is base Field";
	
}
