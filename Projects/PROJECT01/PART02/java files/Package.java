/**
*Package class is used to store informaion of sender reciever and package itself of a package
*/
public class Package{

	private String senderName,senderSurename,recieverName,recieverSurename,packageStatus;
	private int senderTrackingNumber,packageTrackingNumber;
	private String branchName;

	/**
	*defalut constructor of Package type
	*/
	Package(){}
	
	/**
	*this function returns senderName as string
	*@return senderName is returned as string to the calling scope
	*/
	protected String getSenderName(){return this.senderName;}
	
	/**
	*this function takes a string as input and assings it to senderName variable in Package class
	*@param senderName this parameter is a string type 
	*/
	protected void setSenderName(String senderName){this.senderName = senderName;};
	/**
	*this function returns senderSurename as string
	*@return senderSurename is returned as string to the calling scope
	*/
	protected String getSenderSurename(){return this.senderSurename;}
	/**
	*this function takes a string as input and assings it to senderSurename variable in Package class
	*@param senderSurename this parameter is a string type 
	*/
	protected void setSenderSurename(String senderSurename){this.senderSurename = senderSurename;}
	/**
	*this function returns recieverName as string
	*@return recieverName is returned as string to the calling scope
	*/
	protected String getRecieverName(){return this.recieverName;}
	/**
	*this function takes a string as input and assings it to recieverName variable in Package class
	*@param recieverName this parameter is a string type 
	*/
	protected void setRecieverName(String recieverName){this.recieverName = recieverName;};
	/**
	*this function returns recieverSurename as string
	*@return recieverSurename is returned as string to the calling scope
	*/
	protected String getRecieverSurename(){return this.recieverSurename;}
	/**
	*this function takes a string as input and assings it to recieverSurename variable in Package class
	*@param recieverSurename this parameter is a string type 
	*/
	protected void setRecieverSurename(String recieverSurename){this.recieverSurename = recieverSurename;}

	/**
	*this function returns senderTrackingNumber as integer
	*@return senderTrackingNumber is returned as string to the calling scope
	*/
	protected int getsenderTrackingNumber(){return this.senderTrackingNumber;}
	/**
	*this function takes a string as input and assings it to senderTrackingNumber variable in Package class
	*@param senderTrackingNumber this parameter is a string type 
	*/
	protected void setsenderTrackingNumber(int senderTrackingNumber){this.senderTrackingNumber = senderTrackingNumber;}
	/**
	*this function returns packageTrackingNumber as integer
	*@return packageTrackingNumber is returned as string to the calling scope
	*/
	protected int getPackageTrackingNumber(){return this.packageTrackingNumber;}
	/**
	*this function takes a string as input and assings it to packageTrackingNumber variable in Package class
	*@param packageTrackingNumber this parameter is a string type 
	*/
	protected void setPackageTrackingNumber(int packageTrackingNumber){this.packageTrackingNumber = packageTrackingNumber;}
	/**
	*this function returns packageStatus as string
	*@return packageStatus is returned as string to the calling scope
	*/
	protected String getPackageStatus(){return this.packageStatus;}
	/**
	*this function takes a string as input and assings it to packageStatus variable in Package class
	*@param packageStatus this parameter is a string type 
	*/
	protected void setPackageStatus(String packageStatus){this.packageStatus = packageStatus;}

	/**
	*this function returns branchName as string
	*@return branchName is returned as string
	*/
	protected String getBranchName(){return this.branchName;}
	
	/**
	*this function takes a string as input 
	*@param branchName this parameter is a type of string class
	*/
	protected void getBranchName(String branchName){this.branchName  = branchName;}

	public String toString(){ return "Sender's Name: "+ getSenderName() +" Sender's Surename: "+ getSenderSurename()+
	" Sender's TrackingNumber: "+getsenderTrackingNumber()+" Reciever's Name: "+ getRecieverName() +" Reciever's Surename: "+
	getRecieverSurename() +" Package TrackingNumber: "+getPackageTrackingNumber()+" Package Status: "+getPackageStatus();}
}