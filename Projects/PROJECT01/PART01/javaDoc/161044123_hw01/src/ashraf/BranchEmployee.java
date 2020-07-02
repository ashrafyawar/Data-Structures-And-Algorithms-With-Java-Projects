package ashraf;

/**
*BranchEmployee class extends the class User and has all functionality if User abstract class 
*/
public class BranchEmployee extends User{

	/**
	*default constructor of type BranchEmployee class
	*/
	public BranchEmployee(){}
	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param password as string
	* and calls constructor of super class which is User class in this case and assign the values. 
	*/
	public BranchEmployee(String name,String surename ,String position, int password){super(name,surename,position,password);}
}