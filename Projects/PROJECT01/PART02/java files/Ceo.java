
/**
*Ceo class extends the class User and has all functionality if User abstract class 
*/
import java.util.ArrayList;
class Ceo extends Person{

	private ArrayList<Administrator> adminList;
	
	/**
	*default constructor of type Ceo class
	*/
	Ceo(){ adminList = new ArrayList<>(0); }

	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param id
	* and calls constructor of super class which is User class in this case and assign the values. 
	*/
	Ceo(String name,String surename ,String position,int id){

		super(name,surename,position,id);
		adminList = new ArrayList<>(0);
	}
	
	/**
	*@return this function takes nothing and return an arraylist of type administrator class
	*/
	public ArrayList<Administrator> getAdminList(){ return this.adminList ;} 
	
	/**
	*@param adminList this function takes an arraylist of type admin 
	*/
	public void setAdminList(ArrayList<Administrator> adminList){ this.adminList = adminList;}

	/**
	* this function takes an object of type Administrator and adds the element to the SAdministrator list
	*@param element this function takes and element of type person class
	*/
	public void addEmployee(Person element){ adminList.add((Administrator)element); }
	
	/**
	*@param index this parameter is int  type 
	*@param element this parameter is person class type
	*/
	public void removeEmployee(Person element,int index){adminList.remove(index);}

	public String toString(){ return "Ceo Name: "+
	getName() +" Ceo Surename: "+ getSurename() +
	" Ceo Position: "+ getPosition() +" Ceo Id: "+ getId(); 
	}
}