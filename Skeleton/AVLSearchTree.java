public class AVLSearchTree extends BinarySearchTree {
	public AVLSearchTree(){
		super();
	}

	public void insert(MyObject toAdd) {
        if (root == null)
            root = new AVLSearchNode(toAdd);
        else
            root = ((AVLSearchNode) root).insert(toAdd).getRoot();
    }
	
	public void remove(Comparable toRemove) {
        if (root != null) {
            BinaryNode tmp = ((AVLSearchNode) root).remove(toRemove);
            if (tmp != null) {
                root = tmp.getRoot();
            }
        }
    }
}
