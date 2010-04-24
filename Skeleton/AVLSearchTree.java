public class AVLSearchTree extends BinarySearchTree {
	public AVLSearchTree(){
		super();
	}

	public void insert(MyObject toAdd) {
        //TODO: isn't updating root necessary?
        root.insert(toAdd);
    }
	
	public void remove(Comparable toRemove) {
        root.remove(toRemove);
    }
	
	

	
}
