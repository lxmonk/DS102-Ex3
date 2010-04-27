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
            BinaryNode son = root;
            if (((Task)root.getData()).compareTo(toRemove) == 0) {
                if (root.getHeight() == 1) {
                    // deleting the last node of the tree:
                    root = null;
                    return;
                } else {
                    son = (BinaryNode)root.getHigherSon()[0];
                }
            }
            BinaryNode tmp = ((AVLSearchNode) root).remove(toRemove);
            if (tmp != null) {
                root = tmp.getRoot();
            } else {
                root = son.getRoot();
            }
        }
    }
}
