package Part03Package;

public class TestMain {
    public static void main(String[] args) {
        //Create an empty age tree
        AgeSearchTree ageTree = new AgeSearchTree();
        //Add nodes for
        System.out.println("************************************************************");
        System.out.println("Testing add() ...");
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(1));

        System.out.println("************************************************************");
        System.out.println("Testing toString() ...");
        //Create a string representing the tree and print it
        String treeStr = ageTree.toString();
        System.out.println(treeStr);
        System.out.println("************************************************************");
        System.out.println("Testing yongerThan() for value 5 ... ");
        System.out.println(ageTree.youngerThan(5));
        System.out.println("Testing youngerThan() for value 10 ... ");
        System.out.println(ageTree.youngerThan(10));
        System.out.println("Testing youngerThan() for value 15 ... ");
        System.out.println(ageTree.youngerThan(15));
        System.out.println("Testing youngerThan() for value 20 ... ");
        System.out.println(ageTree.youngerThan(20));
        System.out.println("************************************************************");
        System.out.println("Testing olderThan() for value 5 ... ");
        System.out.println(ageTree.olderThan(5));
        System.out.println("Testing olderThan() for value 10 ... ");
        System.out.println(ageTree.olderThan(10));
        System.out.println("Testing olderThan() for value 15 ... ");
        System.out.println(ageTree.olderThan(15));
        System.out.println("Testing olderThan() for value 20 ... ");
        System.out.println(ageTree.olderThan(20));
        System.out.println("************************************************************");
        System.out.println("Testing delete() first Attempt ...");
        System.out.println("Testing...");
        ageTree.remove(10);
        System.out.println(ageTree.toString());
        System.out.println("Testing delete() second Attempt ... " );
        System.out.println("Testing ... ");
        ageTree.remove(10);
        System.out.println(ageTree.toString());
        System.out.println("************************************************************");
        System.out.println("Testing find() ... ");
        System.out.println("Exprested output  5 - 1");
        //Find the number of people at any age
        System.out.println(ageTree.find(new AgeData(5)).toString());

        System.out.println("************************************************************");
        System.out.println("************************************************************");
    }
}