package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import course.course;

public class Student 
{

	String major;
	List<course> registered_courses = new ArrayList<course>();
	Personal_Information info = new Personal_Information();
	HashMap<List<course>, List<course>> DegreeProgress = new HashMap<>();
	int current_semester;
	Professor advisor = new Professor();
	//Image Program_of_Study;
	
	public Student() 
	{
		
	}
	/**
	 * 
	 * @param name - the name to set a student to, calls personal information to set
	 */
	public void setName(String name)
	{
		info.setName(name);
	}
	/**
	 * 
	 * @return the name of the student from personal info
	 */
	public String getName()
	{
		return info.getName();
	}
	/**
	 * Dummy function that would return true if the student was able 
	 * to successfully select their advisor
	 * @return true if successful
	 */
	public boolean select_advisor()
	{
		return true;
	}
	/**
	 * This would allow a student to change the classes they are signed up for 
	 * @param courses - the list of courses a student has taken
	 * @return true if successful
	 */
	public boolean modifyProgress(List<course> courses)
	{
		return true;
	}
	
	/*
	 * This would return this type
	 * HashMap<List<course>, List<course>>
	 */
	public  String get_DegreeProgress()
	{
		return "This would return a hashmap of degree progress\n which "
				+ "would include classes taken and classes needed to take";
	}
	
	//Would return image
	public String get_program_Study()
	{
		return "This would display the program of study form";
	}
}
