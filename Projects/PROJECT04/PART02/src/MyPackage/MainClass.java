package MyPackage;

import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {

        DequeClass<Integer> myObject = new DequeClass<Integer>();

        try {

            //removeFirst()
            System.out.println("removeFirst() Testing...");
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //removeLast()
            System.out.println("removeLast() Testing...");
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //pollFirst()
            System.out.println("pollFirst() Testing...");
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //pollLast()
            System.out.println("pollLast() Testing...");
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //addFirst()
            System.out.println("addFirst() Testing...");
            myObject.addFirst(1);
            myObject.addFirst(2);
            myObject.addFirst(3);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //addLast()
            System.out.println("addLast() Testing...");
            myObject.addLast(100);
            myObject.addLast(200);
            myObject.addLast(300);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //offerFirst()
            System.out.println("offerFirst() Testing...");
            myObject.offerFirst(4);
            myObject.offerFirst(5);
            myObject.offerFirst(6);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //offerLast()
            System.out.println("offerLast() Testing...");
            myObject.addLast(1000);
            myObject.addLast(2000);
            myObject.addLast(3000);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

          //removeFirst()
            System.out.println("removeFirst() Testing...");
            System.out.println("Removed Item : " + myObject.removeFirst());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //removeLast()
            System.out.println("removeLast() Testing...");
            System.out.println("Removed Item : " + myObject.removeLast());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //pollFirst()
            System.out.println("pollFirst() Testing...");
            System.out.println("Polled Item : " + myObject.pollFirst());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //pollLast()
            System.out.println("pollLast() Testing...");
            System.out.println("Polled Item : " + myObject.pollLast());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //getFirst()
            System.out.println("getFirst() Testing...");
            System.out.println("get Item : " + myObject.getFirst());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //getLast()
            System.out.println("getLast() Testing...");
            System.out.println("get Item : " + myObject.getLast());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //peekFirst()
            System.out.println("peekFirst() Testing...");
            System.out.println("Peeked Item : " + myObject.peekFirst());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //peekLast()
            System.out.println("pollLast() Testing...");
            System.out.println("Peeked Item : " + myObject.peekLast());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //removeFirstOccurrence()
            System.out.println("removeFirstOccurrence() Testing...");
            myObject.removeFirstOccurrence(4);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //add()
            System.out.println("add() Testing...");
            myObject.add(1111111);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //offer()
            System.out.println("offer() Testing...");
            myObject.offer(22222222);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //remove()
            System.out.println("remove() Testing...");
            myObject.remove();
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //poll()
            System.out.println("poll() Testing...");
            myObject.poll();
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //element()
            System.out.println("element() Testing...");
            System.out.println(myObject.element());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //peek()
            System.out.println("peek() Testing...");
            System.out.println(myObject.peek());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //push()
            System.out.println("push() Testing...");
            myObject.push(55555555);
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //pop()
            System.out.println("pop() Testing...");
            System.out.println(myObject.pop());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //contains()
            System.out.println("contains() Testing...");
            System.out.println(myObject.contains(3));
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //contains()
            System.out.println("contains() Testing...");
            System.out.println(myObject.contains(7777777));
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());
            System.out.println("garbageList Content >>> ");
            myObject.displayGarbageList(myObject.getGarbageListTail());

            //size()
            System.out.println("size() Testing...");
            System.out.println(myObject.size());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());

            //isEmpty()
            System.out.println("isEmpty() Testing...");
            System.out.println(myObject.isEmpty());
            System.out.println("dequeList Content >>> ");
            myObject.displayDequeList(myObject.getDequeListHead());

            Iterator<Integer> iterator = myObject.iterator();

            //hasNext();
            System.out.println(iterator.hasNext());

            //next();
            System.out.println("next() Testing...");
            System.out.print("[");
            while (iterator.hasNext()){
                System.out.print(" "+iterator.next());
            }
            System.out.println(" ]");

        }
        catch (NullPointerException p){
            System.out.println("Null pointer !!! ");
        }
    }
}
