package Part04Package;

public class TestMain {
    public static void main(String[] args) {

        //Create an empty heap
        MaxHeap heap = new MaxHeap();
        System.out.println("****************************************");
        System.out.println("Testing add() ... ");

        //Add nodes
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        heap.add(new AgeData(50));
        heap.add(new AgeData(5));
        heap.add(new AgeData(15));


        System.out.println("****************************************");
        System.out.println("Testing toString() ... ");
        System.out.println(heap.toString());
        System.out.println("****************************************");
        System.out.println("Testing remove() removing 10... ");
        heap.remove(10);

        System.out.println("****************************************");
        System.out.println("Testing toString() ... ");
        System.out.println(heap.toString());
        System.out.println("****************************************");
        System.out.println("Testing remove() removing 50 ... ");
        heap.remove(50);

        System.out.println("****************************************");
        System.out.println("Testing toString() ... ");
        System.out.println(heap.toString());
        System.out.println("****************************************");
        System.out.println("Testing find() finding 70 ... ");
        System.out.println(heap.find(new AgeData(70)).toString());

        System.out.println("Testing find() finding 10 ... ");
        System.out.println(heap.find(new AgeData(10)).toString());
        System.out.println("Testing find() finding 15 ... ");
        System.out.println(heap.find(new AgeData(15)).toString());
        System.out.println("****************************************");
        System.out.println("Testing youngerThan()...");
        System.out.println("Testing with value 5 ...");
        int result = heap.youngerThan(5);
        System.out.println(result);

        System.out.println("Testing with value 50 ...");
        result = heap.youngerThan(50);
        System.out.println(result);

        System.out.println("Testing with value 15 ...");
        result = heap.youngerThan(15);
        System.out.println(result);
        System.out.println("****************************************");
        System.out.println("Testing olderThan()...");
        System.out.println("Testing with value 5 ...");
        result = heap.olderrThan(5);
        System.out.println(result);

        System.out.println("Testing with value 50 ...");
        result = heap.olderrThan(50);
        System.out.println(result);

        System.out.println("Testing with value 15 ...");
        result = heap.olderrThan(15);
        System.out.println(result);
        System.out.println("****************************************");
    }
}