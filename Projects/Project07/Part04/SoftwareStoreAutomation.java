
public class SoftwareStoreAutomation < E extends Comparable < E >> extends BinaryTree < E >implements SearchTree < E > {

    // Data FieldsBinarySearchTree
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected E deleteReturn;

    /**
     * constructor with some initial software packages added.
     */
    public SoftwareStoreAutomation(){

        this.add((E) new SoftwareInfo("Adobe Photoshop 6.0",450,1));
        this.add((E) new SoftwareInfo("Adobe Photoshop 6.2",6799,2));
        this.add((E) new SoftwareInfo("Norton 4.5",1000,3));
        this.add((E) new SoftwareInfo("Norton 5.5",1313,2));
        this.add((E) new SoftwareInfo("Adobe Flash 3.3",2323,1));
        this.add((E) new SoftwareInfo("Adobe Flash 4.0",2999,1));
    }

    //Methods

    /**
     * @param softName this param is software name
     * @return
     */
    public E SearchBySoftName(E softName){
        return SearchBySoftName(root,softName);
    }
    private E SearchBySoftName(Node localRoot, E softName) {
        if (localRoot == null) {
            return null;
        }
        // Compare the target with the data field at the root.
        int compResult =  compareString(softName.toString(),localRoot.data.toString());
        if (compResult == 0) {
            System.out.println(localRoot.printSoft());
        }
        if (compResult < 0) {
            return SearchBySoftName(localRoot.left, softName);
        }
        else {
            return SearchBySoftName(localRoot.right, softName);
        }
    }

    public void SearchBySoftPrice(E softPrice){
        E temp = softPrice;
        SearchBySoftPrice(root,temp);
    }
    private void SearchBySoftPrice(Node localRoot, E softPrice) {
        if (localRoot == null) {
            return;
        }
        SoftwareInfo tt  = (SoftwareInfo) softPrice;
        int temp = tt.getSoftwarePrice();
        SoftwareInfo temp1 = (SoftwareInfo)localRoot.data;
        int tempoo = temp1.getSoftwarePrice();

        if ( temp == tempoo) {
            System.out.println(localRoot.printSoft());
        }
        SearchBySoftPrice(localRoot.left, softPrice);
        SearchBySoftPrice(localRoot.right, softPrice);
    }

    public void SearchBySoftQuantity(E softQuantity){
        E temp = softQuantity;
        SearchBySoftQuantity(root,temp);
    }
    private void SearchBySoftQuantity(Node localRoot, E softQuantity) {
        if (localRoot == null) {
            return;
        }
        SoftwareInfo tt  = (SoftwareInfo) softQuantity;
        int temp = tt.getSoftwareQuantity();
        SoftwareInfo temp1 = (SoftwareInfo)localRoot.data;
        int tempoo = temp1.getSoftwareQuantity();

        if ( temp == tempoo) {
            System.out.println(localRoot.printSoft());
        }
        SearchBySoftQuantity(localRoot.left, softQuantity);
        SearchBySoftQuantity(localRoot.right, softQuantity);
    }

    private int compareString(String str, String argumentString) {

        String[] s1 = argumentString.split("\\s");
        String argumentStringCopy = "";
        for (int i = 0; i <s1.length-1 ; i++) {
            argumentStringCopy += s1[i];
        }
        String strCopy = str.replaceAll("\\s","");

        int lim = Math.min(strCopy.length(), argumentStringCopy.length());
        int k=0;
        while(k<lim) {
            if(strCopy.charAt(k)!= argumentStringCopy.charAt(k)) {
                return (int) strCopy.charAt(k)- argumentStringCopy.charAt(k);
            }
            k++;
        }
        return strCopy.length() - argumentStringCopy.length();
    }

    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return The object, if found, otherwise null
     */
    public E find(E target) {
        return find(root, target);
    }
    /** Recursive find method.
     @param localRoot The local subtree’s root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private E find(Node localRoot, E target) {
        if (localRoot == null) {
            return null;
        }
        // Compare the target with the data field at the root.
        int compResult = target.compareTo((E) ((SoftwareInfo)localRoot.data).getSoftwareNameAndVersion());
        if (compResult == 0) {
            return localRoot.data;
        }
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    public void  browseSoftwares(){
        browseSoftwares(root);
    }
    private void browseSoftwares (Node localRoot){
        if (localRoot == null) {
            return;
        }
        System.out.println(localRoot.printSoft());
        browseSoftwares(localRoot.left);
        browseSoftwares(localRoot.right);
    }

    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }
    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node add(Node localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Node(item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            ((SoftwareInfo) localRoot.data).incrementQuantity(((SoftwareInfo)item).getSoftwareQuantity());
            addReturn = true;
            return  localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }
    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node delete(Node localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo((E) ((SoftwareInfo)localRoot.data).getSoftwareNameAndVersion());
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else {

            if (((SoftwareInfo) localRoot.data).getSoftwareQuantity()  > 1){
                //if the item to be removed has more than one quantity then just decrement the quantity.
                ((SoftwareInfo) localRoot.data).decrementQuantity(1);
                return localRoot;
            }else {

                // item is at local root and has quantity of one 1
                deleteReturn = localRoot.data;
                if (localRoot.left == null) {
                    // If there is no left child, return right child
                    // which can also be null.
                    return localRoot.right;
                } else if (localRoot.right == null) {
                    // If there is no right child, return left child.
                    return localRoot.left;
                } else {
                    // Node being deleted has 2 children, replace the data
                    // with inorder predecessor.
                    if (localRoot.left.right == null) {
                        // The left child has no right child.
                        // Replace the data with the data in the
                        // left child.
                        localRoot.data = localRoot.left.data;
                        // Replace the left child with its left child.
                        localRoot.left = localRoot.left.left;
                        return localRoot;
                    } else {
                        // Search for the inorder predecessor (ip) and
                        // replace deleted node’s data with ip.
                        localRoot.data = findLargestChild(localRoot.left);
                        return localRoot;
                    }
                }
            }
        }
    }

    /** Removes target from tree.
     @param target Item to be removed
     @return true if the object was in the tree, false otherwise
     @post target is not in the tree
     @throws ClassCastException if target is not Comparable
     */
    public boolean remove(E target) {
        return delete(target) != null;
    }

    /** Determine if an item is in the tree
     @param target Item being sought in tree
     @return true If the item is in the tree, false otherwise
     @throws ClassCastException if target is not Comparable
     */
    public boolean contains(E target) {
        return find(target) != null;
    }

    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    private E findLargestChild(Node parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else {
            return findLargestChild(parent.right);
        }
    }
}