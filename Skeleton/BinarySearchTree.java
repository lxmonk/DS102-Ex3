


public class BinarySearchTree extends BinaryTree{

	public BinarySearchTree(){
		super();
	}
	/*
	 * inserts toAdd to its proper place in the search tree
	 */
	public void insert(MyObject toAdd) {
        BinaryNode nxt = this.root;
        BinaryNode
        while (nxt != null) {
            if (nxt.getData().getKeyData().compareTo(toAdd.getKeyData()) < 0) {
                nxt = nxt.getRight();
            } else { // toAdd.getKeyData() > nxt.getData().getKeyData()
                nxt = nxt.getLeft();
            }
            nxt =
        }
    }

	/*
	 * removes the object from the search tree
	 */
	public void remove(Comparable object){
		//TODO
	}
	/*
	 * Searches the search tree for a node that ovelaps (defined in the assignment description) with the interval [start, end]
	 * Returns the first overlaping node it encounters in the tree.
	 */
	public MyObject OverlapSearch(Comparable start, Comparable end){ 
		//TODO
	}
}
