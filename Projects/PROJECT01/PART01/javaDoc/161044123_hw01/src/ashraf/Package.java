package ashraf;

/**
*Package class is used to store informaion of sender reciever and package itself of a package
*/
public class Package{

	private String senderName,senderSurename,recieverName,recieverSurename,packageName,packageStatus;
	private int senderTrackingNumber,packageTrackingNumber;
	
	/**
	*defalut constructor of Package type
	*/
	public Package(){}
	
	/**
	*this function returns senderName as string
	*@return senderName is returned as string to the calling scope
	*/
	public String getSenderName(){return this.senderName;}
	
	/**
	*this function takes a string as input and assings it to senderName variable in Package class
	*@param senderName this parameter is a string type 
	*/
	public void setSenderName(String senderName){this.senderName = senderName;};
	/**
	*this function returns senderSurename as string
	*@return senderSurename is returned as string to the calling scope
	*/
	public String getSenderSurename(){return this.senderSurename;}
	/**
	*this function takes a string as input and assings it to senderSurename variable in Package class
	*@param senderSurename this parameter is a string type 
	*/
	public void setSenderSurename(String senderSurename){this.senderSurename = senderSurename;}
	/**
	*this function returns recieverName as string
	*@return recieverName is returned as string to the calling scope
	*/
	public String getRecieverName(){return this.recieverName;}
	/**
	*this function takes a string as input and assings it to recieverName variable in Package class
	*@param recieverName this parameter is a string type 
	*/
	public void setRecieverName(String recieverName){this.recieverName = recieverName;};
	/**
	*this function returns recieverSurename as string
	*@return recieverSurename is returned as string to the calling scope
	*/
	public String getRecieverSurename(){return this.recieverSurename;}
	/**
	*this function takes a string as input and assings it to recieverSurename variable in Package class
	*@param recieverSurename this parameter is a string type 
	*/
	public void setRecieverSurename(String recieverSurename){this.recieverSurename = recieverSurename;}
	/**
	*this function returns packageName as string
	*@return packageName is returned as string to the calling scope
	*/
	public String getPackageName(){return this.packageName;}
	/**
	*this function takes a string as input and assings it to packageName variable in Package class
	*@param packageName this parameter is a string type 
	*/
	public void setPackageName(String packageName){this.packageName = packageName;};
	/**
	*this function returns senderTrackingNumber as integer
	*@return senderTrackingNumber is returned as string to the calling scope
	*/
	public int getsenderTrackingNumber(){return this.senderTrackingNumber;}
	/**
	*this function takes a string as input and assings it to senderTrackingNumber variable in Package class
	*@param senderTrackingNumber this parameter is a string type 
	*/
	public void setsenderTrackingNumber(int senderTrackingNumber){this.senderTrackingNumber = senderTrackingNumber;}
	/**
	*this function returns packageTrackingNumber as integer
	*@return packageTrackingNumber is returned as string to the calling scope
	*/
	public int getpackageTrackingNumber(){return this.packageTrackingNumber;}
	/**
	*this function takes a string as input and assings it to packageTrackingNumber variable in Package class
	*@param packageTrackingNumber this parameter is a string type 
	*/
	public void setpackageTrackingNumber(int packageTrackingNumber){this.packageTrackingNumber = packageTrackingNumber;}
	/**
	*this function returns packageStatus as string
	*@return packageStatus is returned as string to the calling scope
	*/
	public String getPackageStatus(){return this.packageStatus;}
	/**
	*this function takes a string as input and assings it to packageStatus variable in Package class
	*@param packageStatus this parameter is a string type 
	*/
	public void setPackageStatus(String packageStatus){this.packageStatus = packageStatus;}
}