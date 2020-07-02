package part01;
/**
 * @param <E> generic Type class Double LinkedList Node
 *           this class has local parameters :
 *           size: size of the ArrayList inside Node class.
 *           arrayList: stores generic type elements in it.
 *           CAPACITY: fixed size capacity for arrayList size.
 *           next : reference to the next Node
 *           prev : reference to the prevuios node.
 *
 */
public class Node<E>{

    static final int  CAPACITY = 5;
    int size = 0;
    E[] arrayList;
    Node<E> next = null;
    Node<E> prev = null;

    /**
     * Node class default constructor.
     */
    Node(){next = null; prev = null; size = 0;}

    /**
     * this Node constructor created automatically when creating the object of Node type.
     * this node created an arrayList of size CAPACITY and assigns the E element at index size.
     * @param element type generic
     */
    Node(E element){

        arrayList =(E[]) new Object[CAPACITY];//generic array creation
        this.arrayList[size] = element;
        size++;
        System.out.println("new Node created and element added to the new node 0th index...");
    }
}
