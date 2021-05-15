package main;

import java.io.IOException;
import java.util.Scanner;
import user.user;
import user.Personal_Information;
import course.course;
import user.Student;
import user.Professor;
import strategy.ProfessorStrategy;
import strategy.StudentStrategy;


public class MainClass {
	
	user person;
	Personal_Information info = new Personal_Information();

	public static void main(String[] args) throws IOException
	{
		MainClass m = new MainClass();
		Scanner in = new Scanner(System.in);
		user person = new user();
		int input = 1;
		
		
		/***
		 * Asks the user if they are a student or prof
		 * if they are a prof they are sent to the isprof method
		 */
		System.out.println("---------------------------");
		System.out.println("Enter one of the following:  \n1 - If you are a Student \n2 - If you are a Professor");
		System.out.println("---------------------------");
		input = in.nextInt();
		
		if(input == 1)
		{
			person.setStrategy(new StudentStrategy());
			m.setUser(person);
			m.whatNext();
		}
		else if(input == 2)
		{
			person.setStrategy(new ProfessorStrategy());
			m.setUser(person);
			m.isProfessor();
		}
		
		
		in.close();
		
	}
	
	/**
	 * Once the user decided if they are prof or student this
	 * method is called to set that for the program
	 * @param person - the student or prof user that is to be set to the global person variable
	 */
	public void setUser(user person)
	{
		this.person = person;
	}
	
