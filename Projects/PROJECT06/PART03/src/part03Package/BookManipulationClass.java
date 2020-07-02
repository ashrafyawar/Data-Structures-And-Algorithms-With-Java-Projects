package part03Package;
import java.util.*;

/**
 * this class handesl all the manipulation of library automation system using map and set data structures in java
 */
public class BookManipulationClass {

    /**
     * this function creates a Map data structure and initializes it with some values and returns it
     * @return returns a Map data structure which is simply the back bone of our library system
     */
    public Map<String, Map<String, Set<String>>> initializeLibrary(){

        Map<String, Map<String, Set<String>>> authorMap = new HashMap<>();
        Map<String, Set<String>> bookNameMap = new HashMap<>();
        Set<String> bookLocationSet = new HashSet<>();

        //Adding some Books to Library...
        bookLocationSet.add("c1s1.3452");
        bookNameMap.put("the message",bookLocationSet);
        authorMap.put("ali",bookNameMap);

        Set<String> bookLocationSet1 = new HashSet<>();
        bookLocationSet1.add("c2s1.3453");
        bookNameMap.put("the passion",bookLocationSet1);
        authorMap.put("ali",bookNameMap);

        Set<String> bookLocationSet2 = new HashSet<>();
        bookLocationSet2.add("c3s1.3455");
        bookNameMap.put("the will",bookLocationSet2);
        authorMap.put("ali",bookNameMap);

        Map<String, Set<String>> bookNameMap1 = new HashMap<>();
        Set<String> bookLocationSet3 = new HashSet<>();

        bookLocationSet3.add("c1s2.3454");
        bookNameMap1.put("computer science",bookLocationSet3);
        authorMap.put("jumer",bookNameMap1);

        Set<String> bookLocationSet4 = new HashSet<>();
        bookLocationSet4.add("c2s2.3456");
        bookNameMap1.put("the dead",bookLocationSet4);
        authorMap.put("jumer",bookNameMap1);

        Set<String> bookLocationSet5 = new HashSet<>();
        bookLocationSet5.add("c3s2.3457");
        bookNameMap1.put("3 idiots",bookLocationSet5);
        authorMap.put("jumer",bookNameMap1);

        Map<String, Set<String>> bookNameMap2 = new HashMap<>();
        Set<String> bookLocationSet6 = new HashSet<>();
        bookLocationSet6.add("c1s3.3458");
        bookNameMap2.put("IT",bookLocationSet6);
        authorMap.put("david",bookNameMap2);

        Set<String> bookLocationSet8 = new HashSet<>();
        bookLocationSet8.add("c2s3.3459");
        bookNameMap2.put("math",bookLocationSet8);
        authorMap.put("david",bookNameMap2);

        Set<String> bookLocationSet9 = new HashSet<>();
        bookLocationSet9.add("c3s3.3553");
        bookNameMap2.put("history",bookLocationSet9);
        authorMap.put("david",bookNameMap2);
        return authorMap;

    }

    /**
     * this function takes a Map data structure and adds a book to the library system if it is new or overrides
     * @param authorMap this is outer Map which holds our library information
     */
    public void addBook(Map<String, Map<String, Set<String>>> authorMap){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean added = false;

        System.out.print("Enter Book Name: ");
        String bookName = myObj.nextLine();
        System.out.print("Enter Book Author:");
        String authorName = myObj.nextLine();
        System.out.print("Enter Book Location:");
        String bookLocation = myObj.nextLine();

        //creating some data structures
        Set<String> bookLocationSet = new HashSet<>();
        bookLocationSet.add(bookLocation);
        Map<String, Set<String>> bookNameMap = new HashMap<>();
        bookNameMap.put(bookName,bookLocationSet);

        try {
            //look for the author list if same author name exists then add the new book the that author's book list
            for (Map.Entry<String, Map<String, Set<String>>> vals : authorMap.entrySet()) {
                if (vals.getKey().equals(authorName)) {
                    Map<String, Set<String>> tempMap = vals.getValue();
                    tempMap.put(bookName, bookLocationSet);
                    authorMap.put(authorName, tempMap);
                    added = true;
                }
            }
            if (!added) {//if not in the author list then create new one and add it to the author list
                authorMap.put(authorName, bookNameMap);
            }
        }catch (NullPointerException np){
            System.out.println("Null Pointer !!!");
        }
    }

