import java.util.*;

/**
* Person class is an abstract class which hold some methods and varilable which are common in it's parent classes
*/
public abstract class Person implements User{

	private String name,surename,position;
	private int id;
	
	/**
	*defalut constructor of Person type
	*/
	public Person(){}

	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param id as int
	* and assings instanciates the calling object. 
	*/

	public Person(String name,String surename ,String position,int id){
		
		this.name = name;
		this.surename = surename;
		this.position = position;
		this.id = id;
	}

	/**
	*this function returns name as string
	*@return name is returned as string to the calling scope
	*/
	public String getName(){return this.name;}
	
	/**
	*this function takes a string as input and assings it to name variable in Person class
	*@param name this parameter is a string type 
	*/
	public void setName(String name){this.name = name;};
	
	/**
	*this function returns surename as string
	*@return surename is returned as string to the calling scope
	*/	
	public String getSurename(){return this.surename;}
	
	/**
	*this function takes a string as input and assings it to surename variable in Person class
	*@param surename this parameter is a string type 
	*/
	public void setSurename(String surename){this.surename = surename;}
	
	/**
	*this function returns position as string
	*@return position is returned as string to the calling scope
	*/	
	public String getPosition(){return this.position;}
	
	/**
	*this function takes a string as input and assings it to position variable in Person class
	*@param position this parameter is a string type 
	*/
	public void setPosition(String position){this.position = position;}
	
	/**
	*this function returns id as integer
	*@return id is returned as int to the calling scope
	*/
	public int getId(){return this.id;}
	
	/**
	*this function takes a int as input and assings it to id variable in Person class
	*@param id this parameter is a int type 
	*/
	public void setId(int id){this.id = id;}

	/**
	*this function takes a element to type person (person class can hold the reference of any type which is child class of it)
	*@param element this parameter is Person class  type 
	*/
	public void addEmployee(Person element){System.out.println("this is Person addEmployee class");}
	
	/**
	*@param index this parameter is int  type
	*@param element this parameter is Person class  type 
	*/
	public void removeEmployee(Person element,int index){System.out.println("this is Person removeEmployee class");}

	public String toString(){ return "Person Name: "+
	getName() +" Person Surename: "+ getSurename() +
	" Person Position: "+ getPosition() +" Person Id: "+ getId(); 
	}
}