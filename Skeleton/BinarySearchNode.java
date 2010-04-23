

public class BinarySearchNode extends BinaryNode {

	public BinarySearchNode(MyObject data) {
		super(data);
	}

	public BinarySearchNode(MyObject data,BinarySearchNode parent) {
		super(data,parent);
	}

	protected BinaryNode insert(MyObject toAdd) {
        BinaryNode nxt = this, ans = null, toReturn = null;
        while (nxt != null) {
            ans = nxt;
            if (nxt.getData().getKeyData().compareTo(toAdd.getKeyData()) < 0) {
                // toAdd.getKeyData() is greater
                nxt = nxt.getRight();
            } else { // toAdd.getKeyData() is less than this.getData().getKeyData()
                nxt = nxt.getLeft();
            }
        }
        BinaryNode newNode = createNode(toAdd);
        newNode.setParent(ans);
        // connecting newNode to ans as the appropriate child
        if (ans.getData().getKeyData().compareTo(toAdd.getKeyData()) < 0) {
            ans.setRight(newNode);
            toReturn = ans.getRight();
        } else {
            ans.setLeft(createNode(toAdd));
            toReturn = ans.getLeft();
        }
        // updating height and max in the parent nodes
        Comparable mx = newNode.getMax();
        while (ans != null) {
            if (ans.getMax().compareTo(mx) < 0) {ans.setMax(mx);} //update max
            ans.updateHeight(); // update height
            ans = ans.getParent();
        }
        return toReturn;
    }

    protected BinaryNode remove(Comparable toRemove) {
        // find the node whose key is toRemove
        BinaryNode tmp = this/*, last = null*/;
        Comparable key = tmp.getData().getKeyData();
        while (key.compareTo(toRemove) != 0 /* && tmp != null */) {
            /*last = tmp;*/
            if (key.compareTo(toRemove) < 0)
                tmp = tmp.getRight();
            else
                tmp = tmp.getLeft();
            if (tmp != null) // the search continues!
                key = tmp.getData().getKeyData();
            else
                return null; // toRemove is not part of the tree, RETURN NULL
        }
        // remove the node containing toRemove
        if (tmp.getParent() == null) // tmp is the root of the tree
            return null;
        BinaryNode parent = tmp.getParent();
        boolean isRight; // is tmp a right-child?
        isRight = (parent.getData().getKeyData().compareTo(key) < 0);
        if (tmp.getHeight() == 1) { // tmp has no children
            if (isRight) {
                parent.setRight(null);
                parent.updateHeight();
                parent.updateMax();
            }
            else {
                parent.setLeft(null);
                parent.updateHeight();
                parent.updateMax();
            }
            return parent;
        }
        else if (tmp.getRight() == null) { // tmp has one child - a left one
            if (isRight) {
                parent.setRight(tmp.getLeft());
                tmp.getLeft().setParent(parent);
                parent.updateHeight();
                parent.updateMax();
            }
            else {
                parent.setLeft(tmp.getLeft());
                tmp.getLeft().setParent(parent);
                parent.updateHeight();
                parent.updateMax();
            }
        }
        else if (tmp.getLeft() == null) { // tmp has one child - a right one
            if (isRight) {
                parent.setRight(tmp.getRight());
                tmp.getRight().setParent(parent);
                parent.updateHeight();
                parent.updateMax();
            }
            else {
                parent.setLeft(tmp.getRight());
                tmp.getRight().setParent(parent);
                parent.updateHeight();
                parent.updateMax();
            }
        }
        else { /*tmp has two children!*/
            BinaryNode suc = this.getSuccessor();
            // IMPORTANT: the successor has no left child.
            BinaryNode suc2 = suc;
            suc.remove(suc.getData().getKeyData()); // remove suc
            tmp.setData(suc2.getData());
            parent.updateHeight();
            parent.updateMax();
        }
        return parent;
    }

    private BinaryNode getSuccessor() {
        if (this.getRight() == null) {
            return this.getParent();
        } else {
            BinaryNode ans = this.getRight();
            while (ans.getLeft() != null) {
                ans = ans.getLeft();
            }
            return ans;
        }
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