	/**
	 * A method that is called whenever the user decided to exit the program
	 */
	public void exitMessage()
	{
		System.out.println("Toodles!");
	}
	
	
	/**
	 * This method is called when the user says they are a professor
	 * This method allows the professor to do many things, 
	 * see the classes they are teaching, add/drop view advisees.
	 *  
	 */
	public void isProfessor() throws IOException
	{
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		Professor prof = new Professor();
		Student stu = new Student();
		String sName = "";
		int input = 1;
		String pName = "";
		
		System.out.println();
		System.out.println("Hey! You're a professor!!!, what is your name? (Last, First)");
		pName = in3.nextLine();
		
		//Sets the professors name so that all of the classes they teach can be 
		//added to their professor object
		prof.setName(pName);
		prof.addCourses(pName);
		
		
		while(input == 1 || input == 2 || input == 3 || input == 4)
		{
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("What would you like to do?\n"
					+ "0 - Go to menu\n1 - Add student to advising\n2 - Remove student from advising\n3 - View all advisees\n4 - View courses you are teaching");
			System.out.println("-------------------------------");
			input = in.nextInt();
			if(input == 1)
			{
				System.out.println("What is the name of the student you would like to add?");
				sName = in2.nextLine();
				
				//Not perfect, but this makes a new student and adds it to the professor 
				//object. Theorectically, it would take an existing student object and add it to the
				//prof that way
				stu = new Student();
				stu.setName(sName);
				
				if(prof.add_advisee(stu) == true)
				{
					System.out.println();
					System.out.println("+++++++++++++++++++++++++++++++");
					System.out.println("Sucessfully added " + sName +" to advisees");
					System.out.println("+++++++++++++++++++++++++++++++");
				}
			}
			else if(input == 2)
			{
				System.out.println("What is the name of the student you would like to remove?");
				sName = in2.nextLine();
				
				/**
				 * This cycles through the list of advisees of the professor and finds
				 * the student they requested be removed
				 */
				for (Student s : prof.get_advisees())
				{
					if(s.getName().toLowerCase().equals(sName.toLowerCase()))
					{
						stu = s;
					}
				}
				
				if(prof.remove_advisee(stu) == true)
				{
					System.out.println();
					System.out.println("+++++++++++++++++++++++++++++++");
					System.out.println("Sucessfully removed " + sName +" from advisees");
					System.out.println("+++++++++++++++++++++++++++++++");
				}
			}
			else if(input == 3)
			{
				//Prints out all advisees, if none there is a unique print
				if(prof.get_advisees().size() == 0)
				{
					System.out.println("You have no advisees :(");
				}
				for (Student s : prof.get_advisees())
				{
					System.out.println(s.getName());
					System.out.println();
				}
				
			}
			//Prints the classes the prof is teaching
			else if(input == 4)
			{
				System.out.println("Here are your classes: ");
				System.out.println("-----------------------");
				System.out.println(prof.getCourses());
			}
		}
		whatNext();
		in.close();
		in2.close();
		in3.close();
	}
	/**
	 * This method prompts the user to find information that they wish
	 * the user can enter 1-4 to view various information. 
	 * 
	 * setInfo is a dummy method that would eventually allow the user to change their personal info
	 * 
	 * 
	 * This method accesses the strategy pattern based on the user
	 * either being student or prof and outputs accordingly
	 * 
	 *
	 * 
	 */
	public void userInfo() throws IOException
	{
		Scanner in = new Scanner(System.in);
		int input = 1;
		
		while(input == 1 || input == 2 || input == 3 || input == 4)
		{
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Amazing! Which would you like to know?\n"
					+ "0 - Go back\n1 - Program of study\n2 - Degree progress\n3 - View all of your personal info!\n4 - Change Personal Information");
			System.out.println("-------------------------------");
			input = in.nextInt();
			if(input == 1)
			{
				person.check_program_of_study();
			}
			else if(input == 2)
			{
				person.check_degree_progress();
			}
			else if(input == 3)
			{
				person.print_information();
			}
			else if (input == 4)
			{
				info.setInfo();
			}
		}
			whatNext();
			in.close();
	}
	
	/**
	 * This is the first method that is called for a student and the second for a professor
	 * basically this is the homepage which allows users to select their desired option.
	 * 
	 */
	public void whatNext() throws IOException
	{
		Scanner in = new Scanner(System.in);
		int input;
		
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("Sweet! what next?\n" 
				+ "0 - To quit\n1 - Program of study, Degree progress, or View/Change Personal Information\n2 "
				+ "- Course Information\n3 - Major/Minor completed and needed courses or Program of study form\n4 - "
				+ "Information for Professors (Only if you are a professor)");
		System.out.println("------------------------------------------");
		input = in.nextInt();
		if(input == 1 || input == 2 || input == 3 || input == 4)
		{
			
			if(input == 1)
			{
				userInfo();
			}
			else if(input == 2)
			{
				courseInfo();
			}
			else if(input == 3)
			{
				majorMinor();
			}
			else if(input == 4)
			{
				isProfessor();
			}
			
		}
		else if(input == 0)
		{
			exitMessage();
		}
		in.close();
		
	}
	
	/*
	 * This provides students or professors with 
	 * description of courses, credits, and prereqs for the entered course
	 */
	public void courseInfo() throws IOException 
	{
		String input = "";
		int input2 = 1;
		person = new user();
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		course rCourse = new course();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Enter the course you would like to know more about");
		System.out.println("--------------------------------------------------");
		input = in.nextLine();
		rCourse = person.view_course_information(input.toLowerCase());
		
		while(input2 == 1 || input2 == 2 || input2 == 3)
		{
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Perfect! Which would you like to know?\n"
					+ "0 - Go back\n1 - Description\n2 - Number of Credits\n3 - Prerequisites");
			System.out.println("-------------------------------");
			input2 = in2.nextInt();
			if(input2 == 1)
			{
				System.out.println("+++++++++++++++++++++++++++++++");
				System.out.println("Output:");
				System.out.println(rCourse.getDescription());
				System.out.println("+++++++++++++++++++++++++++++++");
			}
			else if(input2 == 2)
			{
				System.out.println("+++++++++++++++++++++++++++++++");
				System.out.println("Output:");
				System.out.println(rCourse.getCredits());
				System.out.println("+++++++++++++++++++++++++++++++");
			}
			else if(input2 == 3)
			{
				System.out.println("+++++++++++++++++++++++++++++++");
				System.out.println("Output:");
				System.out.println(rCourse.getPrerequisites());
				System.out.println("+++++++++++++++++++++++++++++++");
			}
			
		}
		whatNext();
		in.close();
		in2.close();
	}
	
	/**
	 * This method allows the user to get their respective program of study
	 * or degree progress
	 * 
	 * Technically this would be passed an instance of Student that matches their name and info
	 * to get the specific info for the specific student
	 */
	public void majorMinor() throws IOException
	{
		Scanner in = new Scanner(System.in);
		int input = 1;
		Student stu = new Student();
		
		
		
		while(input == 1 || input == 2)
		{
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("Fantastic! which would you like?\n" 
					+ "0 - Go back\n1 - Program of study form\n2 "
					+ "- Major/Minor completed or needed courses (Degree Progress)");
			System.out.println("------------------------------------------");
			input = in.nextInt();
		
		if(input == 1)
		{
			System.out.println("+++++++++++++++++++++++++++++++");
			System.out.println("Output:");
			System.out.println(stu.get_program_Study());
			System.out.println("+++++++++++++++++++++++++++++++");
		}
		else if(input == 2)
		{
			System.out.println("+++++++++++++++++++++++++++++++");
			System.out.println("Output:");
			System.out.println(stu.get_DegreeProgress());
			System.out.println("+++++++++++++++++++++++++++++++");
		}
		}
		whatNext();
		in.close();
	}

}
