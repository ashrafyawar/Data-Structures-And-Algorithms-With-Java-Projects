package ashraf;

/**
*@author mohammd ashraf yawar 161044123
* java programming project
*/
public class AutomationSystem{
	
	public static void main(String[] args) {

		boolean correctCommand  = true,flag = true,isAdminAdded = false;// values used as flag in order to start and stop certain menu or option
		
		Ceo ceoObject = new Ceo("ashraf","yawar","Ceo",2514); //crating a ceo for the company
		Administrator adminList[] = new Administrator[0];//array referes to admin objects
		Branch branchList[] = new Branch[0];//array referes to Branch objects
		BranchEmployee branchEmployeeList[] = new BranchEmployee[0];//array referes to branch employee objects
		TransportationPersonnel transportationPersonnelList[] = new TransportationPersonnel[0];//array referes to transportation personnel objects
		Customer customerList[] = new Customer[0];//array referes to customer objects
		Package packageList[] = new Package[0];//array referes to package objects
		
		System.out.println();
		
		System.out.println(" ******* YAWAR BROTHERS CARGO COMPANY ******* ");
		System.out.println(" * WE HAVE ESTABLISHED THIS COMPANY IN 2020 *");
		System.out.println(" > COMPANY CEO IS MR : " + ceoObject.getName() + " " + ceoObject.getSurename());

		System.out.println("MR "+ceoObject.getName() + " " + ceoObject.getSurename() + " PLEASE HIRE ATLEAST ONE ADMINISTRATOR TO YOUR CARGO COMPANY :");
		

		//this loop is to hire administrator to the system (atleast one admin should be hired otherwise program will keep asking user)
		while(isAdminAdded == false){

			System.out.println("<< 1 For Hiring   >> ");
			System.out.print("<< 2 for Stopping >> ");
			String command = System.console().readLine();

			if(command.equals("1")){
				
				Administrator adminObject = new Administrator();//created an admin onject as temporaty used inside this if statment

				System.out.print("admin's name: ");
				adminObject.setName(System.console().readLine());
				System.out.print("admin's surename: ");
				adminObject.setSurename(System.console().readLine());
				adminObject.setPosition("Administrator");
				System.out.print("admin's password: ");
				adminObject.setPassword(Integer.parseInt(System.console().readLine()));
				
				Administrator adminArray[] = new Administrator[adminList.length+1];
				System.arraycopy( adminList,0,adminArray,0,adminArray.length-1);
				adminArray[adminArray.length-1] = adminObject;
				adminList = adminArray;//set the temporary array as new admin list array in order to use it throw out the program

				isAdminAdded = false; // admi added
			}
			else if(command.equals("2") && adminList.length <= 0){
				
				System.out.println("Atleat One Admin Please ");// errore message
				isAdminAdded = false; // atleast one admin not added and trying to exit 
			}
			else if(command.equals("2") && adminList.length > 0){
				
				isAdminAdded = true; // admin added and terminitating
			}
			else{
			
				System.out.println("Invalid Input !! ");
				isAdminAdded = false; // invalid
			}
		}

		System.out.println();
		while(flag == true){
		
			System.out.println(" *** PLEASE LOGIN TO SYSTEM IN ORDER TO MAKE CHANGES *** ");			
			System.out.println(" 1 For Login Page >> ");
			System.out.println(" 2 For Exit Page  >> ");
			System.out.print("Selection : ");
			String selection = System.console().readLine();
			
			correctCommand = true;
			if(selection.equals("1")){

				System.out.println(" ******************** Login Page ********************* ");

				System.out.print(" Name:");
				String name = System.console().readLine();
				System.out.print(" SureName:");
				String surename = System.console().readLine();
				System.out.print(" Position:");
				String position = System.console().readLine();
				System.out.print(" Password:");
				int password = Integer.parseInt(System.console().readLine());

				if(position.equals(ceoObject.getPosition())){ //Ceo has authority to close the system
					
					if(name.equals(ceoObject.getName()) && surename.equals(ceoObject.getSurename()) && password == ceoObject.getPassword()){
						
						System.out.println( "MR " + ceoObject.getName() + " " + ceoObject.getSurename() + " Is  Closing The System ...");
						System.exit(0);
					}
					else{ System.out.println("Ceo Info Is Wrong Try Again :) "); }
				}
				else if(position.equals("Administrator")){
					
					boolean isAdminExist = false;
					for (int i = 0; i < adminList.length;i++){ //this loop athutecates the user info to login
						
						if(name.equals(adminList[i].getName()) && surename.equals(adminList[i].getSurename()) &&
						 	password == adminList[i].getPassword() && position.equals(adminList[i].getPosition())){
							isAdminExist = true;//confirms that the user exists in the list
						}
					}

					correctCommand = true;
					if (isAdminExist == true){

						while(correctCommand == true){ // if the user info is correct in the list then login
							
							System.out.println(" ***************************************************** ");
							System.out.println(" 	***********	Admin Page *********** 	  		   	   ");
							System.out.println(" << 1 For Adding A Branch                           >> ");
							System.out.println(" << 2 For Removing A Branch                         >> ");
							System.out.println(" << 3 For Adding A Branch Employee                  >> ");
							System.out.println(" << 4 For Removing A Branch Employee                >> ");
							System.out.println(" << 5 For Adding A Branch Transportation Personnel  >> ");
							System.out.println(" << 6 For Removing A Branch Transportation Personel >> ");
							System.out.println(" << 7 For LOGING OUT                                >> ");
							System.out.println(" ***************************************************** ");

							System.out.print("Enter Your Selection : ");
							String command = System.console().readLine();

							if(command.equals("1")){

								Branch branchObject = new Branch();

								System.out.print("Branch name: ");
								branchObject.setName(System.console().readLine());
								
								Branch branchArray[] = new Branch[branchList.length+1];//set branch arr lenght as branchList array lenght+1
								System.arraycopy( branchList,0,branchArray,0,branchArray.length-1);//copy array branchList to branchArray
								branchArray[branchArray.length-1] = branchObject;//set last element of branchArray as object branchObject
								branchList = branchArray;// update branchList array

								System.out.println( branchObject.getName()+" Has Been Established :) ");
								correctCommand = true; 	
							}
							else if(command.equals("2")){
									
								System.out.println("Active Branchs In Our Company :");
								for (int i  = 0;i < branchList.length;i++){
									System.out.print(i + ":" + branchList[i].getName()+" ");
								}
								System.out.println();
								
								System.out.print("Enter The branchIndex Of A Branch In Order To Delete It : ");
								int removalbranchIndex = Integer.parseInt(System.console().readLine());

								Branch branchArray[] = new Branch[branchList.length-1];// creat temporary array of branch type
								Branch firstHalfOfArray[]  =  new Branch[removalbranchIndex];//array which holds first part of branchList array
								Branch secondHalfOfArray[]  = new Branch [ branchList.length-removalbranchIndex-1];//array which holds second part of branchList array
								System.arraycopy( branchList,0,firstHalfOfArray,0,firstHalfOfArray.length);//copy first part of array until removal element's branchIndex
								System.arraycopy( branchList,removalbranchIndex+1,secondHalfOfArray,0,secondHalfOfArray.length);//copy second part of array until the lenght 
								System.arraycopy(firstHalfOfArray, 0, branchArray, 0, firstHalfOfArray.length);//copty first part to main array
								System.arraycopy(secondHalfOfArray, 0, branchArray, firstHalfOfArray.length, secondHalfOfArray.length);//copy second part to main array
								branchList = branchArray;//update branchList array to be used later on

								System.out.println("Branch Has Been Deleted Successfully :) ");
								System.out.println("New Branch List : ");
								
								for (int i = 0;i < branchList.length;i++){
									System.out.print(i+" "+branchList[i].getName()+" ");
								}
								
								System.out.println();
								correctCommand = true;	
							}
							else if(command.equals("3")){
								
								BranchEmployee branchEmployeeObject = new BranchEmployee();

								System.out.println("Enter Info Of The Branch Employee >> ");
								
								System.out.print(" Name:");
								branchEmployeeObject.setName(System.console().readLine());
								System.out.print(" Surename:");
								branchEmployeeObject.setSurename(System.console().readLine());
								branchEmployeeObject.setPosition("BranchEmployee");
								System.out.print(" password:");
								branchEmployeeObject.setPassword( Integer.parseInt(System.console().readLine()));

								System.out.println("Active Branchs In Our Company :");
								
								for (int i  = 0;i < branchList.length;i++){
									System.out.print(i + ":" + branchList[i].getName()+" ");
								}
								System.out.println();
								
								System.out.println(" Hire Mr/Miss " + branchEmployeeObject.getName() + " To One Of The Branchs Avaiable In The List >>>");
								System.out.print(" Enter branchIndex: ");
								int branchIndex = Integer.parseInt(System.console().readLine());
								branchEmployeeObject.setBranchRefference(branchList[branchIndex]);
								
						
								BranchEmployee branchEmployeeArray[] = new BranchEmployee[branchEmployeeList.length+1];//set branchEmployeeArray lenght as branchEmployeeList array lenght+1
								System.arraycopy( branchEmployeeList,0,branchEmployeeArray,0,branchEmployeeArray.length-1);	//copy array branchEmployeeList to branchEmployeeArray
								
								branchEmployeeArray[branchEmployeeArray.length-1] = branchEmployeeObject;	//set last element of branchEmployeeArray as object branch_em_obj
								branchEmployeeList = branchEmployeeArray;// update branchEmployeeList array

								System.out.println("Employee Has Been Hired !!!");
								correctCommand = true;	
							}
							else if(command.equals("4")){
							
								System.out.println("List Of Employees In This Company >>> ");
								for (int i = 0;i < branchEmployeeList.length;i++){

									System.out.println(" >> "+i+" "+branchEmployeeList[i].getName()+" "+branchEmployeeList[i].getSurename()
									+" "+branchEmployeeList[i].getPosition());
								}
								
								System.out.print(" Enter branchIndex Of The Employee Who You Want Fire: ");
								int removalbranchIndex = Integer.parseInt(System.console().readLine());

								BranchEmployee branchEmployeeArray[] = new BranchEmployee[branchEmployeeList.length-1];// creat temporary array of branch type
								BranchEmployee firstHalfOfArray[]  =  new BranchEmployee[removalbranchIndex];//array which holds first part of branchEmployeeList array
								BranchEmployee secondHalfOfArray[]  = new BranchEmployee [ branchEmployeeList.length-removalbranchIndex-1];//array which holds second part of branchEmployeeList array
								
								System.arraycopy( branchEmployeeList,0,firstHalfOfArray,0,firstHalfOfArray.length);//copy first part of array until removal element's branchIndex
								System.arraycopy( branchEmployeeList,removalbranchIndex+1,secondHalfOfArray,0,secondHalfOfArray.length);//copy second part of array until the lenght 
								System.arraycopy(firstHalfOfArray, 0, branchEmployeeArray, 0, firstHalfOfArray.length); //copty first part to main array 
								System.arraycopy(secondHalfOfArray, 0, branchEmployeeArray, firstHalfOfArray.length, secondHalfOfArray.length);//copy second part to main array
								
								branchEmployeeList = branchEmployeeArray;//update branchEmployeeList array to be used later on
								
								System.out.println("Employee Has Been Fired  Successfully :( ");
								System.out.println("New Employee List : ");
								
								for (int i = 0;i < branchEmployeeList.length;i++){
									System.out.print(i+": "+branchEmployeeList[i].getName()+" "+branchEmployeeList[i].getSurename()+" ");
								}

								System.out.println();
								correctCommand = true;	
							}
							else if(command.equals("5")){

								TransportationPersonnel transportationPersonnelObject = new TransportationPersonnel();

								System.out.println("Enter Info Of The Transportation Personnel >> ");
								
								System.out.print(" Name:");
								transportationPersonnelObject.setName(System.console().readLine());
								System.out.print(" Surename:");
								transportationPersonnelObject.setSurename(System.console().readLine());
								transportationPersonnelObject.setPosition("TransportationPersonnel");
								System.out.print(" password:");
								transportationPersonnelObject.setPassword( Integer.parseInt(System.console().readLine()));

								System.out.println("Active Branchs In Our Company :");
								
								for (int i  = 0;i < branchList.length;i++){
									System.out.print(i + ":" + branchList[i].getName()+" ");
								}
								System.out.println();
								
								System.out.println(" Hire Mr/Miss " + transportationPersonnelObject.getName() + " To One Of The Branchs Avaiable In The List >>>");
								System.out.print(" Enter branchIndex Of A Branch : ");
								int branchIndex = Integer.parseInt(System.console().readLine());
								transportationPersonnelObject.setBranchRefference(branchList[branchIndex]);

								TransportationPersonnel transportationPersonnelArray[] = new TransportationPersonnel[transportationPersonnelList.length+1];//set transportationPersonnelArray lenght as transportationPersonnelList array lenght+1
								System.arraycopy( transportationPersonnelList,0,transportationPersonnelArray,0,transportationPersonnelArray.length-1);//copy array transportationPersonnelList to transportationPersonnelArray
								transportationPersonnelArray[transportationPersonnelArray.length-1] = transportationPersonnelObject;//set last element of transportationPersonnelArray as object transportationPersonnelObject
								transportationPersonnelList = transportationPersonnelArray;// update transportationPersonnelList array

								System.out.println("TransportationPersonnel Has Been Hired !!!");
								correctCommand = true;
							}
							else if(command.equals("6")){
								
								System.out.println("List Of TransportationPersonnel In This Company >>> ");
								for (int i = 0;i < transportationPersonnelList.length;i++){

									System.out.println(" >> "+i+" "+transportationPersonnelList[i].getName()+" "+transportationPersonnelList[i].getSurename()
									+" "+transportationPersonnelList[i].getPosition());
								}
								
								System.out.print(" Enter branchIndex Of The Employee Who You Want Fire: ");
								int removalbranchIndex = Integer.parseInt(System.console().readLine());

								TransportationPersonnel transportationPersonnelArray[] = new TransportationPersonnel[transportationPersonnelList.length-1];//creat temporary array of branch type
								TransportationPersonnel firstHalfOfArray[]  =  new TransportationPersonnel[removalbranchIndex];//array which holds first part of transportationPersonnelList array
								TransportationPersonnel secondHalfOfArray[]  = new TransportationPersonnel [ transportationPersonnelList.length-removalbranchIndex-1];//array which holds second part of transportationPersonnelList array
								
								System.arraycopy( transportationPersonnelList,0,firstHalfOfArray,0,firstHalfOfArray.length);//copy first part of array until removal element's branchIndex
								System.arraycopy( transportationPersonnelList,removalbranchIndex+1,secondHalfOfArray,0,secondHalfOfArray.length);//copy second part of array until the lenght 
								System.arraycopy(firstHalfOfArray, 0, transportationPersonnelArray, 0, firstHalfOfArray.length);//copty first part to main array  
								System.arraycopy(secondHalfOfArray, 0, transportationPersonnelArray, firstHalfOfArray.length, secondHalfOfArray.length);//copy second part to main array
								
								transportationPersonnelList = transportationPersonnelArray;//update transportationPersonnelList array to be used later on
								
								System.out.println("TransportationPersonnel Has Been Fired  Successfully :( ");
								System.out.println("New TransportationPersonnel List : ");
								
								for (int i = 0;i < transportationPersonnelList.length;i++){
									System.out.print(i+": "+transportationPersonnelList[i].getName()+" "+transportationPersonnelList[i].getSurename()+" ");
								}

								System.out.println();
								correctCommand = true;	
							}
							else if(command.equals("7")){correctCommand = false;}
							else{
								System.out.println("ERROE Enter Commands Bitween 1 And 6 !!!!! ");
								correctCommand = true;
							}
						}
					}
					else{ System.out.println("Error Admin Info Is Incorrect !!!"); }
				}
				else if(position.equals("BranchEmployee")){

					boolean isBranchEmployeeExist = false;
					for (int i = 0; i < branchEmployeeList.length;i++){ //this loop athutecates the user info to login
						
						if(name.equals(branchEmployeeList[i].getName()) && surename.equals(branchEmployeeList[i].getSurename()) &&
						 	password == branchEmployeeList[i].getPassword() && position.equals(branchEmployeeList[i].getPosition())){
							isBranchEmployeeExist = true;
						}
					}

					correctCommand = true;
					if(isBranchEmployeeExist == true){

						while(correctCommand == true){

							System.out.println(" ***************************************************** ");
							System.out.println(" ***********Branch Employee Page*********** 	       ");
							System.out.println(" << 1 For Adding A Customer                         >> ");
							System.out.println(" << 2 For Removing A Customer                       >> ");
							System.out.println(" << 3 For Recieve Package To Branch                 >> ");
							System.out.println(" << 4 For Send Package From Branch                  >> ");
							System.out.println(" << 5 For Change Status Of Arrived Packages         >> ");
							System.out.println(" << 6 For LOGING OUT                                >> ");
							System.out.println(" ***************************************************** ");

							System.out.print("Enter Your Selection : ");
							String command = System.console().readLine();

							if(command.equals("1")){
								
								Customer customerObject = new Customer();

								System.out.print("Customer's name : ");
								customerObject.setName(System.console().readLine());
								System.out.print("Customer's surename : ");
								customerObject.setSurename(System.console().readLine());
								customerObject.setPosition("Customer");
								System.out.print("Customer's Traching packageTrackingNumber : ");
								customerObject.setPassword(Integer.parseInt(System.console().readLine()));
								
								Customer customerArray[] = new Customer[customerList.length+1];//set customerArray lenght as customerList array lenght+1
								System.arraycopy( customerList,0,customerArray,0,customerArray.length-1);//copy array customerList to customerArray
								
								customerArray[customerArray.length-1] = customerObject;//set last element of customerArray as object customerObject
								customerList = customerArray;// update customerList array

								System.out.println("customerList : ");
								
								for(int i = 0;i < customerList.length;i++){
									System.out.print(customerList[i].getName()+" "+customerList[i].getSurename()+" "+customerList[i].getPassword()+" ");
								}

								System.out.println();
								correctCommand = true;
							}
							else if(command.equals("2")){
							
								System.out.println("Active Customer List In Our Company :");
								
								for (int i  = 0;i < customerList.length;i++){
									System.out.println(i + ":" + customerList[i].getName()+" "+customerList[i].getSurename()+
									" "+customerList[i].getPassword());
								}
								System.out.println();
								
								System.out.print("Enter The branchIndex Of A Customer In Order To Delete : ");
								int removalbranchIndex = Integer.parseInt(System.console().readLine());

								Customer customerArray[] = new Customer[customerList.length-1];//creat temporary array of branch type
								Customer firstHalfOfArray[]  =  new Customer[removalbranchIndex];//array which holds first part of customerList array
								Customer secondHalfOfArray[]  = new Customer [ customerList.length-removalbranchIndex-1];//array which holds second part of customerList array
								
								System.arraycopy( customerList,0,firstHalfOfArray,0,firstHalfOfArray.length);//copy first part of array until removal element's branchIndex
								System.arraycopy( customerList,removalbranchIndex+1,secondHalfOfArray,0,secondHalfOfArray.length);//copy second part of array until the lenght 
								System.arraycopy(firstHalfOfArray, 0, customerArray, 0, firstHalfOfArray.length);//copty first part to main array  
								System.arraycopy(secondHalfOfArray, 0, customerArray, firstHalfOfArray.length, secondHalfOfArray.length);//copy second part to main array
								
								customerList = customerArray;//update customerList array to be used later on

								System.out.println("Customer Has Been Deleted Successfully :) ");
								System.out.println("New Customer List : ");
								
								for (int i = 0;i < customerList.length;i++){
									System.out.print(i+" "+customerList[i].getName()+" ");
								}
								
								System.out.println();
								correctCommand = true;
							}
							else if(command.equals("3")){

								System.out.println(" >> Press 1 For Already  A Registered Customer  >> ");
								System.out.println(" >> Press 2 For Register And Enter Package Info >> ");
								String choise = System.console().readLine();
								
								if (choise.equals("1")){

									System.out.println("Active Customer List In Our Company :");
									
									for (int i  = 0;i < customerList.length;i++){
										System.out.println(" >> "+i + ":" + customerList[i].getName()+" "+customerList[i].getSurename()+
										" "+customerList[i].getPassword());
									}
									System.out.println();
									
									System.out.print("Enter branchIndex Of Customer Who Has Been Registered Before: ");
									int customer_branchIndex = Integer.parseInt(System.console().readLine());

									Package packageObject = new Package();

									packageObject.setSenderName(customerList[customer_branchIndex].getName());
									packageObject.setSenderSurename(customerList[customer_branchIndex].getSurename());
									packageObject.setsenderTrackingNumber(customerList[customer_branchIndex].getPassword());
									System.out.println("Sender's Info Entered Now Enter Recivers's Info :");
									
									System.out.print("Reciever's Name: ");
									packageObject.setRecieverName(System.console().readLine());
									System.out.print("Reciever's SureName: ");
									packageObject.setRecieverSurename(System.console().readLine());
									System.out.print("Package  Name: ");
									packageObject.setPackageName(System.console().readLine());
									packageObject.setPackageStatus("inbranch");
									System.out.print("Package Tracking packageTrackingNumber: ");
									packageObject.setpackageTrackingNumber(Integer.parseInt(System.console().readLine()));

									Package packageArray[] = new Package[packageList.length+1];
									System.arraycopy( packageList,0,packageArray,0,packageArray.length-1);
									packageArray[packageArray.length-1] = packageObject;
									packageList = packageArray;
									customerList[customer_branchIndex].setPackageReffrence(packageObject);//set the refrence of customer class's packages reference to obj of a package class
								
								}else if(choise.equals("2")){

									Customer customerObject = new Customer();
									System.out.print("Customer's name : ");
									customerObject.setName(System.console().readLine());
									System.out.print("Customer's surename : ");
									customerObject.setSurename(System.console().readLine());
									customerObject.setPosition("Customer");
									System.out.print("Customer's Tracking packageTrackingNumber : ");
									customerObject.setPassword(Integer.parseInt(System.console().readLine()));
									
									Package packageObject = new Package();

									packageObject.setSenderName(customerObject.getName());
									packageObject.setSenderSurename(customerObject.getSurename());
									packageObject.setsenderTrackingNumber(customerObject.getPassword());

									System.out.println("Sender's Info Entered Now Enter Recivers's Info :");
									System.out.print("Reciever's Name: ");
									packageObject.setRecieverName(System.console().readLine());
									System.out.print("Reciever's SureName: ");
									packageObject.setRecieverSurename(System.console().readLine());
									System.out.print("Package  Name: ");
									packageObject.setPackageName(System.console().readLine());
									packageObject.setPackageStatus("inbranch");
									System.out.print("Package Tracking packageTrackingNumber: ");
									packageObject.setpackageTrackingNumber(Integer.parseInt(System.console().readLine()));

									Package packageArray[] = new Package[packageList.length+1];
									System.arraycopy( packageList,0,packageArray,0,packageArray.length-1);
									packageArray[packageArray.length-1] = packageObject;
									packageList = packageArray;
									customerObject.setPackageReffrence(packageObject);//set reference of customerObject type of Customer class as packageObject

									Customer customerArray[] = new Customer[customerList.length+1];
									System.arraycopy( customerList,0,customerArray,0,customerArray.length-1);
									customerArray[customerArray.length-1] = customerObject;
									customerList = customerArray;
									System.out.println("Package Has Been Registered To The System Successfully :)");
									
									for (int i=0;i < packageList.length;i++){
										System.out.print(" >> "+packageList[i].getPackageName()+" "+packageList[i].getPackageStatus()+" ");
									}
									System.out.println();
								}
								else{System.out.println("Wrong Input Only 1 Or 2 !!! ");}

								correctCommand = true;
							}
							else if(command.equals("4")){

								System.out.print("Enter Tracking packageTrackingNumber Of Package To Send:");
								int packageTrackingNumber = Integer.parseInt(System.console().readLine());
								boolean isPackageExist = false;
								
								for (int i = 0;i < packageList.length;i++){
									if(packageTrackingNumber == packageList[i].getpackageTrackingNumber() && packageList[i].getPackageStatus().equals("inbranch")){
										packageList[i].setPackageStatus("on the way");
										isPackageExist = true;
										break;
									}
								}

								if(isPackageExist == true){
									System.out.println("Package Tracking packageTrackingNumber "+packageTrackingNumber+" Is In It's Way To Deriviration Precess :) ");
								}
								else{
									System.out.println("No Package Has This Tracking packageTrackingNumber Or Package Is Not In Branch :( ");
								}

								correctCommand = true;
							}
							else if(command.equals("5")){

								System.out.print("Enter Tracking packageTrackingNumber Of Delvered Package:");
								int packageTrackingNumber = Integer.parseInt(System.console().readLine());
								boolean isPackageExist = false;
								
								for (int i = 0;i < packageList.length;i++){
									if(packageTrackingNumber == packageList[i].getpackageTrackingNumber() && packageList[i].getPackageStatus().equals("on the way")){
										packageList[i].setPackageStatus("delivered");
										isPackageExist = true;
										break;
									}
								}

								if(isPackageExist == true){
									System.out.println("Package Tracking packageTrackingNumber "+packageTrackingNumber+" Has Been Delvered Successfully :) ");
								}
								else{
									System.out.println("No Package Has This Tracking packageTrackingNumber Or Package Is Not On The Way :( ");
								}

								correctCommand = true;
							}
							else if(command.equals("6")){correctCommand = false;}
							else{ 
							
								System.out.println("ERROE Enter Commands Bitween 1 And 6 !!!!! ");
								correctCommand = true;
							}	
						}
					}
					else{ System.out.println("Error !!  BranchEmployee Is Not In The List  :( ");}
				}
				else if(position.equals("TransportationPersonnel")){

					boolean isTransportaionPersonnelExist = false;
					for (int i = 0; i < transportationPersonnelList.length;i++){ //this loop athutecates the user info to login
						
						if(name.equals(transportationPersonnelList[i].getName()) && surename.equals(transportationPersonnelList[i].getSurename()) &&
						 	password == transportationPersonnelList[i].getPassword() && position.equals(transportationPersonnelList[i].getPosition())){
							isTransportaionPersonnelExist = true;
						}
					}

					correctCommand = true;
					if(isTransportaionPersonnelExist == true){

						while(correctCommand == true){

							System.out.println(" ************************************************************************* ");
							System.out.println(" ***********  Transportation Personnel Page ***********   ");
							System.out.println(" << 1 For Check For Deleverd Packages And Delete Them From Package List >> ");
							System.out.println(" << 2 For LOGING OUT                                                    >> ");
							System.out.println(" ************************************************************************* ");

							System.out.print("Enter Your Selection: ");
							String command = System.console().readLine();

							if(command.equals("1")){
								
								System.out.print("Enter Tracking packageTrackingNumber Of Delvered Package:");
								int packageTrackingNumber = Integer.parseInt(System.console().readLine());
								boolean isPackageExist = false;
								
								for (int i = 0;i < packageList.length;i++){
									if(packageTrackingNumber == packageList[i].getpackageTrackingNumber() && packageList[i].getPackageStatus().equals("delivered")){

										Package packageArray[] = new Package[packageList.length-1];
										Package firstHalfOfArray[]  =  new Package[i];
										Package secondHalfOfArray[]  = new Package [ packageList.length-i-1];

										System.arraycopy( packageList,0,firstHalfOfArray,0,firstHalfOfArray.length);
										System.arraycopy( packageList,i+1,secondHalfOfArray,0,secondHalfOfArray.length);
										System.arraycopy(firstHalfOfArray, 0, packageArray, 0, firstHalfOfArray.length);  
										System.arraycopy(secondHalfOfArray, 0, packageArray, firstHalfOfArray.length, secondHalfOfArray.length);

										packageList = packageArray;
										
										isPackageExist = true;
										break;
									}
								}

								if(isPackageExist == true){
									System.out.println("Package Tracking packageTrackingNumber "+packageTrackingNumber+" Has Been Deleted From Package List Successfully :) ");
								}
								else{
									System.out.println("No Package Has This Tracking packageTrackingNumber Or Package Is Not Delvered Yet :( ");
								}

								correctCommand = true;
							}
							else if(command.equals("2")){ correctCommand = false;}
							else{ System.out.println("Error Wrong Input :( "); correctCommand = true;}	
						}
					}
					else{ System.out.println("Error !!  TransportationPersonnel Is Not In The List  :( ");}
				}
				else if(position.equals("Customer")){

					boolean isCustomerExist = false;
					
					for (int i = 0; i < customerList.length;i++){ //this loop athutecates the user info to login
						
						if(name.equals(customerList[i].getName()) && surename.equals(customerList[i].getSurename()) &&
						 	password == customerList[i].getPassword() && position.equals(customerList[i].getPosition())){
							isCustomerExist = true;
						}
					}

					correctCommand = true;
					if(isCustomerExist == true){

						while(correctCommand == true){

							System.out.println(" ************************************************************************* ");
							System.out.println(" ***********     Customer Page     ***********   ");
							System.out.println(" << 1 For Displaying Sender's Reciever's And Package Info               >> ");
							System.out.println(" << 2 For LOGING OUT                                                    >> ");
							System.out.println(" ************************************************************************* ");
							
							System.out.print("Enter Your Selection : ");
							String command = System.console().readLine();

							if(command.equals("1")){

								System.out.print("Enter Tracking packageTrackingNumber :");
								int packageTrackingNumber = Integer.parseInt(System.console().readLine());
								 

								boolean isPackageExist = false;
								for (int i = 0;i < customerList.length;i++){
									
									if(packageTrackingNumber == customerList[i].getPassword()){
										
										System.out.println(" >> Sender Name: "+customerList[i].getPackageReffrence().getSenderName());
										System.out.println(" >> Sender SureName: "+customerList[i].getPackageReffrence().getSenderSurename());
										System.out.println(" >> Package Name: "+customerList[i].getPackageReffrence().getPackageName());
										System.out.println(" >> Reciever Name: "+customerList[i].getPackageReffrence().getRecieverName());
										System.out.println(" >> Reciever SureName: "+customerList[i].getPackageReffrence().getRecieverSurename());
										System.out.println(" >> Package Tracking packageTrackingNumber: "+customerList[i].getPackageReffrence().getpackageTrackingNumber());
										System.out.println("Package Current Status: "+customerList[i].getPackageReffrence().getPackageStatus());
										isPackageExist = true;
										break;
									}
								}

								if(isPackageExist == false){
									System.out.println(" No Customer With This Tracking packageTrackingNumber :(");
								}

								correctCommand = true;
							}
							else if(command.equals("2")){
							
								correctCommand = false;
							}
							else{
								
								System.out.println("Wrong Input :( ")
								;correctCommand  = true;
							}	
						}
					}
					else{ System.out.println("Error !!  Customer Is Not In The List  :( ");}
				}
				else{ System.out.println(" invalid input !!! "); }
				flag = true;
			}
			else if(selection.equals("2")){
				System.exit(0);
			}	
		}
	}
}