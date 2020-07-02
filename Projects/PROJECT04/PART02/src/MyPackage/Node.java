package MyPackage;

import java.util.Iterator;

/**
     *           this class has local parameters :
     *           size: size of the ArrayList inside Node class.
     *           arrayList: stores generic type elements in it.
     *           CAPACITY: fixed size capacity for arrayList size.
     *           next : reference to the next Node
     *           prev : reference to the prevuios node.
     *
     */
    public class Node<E>  {

        private Node<E> next = null;
        private Node<E> prev = null;
        private E element;
        /**
         * Node class default constructor.
         */
        Node(){next = null; prev = null;}

        /**
         * this Node constructor created automatically when creating the object of Node type.
         * this node created an arrayList of size CAPACITY and assigns the E element at index size.
         * @param element type generic
         */
        Node(E element){
            setElement(element);
        }

        /**
         * @return returns next node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * @param next set the nex node
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * @return returns prevous node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * @param prev set the prev node
         */
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        /**
         * @return returns the element
         */
        public E getElement() {
            return element;
        }

        /**
         * @param element sets the element
         */
        public void setElement(E element) {
            this.element = element;
        }
    }


