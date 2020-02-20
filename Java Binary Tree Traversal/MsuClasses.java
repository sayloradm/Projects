package project21;

public class MsuClasses {
	
	public String title = "";
	public String courseId = "";
	public int seats = 0;
	public int sectionNum = 0;
	static String ID = "";
	private static int seatTotal = 0;
	public String startTime = "";
	public String endTime = "";
	public String location = "";
	public String type = "";
	public String key = "";
	public String val = "";
	public String[] input = new String[100];
	public boolean isLect = false;
	
/**
 * 
 * @param input the string from the CSV reader to be pulled apart
 * and divided into single values
 */
public MsuClasses(String[] input)
{
	//ID of the course
	courseId = input[1];
	
	//Section number 
	sectionNum = Integer.parseInt(input[2]);
	//Title of the course 
	title = input[3];
	//Lecture or not
	type = input[16];
	//How many seats per section
	seats = Integer.parseInt(input[5]);
	//time of the class
	startTime = input[17];
	//end time of class
	endTime = input[18];
	//location of class
	location = input[19];
	
}
/***
 * 
 * @param inp1 a string to store the value of the courseID
 */
public void addSeats(String inp1)
{	
	//If the section is the first section then the value of total seats 
	//is updated to the total seat value 
	if(sectionNum == 1)
	{
		seatTotal = seats;
	}
	//If the previous courseId is equal to the current one
	//then seats will be added to the totalSeats for that section
	if(ID.equals(courseId))
    {
		//The special case that 494 has the same name but different classes
		if(courseId.equals("CSCI 494"))
		{
			return;
		}
		//Add number of seats of specific section to total number of 
		//seats for all sections of that class
		seatTotal += seats;
    }
	
	//sets ID to the previous courses ID to be compared with the next courseId
    ID = inp1;
    //Final value for seats is stored to be sent into the BST
    seats = seatTotal;
}
/***
 * Constructs the key for the BST using information from the 
 * line of the CSV 
 * @return returns the key
 */
public String getKey()
{
		
		key = startTime + "-" + endTime +"-"+ location;
		
		return key;
		
}
/***
 * Constructs the value for the BST using information from 
 * each line from the CSV
 * @return returns the value to be associated with the key
 */
public String getVal()
{
		
		String space = Output(String.valueOf(title).length());
		val = courseId + "  " + sectionNum + " 	" + seats + " 	" + title + space + key;
		return val;
}
/***
 * Checks to see if the type of class is equal to lecture or seminar
 *
 * @return returns true or false depending on class type
 */
public boolean isLecture()
{
	
	if (type.equals("Lecture") || type.equals("Seminar"))
	{
		return true;
	}
	else
	{
		return false;
	}
}

//Adds spaces to each title so that they all line up nicely with the "When"
public String Output(int size)
{
	String blankSpace = "";
	
	while(size < 34)
	{
		blankSpace += " ";
		size++;
	}
	
	return blankSpace;
}

}
