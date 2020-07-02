/**
*Administrator class extends the class User and has all functionality if User abstract class 
*/
import java.util.ArrayList;
public class Administrator extends Person{
	
	private ArrayList<Branch> branchList;
	private ArrayList<BranchEmployee> branchEmployeeList;
	private ArrayList<TransportationPersonnel> transportationPersonnelList;

	/**
	*default constructor of type Administrator class
	*/
	Administrator(){ 
	
		branchList = new ArrayList<>(0);
		branchEmployeeList = new ArrayList<>(0);
		transportationPersonnelList = new ArrayList<>(0);
	}
	
	/**
	*this constructoe takes :
	*@param name as string
	*@param surename as string
	*@param position as strin
	*@param id as int
	* and calls constructor of super class which is User class in this case and assign the values. 
	*/
	Administrator(String name,String surename ,String position,int id){
		
		super(name,surename,position,id);
		branchList = new ArrayList<>(0);
		branchEmployeeList = new ArrayList<>(0);
		transportationPersonnelList = new ArrayList<>(0);
	}

	/**
	*@return function returns an arraylist of type branch class
	*/
	protected ArrayList<Branch> getBranchList(){ return this.branchList ;} 
	
	/**
	*@param branchList parameter of type arralist of type branch class
	*/
	protected void setBranchList(ArrayList<Branch> branchList){ this.branchList = branchList;}
	
	/**
	*@return function returns an arraylist of type branch employee class
	*/
	protected ArrayList<BranchEmployee> getBranchEmployeeList(){ return this.branchEmployeeList ;} 
	
	/**
	*@param branchEmployeeList parameter of type arralist of type branch employee  class
	*/
	protected void setBranchEmployeeList(ArrayList<BranchEmployee> branchEmployeeList){ this.branchEmployeeList = branchEmployeeList;}
	
	/**
	*@return function returns an arraylist of type transportation personnel class
	*/
	protected ArrayList<TransportationPersonnel> getTransportationPersonnelList(){ return this.transportationPersonnelList ;} 
	
	/**
	*@param transportaionPersonnelList parameter of type arralist of type branch employee  class
	*/
	protected void setTranportaionPersonnelList(ArrayList<TransportationPersonnel> transportationPersonnelList){ this.transportationPersonnelList = transportationPersonnelList;}

	/**
	* this function takes an arraylist of type Administrator and an object of type Administrator and adds the element to the given Administrator list
	*@param element parameter type of person class 
	*/
	public void addEmployee(Person element){

		if(element instanceof BranchEmployee) {
			branchEmployeeList.add((BranchEmployee)element);
		}

		else if(element instanceof TransportationPersonnel) {
			transportationPersonnelList.add((TransportationPersonnel)element);
		}
		else{
			System.out.println("Incompatable Type Please Check The Calling Function :( ");
		}
	}

	/**
	*@param element parameter type person class
	*@param index parameter type of integer
	*/
	public void removeEmployee(Person element,int index){

		if(element instanceof BranchEmployee){
			branchEmployeeList.remove(index);
		}
		else if(element instanceof TransportationPersonnel){
			transportationPersonnelList.remove(index);
		}
		else{
			System.out.println("Inocapatable Instance :( ");
		}
	}

	/**
	*@param branch parameter type of branch class
	*/
	protected void addBranch(Branch branch){ branchList.add(branch); }
	
	/**
	*@param index paramter type of integer
	*/
	protected void removeBranch(int index) { branchList.remove(index); }
	public String toString(){ return "Administrator Name: "+
	getName() +" Administrator Surename: "+ getSurename() +
	" Administrator Position: "+ getPosition() +" Administrator Id: "+ getId(); 
	}
}