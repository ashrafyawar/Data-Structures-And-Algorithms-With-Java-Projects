package MyPackage;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeClass<E> implements Deque<E> ,Iterable<E>{

    private Node<E> dequeListHead;
    private Node<E> dequeListTail;
    private Node<E> garbageListHead;
    private Node<E> garbageListTail;
    private int size = 0;

    /**
     * DequeClass default constructor
     */
    DequeClass() {

        dequeListHead = null;
        dequeListTail = null;
        garbageListHead = null;
        garbageListTail = null;
        size = 0;
    }

    /**
     * this function displays all the element inside dequeList
     * @param head is the head pointer of the dequeList
     */
    public void displayDequeList(Node<E> head){

        Node<E> temp = dequeListHead;
        System.out.print("[");
        while (temp != null){
            System.out.print(" "+temp.getElement());
            temp = temp.getNext();
        }
        System.out.println(" ]");
        System.out.println();
    }

    /**
     * this function displays all the element inside garbageList
     * @param head is the head pointer of the garbageList
     */
    public void displayGarbageList(Node<E> head){

        Node<E> temp = garbageListHead;
        System.out.print("[");
        while (temp != null){
            System.out.print(" "+temp.getElement());
            temp = temp.getNext();
        }
        System.out.println(" ]");
        System.out.println();
    }

    /**
     * this function adds the new element on the front of the Deque list
     *
     * @param o is an element of type Object
     */
    @Override
    public void addFirst(Object o) {

        try {

            if (garbageListHead != null) {

                if (dequeListHead == null) {

                    Node<E> temoNOde = garbageListTail;
                    temoNOde.setElement((E)o);
                    garbageListTail = garbageListTail.getPrev();
                    garbageListTail.setNext(null);

                    temoNOde.setNext(null);
                    temoNOde.setPrev(null);

                    dequeListHead = temoNOde;
                    dequeListTail = temoNOde;
                    size++;

                } else if (dequeListHead != null) {

                    Node<E> temoNOde = garbageListTail;
                    temoNOde.setElement((E)o);

                    garbageListTail = garbageListTail.getPrev();
                    garbageListTail.setNext(null);

                    temoNOde.setPrev(null);
                    temoNOde.setNext(dequeListHead);
                    dequeListHead = temoNOde;
                    size++;
                }
            } else if (garbageListHead == null && garbageListTail == null) {


                if (dequeListHead == null) {

                    Node<E> newNode = new Node<E>((E) o);

                    dequeListTail = dequeListHead = newNode;
                    dequeListHead.setNext(null);
                    dequeListHead.setPrev(null);
                    dequeListTail.setNext(null);
                    dequeListTail.setPrev(null);
                    size++;
                } else if (dequeListHead != null) {

                    Node<E> newNode = new Node<E>((E) o);
                    newNode.setPrev(null);
                    newNode.setNext(dequeListHead);
                    dequeListHead = newNode;
                    size++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Exception thrown !!!!! ");
        }

    }

    /**
     * this function adds new element on the end of the Deque list.
     *
     * @param o is an element of type Object
     */
    @Override
    public void addLast(Object o) {

        try {

            if (garbageListHead != null) {
                if (dequeListHead == null) {

                    Node<E> temoNOde = garbageListTail;
                    temoNOde.setElement((E)o);

                    garbageListTail = garbageListTail.getPrev();
                    garbageListTail.setNext(null);

                    temoNOde.setNext(null);
                    temoNOde.setPrev(null);

                    dequeListHead = temoNOde;
                    dequeListTail = temoNOde;
                    size++;

                } else if (dequeListHead != null) {

                    Node<E> temoNOde = garbageListTail;
                    temoNOde.setElement((E)o);

                    garbageListTail = garbageListTail.getPrev();
                    garbageListTail.setNext(null);

                    temoNOde.setNext(null);
                    temoNOde.setPrev(dequeListTail);

                    dequeListTail.setNext(temoNOde);
                    dequeListTail = temoNOde;
                    size++;
                }
            } else if (garbageListHead == null && garbageListTail == null) {


                if (dequeListHead == null) {

                    Node<E> newNode = new Node<E>((E) o);

                    dequeListTail = dequeListHead = newNode;
                    dequeListHead.setNext(null);
                    dequeListHead.setPrev(null);
                    dequeListTail.setNext(null);
                    dequeListTail.setPrev(null);
                    size++;

                } else if (dequeListHead != null) {

                    Node<E> newNode = new Node<E>((E) o);

                    newNode.setNext(null);
                    newNode.setPrev(dequeListTail);

                    dequeListTail.setNext(newNode);
                    dequeListTail = newNode;
                    size++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Exception thrown !!!!! ");
        }
    }

    /**
     * @param o is an element of type Object later casted to E
     * @return false of could not add or true of added successfully
     */
    @Override
    public boolean offerFirst(Object o) {

        if (garbageListHead != null) {

            if (dequeListHead == null) {

                Node<E> temoNOde = garbageListTail;
                temoNOde.setElement((E)o);

                garbageListTail = garbageListTail.getPrev();
                garbageListTail.setNext(null);

                temoNOde.setNext(null);
                temoNOde.setPrev(null);

                dequeListHead = temoNOde;
                dequeListTail = temoNOde;
                size++;

                return true;

            } else if (dequeListHead != null) {

                Node<E> temoNOde = garbageListTail;
                temoNOde.setElement((E)o);

                garbageListTail = garbageListTail.getPrev();
                garbageListTail.setNext(null);

                temoNOde.setPrev(null);
                temoNOde.setNext(dequeListHead);
                dequeListHead = temoNOde;
                size++;

                return true;
            }
        } else if (garbageListHead == null && garbageListTail == null) {


            if (dequeListHead == null) {

                Node<E> newNode = new Node<E>((E) o);

                dequeListTail = dequeListHead = newNode;
                dequeListHead.setNext(null);
                dequeListHead.setPrev(null);
                dequeListTail.setNext(null);
                dequeListTail.setPrev(null);
                size++;

                return true;
            } else if (dequeListHead != null) {

                Node<E> newNode = new Node<E>((E) o);
                newNode.setPrev(null);
                newNode.setNext(dequeListHead);
                dequeListHead = newNode;
                size++;

                return true;
            }
        }

        return false;
    }

    /**
     * @param o is an element of type Object later casted to type E
     * @return false if could not add to the Deque list or true if added successfully.
     */
    @Override
    public boolean offerLast(Object o) {

        if (garbageListHead != null) {
            if (dequeListHead == null) {

                Node<E> temoNOde = garbageListTail;
                temoNOde.setElement((E)o);

                garbageListTail = garbageListTail.getPrev();
                garbageListTail.setNext(null);

                temoNOde.setNext(null);
                temoNOde.setPrev(null);

                dequeListHead = temoNOde;
                dequeListTail = temoNOde;
                size++;

                return true;

            } else if (dequeListHead != null) {

                Node<E> temoNOde = garbageListTail;
                temoNOde.setElement((E)o);

                garbageListTail = garbageListTail.getPrev();
                garbageListTail.setNext(null);

                temoNOde.setNext(null);
                temoNOde.setPrev(dequeListTail);

                dequeListTail.setNext(temoNOde);
                dequeListTail = temoNOde;
                size++;

                return true;
            }
        } else if (garbageListHead == null && garbageListTail == null) {


            if (dequeListHead == null) {

                Node<E> newNode = new Node<E>((E) o);

                dequeListTail = dequeListHead = newNode;
                dequeListHead.setNext(null);
                dequeListHead.setPrev(null);
                dequeListTail.setNext(null);
                dequeListTail.setPrev(null);
                size++;

                return true;

            } else if (dequeListHead != null) {

                Node<E> newNode = new Node<E>((E) o);

                newNode.setNext(null);
                newNode.setPrev(dequeListTail);

                dequeListTail.setNext(newNode);
                dequeListTail = newNode;
                size++;

                return true;
            }
        }
        return false;
    }

    /**
     * removes the entry at the front of the deque and returns it if the deque is not empty
     * @return removed object if dequelist is not empty otherwise throw no such element exception
     */
    @Override
    public E removeFirst() {

        Node<E> temp = null;
        try{
            temp = dequeListHead;

            dequeListHead = dequeListHead.getNext();

            if (garbageListHead == null){

                garbageListHead = garbageListTail = temp;
                temp.setNext(null);
                temp.setPrev(null);
            }
            else {

                temp.setNext(null);
                temp.setPrev(garbageListTail);
                garbageListTail.setNext(temp);
                garbageListTail = temp;
            }
            size--;
        }
        catch (NoSuchElementException e){
            System.out.println("Exception !!! Element could not be inserted ... ");
        }
        catch (NullPointerException n){
            System.out.println("Null pointer Exception !!!!");
        }

        return  temp.getElement();
    }

    /**
     * removes the entry at the front of the deque and returns it if the deque is not empty
     * @return removed object if dequelist is not empty otherwise throw no such element exception
     */
    @Override
    public E removeLast() {

        Node<E> temp = null;
        try{

            temp = dequeListTail;
            dequeListTail = dequeListTail.getPrev();
            dequeListTail.setNext(null);

            if (garbageListHead == null){

                garbageListHead = garbageListTail = temp;
                temp.setNext(null);
                temp.setPrev(null);
            }
            else {

                temp.setNext(null);
                temp.setPrev(garbageListTail);
                garbageListTail.setNext(temp);
                garbageListTail = temp;
            }
            size--;
        }
        catch (NoSuchElementException e){
            System.out.println("Exception !!! Element could not be inserted ... ");
        }
        catch (NullPointerException n){
            System.out.println("Null pointer Exception !!!!");
        }

        return temp.getElement();
    }

    /**
     * this function removes  an element on the front of the list and returns it to the caller area
     * @return removed element otherwise null
     */
    @Override
    public E pollFirst() {

        if (dequeListHead == null){
            return  null;
        }
        else{

            Node<E> temp = dequeListHead;
            dequeListHead = dequeListHead.getNext();
            size--;

            if (garbageListHead == null){

                garbageListHead = garbageListTail = temp;
                temp.setNext(null);
                temp.setPrev(null);
                return temp.getElement();
            }
            else {

                temp.setNext(null);
                temp.setPrev(garbageListTail);
                garbageListTail.setNext(temp);
                garbageListTail = temp;
                return temp.getElement();
            }

        }
    }

    /**
     * this function removes  an element on the end of the list and returns it to the caller area
     * @return removed element otherwise null
     */
    @Override
    public E pollLast() {

        if (dequeListHead == null){
            return  null;
        }
        else{

            Node<E> temp = dequeListTail;
            dequeListTail = dequeListTail.getPrev();
            dequeListTail.setNext(null);
            size--;
            if (garbageListHead == null){

                garbageListHead = garbageListTail = temp;
                temp.setNext(null);
                temp.setPrev(null);
                return temp.getElement();
            }
            else {

                temp.setNext(null);
                temp.setPrev(garbageListTail);
                garbageListTail.setNext(temp);
                garbageListTail = temp;
                return temp.getElement();
            }
        }
    }

    /**
     * @return returns the first element on the list
     */
    @Override
    public E getFirst() {

        Node<E> temp = null;
        try{
            temp = dequeListHead;
        }
        catch (NoSuchElementException exe){
            System.out.println("NO such element or deque is empty !!!");
        }
        catch (NullPointerException w){
            System.out.println("Null Pointer Exception !!!");
        }
        return temp.getElement();
    }

    /**
     * @return returns last element on the list
     */
    @Override
    public E getLast() {

        Node<E> temp = null;
        try{
            temp = dequeListTail;
        }
        catch (NoSuchElementException e){
            System.out.println("NO such element or deque is empty !!!");
        }
        return temp.getElement();
    }

    /**
     * @return returns first element
     */
    @Override
    public E peekFirst() {

        if(dequeListHead == null){
            return  null;
        }
        else{
            return dequeListHead.getElement();
        }
    }

    /**
     * @return returns last element on the list
     */
    @Override
    public E peekLast() {

        if(dequeListTail == null){
            return  null;
        }
        else{
            return dequeListTail.getElement();
        }
    }

    /**
     * @param o element to be removed from the list
     * @return returns the found element
     */
    public boolean removeFirstOccurrence(Object o) {

        Node<E> temp;
        E element = (E) o;

        try {

            temp = dequeListHead;
            if (dequeListHead.getPrev() == null && dequeListHead.getNext() == null)
                System.out.println("yes both null");
            while (temp != null) {

                if (temp.getElement() == element) {

                    if (temp.getNext() == null && temp.getPrev() == null){// if at head

                        System.out.println("head head");

                        temp.setPrev(garbageListTail);
                        garbageListTail.setNext(temp);
                        garbageListTail = temp;
                        dequeListHead = dequeListTail = null;//reset the list
                        return true;

                    }
                    else if (temp.getPrev() != null && temp.getNext() == null){//if at tail

                            System.out.println("tail tail");
                            dequeListTail  = dequeListTail.getPrev();
                            temp.setPrev(garbageListTail);
                            garbageListTail.setNext(temp);
                            garbageListTail = temp;
                            return true;

                    }
                    else{

                        System.out.println(">>>>");
                        Node<E> prev = temp.getNext();
                        Node<E> next =  temp.getPrev();
                        System.out.println(temp.getNext().getElement());
                        System.out.println((temp.getPrev()).getElement());

                        return true;

                    }
                }
                temp = temp.getNext();
            }
        }
        catch (NullPointerException e){
            System.out.println("Null Pointer Exception");
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    /**
     * @param o element to be added
     * @return returns the element
     */
    @Override
    public boolean add(Object o) {
        boolean success =false;
        try{
            addFirst(o);
            success =true;
        }
        catch (ClassCastException c){
            System.out.println("Cannot cast this class");
        }
        catch (NullPointerException n){
            System.out.println("null pointer !!!!");

        }
        catch (IllegalStateException s){
            System.out.println("Illegal State !!!!");
        }
        catch (IllegalArgumentException ill){
            System.out.println("illegal argument exception !!!!");

        }
        return success;
    }

    /**
     * @param o element to be added
     * @return returns the element
     */
    @Override
    public boolean offer(Object o) {


        boolean success =false;
        try{
            offerFirst(o);
            success =true;
        }
        catch (ClassCastException c){
            System.out.println("Cannot cast this class");
        }
        catch (NullPointerException n){
            System.out.println("null pointer !!!!");

        }
        catch (IllegalArgumentException ill){
            System.out.println("illegal argument exception !!!!");

        }
        return success;
    }

    /**
     * @return removes the first element from the list
     */
    @Override
    public E remove(){

        try{
            removeFirst();
        }
        catch (NoSuchElementException n){
            System.out.println("no such element !!!!");
        }
        return null;
    }

    /**
     * @return removes the first element from the list
     */
    @Override
    public E poll() {
        return pollFirst();
    }

    /**
     * @return returns the first element
     */
    @Override
    public E element() {
        return getFirst();
    }

    /**
     * @return returns the first element
     */
    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void push(Object o) {
        addFirst(o);

    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * @param o the element to be looked for in the list
     * @return returns true if in contains the given element
     */
    @Override
    public boolean contains(Object o) {
        Node<E> temp = dequeListHead;
        while (temp != null){
            if (temp.getElement() == (E) o){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    /**
     * @return returns the size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return returns true if list is empty
     */
    @Override
    public boolean isEmpty() {
        if(dequeListHead == null){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return new LinkedListIterator();
    }

    /**
     * iterator class which acts like iterator in Deque interface.
     */
    class LinkedListIterator implements Iterator<E>{

        Node<E> iterator = null;

        @Override
        public boolean hasNext() {
         if (iterator == null && dequeListHead != null){
             return true;
         }
         else if (iterator != null){
             return iterator.getNext() != null;
         }
            return false;
        }


        @Override
        public E next() {
            if(iterator == null && dequeListHead != null){
                iterator = dequeListHead;
                return dequeListHead.getElement();
            }
            else if(iterator != null){
                iterator = iterator.getNext();
                return iterator.getElement();
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator descendingIterator() {
        return null;
    }


    /**
     * @return returns dequelist head pointer
     */
    public Node<E> getDequeListHead() {
        return dequeListHead;
    }

    /**
     * @param dequeListHead sets the dequelist head pointer
     */
    public void setDequeListHead(Node<E> dequeListHead) {
        this.dequeListHead = dequeListHead;
    }

    public Node<E> getDequeListTail() {
        return dequeListTail;
    }

    /**
     * @param dequeListTail sets dequelist tail pointer
     */
    public void setDequeListTail(Node<E> dequeListTail) {
        this.dequeListTail = dequeListTail;
    }

    public Node<E> getGarbageListHead() {
        return garbageListHead;
    }

    /**
     * @param garbageListHead sets garbagelist head pointer
     */
    public void setGarbageListHead(Node<E> garbageListHead) {
        this.garbageListHead = garbageListHead;
    }

    /**
     * @return get garbagelist tail pointer
     */
    public Node<E> getGarbageListTail() {
        return garbageListTail;
    }

    /**
     * @param garbageListTail sets garbagelist tail pointer
     */
    public void setGarbageListTail(Node<E> garbageListTail) {
        this.garbageListTail = garbageListTail;
    }
}
