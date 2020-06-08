package part02;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Simpletexteditor class
 */
public class SimpleTextEditor {

    private ArrayList<Character> arrayList = null;
    private LinkedList<Character> linkedList = null;

    /**
     * construstor method
     */
    SimpleTextEditor(){
       this.arrayList = new ArrayList<Character>();
       this.linkedList = new LinkedList<Character>();
    }

    /**
     * this function takes a path to a file txt an reads its content to an arraylist
     * @param path is the path to the file.txt tobe read from
     */
    //read
    public void readToArrayListUsingLoop(String path){

        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                this.arrayList.add((char) content);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
    /**
     * this function takes a path to a file txt an reads its content to an arraylist
     * @param path is the path to the file.txt tobe read from
     */
    public void readToArrayListUsingIterator(String path){

        ListIterator <Character> itr = arrayList.listIterator();
        File file = new File(path);

        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {

                itr.add((char) content);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * this function takes a path to a file txt an reads its content to an linkedlist
     * @param path is the path to the file.txt tobe read from
     */
    public void readToLinkedListUsingLoop(String path){

        File file = new File(path);

        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                this.linkedList.add((char) content);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * this function takes a path to a file txt an reads its content to an linkedlist
     * @param path is the path to the file.txt tobe read from
     */
    public void readToLinkedListUsingIterator(String path){

        ListIterator <Character> itr = linkedList.listIterator();

        File file = new File(path);

        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                itr.add((char) content);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }


    /**
     * this function adds the given string to the given index
     * @param index is index of a string char to be added to the arraylist
     * @param string sequence of characters to be added to the arraylist
     */
    //add
    public void addToArrayListUsingLoop(int index, String string){

       try {
           ArrayList<Character> charArray = new ArrayList<>(); // these three lines convert the given string to char arraylist
           for (char ch : string.toCharArray()) {
               charArray.add(ch);
           }

           for (int i = 0; i < charArray.size(); i++) {
               this.arrayList.add(index, charArray.get(i));
               index++;
           }
       } catch (IndexOutOfBoundsException e) {
           System.out.println("Opps! index is out of bound try to give valid index!!!  ");
       }
    }

    /**
     *this function adds the given string to the given index
     * @param index is index of a string char to be added to the arraylist
     * @param string sequence of characters to be added to the arraylist
     */
    public void addToArrayListUsingIterator(int index, String string){

        try {

            ArrayList<Character> charArray = new ArrayList<>(); // these three lines convert the given string to char arraylist
            for (char ch : string.toCharArray()) {
                charArray.add(ch);
            }

            ListIterator<Character> arrayListItr = arrayList.listIterator();
            ListIterator<Character> charArrayItr = charArray.listIterator();

            for (int i = 0; i < index - 1; i++) {
                arrayListItr.next();
            }
            while (charArrayItr.hasNext()) {
                arrayListItr.add(charArrayItr.next());
            }
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Opps! index is out of bound try to give valid index!!!  ");
        }
    }

    /**
     * this function adds the given string to the given index
     * @param index is index of a string char to be added to the linkedlist
     * @param string sequence of characters to be added to the linkedlist
     */
    public void addToLinkedListUsingLoop(int index, String string){

        try{
            ArrayList<Character> charArray = new ArrayList<>(); // these three lines convert the given string to char arraylist
            for (char ch: string.toCharArray()) { charArray.add(ch); }

            for (int i = 0; i <charArray.size(); i++) {
                this.linkedList.add(index,charArray.get(i));
                index++;
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Opps! index is out of bound try to give valid index!!!  ");
        }
    }

    /**
     * this function adds the given string to the given index
     * @param index is index of a string char to be added to the linkedlist
     * @param string sequence of characters to be added to the linkedlist
     */
    public void addToLinkedListUsingIterator(int index, String string){

        try{
            ArrayList<Character> charArray = new ArrayList<>(); // these three lines convert the given string to char arraylist
            for (char ch: string.toCharArray()) { charArray.add(ch); }

            ListIterator <Character> linkedListItr = linkedList.listIterator();
            ListIterator <Character> charArrayItr = charArray.listIterator();

            for (int i = 0; i <index-1 ; i++) { linkedListItr.next(); }
            while(charArrayItr.hasNext()){ linkedListItr.add(charArrayItr.next()); }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opps! index is out of bound try to give valid index!!!  ");
        }
    }

    //find

    /**
     * this function finds the given sequence of charracters
     * @param string sequence of chars to be found.
     * @return return index of first char of existence of sequence of chars string.
     */
    public int findFromArrayListUsingLoop(String string){

        int index = 0, count = 0;
        boolean found = false;

        try {

            ArrayList<Character> charArray = new ArrayList<>(); // these three lines convert the given string to char arraylist
            for (char ch : string.toCharArray()) {
                charArray.add(ch);
            }

            while ((found == false) && (index < (arrayList.size() - charArray.size()))) {

                count = index;found = true;
                for (int i = 0; i < charArray.size(); i++) {
                    if (charArray.get(i) != arrayList.get(count)) {
                        found = false;
                    }
                    count++;
                }
                index++;
            }
            if (found == true)
                return index;
            else
                return -1;
        }
        catch (NullPointerException e) {
          System.out.println("Opps! string points to Null !!!  ");
        }
        return index;
    }

    /**
     * this function finds the given sequence of charracters
     * @param string sequence of chars to be found.
     * @return return index of first char of existence of sequence of chars string.
     */
    public int findFromArrayListUsingIterator(String string){

        int index = 0,count = 0;
        boolean found = false;
        try {

            ArrayList<Character> charArray = new ArrayList<>(); // these two lines convert the given string to char arraylist
            for (char ch : string.toCharArray()) {
                charArray.add(ch);
            }

            ListIterator<Character> charArrayItaretor = charArray.listIterator();
            while ((found == false) && (index < (arrayList.size() - charArray.size()))) {

                count = index;found = true;
                while (charArrayItaretor.hasNext()) {
                    if (charArrayItaretor.next() != arrayList.get(count)) {
                        found = false;
                    }
                    count++;
                }
                charArrayItaretor = charArray.listIterator();
                index++;
            }
            if (found == true)
                return index;
            else
                return -1;
        }
        catch (NullPointerException e) {
            System.out.println("Opps! string points to Null !!!  ");
        }
        return index;
    }

    /**
     * this function finds the given sequence of charracters
     * @param string sequence of chars to be found.
     * @return return index of first char of existence of sequence of chars string.
     */
    public int findFromLinkedListUsingLoop(String string){

        int index = 0,count = 0 ;
        boolean found = false;
        try{

            ArrayList<Character> charArray = new ArrayList<>(); // these three lines convert the given string to char arraylist
            for (char ch: string.toCharArray()) { charArray.add(ch); }

            while((found == false) && (index < (linkedList.size() - charArray.size()))){

                count = index;found  = true;
                for (int i = 0; i < charArray.size(); i++) {
                    if(charArray.get(i) != linkedList.get(count)){
                        found = false;
                    }
                    count++;
                }
                index++;
            }
            if (found == true)
                return index;
            else
                return -1;
        }
        catch (NullPointerException e) {
            System.out.println("Opps! string points to Null !!!  ");
        }
        return index;
    }

    /**
     * this function finds the given sequence of charracters
     * @param string sequence of chars to be found.
     * @return return index of first char of existence of sequence of chars string.
     */
    public int findFromLinkedListUsingIterator(String string){

        int index = 0,count = 0;
        boolean found = false;
        try{
            ArrayList<Character> charArray = new ArrayList<>(); // these two lines convert the given string to char arraylist
            for (char ch: string.toCharArray()) { charArray.add(ch); }

            ListIterator <Character> charArrayItaretor = charArray.listIterator();

            while((found == false) && (index < (linkedList.size() - charArray.size()))){
                count = index;
                found  = true;

                while(charArrayItaretor.hasNext()) {
                    if(charArrayItaretor.next() != linkedList.get(count)){
                        found = false;
                    }
                    count++;
                }
                charArrayItaretor = charArray.listIterator();
                index++;
            }
            if (found == true)
                return index;
            else
                return -1;
        }
        catch (NullPointerException e) {
            System.out.println("Opps! string points to Null !!!  ");
        }
        return index;
    }


    /**
     * this function takes two char one is a char from the array and linked list other is used to replace
     * @param char1 character to be replaced
     * @param char2 character to replace
     */
    //replace
    public void replaceUsingArrayListUsingLoop(Character char1,Character char2){

        for (int i = 0; i < arrayList.size() ; i++)
            if(arrayList.get(i) == char1)
                arrayList.set(i,char2);
    }

    /**
     * this function takes two char one is a char from the array and linked list other is used to replace
     * @param char1 character to be replaced
     * @param char2 character to replace
     */
    public void replaceUsingArrayListUsingIterator(Character char1,Character char2){

        ListIterator <Character> itr = arrayList.listIterator();
        while (itr.hasNext()){
            if(itr.next() == char1){
                itr.set(char2);
            }
        }
    }

    /**
     * this function takes two char one is a char from the array and linked list other is used to replace
     * @param char1 character to be replaced
     * @param char2 character to replace
     */
    public void replaceUsingLinkedListUsingLoop(Character char1,Character char2){

        for (int i = 0; i < linkedList.size() ; i++)
            if(linkedList.get(i) == char1)
                linkedList.set(i,char2);
    }

    /**
     * this function takes two char one is a char from the array and linked list other is used to replace
     * @param char1 character to be replaced
     * @param char2 character to replace
     */
    public void replaceUsingLinkedListUsingIterator(Character char1,Character char2){

        ListIterator <Character> itr = linkedList.listIterator();
        while (itr.hasNext()){
            if(itr.next() == char1){
                itr.set(char2);
            }
        }
    }

    //getters

    /**
     * this fucntion returns the arraylist
     * @return returns arraylist reference
     */
    public ArrayList<Character> getArrayList() { return arrayList; }

    /**
     * this fucntion returns the linkedlist
     * @return returns linkedlist reference
     */
    public LinkedList<Character> getLinkedList() { return linkedList; }
}
