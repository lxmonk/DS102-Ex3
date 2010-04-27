


public class BinarySearchTree extends BinaryTree{

	public BinarySearchTree(){
		super();
	}
	/*
	 * inserts toAdd to its proper place in the search tree
	 */
	public void insert(MyObject toAdd) {
        if (root == null)
            root = new BinaryNode(toAdd);
        else root.insert(toAdd);
    }

	/*
	 * removes the object from the search tree
	 */
	public void remove(Comparable object) {
        if (root != null) {
            root.remove(object);
        }
    }
	/*
	 * Searches the search tree for a node that overlaps (defined in the assignment description) with the interval [start, end]
	 * Returns the first overlaping node it encounters in the tree.
	 */
	public MyObject OverlapSearch(Comparable start, Comparable end) {
        return root.overlapSearch(start, end);
    }
}
