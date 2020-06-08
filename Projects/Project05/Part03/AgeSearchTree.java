package Part03Package;

/**
 * AgeSearchTree class extends BinarySearch class functionality and overrides its functions
 */
public class AgeSearchTree {

    private AgeData root;
    private boolean addReturn;
    private AgeData deleteReturn;

    /**
     * default constructor
     */
    AgeSearchTree (){root  = null;}

    /**
     * this function takes an object of type AgeData class and adds it into a BinarySearch Tree
     * @param item object to be added to BinarySearch like AgeSearchTree
     * @return returns true if successfully added false otherwise.
     */
    public boolean add(AgeData item) {
        try {
            root = add(root, item);
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
        return addReturn;
    }

    /**
     * function inserts given object to the BinarySearchTree
     * @param localRoot AgeData type node
     * @param newNode node tobe added to tree
     * @return returns the added object to the tree otherwise null
     */
    private AgeData add(AgeData localRoot,AgeData newNode){
            if (localRoot == null) {
                addReturn = true;
                return newNode;
            } else if (newNode.compareTo(localRoot.age) == 0) {
                addReturn = true;
                localRoot.numberOfPeople = localRoot.numberOfPeople + 1;
                return localRoot;
            } else if (newNode.compareTo(localRoot.age) < 0) {
                localRoot.left = add(localRoot.left, newNode);
                return localRoot;
            } else {
                localRoot.right = add(localRoot.right, newNode);
                return localRoot;
            }
    }

    /**
     * this function uses its wrapper delete function to delete a particular object from tree
     * @param ageValue value tobe deleted from tree
     * @return returns the object deleted from tree if successful otherwise null.
     */
    public boolean remove(int ageValue){
        AgeData tempNode = new AgeData();
        tempNode.age = ageValue;
        tempNode = find(tempNode);
        boolean res  =false;
        try{
           tempNode =  delete(root,tempNode);
            if(tempNode != null){
                res = true;
            }
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
            return res;
    }

    /**
     * this function deleted given object from binarySearch Tree
     * @param localRoot root to current location in the tree
     * @param ageNode object to be found and deleted from tree
     * @return reruns deleted object if successful null otherwise.
     */
    private AgeData delete(AgeData localRoot,AgeData ageNode){

       if (localRoot == null){//if node is null
           deleteReturn = null;
           return localRoot;
       }

       int compResult = ageNode.compareTo(localRoot.age);//compare if target value is equal or bigger of smaller than current objects corresponding value
       if (compResult < 0){//if smaller the trace left of tree
           localRoot.left = delete(localRoot.left,ageNode);
           return localRoot;
       }
       else if (compResult > 0){//if bigger then trace right of tree
           localRoot.right = delete(localRoot.right,ageNode);
           return localRoot;
       }
       else{//if equal
           deleteReturn = localRoot;
           if (ageNode.numberOfPeople > 1){//if AgeData object has more than one numberOfPeople the decrease it by 1.
               localRoot.numberOfPeople = localRoot.numberOfPeople - 1;
               return localRoot;
           }
           else{//if numberOfPeople smaller than 1 then delete the node accordingly
               if (localRoot.left == null){
                   return localRoot.right;
               }
               else if (localRoot.right == null){
                   return localRoot.left;
               }
               else{
                   if (localRoot.left.right == null){
                       localRoot.age = localRoot.left.age;
                       localRoot.numberOfPeople = localRoot.left.numberOfPeople;
                       localRoot.left = localRoot.left.left;
                   }
                   else{
                       localRoot = findLargestChild(localRoot.left);
                       return localRoot;
                   }
               }
           }
       }
       return localRoot;
    }

    /**
     * this function traces BinarySearch Tree starting from parent node and finds the largest values in that subtree
     * @param parent object of type AgeData holds current parent value
     * @return returns largest value object
     */
    private AgeData findLargestChild(AgeData parent){
        try {
            if (parent.right.right == null) {
                AgeData returnNode = new AgeData();
                returnNode.age = parent.right.age;
                returnNode.numberOfPeople = parent.right.numberOfPeople;
                return returnNode;
            } else {
                return findLargestChild(parent.right);
            }
        }catch (NullPointerException nl){
        System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
        return null;
    }

    /**
     * this function takes an object and searches for it in BinarySearchTree and returns it if found otherwise null.
     * @param newObject object to be found from the tree
     * @return returns the object if found otherwise null
     */
    public AgeData find(AgeData newObject){
        AgeData tem = null;
        try {
            tem =find(root,newObject);
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
            return tem;
    }
    private AgeData find(AgeData localRoot,AgeData newObject){
        if (localRoot == null){
            return null;
        }
        else{
            int compResult = newObject.compareTo(localRoot.age);
            if (compResult == 0){
                return localRoot;
            }
            else if (compResult < 0){
                return find(localRoot.left,newObject);
            }
            else{
                return find(localRoot.right,newObject);
            }
        }
    }

    /**
     * this function uses its wrapper youngerThan function to evaluate the function.
     * @param target value which counts of the values smaller than this should be found
     * @return returns counts of the numbers smaller than target value
     */
    public int youngerThan(int target){
        int result = 0;
        try {
            result = youngerThan(root, target, 0);
        }catch (NullPointerException nl){
            System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
        return result;
    }

    /**
     * @param localNode current location in BinarySearchTree
     * @param target value to be compared and find out whether smaller of bigger of equal
     * @param result counts of the occurrence of the values smaller than target values in a BinarySearch Tree
     * @return returns counts of the values smaller than the target value.
     */
    private int youngerThan(AgeData localNode,int target,int result){
        if (localNode == null){
            return result;
        }
        int compare = localNode.compareTo(target);
        if (compare == 0){
           result =  youngerThan(localNode.left,target,result);
        }
        else if (compare < 0 ){
            result =  youngerThan(localNode.right,target,result);
            result = youngerThan(localNode.left,target,result);
            result = result + 1;
        }
        else{
            result = youngerThan(localNode.left,target,result);
        }
        return result;
    }

    /**
     * this function uses its wrapper olderThan function to evaluate the function.
     * @param target value which counts of the values bigger than this should be found
     * @return returns counts of the numbers bigger than target value
     */
    public int olderThan(int target) {
        int result = 0;
        try {
            result = olderThan(root, target, 0);

        } catch (NullPointerException nl) {
            System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
        return result;
    }

    /**
     * @param localNode current location in BinarySearchTree
     * @param target value to be compared and find out whether smaller of bigger of equal
     * @param result counts of the occurrence of the values bigger than target values in a BinarySearch Tree
     * @return returns counts of the values bigger than the target value.
     */
    private int olderThan(AgeData localNode,int target,int result){

        if (localNode == null){
            return result;
        }
        int compare = localNode.compareTo(target);
        if (compare == 0){
            result =  olderThan(localNode.right,target,result);
        }
        else if (compare > 0 ){
            result =  olderThan(localNode.right,target,result);
            result = olderThan(localNode.left,target,result);
            result = result + 1;
        }
        else{
            result = olderThan(localNode.right,target,result);
        }
        return result;
    }

    /**
     * this function traverses tree in preorder manner and returns
     * tree string representation.
     * @return string representation of the tree.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, sb);
        return sb.toString();
    }

    /**
     * this function takes reference to a node and a String Builder element and traverses the tree and writes into string builder
     * @param node reference to the particular node
     * @param sb String Builder element
     */
    private void preOrderTraverse(AgeData node,StringBuilder sb) {
        try {
            if (node == null) {
                sb.append("null\n");
            } else {
                sb.append(node.toString());
                sb.append("\n");
                preOrderTraverse(node.left, sb);
                preOrderTraverse(node.right, sb);
            }
        }catch (NullPointerException nl){
        System.out.println("Null Pointer Exception Please Check the Program Properly !!!!!");
        }
    }
}