/**
*@author mohammd ashraf yawar 161044123
* java programming project
* Branch class stores information of a created Branch object it has paramater naemd branchName which store given string in it.
*/
public class Branch{

	private String branchName;
	private int branchId;
	/**
	*defalut constructor of Branch type
	*/
	Branch(){}
	
	/**
	*Branch consctrutor takes an input string and assings it's value in banchName Branch class variable.
	*@param branchName this parameter is a string type parameter
	*@param branchId this is an int type parameter 
	*/
	Branch(String branchName,int branchId){this.branchName = branchName; this.branchId = branchId; }
	
	/**
	*this function returns branchName as string
	*@return banchName is returned as string to the calling scope
	*/
	protected String getName(){return branchName;}
	
	/**
	*this function takes a string as input and assings it to branchName variable in Branch class
	*@param branchName this parameter is a string type 
	*/
	protected void setName(String branchName){this.branchName = branchName;}

	/**
	*this function returns branchId as int
	*@return branchId is returned as string to the calling scope
	*/
	protected int getId(){return branchId;}
	
	/**
	*this function takes a int as input and assings it to branchId variable in Branch class
	*@param branchId this parameter is a int type 
	*/
	protected void setId(int branchId){this.branchId = branchId;}
	public String toString(){ return "Bracnh name: "+ getName() +" Branch Id: "+ getId();}
	
}