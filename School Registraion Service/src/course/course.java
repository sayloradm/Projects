package course;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class course 
{
	private String name = "";
	private String number = "";
	private int CRN = 0;
	private String Prof = "";
	//private int number_credits;
	private String description = ""; // We are not given a description
	Hashtable<Integer, List<Map<String, String>>> schedule = new Hashtable<Integer, List<Map<String ,String>>>();
	List<String> prerequisites = new ArrayList<String>();
	
	/**
	 * This constructor sets the name, number, crn, and prof of each course
	 * as they are read in from CourseList
	 * 
	 */
	public course(String[] courseData)
	{
		this.name = courseData[2];
		this.number = courseData[1];
		this.CRN = Integer.parseInt(courseData[3]);
		this.Prof = courseData[4];
	}
	
	public course() {}
	
	public String getDescription()
	{
		return this.description + "Course description for " + getName();
	}
	
	public String getCredits()
	{
		// + this.number_credits
		return "Number of credits of " + getName();
	}
	
	public String getPrerequisites()
	{
		return "Prerequisites for  " + getName();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	
	public int getCRN()
	{
		return this.CRN;
	}
	
	public String getProf()
	{
		return this.Prof;
	}
	
	/**
	 * 
	 * Dummy function that would return true
	 * if a student was successfully added as an
	 * advisee to a prof
	 */
	public boolean addStudent()
	{
		return true;
	}
	
	/**
	 * 
	 * Dummy function that would return true
	 * if a student was successfully dropped as an
	 * advisee to a prof
	 */
	public boolean dropStudent()
	{
		return true;
	}
	
	public String getProfessor()
	{
		return this.Prof;
	}
	
	@Override
	public String toString()
	{
		return String.format(getName());
	}
	
	
}
