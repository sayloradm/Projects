package strategy;

public interface UserStrategy 
{
	//Checks the program dependent on strategy
	public void checkProgram();
	//Checks the progress dependent on strategy
	public void checkProgress();
	//Shows the users info dependent on strategy
	public void print_info();
	
	
	
}
