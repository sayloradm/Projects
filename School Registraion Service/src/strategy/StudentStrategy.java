package strategy;

import user.Personal_Information;

public class StudentStrategy implements UserStrategy
{
	Personal_Information info = new Personal_Information();
	//Overrides check program based on student user
	@Override
	public void checkProgram() 
	{
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("Program of study for Student");
		System.out.println("+++++++++++++++++++++++++++");
	};
	//Overrides check progress based on student user
	@Override
	public void checkProgress() 
	{
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("Degree progress for Student");
		System.out.println("+++++++++++++++++++++++++++");
	};
	//Overrides print info based on student user
	@Override
	public void print_info() 
	{
		System.out.println("-------------------------------------------");
		System.out.println("You are a Student, here is your information - ");
		System.out.println("-------------------------------------------");
		System.out.println(info.getInfo());
	};
}
