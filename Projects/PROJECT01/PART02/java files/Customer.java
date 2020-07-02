/**
*Customer class extends the class User and has all functionality if User abstract class 
*/
class Customer extends Person{
	
	private Package packageClassReffrence;
	/**
	*default constructor of type Customer class
	*/
	Customer(){packageClassReffrence = null;}

	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param id as int
	* and calls constructor of super class which is User class in this case and assign the values. 
	*/
	Customer(String name,String surename ,String position,int id){super(name,surename,position,id);packageClassReffrence = null;}


	/**
	*this function returns packageClassReffrence as reference
	*@return packageClassReffrence is returned as refence to an created object type of Package
	*/
	protected Package getPackageReffrence(){return packageClassReffrence;}
	/**
	*this function takes a string as input and assings it to packageClassReffrence variable in Customer class
	*@param packageClassReffrence this parameter is a type of Package class
	*/
 	protected void setPackageReffrence(Package packageClassReffrence){this.packageClassReffrence = packageClassReffrence;}

 	public String toString(){ return "Customer Name: "+ getName() +" Customer Surename: "+ getSurename() +
 	" Customer Position: "+ getPosition() +" Customer Id: "+ getId(); }
}