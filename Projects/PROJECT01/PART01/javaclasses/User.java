/**
* User class is an abstract class which hold some methods and varilable which are common in it's parent classes
*/
public abstract class User{

	private String name,surename,position;
	private int password;
	private Branch branchClassReference;
	
	/**
	*defalut constructor of User type
	*/
	User(){}

	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param password as string
	* and assings instanciates the calling object. 
	*/

	User(String name,String surename ,String position, int password){
		
		this.name = name;
		this.surename = surename;
		this.position = position;
		this.password = password;
	}

	/**
	*this function returns name as string
	*@return name is returned as string to the calling scope
	*/
	String getName(){return this.name;}
	/**
	*this function takes a string as input and assings it to name variable in User class
	*@param name this parameter is a string type 
	*/
	void setName(String name){this.name = name;};
	/**
	*this function returns surename as string
	*@return surename is returned as string to the calling scope
	*/	
	String getSurename(){return this.surename;}
	/**
	*this function takes a string as input and assings it to surename variable in User class
	*@param surename this parameter is a string type 
	*/
	void setSurename(String surename){this.surename = surename;}
	/**
	*this function returns position as string
	*@return position is returned as string to the calling scope
	*/	
	String getPosition(){return this.position;}
	/**
	*this function takes a string as input and assings it to position variable in User class
	*@param position this parameter is a string type 
	*/
	void setPosition(String position){this.position = position;}
	/**
	*this function returns password as integer
	*@return password is returned as string to the calling scope
	*/
	int getPassword(){return this.password;}
	/**
	*this function takes a string as input and assings it to password variable in User class
	*@param password this parameter is a string type 
	*/
	void setPassword(int password){this.password = password;}
	/**
	*this function returns branchClassReference as reference
	*@return branchClassReference is returned as refence to an created object type of Branch
	*/
	Branch getBranchRefference(){return this.branchClassReference;}
	/**
	*this function takes a string as input and assings it to branchClassReference variable in User class
	*@param branchClassReference this parameter is a type of Branch class
	*/
	void setBranchRefference(Branch branchClassReference){this.branchClassReference  = branchClassReference;}
}