/**
*@author mohammd ashraf yawar 161044123
* java programming project
* Branch class stores information of a created Branch object it has paramater naemd branchName which store given string in it.
*/
public class Branch{

	private String branchName;
	/**
	*defalut constructor of Branch type
	*/
	Branch(){}
	
	/**
	*Branch consctrutor takes an input string and assings it's value in banchName Branch class variable.
	*@param branchName this parameter is a string type 
	*/
	Branch(String branchName){this.branchName = branchName;}
	
	/**
	*this function returns branchName as string
	*@return banchName is returned as string to the calling scope
	*/
	String getName(){return branchName;}
	
	/**
	*this function takes a string as input and assings it to branchName variable in Branch class
	*@param branchName this parameter is a string type 
	*/
	void setName(String branchName){this.branchName = branchName;}
}