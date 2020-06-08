package filePackage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * FileSystemTree class has addDir addFile printTree and remove methods which each is used to manipulate a general tree structure.
 */
public class FileSystemTree{

    /**
     * FileNode class is a private class represents a file of a directory according to desire
     */
    private class FileNode{

        private String nodeName;
        private char nodeType;
        private FileNode parent;
        /**
         * children is sub directories of files of this node
         */
        private ArrayList<FileNode> children;

        /**
         *  FileNode constructor takes rootName and creates an empty ArraList to it's sub directories or files in case of having it
         * @param rootName rootName is name of the root directory
         */
        public FileNode(String rootName) {
            this.nodeName = rootName;
            this.parent = null;
            this.children = new ArrayList<>(0);
        }
    }

    //file system class area
    /**
     * root is reference ot root node
     */
    FileNode root;
    /**
     * counter is used to prettyPrint the Tree as needed
     */
    private int counter = 0;
    /**
     * found is used to halt or break the adding process when the certain directory of file is found and added successfully
     */
    private boolean found = false;

    /**
     * FileSystemTree class constructor takes rootName and creates a node to root directory.
     * @param rootName rootName is the name is roo directory
     */
    FileSystemTree(String rootName){
        this.root = new FileNode(rootName);
        this.root.nodeType='d';
    }

    /**
     * addDir function takes a path to directory and calls it's wrapper function with root reference.
     * @param path path is the path if directory to be added to the general tree
     */
    protected void addDir(String path) {

        found = false;// set found false in each addition
        String[] list = path.split("/");// split path to its String Array to manipulate
        FileNode head = root;
        addDir(head,list);
    }

