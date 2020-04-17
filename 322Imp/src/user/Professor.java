package user;

import course.course;
import course.CourseList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Professor 
{
	
	List<course> coursesTeaching = new ArrayList<course>();
	List<Student> advisees = new ArrayList<Student>();
	Personal_Information info = new Personal_Information();
	CourseList c;
	
	/**
	 * Adds the specified student to advisees List
	 * @param student - the student to add to the professors advisees
	 * 
	 */
	public boolean add_advisee(Student student)
	{
		this.advisees.add(student);
		return true;
	}
	/**
	 * Removes the specified student from advisees list
	 * @param student - the student to remove from the professors advisees
	 * 
	 */
	public boolean remove_advisee(Student student)
	{
		this.advisees.remove(student);
		return true;
	}
	/**
	 * 
	 * @return a list of students that the professor is advising
	 */
	public List<Student> get_advisees()
	{
		return advisees;
	}
	/**
	 * This method iterates through the list of courses made in CourseList 
	 * and matches the entered professors name with any professor name that is
	 * in courselist and adds those courses to the list of coursesteaching
	 * 
	 * 
	 * @param pName - the name of the professor 
	 * 
	 */
	public void addCourses(String pName) throws IOException
	{
		c = new CourseList();
		for(course cs : c.getOfferings())
		{
			if(cs.getProf().equals(pName))
			{
				this.coursesTeaching.add(cs);
			}
		}
	}
	/**
	 * 
	 * @return a list of all courses a specified prof is teaching
	 */
	public String getCourses()
	{
		String out = "";
		for(course c : coursesTeaching)
		{
			out = out + c.getNumber() +" "+ c.getName()+"\n";
		}
		
		return out;
	}
	/**
	 * 
	 * @param name - the name to set a prof
	 */
	public void setName(String name)
	{
		info.setName(name);
	}
	/**
	 * 
	 * @return a professors name
	 */
	public String getName()
	{
		return info.getName();
	}
	
	
	
}
