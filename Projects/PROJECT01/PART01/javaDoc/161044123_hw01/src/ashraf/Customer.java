package ashraf;

/**
*Customer class extends the class User and has all functionality if User abstract class 
*/
public class Customer extends User{
	
	private Package packageClassReffrence;

	/**
	*default constructor of type Customer class
	*/
	public Customer(){}

	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param password as string
	* and calls constructor of super class which is User class in this case and assign the values. 
	*/
	public Customer(String name,String surename ,String position, int password){super(name,surename,position,password);}


	/**
	*this function returns packageClassReffrence as reference
	*@return packageClassReffrence is returned as refence to an created object type of Package
	*/
	public Package getPackageReffrence(){return packageClassReffrence;}
	/**
	*this function takes a string as input and assings it to packageClassReffrence variable in Customer class
	*@param packageClassReffrence this parameter is a type of Package class
	*/
	public void setPackageReffrence(Package packageClassReffrence){this.packageClassReffrence = packageClassReffrence;}
}