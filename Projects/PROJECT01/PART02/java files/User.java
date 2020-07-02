public interface User{

	/**
	*this function returns name as string
	*@return name is returned as string to the calling scope
	*/
	String getName();
	
	/**
	*this function takes a string as input and assings it to name variable in Person class
	*@param name this parameter is a string type 
	*/
	void setName(String name);
	
	/**
	*this function returns surename as string
	*@return surename is returned as string to the calling scope
	*/	
	String getSurename();
	
	/**
	*this function takes a string as input and assings it to surename variable in Person class
	*@param surename this parameter is a string type 
	*/
	void setSurename(String surename);
	
	/**
	*this function returns position as string
	*@return position is returned as string to the calling scope
	*/	
	String getPosition();
	
	/**
	*this function takes a string as input and assings it to position variable in Person class
	*@param position this parameter is a string type 
	*/
	void setPosition(String position);
	
	/**
	*this function returns id as integer
	*@return id is returned as int to the calling scope
	*/
	int getId();
	
	/**
	*this function takes a int as input and assings it to id variable in Person class
	*@param id this parameter is a int type 
	*/
	void setId(int id);
	/**
	*this function is overrided in it's implremented classes
	*/
	String toString();
}