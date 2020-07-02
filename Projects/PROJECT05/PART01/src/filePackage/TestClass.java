package filePackage;

public class TestClass {
    public static void main(String[] args) {

        System.out.println("***** FILE SYSTEM TREE PROJECT *****");

        System.out.println("creating root directory named 'root' ...");
        FileSystemTree myFileSystem = new FileSystemTree("root");
        System.out.println();

        //Add directories and files using paths
        myFileSystem.addDir("root/first_directory");
        myFileSystem.addDir("root/second_directory");
        myFileSystem.addDir("root/3th_directory");
        myFileSystem.addFile("root/3th_directory/file1.txt");
        myFileSystem.addFile("root/3th_directory/file2.txt");
        myFileSystem.addDir("root/second_directory/new_directory");
        myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");
        myFileSystem.addFile("root/first_directory/new_file.txt");

        System.out.println("Printing Tree...");
        myFileSystem.printFileSystem();

        //Search file or directory names including “new”
        System.out.println("Testing search() ...");
        myFileSystem.search("txt");

        //Remove files or directories
        System.out.println("Testing remove() ...");
        myFileSystem.remove("root/first_directory");
        myFileSystem.remove("root/second_directory/new_directory/new_file.doc");

        System.out.println("Printing Tree...");
        myFileSystem.printFileSystem();

        myFileSystem.addDir("root/first_directory");
        myFileSystem.addFile("root/first_directory/new_file.txt/newnewnewfile.txt");
    }
}
