import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(" **************** Software Store Management System ****************");

        String adminPass = "1453";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean isCorrect = false;
        String selection;
        SoftwareStoreAutomation obj = new SoftwareStoreAutomation();

        System.out.println("***** SOFTWARE STORE AUTOMATION SYSTEM *****");
        do{
            System.out.println("**************************************");
            System.out.println("Search By Software Name     >> 1");
            System.out.println("Search By Software Quantity >> 2");
            System.out.println("Search By Software Price    >> 3");

            System.out.println("Administrator Menu          >> 4");
            System.out.println("User Menu                   >> 5");
            System.out.println("Exiting Program             >> 6");

            System.out.print("Enter Your Selection: ");
            selection = myObj.nextLine();  // Read user input

            if (selection.equals("1")){
                System.out.print("Type Software Name Without Version: ");
                obj.SearchBySoftName(new SoftwareInfo(myObj.nextLine(),0,0));
                isCorrect = true;
            }
            else if (selection.equals("2")){
                System.out.print("Type Software Price To Find: ");
                obj.SearchBySoftPrice(new SoftwareInfo(null,Integer.parseInt(myObj.nextLine()),0));
                isCorrect = true;
            }
            else if (selection.equals("3")){
                System.out.print("Type Software Quantity: ");
                obj.SearchBySoftQuantity(new SoftwareInfo(null,0,Integer.parseInt(myObj.nextLine())));
                isCorrect = true;
            }
            else if (selection.equals("4")) {
                boolean isPassed = false;
                Scanner adminInput = new Scanner(System.in);  // Create a Scanner object

                do{
                    System.out.print("Admin Password Please: ");
                    String input = adminInput.nextLine();
                    if (input.equals(adminPass)){
                        isPassed = true;
                    }
                }while (isPassed == false);

                System.out.println();
                System.out.println("************************************");
                System.out.println("            Admin Menu              ");
                System.out.println("************************************");

                System.out.println("Search By Software Name     >> 1");
                System.out.println("Search By Software Quantity >> 2");
                System.out.println("Search By Software Price    >> 3");
                System.out.println("Add A New Software          >> 4");
                System.out.println("Remove A Software           >> 5");
                System.out.println("Browse Through Software's   >> 6");
                System.out.println("Go Back                     >> 7");


                System.out.print("Your Selection: ");
                selection = myObj.nextLine();
                if(selection.equals("1")){
                    System.out.print("Type Software Name Without Version: ");
                    obj.SearchBySoftName(new SoftwareInfo(myObj.nextLine(),0,0));
                }
                else if (selection.equals("2")){
                    System.out.print("Type Software Price To Find: ");
                    obj.SearchBySoftPrice(new SoftwareInfo(null,Integer.parseInt(myObj.nextLine()),0));
                }
                else if (selection.equals("3")){
                    System.out.print("Type Software Quantity: ");
                    obj.SearchBySoftQuantity(new SoftwareInfo(null,0,Integer.parseInt(myObj.nextLine())));
                }
                else if (selection.equals("4")){

                    System.out.print("New Software Name And Version: ");
                    String softNameVersion = myObj.nextLine();

                    System.out.print(softNameVersion+"' Price: ");
                    Integer price = Integer.parseInt(myObj.nextLine());

                    System.out.print(softNameVersion+"' Quantity: ");
                    Integer Quantity = Integer.parseInt(myObj.nextLine());

                    boolean isAdded = obj.add(new SoftwareInfo(softNameVersion,price,Quantity));
                    System.out.println();
                    obj.browseSoftwares();

                    if(isAdded){
                        System.out.println("Software Added Successfully !!!!");
                    }
                    else{
                        System.out.println("Opps Could Not Add The Software !!!! ");
                    }
                }
                else if (selection.equals("5")){
                    System.out.print("Enter Name Of the Software With Version To Delete: ");
                    String softNameVersion = myObj.nextLine();
                    obj.remove(softNameVersion);
                    obj.browseSoftwares();
                }
                else if (selection.equals("6")){
                    System.out.println("Browsing All Software...");
                    obj.browseSoftwares();
                }
                else if (selection.equals("7")){
                    System.out.println("Exiting Menu ....");
                }
                else{
                    System.out.println("Wrong Input !!!!");
                }
                isCorrect = true;
            }
            else if (selection.equals("5")) {
                System.out.println("************************************");
                System.out.println("            User Menu              ");
                System.out.println("************************************");

                System.out.println("Search By Software Name     >> 1");
                System.out.println("Search By Software Quantity >> 2");
                System.out.println("Search By Software Price    >> 3");
                System.out.println("Browse Through Software's   >> 4");

                System.out.print("Your Selection: ");
                selection = myObj.nextLine();

                if(selection.equals("1")){
                    System.out.print("Type Software Name Without Version: ");
                    obj.SearchBySoftName(new SoftwareInfo(myObj.nextLine(),0,0));
                }
                else if (selection.equals("2")){
                    System.out.print("Type Software Price To Find: ");
                    obj.SearchBySoftPrice(new SoftwareInfo(null,Integer.parseInt(myObj.nextLine()),0));
                }
                else if (selection.equals("3")){
                    System.out.print("Type Software Quantity: ");
                    obj.SearchBySoftQuantity(new SoftwareInfo(null,0,Integer.parseInt(myObj.nextLine())));
                }
                else if (selection.equals("4")){
                    System.out.println("Browsing All Software...");
                    obj.browseSoftwares();
                }
                else{
                    System.out.println("Wrong Input !!!!");
                }
                isCorrect = false;
            }
            else if (selection.equals("6")){
                System.out.println("Exiting System...");
                isCorrect = true;
            }else{
                System.out.println("Wrong Selection Exiting The System...");
                isCorrect = true;
            }
        }while (isCorrect == false);
    }
}