    /**
     * this function removes a book from the library systems if given datas are correct or fails otherwise
     * @param authorMap this is Map data structure which is our library system back bone
     * @return returns the removes books or null if fails
     */
    public String removeBook(Map<String, Map<String, Set<String>>> authorMap){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String removedValue = null;

        try {//exceptin handaling

            System.out.print("Enter Book Name To Be Removed:");
            String bookName = myObj.nextLine();
            System.out.print("Enter Author Name Of The Book To Be Removed :");
            String authorName = myObj.nextLine();

            for (Map.Entry<String, Map<String, Set<String>>> vals : authorMap.entrySet()) {
                if (vals.getKey().equals(authorName)) {
                    removedValue = vals.getValue().remove(bookName).toString();
                }
            }
        }catch (NullPointerException np){
            System.out.println("Cannot Remove !!!!");
        }
        return removedValue;
    }

    /**
     * this function adits any book info if given book info is suitable to to edit
     * @param authorMap  Map data structure our library system information holder.
     */
    public void editLibrary(Map<String, Map<String, Set<String>>> authorMap){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean edited = false;
        System.out.println("Change Book Location :");
        System.out.print("Enter Book Name        :");
        String bookName = myObj.nextLine();
        System.out.print("Enter Author Name      :");
        String authorName = myObj.nextLine();
        System.out.print("Old Location           :");
        String oldLocation = myObj.nextLine();
        System.out.print("Enter New Location     :");
        String newLocation = myObj.nextLine();
        try {
            for (Map.Entry<String, Map<String, Set<String>>> vals : authorMap.entrySet()) {
                if (vals.getKey().equals(authorName)) {
                    Map<String, Set<String>> tempMap = vals.getValue();
                    for (Map.Entry<String, Set<String>> inner : tempMap.entrySet()) {
                        if (inner.getKey().equals(bookName)) {
                            for (String st : inner.getValue()) {
                                if (st.equals(oldLocation)) {
                                    inner.getValue().remove(st);
                                    inner.getValue().add(newLocation);
                                    edited = true;
                                }
                            }
                        }
                    }

                }
            }
            if (!edited) {
                System.out.println("Could Not Edit !!!");
            }
        }catch (NullPointerException np){
            System.out.println("Null Pointer Exception !!!");
        }
    }

    /**
     * this function search for a book according to it's author names and if found lists the books related to that author
     * @param authorMap  authorMap is all books info in our library system
     */
    public void searchByAuthorName(Map<String, Map<String, Set<String>>> authorMap){

        int counter  = 1;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String authorName = null;
        try{
            System.out.print("Enter Author Name :");
            authorName = myObj.nextLine();
            Map<String,Set<String>> tm = authorMap.get(authorName);
            System.out.println("MR/MS "+authorName +"'s Books Are >>");

            //list all the books related to the authorName
            for (Map.Entry<String, Set<String>> vals : tm.entrySet()) {
                System.out.println(counter + ":  " + vals.getKey());
                ++counter;
            }

            System.out.println("Enter Book Name To Show its Location(s) On The Library.");
            String st = myObj.nextLine();
            System.out.println("Book Name: "+st);
            System.out.println("Location(s) "+authorMap.get(authorName).get(st).toString());
        }catch (NullPointerException np){
            System.out.println("Trying To Access illegal area !!!");
        }
    }

    /**
     * this function search a book by given it's title name and displayes it's related author name and locations
     * @param authorMap map holds info a bout library systems's books
     */
    public void searchByTitle(Map<String, Map<String, Set<String>>> authorMap){

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean isExist = false;
        System.out.print("Enter Book title :");
        String bookTitle = myObj.nextLine();

       try {
           for (Map.Entry<String, Map<String, Set<String>>> vals : authorMap.entrySet()) {
               Map<String, Set<String>> innerMap = vals.getValue();
               if (innerMap.containsKey(bookTitle)) {
                   System.out.println("Book Name: " + bookTitle);
                   System.out.println("Book Author: " + vals.getKey());
                   System.out.println("Book Location(s): " + innerMap.get(bookTitle));
                   isExist = true;
               }
           }
           if (!isExist) {
               System.out.println("Could Not Find The Book !!!");
           }
       }catch (NullPointerException np){
           System.out.println("Null Pointer Exception !!!!");
       }
    }

    /**
     * this function displays all the books and their related auhtor names and location in your library systems.
     * @param libraryBooks map library systems
     */
    public void printBooks(Map<String,Map<String,Set<String>>> libraryBooks){

        for (Map.Entry<String,Map<String,Set<String>>> outerMap: libraryBooks.entrySet()){
            System.out.println("Author Name: "+outerMap.getKey());
            System.out.println("Book's List:");
            for (Map.Entry<String,Set<String>> innermap:outerMap.getValue().entrySet()){
                System.out.print ("     Book Name: ["+innermap.getKey());
                System.out.println("] Location(s): "+innermap.getValue().toString());
            }
            System.out.println("***********************************************************");
        }
        System.out.println();
    }
}