    /**
     * this function adds a directory to it's desired location
     *I have used a recursion to trace the general tree and find the desired location to add a directory if exist
     * function takes a path as a String arrays which's last element is the name of the directory to be added to the
     * general tree also head or root of the tree to start tracing from.
     * base case is if we reach the last element of the given String arrays which's our directory path
     * if we reach the last element we added we add the directory to its corresponding parent node's children's list
     * otherwise we keep calling the function itself with new values until we find the desired path
     * @param head reference to root directory
     * @param path path of directory to be added.
     */
    private void addDir(FileNode head,String[] path){

        try {
            if (path.length == 1) {//base case if we each the directory to be removed the added to it's parent

                boolean add;
                FileNode newNode = new FileNode(path[0]);//create a node to new directory
                newNode.nodeType = 'd';//set type of directory as d which indicates that it's a directory
                newNode.parent = head;//set the parent reference
                add = isExist(path[0],head);
                if (!add){
                    head.children.add(newNode);//add the directory to it's corresponding parent's list
                }
                else{
                    System.out.println("DIRECTORY WITH THE SAME NAME IS ALREADY EXIST !!!1");
                }
                found = true;//found true indicates that we have added the directory to it's corresponding parent directory and no need to trace rest of the tree
            } else {//if we are not reached to desired directory path
                if (head.nodeName.equals(path[0]) && path.length == 2) {//if we are the directory which is going to be the new directory's parent directory
                    String[] st = new String[path.length - 1];//shrink the past array size
                    System.arraycopy(path, 1, st, 0, path.length - 1);//shrink the past array size
                    addDir(head, st);
                } else {
                    ArrayList<FileNode> tmp = head.children;
                    for (int i = 0; i < tmp.size(); i++) {//trace all the children to head node to
                        if (found) {//if new directory is added to tree then halt the function and avoid the unnecessary trace
                            return;
                        } else {//of directory not yet found
                            String[] st = new String[path.length - 1];//shrink the past array size
                            System.arraycopy(path, 1, st, 0, path.length - 1);//shrink the past array size
                            addDir(tmp.get(i), st);
                        }
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException ind){
            System.out.println("INDEX OUT OF BOUND !!!");
        }catch (NullPointerException nl){
            System.out.println("NULL POINTER EXCEPTION !!! ");
        }
    }

    /**
     * addDir function takes a path to file and calls it's wrapper function with root reference.
     * @param path path is the path if file to be added to the general tree
     */
    protected void addFile(String path) {
        found = false;// set found false in each addition
        String[] list = path.split("/");// split path to its String Array to manipulate
        FileNode head = root;
        addFile(head,list);
    }

    /**
     * this function adds a file to it's desired location
     *I have used the recursion to trace the general tree and find the desired location to add a file if exist
     * function takes a path as a String arrays which's last element is the name of the file to be added to the
     * general tree also head or root of the tree to start tracing from.
     * base case is if we reach the last element of the given String arrays which's our file path
     * if we reach the last element we added we add the file to its corresponding parent node's children's list
     * otherwise we keep calling the function itself with new values until we find the desired path
     * @param head reference to root file
     * @param path path of file to be added.
     */
    private void addFile(FileNode head,String[] path){

        try {

            if (path.length == 1) {//base case if we each the file to be removed the added to it's parent
                boolean add;
                FileNode newNode = new FileNode(path[0]);//create a node to new file
                newNode.nodeType = 'f';//set type of file as d which indicates that it's a file
                newNode.parent = head;//set the parent reference
                if (!head.nodeName.contains(".")) {// if parent is file directory can add the file otherwise cannot add

                    add = isExist(path[0], head);
                    if (!add) {
                        head.children.add(newNode);//add the file to it's corresponding parent's list
                    } else {
                        System.out.println("FILE WITH THE SAME NAME IS ALREADY EXIST !!!1");
                    }
                } else {
                    System.out.println("CANNOT ADD TO A FILE MAKE SURE YOU SELECT A DIRECTORY TO ADD THE FILE !!!");
                }
                found = true;//found true indicates that we have added the file to it's corresponding parent directory and no need to trace rest of the tree
            } else {//if we are not reached to desired file path
                if (head.nodeName.equals(path[0]) && path.length == 2) {//if we are the file which is going to be the new file's parent directory
                    String[] st = new String[path.length - 1];//shrink the past array size
                    System.arraycopy(path, 1, st, 0, path.length - 1);//shrink the past array size
                    addFile(head, st);
                } else {
                    ArrayList<FileNode> tmp = head.children;
                    for (int i = 0; i < tmp.size(); i++) {//trace all the children to head node to
                        if (found) {//if new file is added to tree then halt the function and avoid the unnecessary trace
                            return;
                        } else {//of file not yet found
                            String[] st = new String[path.length - 1];//shrink the past array size
                            System.arraycopy(path, 1, st, 0, path.length - 1);//shrink the past array size
                            addFile(tmp.get(i), st);
                        }
                    }
                }
            }
        }catch (IndexOutOfBoundsException ind){
            System.out.println("INDEX OUT OF BOUND !!!");
        }catch (NullPointerException nl){
            System.out.println("NULL POINTER EXCEPTION !!! ");
        }
    }

    /**
     * this function takes a directory of file path and removes it from general tree if possible by calling its wrapper function
     * @param path path of the directory of file to be removed from general tree
     */
    protected void remove(String path){
        String[] list = path.split("/");//split the path according to char '/'
        FileNode head = root;
        remove(head,list);//call wrapper function
    }

    /**
     * this function takes path and head and removes a file or directory if exist or if possible by using recursion.
     * base case is if we reach the last element of string array which holds path
     * this function finds the file of directory to be removed if exist and check if it is file then removes it or if it is
     * a nonempty directory then asks user whether to delete it or not and acts accordingly.
     * @param head reference root if the tree
     * @param path path of the directory or file to be removed from general tree
     */
    private void remove(FileNode head, String[] path){

        try{
            if (path.length == 1) {//base case

                for (int i = 0; i < head.children.size(); i++) {//find the directory or file to be removed from children list

                    if (head.children.get(i).nodeName.equals(path[0])) {//if directory of file to be removed is found

                        if (head.children.get(i).nodeType == 'f') {//if it is a file then delete
                            head.children.remove(i);
                            System.out.println(" file Removed Successfully !!!");
                        } else if (head.children.get(i).nodeType == 'd') {//if it is a directory the check if it has children or not

                            if (head.children.get(i).children.size() == 0) {//if it does not have any  children the delete
                                head.children.remove(i);
                                System.out.println(" directory Removed Successfully !!!");
                            } else {//if it has children then print it's children and ask user whether to delete or not
                                System.out.println("this directory has :");
                                System.out.println("");
                                print(head.children.get(i));
                                System.out.println("");

                                System.out.print("do you still want to delete this directory ? (1) for YES or (0) for NO :");
                                Scanner sc = new Scanner(System.in);
                                String name = sc.nextLine();

                                if (name.equals("1")) {//if user says yes then delete it
                                    head.children.remove(i);
                                } else if (name.equals("0")) {//if user says not then do NOt delete it
                                    System.out.println(" You selected NO ...");
                                } else {
                                    System.out.println("Wrong input !!!");
                                }
                            }
                        } else {//if file not found then give error
                            System.out.println("No Such File Or Directory !!!");
                        }
                        return;
                    }
                }
                return;
            }
            else{//if directory of file not found yet.

                if (head.nodeName.equals(path[0]) && path.length == 2) {
                    String[] st = new String[path.length - 1];
                    System.arraycopy(path, 1, st, 0, path.length - 1);
                    remove(head, st);
                    return;
                } else {

                    ArrayList<FileNode> tmp = head.children;
                    for (int i = 0; i < tmp.size(); i++) {
                        String[] st = new String[path.length - 1];
                        System.arraycopy(path, 1, st, 0, path.length - 1);
                        remove(tmp.get(i), st);
                    }
                }
                return ;
            }
        }catch(IndexOutOfBoundsException ind){
            System.out.println("INDEX OUT OF BOUND !!!");
        }catch (NullPointerException nl){
            System.out.println("NULL POINTER EXCEPTION !!! ");
        }
    }

    /**
     * search function calls its wrapper search function to handle the search operation.
     * @param sampleText string to be looked to it's identical
     */
    protected void search(String sampleText){
        ArrayList<String> st = new ArrayList<>(0);
        search(sampleText,st,root);
    }

    /**
     * function makes use of recursion to trace the whole tree and find and print the desired path
     * its base case is if current nodes' node name contains the sampleText then print the path starting from root and
     * trace the whole tree each node
     * @param sampleText string to be looked for its identical
     * @param path path string is used to handle the back end fort path changes of general tree to prettyPrint
     * @param currentHead head type of FileNode class
     */
    private void search(String sampleText,ArrayList<String > path,FileNode currentHead){

        try {
             if (currentHead.nodeName.contains(sampleText)) {//base case
                 path.add("/" + currentHead.nodeName);
                 printPath(currentHead.nodeType, path);//prints the path
                 if (currentHead.children.size() > 0) {//if currentHead has more children than trace them all the print path if possible
                     search(sampleText, path, currentHead.children.get(0));
                 }
             }
             else {//if not found the match, yet the keep tracing the general tree by visiting it's each node
                 ArrayList<String> prevPath;
                 path.add("/" + currentHead.nodeName);
                 prevPath = (ArrayList<String>) path.clone();
                 for (int i = 0; i < currentHead.children.size(); i++) {
                     search(sampleText, path, currentHead.children.get(i));
                     path = (ArrayList<String>) prevPath.clone();
                 }
             }
         }catch (IndexOutOfBoundsException in){
             System.out.println("INDEX OUT OF BOUND !!!");
         }catch (NullPointerException nl){
             System.out.println("NULL POINTER EXCEPTION !!! ");
         }
    }

    /**
     * this function takes a string and a node reference and checks whether node's children contains the given nodeName string or not
     * @param nodeName name of the node to be looked for
     * @param head head node rerefence
     * @return returns true if the head's children contains nodeName string otherwise return false
     */
    private boolean isExist(String nodeName,FileNode head){
        try {
            for (int i = 0; i < head.children.size(); i++) {
                if (head.children.get(i).nodeName.equals(nodeName)) {
                    return true;
                }
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("INDEX OUT OF BOUND !!!");
        }catch (NullPointerException nl){
            System.out.println("NULL POINTER EXCEPTION !!! ");
        }
        return false;
    }

    /**
     * this function takes a path and prints it
     * @param type d for directory and f for files
     * @param path path to be printed
     */
    private void printPath(char type,ArrayList<String > path){

        try{
            if (type== 'd'){
                System.out.print("dir - ");
                for (String i:path) {
                    System.out.print(i);
                }
                System.out.println("");
            }
            else{
                System.out.print("file - ");
                for (String i:path) {
                    System.out.print(i);
                }
                System.out.println("");
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("INDEX OUT OF BOUND !!!");
        }catch (NullPointerException nl){
            System.out.println("NULL POINTER EXCEPTION !!! ");
        }
    }

    /**
     * this function prints the whole general tree by callings its wrapper function named print()
     */
    protected void printFileSystem(){
        FileNode head = root;
        print(head);
        System.out.println("");
    }

    /**
     * this function prints the whole general tree using recursion.
     * @param node root node
     */
    private void print(FileNode node){

        try {
            if (node.children.size() == 0) {
                System.out.println(node.nodeName);
            }
            else {
                counter++;
                System.out.println(node.nodeName);
                for (int i = 0; i < node.children.size(); i++) {
                    for (int j = 0; j < counter; j++)
                        System.out.print("   ");
                    System.out.print("--");
                    print(node.children.get(i));
                }
                counter--;
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("INDEX OUT OF BOUND !!!");
        }catch (NullPointerException nl){
            System.out.println("NULL POINTER EXCEPTION !!! ");
        }
    }
}