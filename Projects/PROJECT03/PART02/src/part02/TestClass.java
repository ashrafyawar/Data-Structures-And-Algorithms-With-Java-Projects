package part02;

import java.io.IOException;
import java.util.ListIterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.lang.System.nanoTime;

/**
 * this class is used to test 
 */
public class TestClass {
    public static void main(String[] args){

        long start,end;

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("/home/ashraf/Desktop/6.SEMESTER/(1)Data Structures (BİL 222)/HOMEWORKS/HW03/part02/logFile/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String file01 = "src/part02/file01.txt";
        String file02 = "src/part02/file02.txt";

        System.out.println("Testing all the methods used in this part of homework >>> ");
        SimpleTextEditor obj1 = new SimpleTextEditor();//to test content of file01
        SimpleTextEditor obj2 = new SimpleTextEditor(); // to test content of file02


        System.out.println("********************************************************************");
        System.out.println("Reading from file01.txt ...");
        System.out.println("Text read from file to arraylist and linkedlist Successfully :) ");
        System.out.println("MEASURING THE RUNNING TIME OF IMPLEMENTAION OF READ FUNCTIONS IN TWO DIFFERENT SIZED TXT FILES... >>> ");

        System.out.println("arrayList Using loop:");
        start = nanoTime();
        obj1.readToArrayListUsingLoop(file01);
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj1.readToArrayListUsingIterator(file01);
        end = nanoTime();
        System.out.println("arrayList Using iterator:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj1.readToLinkedListUsingLoop(file01);
        end = nanoTime();
        System.out.println("linkedList Using Loop:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        
        System.out.println();
        start = nanoTime();
        obj1.readToLinkedListUsingIterator(file01);
        end = nanoTime();
        System.out.println("linkedList Using iterator:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        System.out.println("Reading from file02.txt ...");
        System.out.println("Text read from file to arraylist and linkedlist Successfully :) ");

        System.out.println("arrayList Using loop:");
        start = nanoTime();
        obj2.readToArrayListUsingLoop(file02);
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj2.readToArrayListUsingIterator(file02);
        end = nanoTime();
        System.out.println("arrayList Using iterator:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");
        
        System.out.println();
        start = nanoTime();
        obj2.readToLinkedListUsingLoop(file02);
        end = nanoTime();
        System.out.println("linkedList Using Loop:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj2.readToLinkedListUsingIterator(file02);
        end = nanoTime();
        System.out.println("linkedList Using iterator:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println("********************************************************************");
        System.out.println("********************************************************************");

        //add(index,string);
        System.out.println("Calling Add function (adding string 'Ashrafanisa' at index 3)...");

        System.out.println("Adding using Loop >>");
        obj1.addToArrayListUsingLoop(3,"Ashrafanisa");
        System.out.println();
        System.out.println("New text in arrayList:");
        for (int i = 0; i <obj1.getArrayList().size() ; i++) {
            System.out.print(obj1.getArrayList().get(i));
        }

        System.out.println();
        System.out.println("Adding using iterator >>");
        obj1.addToArrayListUsingIterator(10,"AAAAAAAAAAAAAAAAA");
        System.out.println();
        System.out.println("New text in arrayList:");
        for (int i = 0; i <obj1.getArrayList().size() ; i++) {
            System.out.print(obj1.getArrayList().get(i));
        }

        System.out.println();
        System.out.println("Adding using Loop >>");
        obj1.addToLinkedListUsingLoop(3,"Ashrafanisa");
        System.out.println();
        System.out.println("New text in linkedList:");
        for (int i = 0; i <obj1.getLinkedList().size() ; i++) {
            System.out.print(obj1.getLinkedList().get(i));
        }

        System.out.println();
        System.out.println("Adding using iterator >>");
        obj1.addToLinkedListUsingIterator(10,"AAAAAAAAAAAAAAAAA");
        System.out.println();
        System.out.println("New text in linkedList:");
        for (int i = 0; i <obj1.getArrayList().size() ; i++) {
            System.out.print(obj1.getArrayList().get(i));
        }

        System.out.println("********************************************************************");

        System.out.println("********************************************************************");
        // find(string);

        System.out.println("trying to find string 'Ashraf and ashraf' in the arrayList and linkedList...");

        System.out.println("using arrayList Loop version :");
        int result = obj1.findFromArrayListUsingLoop("Ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");
        result = obj1.findFromArrayListUsingLoop("ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");

        System.out.println();
        System.out.println("using arrayList Iterator version :");
        result = obj1.findFromArrayListUsingIterator("Ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");
        result = obj1.findFromArrayListUsingIterator("ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");

        System.out.println();
        System.out.println("using linkedList Loop version :");
        result = obj1.findFromLinkedListUsingLoop("Ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");
        result = obj1.findFromLinkedListUsingLoop("ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");

        System.out.println();
        System.out.println("using linkedList Iterator version :");
        result = obj1.findFromLinkedListUsingIterator("Ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");
        result = obj1.findFromLinkedListUsingIterator("ashraf");
        if (result != -1)
            System.out.println("returned index is : " +result);
        else
            System.out.println("returned : " + result +" String Not Found!!!! :( ");

        System.out.println("********************************************************************");
        //replace(character,character)
        System.out.println("Replasing a to z...");

        System.out.println();
        System.out.println("Using arrayList:");
        obj1.replaceUsingArrayListUsingLoop('a','z');

        System.out.println();
        System.out.println("Using linedList :");
        obj1.replaceUsingLinkedListUsingLoop('a','z');

        System.out.println("arraList Loop version after replacing a to z: ");
        for (int i = 0; i < obj1.getArrayList().size() ; i++) {
            System.out.print(obj1.getArrayList().get(i));
        }

        System.out.println();
        obj1.replaceUsingArrayListUsingIterator('a','z');
        System.out.println("arraList Iterator version after replacing a to z: ");

        ListIterator<Character> itr = obj1.getArrayList().listIterator();
        while(itr.hasNext()) {
            System.out.print(itr.next());
        }

        System.out.println();
        System.out.println("linkedList loop version after replacing a to z: ");
        for (int i = 0; i < obj1.getLinkedList().size() ; i++) {
            System.out.print(obj1.getLinkedList().get(i));
        }

        System.out.println();
        obj1.replaceUsingLinkedListUsingIterator('a','z');
        System.out.println("linkedList Iterator version after replacing a to z: ");

        itr = obj1.getLinkedList().listIterator();
        while(itr.hasNext()) {
            System.out.print(itr.next());
        }

        System.out.println("********************************************************************");


        SimpleTextEditor obj3 = new SimpleTextEditor();//to test content of file01
        System.out.println("*********************************************************************");
        System.out.println();
        System.out.println(" COMPARISON OF THE EXPERIMENTAL PERFORMANCE OF EACH OPERATION :");

        //read method time lapsing tests.
        System.out.println("Reading from file01.txt ...");
        System.out.println("Text read from file to arraylist and linkedlist Successfully :) ");

        System.out.println("arrayList Using loop:");
        start = nanoTime();
        obj3.readToArrayListUsingLoop(file01);
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj3.readToArrayListUsingIterator(file01);
        end = nanoTime();
        System.out.println("arrayList Using iterator:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj3.readToLinkedListUsingLoop(file01);
        end = nanoTime();
        System.out.println("linkedList Using Loop:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        start = nanoTime();
        obj3.readToLinkedListUsingIterator(file01);
        end = nanoTime();
        System.out.println("linkedList Using iterator:");
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        //add(index,string);
        System.out.println("Calling Add function (adding string 'Ashrafanisa' at index 3)...");

        System.out.println();
        System.out.println("Adding using Loop >>");
        start = nanoTime();
        obj3.addToArrayListUsingLoop(3,"Ashrafanisa");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("Adding using iterator >>");
        start = nanoTime();
        obj3.addToArrayListUsingIterator(3,"Ashrafanisa");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("Adding using Loop >>");
        start = nanoTime();
        obj3.addToLinkedListUsingLoop(3,"Ashrafanisa");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("Adding using iterator >>");
        start = nanoTime();
        obj3.addToLinkedListUsingIterator(3,"Ashrafanisa");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        // find(string);
        System.out.println("trying to find string 'Ashraf and ashraf' in the arrayList and linkedList...");
        System.out.println("using arrayList Loop version :");

        start = nanoTime();
        result = obj3.findFromArrayListUsingLoop("Ashraf");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");


        System.out.println();
        System.out.println("using arrayList Iterator version :");
        start = nanoTime();
        result = obj3.findFromArrayListUsingIterator("Ashraf");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("using linkedList Loop version :");
        start = nanoTime();
        result = obj3.findFromLinkedListUsingLoop("Ashraf");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("using linkedList Iterator version :");
        start = nanoTime();
        result = obj3.findFromLinkedListUsingIterator("Ashraf");
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        //replace(character,character)
        System.out.println("Replasing a to z...");

        System.out.println();
        System.out.println("Using arrayList Loop version:");
        start = nanoTime();
        obj3.replaceUsingArrayListUsingLoop('a','z');
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("Using arrayList iterator version :");
        start = nanoTime();
        obj3.replaceUsingArrayListUsingIterator('a','z');
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println();
        System.out.println("Using linedList Loop version:");
        start = nanoTime();
        obj3.replaceUsingLinkedListUsingLoop('a','z');
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");


        System.out.println();
        System.out.println("Using linedList Iterator version:");
        start = nanoTime();
        obj3.replaceUsingLinkedListUsingIterator('a','z');
        end = nanoTime();
        logger.info("Elapsed Time for this oparation is :"+ (end - start)+ " Nano Seconds");

        System.out.println("********************************************************************");

    }
}
