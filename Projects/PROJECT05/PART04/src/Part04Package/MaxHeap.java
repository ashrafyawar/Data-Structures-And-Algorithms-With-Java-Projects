package Part04Package;
import java.util.ArrayList;

public class MaxHeap {

    ArrayList<AgeData> root;
    private boolean addReturn;
    MaxHeap(){root = new ArrayList<>(0); }

    /**
     * this function takes an object of type AgeData class and adds it into a Head tree Tree
     * @param newNode object to be added to head tree
     * @return returns true if successfully added false otherwise.
     */
    public boolean add(AgeData newNode) {
        try {
            root = add(root, newNode);
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
        return addReturn;
    }

    /**
     * this function checks if the up coming node.age is already in tree if so then only increases the value
     * else adds new node to the end of arraylist .
     * @param localRoot node to root of tree
     * @param newNode node of type AgeData
     * @return retruns arraylist of type AgeData class
     */
    private ArrayList<AgeData> add(ArrayList<AgeData> localRoot,AgeData newNode){
       int todo =  modifyIfExist(newNode.age);

           if (todo >= 0) {
               int child, parent;
               child = todo;
               parent = (child - 1) / 2;

               while (parent >= 0 && root.get(parent).numberOfPeople < root.get(child).numberOfPeople) {
                   swap(parent, child);
                   child = parent;
                   parent = (child - 1) / 2;
               }
               addReturn = true;
               return root;
           } else {
               root.add(newNode);
               addReturn = true;
               return root;
           }
    }

    /**
     * @param age age to be removed from heap tree
     * @return returns true if removed successfully false otherwise.
     */
    public boolean remove(int age){

        AgeData node = new AgeData();
        node.age  = age;//extract node.age
        try {//exception handling

            int result = modifyIfExist(node);//check if age is already exist if so then only decrease the numofPeople value.
            if (result >= 0) {//if numOfPeople is decremented
                int parent = 0, leftChild, rightChild;

                while (true) {
                    leftChild = (parent * 2) + 1;
                    rightChild = leftChild + 1;
                    if (leftChild >= root.size()) {
                        break;
                    }
                    int minChild = leftChild;
                    if (rightChild < root.size() && root.get(rightChild).numberOfPeople > root.get(leftChild).numberOfPeople) {
                        minChild = rightChild;
                    }
                    if (root.get(parent).numberOfPeople < root.get(minChild).numberOfPeople) {
                        swap(parent, minChild);
                        parent = minChild;
                    } else {
                        break;
                    }
                }
                return true;
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("index out of bound !!!!!");
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception !!!!");
        }
        return false;
    }

    /**
     * this function checks for target value if found returns the corresponding object null otherwise.
     * @param targetNode target value to be found from heap tree
     * @return returns an object of Type AgeData if target is found null otherwise.
     */
    public AgeData find(AgeData targetNode){
        try {
            for (int i = 0; i < root.size(); i++) {
                if (root.get(i).compareTo(targetNode.age) == 0) {
                    return root.get(i);
                }
            }
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception !!!!!");
        }
        return null;
    }

    /**
     * this function compares target value with each value of heap tree and returns the count of them
     * @param target target value to be compared with heap trees each node's data
     * @return returns count of the values which are smaller than the target value
     */
    public int youngerThan(int target){
        int counter = 0;
        try {
            for (int i = 0; i < root.size(); i++) {
                if (root.get(i).compareTo(target)< 0) {
                    counter++;
                }
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("Index out of Bound !!!1");
        }
        return counter;
    }

    /**
     * this function compares target value with each value of heap tree and returns the count of them
     * @param target target value to be compared with heap trees each node's data
     * @return returns count of the values which are bigger than the target value
     */
    public int olderrThan(int target){
        int counter = 0;
        try {
            for (int i = 0; i < root.size(); i++) {
                if (root.get(i).compareTo(target) > 0) {
                    counter++;
                }
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("Index out of Bound !!!1");
        }
        return counter;
    }

    /**
     * this function takes an integer age and compares it with each value of heap tree if matches the returns index of
     * particular node index -1 otherwise.
     * @param age age value of particular node of heap tree
     * @return returns index of the heap tree if age == root.index.age
     */
    private int modifyIfExist(int age){
        try {
            for (int i = 0; i < root.size(); i++) {
                if (root.get(i).compareTo(age) == 0) {
                    root.get(i).numberOfPeople = root.get(i).numberOfPeople + 1;//modify the number of people in a node
                    return i;
                }
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("index out of bound !!!!");
        }
        return -1;
    }

    /**
     * this function takes a AgeData object and compares its age value with each age value of heap tree
     * if matches then returns index of that particular node in heap tree -1 otherwise.
     * @param node node to be compared with each node value of heap tree
     * @return returns index of nodes in heap tree if node.age == root.index.age -1 otherwise.
     */
    private int modifyIfExist(AgeData node){
        try{
            for (int i = 0; i < root.size(); i++) {
                if (root.get(i).compareTo(node.age) == 0){
                    if (root.get(i).numberOfPeople > 1){
                        root.get(i).numberOfPeople = root.get(i).numberOfPeople - 1;
                        return i;
                    }else{
                        root.remove(i);
                        return -1;
                    }
                }
            }
        }catch (IndexOutOfBoundsException in){
            System.out.println("index out of bound !!!!");
        }catch (NullPointerException nl){
            System.out.println("Null pointer exception !!!");
        }
        return -1;
    }

    /**
     * @return String representaion of heap tree.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <root.size() ; i++) {
            sb.append(root.get(i).toString()+" \n");
        }
        return sb.toString();
    }

    /**
     * this function takes two integer and swaps the nodes in heap tree
     * @param parentIndex intger value
     * @param childIndex integer value
     */
    private  void swap(int parentIndex, int childIndex){
        try {
            int age = root.get(parentIndex).age;
            int numPeople = root.get(parentIndex).numberOfPeople;

            root.get(parentIndex).age = root.get(childIndex).age;
            root.get(parentIndex).numberOfPeople = root.get(childIndex).numberOfPeople;

            root.get(childIndex).age = age;
            root.get(childIndex).numberOfPeople = numPeople;
        }catch (IndexOutOfBoundsException in){
            System.out.println("Index out of bound !!!!");
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception !!!!");
        }
    }
}
