package user;

public class Personal_Information 
{

	private String name;
	private String NetId;
	private String SSN;
	private String address;
	private String phone;
	
	/**
	 * 
	 * @return users personal info
	 */
	public String getInfo()
	{
		return
				"Name: "+this.name
				+"\nNetId: "+this.NetId
				+"\nSSN: "+this.SSN
				+"\nAddress: "+this.address
				+"\nPhone: "+this.phone
				;		
	}
	/**
	 * Technically there should be getter and setter methods for 
	 * each global variable 
	 * 
	 * @param name the users name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Would prompt the user to enter all required personal info
	 */
	public void setInfo()
	{
		System.out.println("This would in theory prompt the user to set or change\ntheir personal info");
	}
	/*
	 * Returns the users name
	 */
	public String getName()
	{
		return this.name;
	}
}
