
public class BinaryTree {
	protected BinaryNode root;
	
	/*
	 * create an empty tree
	 */
	public BinaryTree() {
        this.root = null;
    }

	/*
	 * returns the tree height
	 */
	public int height() {
        return root.getHeight();
    }

	/*
	 * returns true iff the tree is empty
	 */
	public boolean isEmpty() {
        return root == null;
    }

	/*
	 * print the tree inorder
	 */
	public void printInOrder(){
		root.printInOrder();
	}

	/*
	 * print the tree by levels
	 */
	public void printByLevels(){
		root.printByLevels();
	}
	
	
	//NOT REALLY IMPLEMENTED
	public void remove(Comparable o){
	}

	
	
	
}