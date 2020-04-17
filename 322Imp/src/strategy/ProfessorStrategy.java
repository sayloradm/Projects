package strategy;

import user.Personal_Information;

public class ProfessorStrategy implements UserStrategy
{
	Personal_Information info = new Personal_Information();
	//Overrides check program based on professor user
	@Override
	public void checkProgram() 
	{
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("Program of study for Professor");
		System.out.println("+++++++++++++++++++++++++++++");
	};
	//Overrides check progress based on professor user
	@Override
	public void checkProgress() 
	{
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("Degree progress for Professor");
		System.out.println("+++++++++++++++++++++++++++++");
	};
	//Overrides print info based on professor user
	@Override
	public void print_info() 
	{
		System.out.println("-------------------------------------------");
		System.out.println("You are a Professor, here is your information - ");
		System.out.println("-------------------------------------------");
		System.out.println(info.getInfo());
	}
	
}
