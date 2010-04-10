

public class BinarySearchNode extends BinaryNode {

	public BinarySearchNode(MyObject data) {
		super(data);
	}

	public BinarySearchNode(MyObject data,BinarySearchNode parent) {
		super(data,parent);
	}

	protected BinaryNode insert(MyObject toAdd) {
        BinarySearchNode nxt, ans = this;
        while (nxt != null) {
            ans = nxt;
            if (nxt.getData().getKeyData().compareTo(toAdd.getKeyData()) < 0) {
                // toAdd.getKeyData() is greater
                nxt = nxt.getRight();
            } else { // toAdd.getKeyData() is less than this.getData().getKeyData()
                nxt = nxt.getLeft();
            }
        }
        if (ans.getData().getKeyData().compareTo(toAdd.getKeyData()) < 0) {
            ans.setRight(createNode(toAdd));
            return ans.getRight();
        } else {
            ans.setLeft(createNode(toAdd));
            return ans.getLeft();
        }
    }

	protected BinaryNode remove(Comparable toRemove){
            // TODO
	}
	

	protected MyObject overlapSearch(Comparable start,Comparable end){
		// TODO
	}
	

	
	/*
	 * creates a new node from data
	 */
	protected BinarySearchNode createNode(MyObject data){
		return new BinarySearchNode(data);
	}
	
	/*
	 * returns the parent as a BinarySearchNode(non-Javadoc)
	 * @see BinaryNode#getParent()
	 */
	protected BinarySearchNode getParent(){
		return (BinarySearchNode)super.getParent();
	}

	/*
	 * returns the left child as a BinarySearchNode(non-Javadoc)
	 * @see BinaryNode#getParent()
	 */
	protected BinarySearchNode getLeft(){
		return (BinarySearchNode)super.getLeft();
	}

	/*
	 * returns the right child as a BinarySearchNode(non-Javadoc)
	 * @see BinaryNode#getParent()
	 */
	protected BinarySearchNode getRight(){
		return (BinarySearchNode)super.getRight();
	}


	



}