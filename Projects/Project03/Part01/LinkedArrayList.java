package part01;

import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;

/**
 * this class implements List interface and extends Abstract class and contains a LinkedArrayList
 */
 public class LinkedArrayList<E> extends AbstractList implements List{

    Node<E> head,tail = null;
    private int size ;
    MyLinkedArrayListIterator it = null;

    /**
     * default constructor for LinkedArrayList
     */
    LinkedArrayList(){

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * @param element element to be added to the end of the linked arraylist abstractiond list.
     * @return true in successful Adding.
     */
    @Override
   public boolean add(Object element){

        try {
            if (head == null) {

                Node newNode = new Node(element);
                head = tail = newNode;
                head.prev = null;
                tail.next = null;
                System.out.println("added to node at index " + tail.size);
                System.out.println(" > element : " + element);
                size++;
            } else {

                if (tail.size <= tail.CAPACITY - 1) {
                    tail.arrayList[ tail.size ] = (E) element;
                    System.out.println("added to node at index " + tail.size);
                    System.out.println(" > element : " + element);
                    tail.size++;
                } else {

                    System.out.println("No Suffecient Place in this Node...");
                    System.out.println("Creating New Node in the end of the list...");
                    Node newNode = (Node) new Node(element);
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                    tail.next = null;
                    System.out.println(" > element : " + element);
                    size++;
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("null pointer exeption  !!!!");
        }
       System.out.println("Total Node " +size);
       return true;
    }

    /**
     * takes an index of and element and adds the element in to the corresponding index
     * @param index index of the element
     * @param element element type Object class later we can cast it to other types.
     */
    @Override
    public void add(int index, Object element) {

        int counter = 0;
        Node temp = head;
        boolean added = false;

        try {
            while (added == false) {

                for (int i = 0; i < temp.size; i++) {

                    if (counter == index) {

                        System.out.println("ohaa laan  " + temp.arrayList[ i ]);
                        if (temp.size >= temp.CAPACITY) {//if no capacity create node

                            System.out.println("No Capacity Creating New node ...");
                            if (temp == tail) { // if we are at the last node then create a node and update the tail.
                                add(element);
                                size++;
                                System.out.println("Node created and tail updated ... ");
                            } else {//if temp is node the last node of the list

                                Node newNode = new Node(temp.arrayList[ temp.size - 1 ]);

                                int prevItem;
                                for (int j = i; j < temp.CAPACITY; j++) {
                                    prevItem = (int) temp.arrayList[ j ];
                                    temp.arrayList[ j ] = element;
                                    element = prevItem;
                                }

                                temp.next.prev = newNode;
                                newNode.next = temp.next;
                                newNode.prev = temp;
                                temp.next = newNode;
                                size++;
                                System.out.println("Node created ... ");
                            }
                        } else {//if capacity exist

                            int prevItem;
                            for (int j = i; j < temp.size - i; j++) {
                                prevItem = (int) temp.arrayList[ j ];
                                temp.arrayList[ j ] = element;
                                element = prevItem;
                            }
                        }
                        added = true;
                    }
                    counter++;
                }
                temp = temp.next;
            }
        }
        catch (IndexOutOfBoundsException in){
            System.out.println("Index out of bound");
        }
    }

    @Override
    public Object remove(int index) {

        Node temp = head;
        E returnThis = null;
        int count = 0;
        boolean found = false;

        try {
            while (found == false) {

                for (int i = 0; i < temp.size; i++) {

                    if (count == index) {
                        returnThis = (E) temp.arrayList[ i ];

                        for (int j = i; j < temp.size - 1; j++) {
                            temp.arrayList[ j ] = temp.arrayList[ j + 1 ];
                        }
                        temp.size--;
                        found = true;
                        break;
                    }
                    count++;
                }
                temp = temp.next;
            }
        }
        catch (IndexOutOfBoundsException ind){
            System.out.println("index out of bound !!!");
        }
        try {
            temp = temp.prev;
            if (temp.size == 0) {

                if (temp == head) {
                    System.out.println("Array Size is Zero so deleting head  node from the list ...");
                    head = head.next;
                } else if (temp == tail) {
                    System.out.println("Array Size is Zero so deleting tail node from the list ...");
                    tail = tail.prev;
                } else {
                    System.out.println("Array Size is Zero so deleting this node from the list ...");
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    System.out.println("Deleted the Node Successfully :) ");
                }
                size--;
            }
        }
        catch (NullPointerException nullpo){
            System.out.println("null pointer exeption !!!");
        }
        return returnThis;
    }

    /**
     * @param index index of the Node to be found and returned to caller(index starts from 0)
     * @return returns Node at ith index.
     */
    @Override
   public Object get(int index) {

        Node temp  = head;
        Integer found = -1;
        int counter = 0;
        try {
            while (temp != null) {
                for (int i = 0; i < temp.size; i++) {
                    if (counter == index) {
                        found = (Integer) temp.arrayList[ i ];
                    }
                    counter++;
                }
                temp = temp.next;
            }
        }
        catch (IndexOutOfBoundsException ind){
            System.out.println("index out of bound !!! ");
        }
        return found;
    }

    /**
     * @return size function returns the size of linked list or the number of nodes in class LinkedArrayList.
     */
    @Override
    public int size() { return this.size; }

    /**
    * this function displays all the elements of the linked list as well as each node's content
    *
    * */
    protected void  displayElements(){

        Node tem = head;
        System.out.print("Array Elements: ");
        while (tem != null){
            for (int i = 0; i < tem.size; i++)
                System.out.print(tem.arrayList[i]+" ");
            tem = tem.next;
        }
    }

    //>>>>>> Iterator Part >>>>>

    /**
     * @return ListIterator generic type object.
     */
    @Override
    public ListIterator<E> listIterator(){
        it = new MyLinkedArrayListIterator();
        return it;
    }

    /**
     * @return boolen
     */
    protected boolean hasNext(){
        return it.hasNext();
    }

    /**
     * @return E type Object from the linked arraylist.
     */
    protected E next(){
        return it.next();
    }

    /**
     * this class implements Listiterator Interface.
     */
    class MyLinkedArrayListIterator implements ListIterator<E>{

       Node<E> iterator;
       int currentPosition;

        /**
         * constructor MyLinkedArrayListIterator
         */
        MyLinkedArrayListIterator(){
            this.currentPosition = 0;
            this.iterator = head;
        }

        /**
         * @return true if not null.
         */
        @Override
        public boolean hasNext() {

            if(currentPosition+1<=size)
                return true;
            else if (currentPosition+1 > size && this.iterator.next != null)
                return true;
            else
                return false;
        }

        @Override
        public boolean hasPrevious() { return false; }

        /**
         * @return object Type E
         */
        @Override
        public E next() {

            if(iterator == null)
                return null;

            E item = (E) this.iterator.arrayList[this.currentPosition];
            this.currentPosition++;
            if(currentPosition > iterator.size) {
                System.out.println(">>>");
                this.iterator = this.iterator.next;
                this.currentPosition = 0;
                return item;
            }
            else{
                System.out.println("<<<<< "+iterator.size);
                this.currentPosition++;
                return item;
            }
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public void add(Object o) {

        }

        @Override
        public void remove(){

        }

        @Override
        public void set(E e) {

        }

        @Override
        public int nextIndex() {
            return 0;
        }
        @Override
        public int previousIndex() {
            return 0;
        }
    }
}

