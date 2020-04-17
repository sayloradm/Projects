package course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseList {
		
		// Class Diagram says userlist as var name but it is a list of courses
		HashMap<String, course> courselist = new HashMap<>();
		//Offerings was added here instead of course class because it makes more
		//sense to do it here so it will keep an entire list of the courses
		//as they are read in
		List<course> offerings = new ArrayList<course>();
	
	/**
	 * This method opens the CSV containing the data and
	 * parses it by commas as well as dealing with double quotes in names and class
	 * titles.
	 * 
	 * The method adds the name of the course attached to the couse object 
	 * to a courselist hashmap so that a course and all of the information with
	 * it can be obtained by searching the hashmap for the course name.
	 */
	public CourseList() throws IOException
	{
		String file = "C:/Users/saylo/2020-Spring_ScheduleData_20191226.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(file));
		String line = "";

		csvReader.readLine();

		while ((line = csvReader.readLine()) != null) 
    	{
			/**
			 * String[] data splits the csv by commas as well as using regex 
			 * to deal with the class names and professor names that have 
			 * commas in the name. Basically it looks for one quote and then an end
			 * quote and adds that value to the indicated indicie.
			 */
			String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			
			/**
			 * This basically takes any quotes out as it eases with 
			 * finding professors and class names when typing them in as input
			 */
			for(int i = 0; i< data.length; i++)
			{
				data[i] = data[i].replace("\"", "");
			}
			// make each class name lowercase to ease with searching for classes
			//from user input
			data[2] = data[2].toLowerCase();
			
			//Add each course and class name to the hashmap
			courselist.put(data[2], new course(data));
			//Add each course to the offerings list
			offerings.add(new course(data));
    	}
		
		
		csvReader.close();
	}
	
	public course get_course(String clas)
	{
		return courselist.get(clas);
	}
	
	public List<course> getOfferings()
	{
		return offerings;
	}
}
	
