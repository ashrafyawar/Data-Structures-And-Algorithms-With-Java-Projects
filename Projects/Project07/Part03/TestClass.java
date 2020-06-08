import BTreePackage.BTree;
import BinarySearchTreePackage.BinarySearchTree;
import RedBlackTreeBookPackage.RedBlackTree;
import SkipListBookPackage.SkipList;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class TestClass {
    public static void main(String[] args) {

        BinarySearchTree<Integer>[] binarySearchTree = new BinarySearchTree[40];

        RedBlackTree<Integer>[] redBlackTreeBook = new RedBlackTree[40];
        TreeMap[] treeMap = new TreeMap[40];

        BTree[] bTree = new BTree[40];

        SkipList<Integer>[] skipListBook = new SkipList[40];
        ConcurrentSkipListSet[] skipListSet = new ConcurrentSkipListSet[40];

        Random rand = new Random();
        long one1 = 0,two2 = 0,three3 = 0,four4 = 0,five5 = 0,six6 = 0,seven7 = 0;

        System.out.println("Adding 10.000 elements into each data structure...");
        for(int i = 0; i < 10;i++){

            binarySearchTree[i] = new BinarySearchTree<>();
            redBlackTreeBook[i] = new RedBlackTree<>();
            treeMap[i] = new TreeMap();
            skipListBook[i] = new SkipList<>();
            skipListSet[i] = new ConcurrentSkipListSet();
            bTree[i] = new BTree(4);
            int random;
            long timeElapsed,start,finish, one = 0,two = 0,three = 0,four = 0,five = 0,six = 0,seven = 0;

            for(int j = 0; j < 10000; j++) {

                random = rand.nextInt(1000);

                start = System.currentTimeMillis();
                binarySearchTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                one = one + timeElapsed;

                start = System.currentTimeMillis();
                redBlackTreeBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                two = two + timeElapsed;

                start = System.currentTimeMillis();
                treeMap[i].put(random, random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                three = three + timeElapsed;


                start = System.currentTimeMillis();
                bTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                four = four + timeElapsed;

                start = System.currentTimeMillis();
                skipListBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                five = five + timeElapsed;

                start = System.currentTimeMillis();
                skipListSet[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                six = six + timeElapsed;

//                start = System.currentTimeMillis();
//                Q2 !!!
//                finish = System.currentTimeMillis();
//                timeElapsed = finish - start;
//                seven = seven + timeElapsed;

            }
            System.out.println("List : " + (i + 1));
            System.out.println("Time Taken To insert 10000 random number into Regular binary search tree is: " + one + " milliSec");
            System.out.println("Time Taken To insert 10000 random number into Red-Black tree implementation in the book is: " + two + " milliSec");
            System.out.println("Time Taken To insert 10000 random number into Red Black tree implementation in java is: " + three + " milliSec");
            System.out.println("Time Taken To insert 10000 random number into B-tree implementation in the book is: " + four + " milliSec");
            System.out.println("Time Taken To insert 10000 random number into Skip list implementation in the book is: " + five + " milliSec");
            System.out.println("Time Taken To insert 10000 random number into Skip list implementation in java is: " + six + " milliSec");
            //System.out.println("Time Taken To insert 10000 random number into Skip list in question Q2 is: " + seven + " milliSec");
            System.out.println();

            one1 += one;
            two2 += two;
            three3 += three;
            four4 += four;
            five5 += five;
            six6 += six;
            seven7 += seven;
        }

        System.out.println("Adding 20.000 elements into each data structure...");
        for(int i = 10; i < 20;i++){

            binarySearchTree[i] = new BinarySearchTree<>();
            redBlackTreeBook[i] = new RedBlackTree<>();
            treeMap[i] = new TreeMap();
            skipListBook[i] = new SkipList<>();
            skipListSet[i] = new ConcurrentSkipListSet();
            bTree[i] = new BTree(4);
            int random;
            long timeElapsed,start,finish, one = 0,two = 0,three = 0,four = 0,five = 0,six = 0,seven = 0;

            for(int j = 0; j < 20000; j++) {

                random = rand.nextInt(1000);

                start = System.currentTimeMillis();
                binarySearchTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                one = one + timeElapsed;

                start = System.currentTimeMillis();
                redBlackTreeBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                two = two + timeElapsed;

                start = System.currentTimeMillis();
                treeMap[i].put(random, random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                three = three + timeElapsed;

                start = System.currentTimeMillis();
                bTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                four = four + timeElapsed;

                start = System.currentTimeMillis();
                skipListBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                five = five + timeElapsed;

                start = System.currentTimeMillis();
                skipListSet[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                six = six + timeElapsed;

//                start = System.currentTimeMillis();
//                Q2 !!!
//                finish = System.currentTimeMillis();
//                timeElapsed = finish - start;
//                seven = seven + timeElapsed;

            }
            System.out.println("List : " + (i + 1));
            System.out.println("Time Taken To insert 20000 random number into Regular binary search tree is: " + one + " milliSec");
            System.out.println("Time Taken To insert 20000 random number into Red-Black tree implementation in the book is: " + two + " milliSec");
            System.out.println("Time Taken To insert 20000 random number into Red Black tree implementation in java is: " + three + " milliSec");
            System.out.println("Time Taken To insert 20000 random number into B-tree implementation in the book is: " + four + " milliSec");
            System.out.println("Time Taken To insert 20000 random number into Skip list implementation in the book is: " + five + " milliSec");
            System.out.println("Time Taken To insert 20000 random number into Skip list implementation in java is: " + six + " milliSec");
            //System.out.println("Time Taken To insert 20000 random number into Skip list in question Q2 is: " + seven + " milliSec");
            System.out.println();

            one1 += one;
            two2 += two;
            three3 += three;
            four4 += four;
            five5 += five;
            six6 += six;
            seven7 += seven;
        }

        System.out.println("Adding 40.000 elements into each data structure...");
        for(int i = 20; i < 30;i++){

            binarySearchTree[i] = new BinarySearchTree<>();
            redBlackTreeBook[i] = new RedBlackTree<>();
            treeMap[i] = new TreeMap();
            skipListBook[i] = new SkipList<>();
            skipListSet[i] = new ConcurrentSkipListSet();
            bTree[i] = new BTree(4);
            int random;
            long timeElapsed,start,finish, one = 0,two = 0,three = 0,four = 0,five = 0,six = 0,seven = 0;

            for(int j = 0; j < 40000; j++) {

                random = rand.nextInt(1000);

                start = System.currentTimeMillis();
                binarySearchTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                one = one + timeElapsed;

                start = System.currentTimeMillis();
                redBlackTreeBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                two = two + timeElapsed;

                start = System.currentTimeMillis();
                treeMap[i].put(random, random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                three = three + timeElapsed;


                start = System.currentTimeMillis();
                bTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                four = four + timeElapsed;

                start = System.currentTimeMillis();
                skipListBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                five = five + timeElapsed;

                start = System.currentTimeMillis();
                skipListSet[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                six = six + timeElapsed;

//                start = System.currentTimeMillis();
//                Q2 !!!
//                finish = System.currentTimeMillis();
//                timeElapsed = finish - start;
//                seven = seven + timeElapsed;

            }
            System.out.println("List : " + (i + 1));
            System.out.println("Time Taken To insert 40000 random number into Regular binary search tree is: " + one + " milliSec");
            System.out.println("Time Taken To insert 40000 random number into Red-Black tree implementation in the book is: " + two + " milliSec");
            System.out.println("Time Taken To insert 40000 random number into Red Black tree implementation in java is: " + three + " milliSec");
            System.out.println("Time Taken To insert 40000 random number into B-tree implementation in the book is: " + four + " milliSec");
            System.out.println("Time Taken To insert 40000 random number into Skip list implementation in the book is: " + five + " milliSec");
            System.out.println("Time Taken To insert 40000 random number into Skip list implementation in java is: " + six + " milliSec");
            //System.out.println("Time Taken To insert 40000 random number into Skip list in question Q2 is: " + seven + " milliSec");
            System.out.println();
            one1 += one;
            two2 += two;
            three3 += three;
            four4 += four;
            five5 += five;
            six6 += six;
            seven7 += seven;
        }

        System.out.println("Adding 80.000 elements into each data structure...");
        for(int i = 30; i < 40;i++){

            binarySearchTree[i] = new BinarySearchTree<>();
            redBlackTreeBook[i] = new RedBlackTree<>();
            treeMap[i] = new TreeMap();
            skipListBook[i] = new SkipList<>();
            skipListSet[i] = new ConcurrentSkipListSet();
            bTree[i] = new BTree(4);
            int random;
            long timeElapsed,start,finish, one = 0,two = 0,three = 0,four = 0,five = 0,six = 0,seven = 0;

            for(int j = 0; j < 80000; j++) {

                random = rand.nextInt(1000);

                start = System.currentTimeMillis();
                binarySearchTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                one = one + timeElapsed;

                start = System.currentTimeMillis();
                redBlackTreeBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                two = two + timeElapsed;

                start = System.currentTimeMillis();
                treeMap[i].put(random, random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                three = three + timeElapsed;

                start = System.currentTimeMillis();
                bTree[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                four = four + timeElapsed;

                start = System.currentTimeMillis();
                skipListBook[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                five = five + timeElapsed;

                start = System.currentTimeMillis();
                skipListSet[i].add(random);
                finish = System.currentTimeMillis();
                timeElapsed = finish - start;
                six = six + timeElapsed;

//                start = System.currentTimeMillis();
//                Q2 !!!
//                finish = System.currentTimeMillis();
//                timeElapsed = finish - start;
//                seven = seven + timeElapsed;

            }
            System.out.println("List : " + (i + 1));
            System.out.println("Time Taken To insert 80000 random number into Regular binary search tree is: " + one + " milliSec");
            System.out.println("Time Taken To insert 80000 random number into Red-Black tree implementation in the book is: " + two + " milliSec");
            System.out.println("Time Taken To insert 80000 random number into Red Black tree implementation in java is: " + three + " milliSec");
            System.out.println("Time Taken To insert 80000 random number into B-tree implementation in the book is: " + four + " milliSec");
            System.out.println("Time Taken To insert 80000 random number into Skip list implementation in the book is: " + five + " milliSec");
            System.out.println("Time Taken To insert 80000 random number into Skip list implementation in java is: " + six + " milliSec");
            //System.out.println("Time Taken To insert 80000 random number into Skip list in question Q2 is: " + seven + " milliSec");
            System.out.println();

            one1 += one;
            two2 += two;
            three3 += three;
            four4 += four;
            five5 += five;
            six6 += six;
            seven7 += seven;
        }

        System.out.println(" ************************** Comparing the run-time performance of the insertion operation for the data structures **************************");
        System.out.println();

        System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into Regular binary search tree is: " + one1 + " milliSec");
        System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into ed-Black tree implementation in the book is: " + two2 + " milliSec");
        System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into Red Black tree implementation in java is: " + three3 + " milliSec");
        System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into B-tree implementation in the book is: " + four4 + " milliSec");
        System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into Skip list implementation in the book is: " + five5 + " milliSec");
        System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into Skip list implementation in java is: " + six6 + " milliSec");
       // System.out.println("Total time taken for adding 10000 , 20000 , 40000 and 80000 random number into Skip list in question Q2 is: " + seven7 + " milliSec");

        System.out.println();
        System.out.println(" ******************************* inserting 10 extra random numbers into each structures ******************************* ");

        int random = 0;
        long timeElapsed,start,finish, one = 0,two = 0,three = 0,four = 0,five = 0,six = 0,seven = 0;
        int [] keepRandomNumsForDelettion = new int[10];//keep last 10 added random numbers in order to perform deletion later using these numbers

        for(int j = 0; j < 10; j++) {
            random = rand.nextInt();
            keepRandomNumsForDelettion[j] = random;

            start = System.nanoTime();

            binarySearchTree[0].add(random);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            one += timeElapsed;

            start = System.nanoTime();
            redBlackTreeBook[0].add(random);
            finish =System.nanoTime();
            timeElapsed = finish - start;
            two = two + timeElapsed;

            start = System.nanoTime();
            treeMap[0].put(random, random);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            three = three + timeElapsed;

            start = System.nanoTime();
            bTree[0].add(random);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            four = four + timeElapsed;

            start = System.nanoTime();
            skipListBook[0].add(random);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            five = five + timeElapsed;

            start = System.nanoTime();
            skipListSet[0].add(random);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            six = six + timeElapsed;

//          start = System.nanoTime();
//          Q2 !!!
//          finish = System.nanoTime();
//          timeElapsed = finish - start;
//          seven = seven + timeElapsed;

        }
        System.out.println("Time Taken To insert 10 extra random number into Regular binary search tree is: " + one + " Nano Seconds");
        System.out.println("Time Taken To insert 10 extra random number into Red-Black tree implementation in the book is: " + two + " Nano Seconds");
        System.out.println("Time Taken To insert 10 extra random number into Red Black tree implementation in java is: " + three + " Nano Seconds");
        System.out.println("Time Taken To insert 10 extra random number into B-tree implementation in the book is: " + four + " Nano Seconds");
        System.out.println("Time Taken To insert 10 extra random number into Skip list implementation in the book is: " + five + " Nano Seconds");
        System.out.println("Time Taken To insert 10 extra random number into Skip list implementation in java is: " + six + " Nano Seconds");
        //System.out.println("Time Taken To insert 10 extra random number into Skip list in question Q2 is: " + seven + " Nano Seconds");
        System.out.println();

        System.out.println(" ******************************* deleting 10 numbers from each structure ******************************* ");

        one = two = three = four = five = six = seven = 0;

        for(int j = 0; j < 10; j++) {

            start = System.nanoTime();

            binarySearchTree[0].delete(keepRandomNumsForDelettion[j]);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            one += timeElapsed;

            start = System.nanoTime();
            redBlackTreeBook[0].delete(keepRandomNumsForDelettion[j]);
            finish =System.nanoTime();
            timeElapsed = finish - start;
            two = two + timeElapsed;

            start = System.nanoTime();
            treeMap[0].descendingKeySet();
            finish = System.nanoTime();
            timeElapsed = finish - start;
            three = three + timeElapsed;

            start = System.nanoTime();
            //bTree[0].delete(random);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            four = four + timeElapsed;

            start = System.nanoTime();
            skipListBook[0].remove(keepRandomNumsForDelettion[j]);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            five = five + timeElapsed;

            start = System.nanoTime();
            skipListSet[0].remove(keepRandomNumsForDelettion[j]);
            finish = System.nanoTime();
            timeElapsed = finish - start;
            six = six + timeElapsed;

////          start = System.nanoTime();
////          Q2 !!!
////          finish = System.nanoTime();
////          timeElapsed = finish - start;
////          seven = seven + timeElapsed;

        }
        System.out.println("Time Taken To delete 10 from Regular binary search tree is: " + one + " Nano Seconds");
        System.out.println("Time Taken To delete 10 number from Red-Black tree implementation in the book is: " + two + " Nano Seconds");
        System.out.println("Time Taken To delete 10 number from Red Black tree implementation in java is: " + three + " Nano Seconds");
        System.out.println("Time Taken To delete 10 number from B-tree implementation in the book is: " + four + " Nano Seconds");
        System.out.println("Time Taken To delete 10 number from Skip list implementation in the book is: " + five + " Nano Seconds");
        System.out.println("Time Taken To delete 10 number from Skip list implementation in java is: " + six + " Nano Seconds");
        //System.out.println("Time Taken To delete 10 number from Skip list in question Q2 is: " + seven + " Nano Seconds");
        System.out.println();

    }
}