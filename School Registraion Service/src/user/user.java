package user;

import strategy.UserStrategy;

import java.io.IOException;

import course.CourseList;
import course.course;

public class user 
{
	
	Personal_Information info = new Personal_Information();
	CourseList cour = new CourseList();
	
	UserStrategy strategy;
	
	public user() throws IOException 
	{
		
	}
	/**
	 * 
	 * @param clas - the class that the information will be viewed of
	 * @return
	 */
	public course view_course_information(String clas) 
	{
		 return cour.get_course(clas);
	}
	/**
	 * Calls the strategy pattern to print the personal information of a user
	 */
	public void print_information()
	{
		this.strategy.print_info();
	}
	/**
	 * calls the strategy pattern to print the program of study
	 */
	public void check_program_of_study()
	{
		this.strategy.checkProgram();
	}
	/**
	 * calls the strategy pattern to print the degree progress
	 */
	public void check_degree_progress()
	{
		this.strategy.checkProgress();
	}
	/**
	 * Sets the strategy for the user to be prof or student
	 * 
	 * @param strategy - the type of strategy that will be set, prof or student
	 */
	public void setStrategy(UserStrategy strategy)
	{
		this.strategy = strategy;
	}
}
