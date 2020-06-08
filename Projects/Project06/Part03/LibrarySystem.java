package part03Package;
import java.util.*;
public class LibrarySystem {

    public static void main(String[] args) {
        BookManipulationClass manipulate =new  BookManipulationClass();
        String adminPass = "1453";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean isCorrect = false;
        String selection;

        Map<String, Map<String,Set<String>>> authorMap = manipulate.initializeLibrary();
        manipulate.printBooks(authorMap);

        System.out.println("***** LIBRARY AUTOMATION SYSTEM *****");
       do {
            System.out.println("**************************************");
            System.out.println("1 For Administrator Menu >> ");
            System.out.println("2 For User Menu          >>");
            System.out.println("3 For Exiting Program    >>");

            System.out.print("Enter Your Selection: ");
            selection = myObj.nextLine();  // Read user input

            if (selection.equals("1")) {
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

                System.out.println("1 For Adding New Book       :");
                System.out.println("2 For Removing A Book       :");
                System.out.println("3 For Edit Information      :");
                System.out.println("4 For Search By Author Name :");
                System.out.println("5 For Search By Book Name   :");

                System.out.print("Your Selection: ");
                selection = myObj.nextLine();

                if(selection.equals("1")){
                    manipulate.addBook(authorMap);
                    System.out.println("Recent Library Content >>> ");
                    manipulate.printBooks(authorMap);
                }
                else if (selection.equals("2")){
                   manipulate.removeBook(authorMap);
                    System.out.println("Recent Library Content >>> ");
                    manipulate.printBooks(authorMap);
                }
                else if (selection.equals("3")){
                    manipulate.editLibrary(authorMap);
                    System.out.println("Recent Library Content >>> ");
                    manipulate.printBooks(authorMap);
                }
                else if (selection.equals("4")){
                    manipulate.searchByAuthorName(authorMap);
                }
                else if (selection.equals("5")){
                    manipulate.searchByTitle(authorMap);
                }else{
                    System.out.println("Wrong Input !!!!");
                }
                isCorrect = false;

            } else if (selection.equals("2")) {
                System.out.println("************************************");
                System.out.println("            User Menu              ");
                System.out.println("************************************");

                System.out.println("1 For Browse Book By Author Name :");
                System.out.println("2 For Browse Book By Book Title   :");

                System.out.print("Your Selection: ");
                selection = myObj.nextLine();

                if(selection.equals("1")){
                    manipulate.searchByAuthorName(authorMap);
                }
                else if (selection.equals("2")){
                    manipulate.searchByTitle(authorMap);
                }
                else{
                    System.out.println("Wrong Input !!!!");
                }
                isCorrect = false;
            }
            else if (selection.equals("3")){
                System.out.println("Exiting System...");
                isCorrect = true;
            }else{
                System.out.println("Wrong Selection Exiting The System...");
                isCorrect = true;
            }
        }while (isCorrect == false);
    }
}