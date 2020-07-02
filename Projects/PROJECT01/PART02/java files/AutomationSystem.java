/**
*@author mohammd ashraf yawar 161044123
* java programming project
*/
import java.util.Scanner;
import java.util.ArrayList;

public class AutomationSystem{
	
	public static void main(String[] args) {

		boolean correctCommand  = true,flag = true,isAdminAdded = false;// values used as flag in order to start and stop certain menu or option
		int idCounter = 0; 
		Ceo ceoObject = new Ceo("ashraf","yawar","Ceo",idCounter++); //crating a ceo for the company
		Scanner inputstream = new Scanner(System.in); 

		System.out.println();
		System.out.println(" ******* YAWAR BROTHERS CARGO COMPANY ******* ");
		System.out.println(" * WE HAVE ESTABLISHED THIS COMPANY IN 2020 *");
		System.out.println(" > COMPANY CEO IS MR : " + ceoObject);
		System.out.println("MR "+ceoObject.getName() + " " + ceoObject.getSurename() + " PLEASE HIRE ATLEAST ONE ADMINISTRATOR TO YOUR CARGO COMPANY :");
		
		//this loop is to hire administrator to the system (atleast one admin should be hired otherwise program will keep asking user)
		while(isAdminAdded == false){

			System.out.println("<< 1 For Hiring   >> ");
			System.out.println("<< 2 For Removing >> ");
			System.out.print("<< 3 for Stopping >> ");
			String command = inputstream.nextLine();

			if(command.equals("1")){
				
				Administrator adminObject = new Administrator();//created an admin onject as temporaty used inside this if statment

				System.out.print("admin's name: ");
				adminObject.setName(inputstream.nextLine());
				System.out.print("admin's surename: ");
				adminObject.setSurename(inputstream.nextLine());
				adminObject.setPosition("Administrator");
				adminObject.setId(idCounter++);
				System.out.println("Your Id is : "+adminObject.getId());
				
				ceoObject.addEmployee(adminObject);

				isAdminAdded = false; // admi added
			}
			else if(command.equals("2")){
				
				if (ceoObject.getAdminList().size() == 0){
					System.out.println("No Administrator To Be Removed !!!! :( ");
				}
				else{

					int index = 0;
					boolean doit = true;

					System.out.println("Avaiable Administrators >> ");
					for (int i = 0;i<ceoObject.getAdminList().size();i++){
						System.out.println( i +": "+ceoObject.getAdminList().get(i));
					}

					System.out.print("Enter Index: ");
					
					try{ index = Integer.parseInt(inputstream.nextLine()); }
					catch(NumberFormatException ex){
						System.out.println(ex +" is not an Enteger!!! Enter Enteger Numbers :");
						doit = false;
					}
					
					if(doit == true){ 
						
						try{ ceoObject.removeEmployee( new Administrator(),index); }
						catch(IndexOutOfBoundsException ind){System.out.println("ooops Wrong Index !! ENTER correct Index :) "); doit = false;}
						if(doit == true){ System.out.println("Administrator At Index " +index+" Ha been removed Successfully :)"); }
					}
				}
			}
			else if(command.equals("3") && ceoObject.getAdminList().size()<= 0){
				
				System.out.println("Atleat One Admin Please ");// errore message
				isAdminAdded = false; // atleast one admin not added and trying to exit 
			}
			else if(command.equals("3") && ceoObject.getAdminList().size()> 0){
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
			
			String selection = inputstream.nextLine();
			
			correctCommand = true;
			if(selection.equals("1")){
				
				int id = 0;
				boolean doit = true;
				
				System.out.println(" ******************** Login Page ********************* ");
				System.out.print(" Name:");
				String name = inputstream.nextLine();
				System.out.print(" SureName:");
				String surename = inputstream.nextLine();
				System.out.print(" Position:");
				String position = inputstream.nextLine();
				System.out.print(" Id:");

				try{ id = Integer.parseInt(inputstream.nextLine());}
				catch(NumberFormatException ex){
					System.out.println( ex + " Enter An Enteger :");
					doit = false;
				}

				if (doit == true){ // if not exeption is occured

					if(position.equals(ceoObject.getPosition())){ //Ceo has authority to close the system
						
						if(name.equals(ceoObject.getName()) && surename.equals(ceoObject.getSurename()) &&
						id == ceoObject.getId()){
							
							System.out.println( "MR " + ceoObject.getName() + " " + ceoObject.getSurename() + " Is  Closing The System ...");
							System.exit(0);
						}
						else{ System.out.println("Ceo Info Is Wrong Try Again :) "); }
					}
					else if(position.equals("Administrator")){
						
						boolean isAdminExist = false;
						
						for (int i = 0; i < ceoObject.getAdminList().size();i++){ //this loop athutecates the user info to login
							
							if(id == ceoObject.getAdminList().get(i).getId()){
								isAdminExist = true;//confirms that the user exists in the list
							}
						}

						correctCommand = true;
						if(isAdminExist == true){

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
								
								String command = inputstream.nextLine();

								if(command.equals("1")){

									Branch branchObject = new Branch();

									System.out.print("Branch Name: ");
									String branchName = inputstream.nextLine();
									branchObject.setName(branchName);
									
									branchObject.setId(idCounter++);
									System.out.println("Branch Id is: " + branchObject.getId());

									for (int i = 0;i < ceoObject.getAdminList().size();i++){
										ceoObject.getAdminList().get(i).addBranch(branchObject);
									}
								
									System.out.println( branchObject.getName()+" Branch Has Been Established :) ");
									correctCommand = true; 	
								}
								else if(command.equals("2")){
									
									int removalbranchIndex = 0;
									doit = true;

									System.out.println("Active Branchs In Our Company :");
									for (int i  = 0;i < ceoObject.getAdminList().get(0).getBranchList().size();i++){
										System.out.println(i + ":" + ceoObject.getAdminList().get(0).getBranchList().get(i));
									}
									System.out.println();
									
									System.out.print("Enter The branchIndex Of A Branch In Order To Delete It : ");
									
									try{ removalbranchIndex = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
										doit = false;
									}

									if(doit == true){
										
										// deleting process...
										for (int i = 0;i < ceoObject.getAdminList().size();i++){

											try{ ceoObject.getAdminList().get(i).removeBranch(removalbranchIndex);}//removes branch from every admin out there since each admin has access to all the branches in a company
											catch(IndexOutOfBoundsException ind){System.out.println("ooops Wrong Index !! ENTER correct Index :) "); doit = false; break;}
										}
										if(doit == true){
											
											System.out.println("Branch Has Been Deleted Successfully :) ");
											System.out.println("New Branch List : ");
										
											for (int i = 0;i < ceoObject.getAdminList().get(0).getBranchList().size();i++){
												System.out.println(i+" "+ceoObject.getAdminList().get(0).getBranchList().get(i));
											}
											System.out.println();
										}
									}
									correctCommand = true;	
								}
								else if(command.equals("3")){
									
									int branchIndex = 0;
									doit = true;
									BranchEmployee branchEmployeeObject = new BranchEmployee();

									System.out.println("Enter Info Of The Branch Employee >> ");
									System.out.print(" Name:");
									branchEmployeeObject.setName(inputstream.nextLine());
									System.out.print(" Surename:");
									branchEmployeeObject.setSurename(inputstream.nextLine());
									branchEmployeeObject.setPosition("BranchEmployee");
									branchEmployeeObject.setId(idCounter++);
									System.out.println(" BranchEmployee Id is:" + branchEmployeeObject.getId()+" remember it in order to login :) ");

									System.out.println("Active Branchs In Our Company :");
									for (int i  = 0;i < ceoObject.getAdminList().get(0).getBranchList().size();i++){
										System.out.println(i + ":" + ceoObject.getAdminList().get(0).getBranchList().get(i));
									}
									System.out.println();
									
									System.out.println(" Hire Mr/Miss " + branchEmployeeObject.getName() + " To One Of The Branchs Avaiable In The List >>>");
									System.out.print(" Enter branchIndex: ");

									try{ branchIndex = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex  + " ENTER AN ENTEGER >> ");
										doit = false;
									}

									if(doit == true){

										try{branchEmployeeObject.setBranchName(ceoObject.getAdminList().get(0).getBranchList().get(branchIndex).getName());} //set branch employee related branch name here
										catch(IndexOutOfBoundsException ex){
											System.out.println(" Wrong index !!! :( ");
											doit  =false;
										}

										if(doit == true){
											
											for (int i = 0;i < ceoObject.getAdminList().size();i++){
												ceoObject.getAdminList().get(i).addEmployee(branchEmployeeObject);
											}
											System.out.println("Employee Has Been Hired !!!");
										}
									}
									correctCommand = true;	
								}
								else if(command.equals("4")){
								
									int removalbranchEmployeeIndex = 0;
									doit = true;

									System.out.println("List Of Employees In This Company >>> ");
									for (int i = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().size();i++){

										System.out.println(" >> "+i+" "+
										ceoObject.getAdminList().get(0).getBranchEmployeeList().get(i));
									}
									
									System.out.print(" Enter Index Of The Employee Who You Want Fire: ");
									
									try{ removalbranchEmployeeIndex = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex  + " ENTER AN ENTEGER >> ");
										doit = false;
									}

									if(doit == true){
										
										for (int i = 0;i < ceoObject.getAdminList().size();i++){

											try{ ceoObject.getAdminList().get(i).removeEmployee(new BranchEmployee(),removalbranchEmployeeIndex); }
											catch(IndexOutOfBoundsException ind){
											
												System.out.println("ooops Wrong Index !! ENTER correct Index :) ");
												doit = false;
												break;
											}
										}
										if(doit == true){
											
											System.out.println("Employee Has Been Fired  Successfully :( ");
											System.out.println("New Employee List : ");
											
											for (int i = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().size();i++){

												System.out.println(" >> "+i+" "+
												ceoObject.getAdminList().get(0).getBranchEmployeeList().get(i));
											}
										}
										System.out.println();
									}	
									correctCommand = true;	
								}
								else if(command.equals("5")){

									int branchIndex = 0;
									doit = true;

									TransportationPersonnel transportationPersonnelObject = new TransportationPersonnel();

									System.out.println("Enter Info Of The Transportation Personnel >> ");
									
									System.out.print(" Name:");
									transportationPersonnelObject.setName(inputstream.nextLine());
									System.out.print(" Surename:");
									transportationPersonnelObject.setSurename(inputstream.nextLine());
									transportationPersonnelObject.setPosition("TransportationPersonnel");
									transportationPersonnelObject.setId(idCounter++);
									System.out.println("Remember Your Id : "+transportationPersonnelObject.getId());
									
									System.out.println("Active Branchs In Our Company :");
									
									for (int i  = 0;i < ceoObject.getAdminList().get(0).getBranchList().size();i++){
										System.out.println(i + ":" + ceoObject.getAdminList().get(0).getBranchList().get(i));
									}

									System.out.println();
									
									System.out.println(" Hire Mr/Miss " + transportationPersonnelObject.getName() + " To One Of The Branchs Avaiable In The List >>>");
									System.out.print(" Enter branchIndex Of A Branch : ");
									
									try{ branchIndex = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex  + " ENTER AN ENTEGER >> ");
										doit = false;
									}

									if(doit == true){

										try{ transportationPersonnelObject.setBranchName(ceoObject.getAdminList().get(0).getBranchList().get(branchIndex).getName()); } //set branch employee related branch name here
										catch(IndexOutOfBoundsException ind){
											System.out.println("Wrong index :( ");
											doit = false;
										}
										if(doit == true){
											for (int i = 0;i < ceoObject.getAdminList().size();i++){
												ceoObject.getAdminList().get(i).addEmployee(transportationPersonnelObject);
											}
											System.out.println("TransportationPersonnel Has Been Hired !!!");
										}
									}
									correctCommand = true;
								}
								else if(command.equals("6")){
									
									int removalTransportaionPersonnelIndex = 0;
									doit = true;
									System.out.println("List Of TransportationPersonnel In This Company >>> ");
									for (int i = 0;i < ceoObject.getAdminList().get(0).getTransportationPersonnelList().size();i++){
										System.out.println(" >> "+i+" "+ceoObject.getAdminList().get(0).getTransportationPersonnelList().get(i));
									}
									
									System.out.print(" Enter Index Of The Employee Who You Want Fire: ");
									
									try{ removalTransportaionPersonnelIndex = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex  + " ENTER AN ENTEGER >> ");
										doit = false;
									}

									if(doit == true){

										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											try {ceoObject.getAdminList().get(i).removeEmployee(new TransportationPersonnel(),removalTransportaionPersonnelIndex); }
											catch(IndexOutOfBoundsException ind){System.out.println("ooops Wrong Index !! ENTER correct Index :) "); doit = false; break;}
										}

										if(doit == true){

											System.out.println("TransportationPersonnel Has Been Fired  Successfully :( ");
											System.out.println("New TransportationPersonnel List : ");
											
											for (int i = 0;i < ceoObject.getAdminList().get(0).getTransportationPersonnelList().size();i++){
												System.out.println(" >> "+i+" "+ceoObject.getAdminList().get(0).getTransportationPersonnelList().get(i));
											}
										}
										System.out.println();
									}
									correctCommand = true;
								}
								else if(command.equals("7")){correctCommand = false;}
								else{
									System.out.println("ERROE Enter Commands Bitween 1 And 7 !!!!! ");
									correctCommand = true;
								}
							}
						}
						else{ System.out.println("Error Admin Info Is Incorrect !!!"); }
					}
					else if(position.equals("BranchEmployee")){

						boolean isBranchEmployeeExist = false;
						for (int i = 0; i < ceoObject.getAdminList().get(0).getBranchEmployeeList().size();i++){ //this loop athutecates the user info to login
							
							if(name.equals(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(i).getName()) && surename.equals(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(i).getSurename()) && position.equals(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(i).getPosition())){
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
								String command = inputstream.nextLine();

								if(command.equals("1")){
									
									Customer customerObject = new Customer();

									System.out.print("Customer's name : ");
									customerObject.setName(inputstream.nextLine());
									System.out.print("Customer's surename : ");
									customerObject.setSurename(inputstream.nextLine());
									customerObject.setPosition("Customer");
									System.out.print("Customer's Traching packageTrackingNumber is : ");
									customerObject.setId(idCounter++);
									
									for (int i = 0;i < ceoObject.getAdminList().size();i++){
										for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
											ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).addCustomer(customerObject);
										}
									}

									System.out.println("New customerList : ");
									
									for(int i = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().size();i++){
										System.out.println(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i));
									}

									System.out.println();
									correctCommand = true;
								}
								else if(command.equals("2")){
								
									int removalCustomerIndex = 0;
									doit = true;

									System.out.println("Active Customer List In Our Company :");
									
									for (int i  = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().size();i++){
										System.out.println(i + ":" + ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i));
									}

									System.out.println();
									System.out.print("Enter The Index Of A Customer In Order To Delete : ");
									
									try{ removalCustomerIndex = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
										doit = false;
									}
									
									if(doit == true){

										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												try{ ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).removeCustomer(removalCustomerIndex);}
												catch(IndexOutOfBoundsException ind){System.out.println("ooops Wrong Index !! ENTER correct Index :) "); doit = false;break;}
											}
											if(doit == false)
												break;
										}

										if(doit == true){

											System.out.println("Customer Has Been Deleted Successfully :) ");
											System.out.println("New Customer List : ");
											
											for (int i  = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().size();i++){
												System.out.println(i + ":" + ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i));
											}
										}
										System.out.println();
									}
									correctCommand = true;
								}
								else if(command.equals("3")){

									System.out.println(" >> Press 1 For Already  A Registered Customer  >> ");
									System.out.println(" >> Press 2 For Register And Enter Package Info >> ");
									String choise = inputstream.nextLine();
									
									if (choise.equals("1")){

										int customerIndex = 0;
										doit = true;

										System.out.println("Active Customer List In Our Company :");
										
										for (int i  = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().size();i++){
											System.out.println(i + ":" + ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i));
										}

										System.out.println();
										
										System.out.print("Enter Index Of Customer Who Has Been Registered Before: ");
										
										try{ customerIndex = Integer.parseInt(inputstream.nextLine()); }
										catch(NumberFormatException ex){
											System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
											doit = false;
										}

										if(doit == true){

											Package packageObject = new Package();

											try{
											
												packageObject.setSenderName(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(customerIndex).getName());
												packageObject.setSenderSurename(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(customerIndex).getSurename());
												packageObject.setsenderTrackingNumber(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(customerIndex).getId());
											}
											catch(IndexOutOfBoundsException ind){
												System.out.println("ooops Index is out of bouund :( ");
												doit = false;
											}
											if(doit ==  true){

												System.out.println("Sender's Info Entered Now Enter Recivers's Info :");
												System.out.print("Reciever's Name: ");
												packageObject.setRecieverName(inputstream.nextLine());
												System.out.print("Reciever's SureName: ");
												packageObject.setRecieverSurename(inputstream.nextLine());
												packageObject.setPackageStatus("inbranch");
												System.out.print("PackageTrackingNumber is: ");
											}
											try{ packageObject.setPackageTrackingNumber(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(customerIndex).getId()); } //tracking number of package name and tracking number of customer is the same
											catch(IndexOutOfBoundsException ind){
												System.out.println("ooops Index out of bound :(");
												doit = false;
											}
											if(doit == true){
												
												System.out.println(packageObject.getPackageTrackingNumber());
												for (int i  = 0;i < ceoObject.getAdminList().size();i++){
													for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
														ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).addPackage(packageObject);
													}
												}

												for (int i  = 0;i < ceoObject.getAdminList().size();i++){
													for (int j = 0;j < ceoObject.getAdminList().get(i).getTransportationPersonnelList().size();j++){
														ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).addPackage(packageObject);
													}
												}

												for (int i = 0;i < ceoObject.getAdminList().size();i++){
													for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
														for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().size();k++){
															if( k == customerIndex){
																ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().get(k).setPackageReffrence(packageObject);
															}
														}	
													}
												}
											}
										}
										correctCommand = true;
									}else if(choise.equals("2")){

										Customer customerObject = new Customer();
										System.out.print("Customer's name : ");
										customerObject.setName(inputstream.nextLine());
										System.out.print("Customer's surename : ");
										customerObject.setSurename(inputstream.nextLine());
										customerObject.setPosition("Customer");
										System.out.print("Customer's Tracking Number is : ");
										customerObject.setId(idCounter++);
										System.out.println(customerObject.getId());
										
										Package packageObject = new Package();

										packageObject.setSenderName(customerObject.getName());
										packageObject.setSenderSurename(customerObject.getSurename());
										packageObject.setsenderTrackingNumber(customerObject.getId());
										System.out.println("Sender's Info Entered Now Enter Recivers's Info :");
										
										System.out.print("Reciever's Name: ");
										packageObject.setRecieverName(inputstream.nextLine());
										System.out.print("Reciever's SureName: ");
										packageObject.setRecieverSurename(inputstream.nextLine());
										packageObject.setPackageStatus("inbranch");
										System.out.print("Package Tracking packageTrackingNumber is: ");
										packageObject.setPackageTrackingNumber(customerObject.getId()); //tracking number of package name and tracking number of customer is the same
										System.out.println(packageObject.getPackageTrackingNumber());
										
										//adding customer to the all customer lists

										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j  = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).addCustomer(customerObject);
											}
											
										}
										// add package to the list of packages in branch employee list
										for (int i  = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).addPackage(packageObject);
											}
										}

										// add package to the list of packages in transportaion personnel list
										for (int i  = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getTransportationPersonnelList().size();j++){
												ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).addPackage(packageObject);
											}
										}

										// adding the pacakges to the specipic customer from the list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().size();k++){
													if( k == customerObject.getId()){
														ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().get(k).setPackageReffrence(packageObject);
														break;
													}
												}	
											}
										}

										System.out.println("Package Has Been Registered To The System Successfully :)");
										for (int i=0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getPackageList().size();i++){
											System.out.println(" >> "+ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getPackageList().get(i));
										}
										System.out.println();
									}
									else{System.out.println("Wrong Input Only 1 Or 2 !!! ");}

									correctCommand = true;
								}
								else if(command.equals("4")){

									int packageTrackingNumber = 0;
									doit = true;

									System.out.print("Enter  packageTrackingNumber To Send:");
									try{ packageTrackingNumber = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
										doit = false;
									}

									if(doit == true){
										
										boolean isPackageExist = false;
										
										//loop to upadate the status of the given package in all employee list package list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).getPackageTrackingNumber()){
														
														ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).setPackageStatus("on the way");
														isPackageExist = true;
														break;
													}
												}
											}
										}

										//loop to upadate the status of the given package in all employee list customer list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().get(k).getId()){
														
														ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().get(k).getPackageReffrence().setPackageStatus("on the way");
														isPackageExist = true;
														break;
													}
												}
											}
										}

										//loop to upadate the status of the given package in all employee list transportation  list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getTransportationPersonnelList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).getPackageList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).getPackageList().get(k).getPackageTrackingNumber()){
														
														ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).getPackageList().get(k).setPackageStatus("on the way");
														isPackageExist = true;
														break;
													}
												}
											}
										}

										if(isPackageExist == true){
											System.out.println("Package Tracking packageTrackingNumber "+packageTrackingNumber+" Is In It's Way To Deriviration Precess :) ");
										}
										else{
											System.out.println("No Package Has This Tracking packageTrackingNumber Or Package Is Not In Branch :( ");
										}
									}
									correctCommand = true;
								}
								else if(command.equals("5")){
									
									int packageTrackingNumber = 0;
									doit = true;

									System.out.print("Enter Tracking packageTrackingNumber Of Delvered Package:");

									try{ packageTrackingNumber = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
										doit = false;
									}

									if(doit == true){

										boolean isPackageExist = false;
									
										//loop to upadate the status of the given package in all employee list package list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).getPackageTrackingNumber()){
														
														ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).setPackageStatus("delivered");
														isPackageExist = true;
														break;
													}
												}
											}
										}

										//loop to upadate the status of the given package in all employee list customer list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().get(k).getId()){
														
														ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getCustomerList().get(k).getPackageReffrence().setPackageStatus("delivered");
														isPackageExist = true;
														break;
													}
												}
											}
										}

										//loop to upadate the status of the given package in all employee list transportation  list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getTransportationPersonnelList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).getPackageList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).getPackageList().get(k).getPackageTrackingNumber()){
														
														ceoObject.getAdminList().get(i).getTransportationPersonnelList().get(j).getPackageList().get(k).setPackageStatus("delivered");
														isPackageExist = true;
														break;
													}
												}
											}
										}

										if(isPackageExist == true){
											System.out.println("Package Tracking packageTrackingNumber "+packageTrackingNumber+" Has Been Delvered Successfully :) ");
										}
										else{
											System.out.println("No Package Has This Tracking packageTrackingNumber Or Package Is Not On The Way :( ");
										}
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
						for (int i = 0;i < ceoObject.getAdminList().get(0).getTransportationPersonnelList().size();i++){ //this loop athutecates the user info to login							
							if(name.equals(ceoObject.getAdminList().get(0).getTransportationPersonnelList().get(i).getName()) &&surename.equals(ceoObject.getAdminList().get(0).getTransportationPersonnelList().get(i).getSurename()) &&id == ceoObject.getAdminList().get(0).getTransportationPersonnelList().get(i).getId() &&position.equals(ceoObject.getAdminList().get(0).getTransportationPersonnelList().get(i).getPosition())) {
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
								String command = inputstream.nextLine();

								if(command.equals("1")){
									
									int packageTrackingNumber = 0;
									doit = true;

									System.out.print("Enter Tracking Of Delvered Package:");

									try{ packageTrackingNumber = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
										doit = false;
									}

									if(doit == true){

										boolean isPackageExist = false;
										
										//delete paclage from the employee list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).getPackageTrackingNumber() &&ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).getPackageStatus().equals("delivered")){
														
														try{ ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).removePackage(k); }
														catch(IndexOutOfBoundsException ind){System.out.println("ooops Wrong Index !! ENTER correct Index :) "); doit = false;break;}
														
														isPackageExist = true;
														break;
													}
												}
												if(doit == false)
													break;
											}
											if(doit == false)
												break;
										}
										//delete package from the transportaion package list
										for (int i = 0;i < ceoObject.getAdminList().size();i++){
											for (int j = 0;j < ceoObject.getAdminList().get(i).getBranchEmployeeList().size();j++){
												for (int k = 0;k < ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().size();k++){
													if(packageTrackingNumber == ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).getPackageTrackingNumber() &&ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).getPackageList().get(k).getPackageStatus().equals("delivered")){
														
														try{ ceoObject.getAdminList().get(i).getBranchEmployeeList().get(j).removePackage(k);}
														catch(IndexOutOfBoundsException ind){System.out.println("ooops Wrong Index !! ENTER correct Index :) "); doit = false;break;}
														
														isPackageExist = true;
														break;
													}
												}
												if(doit == false)
													break;
											}
											if(doit == false)
												break;
										}

										if(doit == true){
											if(isPackageExist == true){
												System.out.println("Package Tracking packageTrackingNumber "+packageTrackingNumber+" Has Been Deleted From Package List Successfully :) ");
											}
											else{
												System.out.println("No Package Has This Tracking packageTrackingNumber Or Package Is Not Delvered Yet :( ");
											}
										}
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
						
						for (int i = 0; i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().size();i++){ //this loop athutecates the user info to login
							
							if(name.equals(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i).getName()) && surename.equals(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i).getSurename()) && id == ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i).getId() && position.equals(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i).getPosition())){
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
								String command = inputstream.nextLine();

								if(command.equals("1")){
									
									int packageTrackingNumber = 0;
									doit = true;
									
									System.out.print("Customer Enter Tracking Number :");
									
									try{ packageTrackingNumber = Integer.parseInt(inputstream.nextLine()); }
									catch(NumberFormatException ex){
										System.out.println(ex+" ENTER AN ENTEGER !!! >>>  ");
										doit = false;
									}

									if(doit == true){
									 
										boolean isPackageExist = false;
										for (int i = 0;i < ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().size();i++){
											
											if(packageTrackingNumber == ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i).getId()){
												System.out.println(ceoObject.getAdminList().get(0).getBranchEmployeeList().get(0).getCustomerList().get(i));
												isPackageExist = true;
												break;
											}
										}

										if(isPackageExist == false){
											System.out.println(" No Customer With This Tracking packageTrackingNumber :(");
										}
									}
									correctCommand = true;
								}
								else if(command.equals("2")){
								
									correctCommand = false;
								}
								else{
									
									System.out.println("Wrong Input :( ");
									correctCommand  = true;
								}	
							}
						}
						else{ System.out.println("Error !!  Customer Is Not In The List  :( ");}
					}
					else{ System.out.println(" invalid input !!! ");
					}
				}
					
				flag = true;
			}
			else if(selection.equals("2")){
				System.exit(0);
			}	
		}
	}
}