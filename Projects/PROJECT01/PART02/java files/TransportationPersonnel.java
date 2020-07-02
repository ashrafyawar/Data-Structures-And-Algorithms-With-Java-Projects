/**
*TransportationPersonnel class extends the class User and has all functionality if User abstract class 
*/
import java.util.ArrayList;
class TransportationPersonnel extends Person{
	
	private String branchName;
	private ArrayList<Package> packageList;


	/**
	*default constructor of type TranspoetaionPersonnel class
	*/
	TransportationPersonnel(){ packageList = new ArrayList<>(0);}
	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as string
	*@param id
	* and calls constructor of super class which is User class in this case and assign the values. 
	*/
	TransportationPersonnel(String name,String surename ,String position,int id){
		super(name,surename,position,id);
		packageList = new ArrayList<>(0);
	}

	/**
	*this function returns branchName as reference
	*@return branchName is returned as string
	*/
	protected String getBranchName(){return this.branchName;}
	
	/**
	*this function takes a string as input and assings it to branchName variable in Person class
	*@param branchName this parameter is a type of string
	*/
	protected void setBranchName(String branchName){this.branchName  = branchName;}

	/**
	*@return packageList is returned as cutomer class arraylist
	*/
	protected ArrayList<Package> getPackageList(){return this.packageList;}
	
	/**
	*this function takes a package class arraylist as input and assings it to packageList variable
	*@param packageList this parameter is a type of Package class
	*/
	protected void setPackageList(ArrayList<Package>  packageList){this.packageList  = packageList;}

	/**
	* this function takes an object of type package and adds the element to the package list
	*/
	protected void addPackage(Package element){ packageList.add(element); }
	
	/**
	*@param index this parameter is int  type 
	*/
	protected void removePackage(int index){ packageList.remove(index); }

	public String toString(){ return "TransportationPersonnel Name: "+
	getName() +" TransportationPersonnel Surename: "+ getSurename() +
	" TransportationPersonnel Position: "+ getPosition() +" TransportationPersonnel Id: "+ getId(); }
}