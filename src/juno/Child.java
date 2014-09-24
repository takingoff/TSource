package juno;

public class Child extends Base
{

	@Override
	protected void innerBaseFunction()
	{
		System.out.println("override inner Base function !!");
	}
	
	public String field = "this is child field ";
	
}
