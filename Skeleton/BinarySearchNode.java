

public class BinarySearchNode extends BinaryNode {

	public BinarySearchNode(MyObject data) {
		super(data);
	}

	public BinarySearchNode(MyObject data,BinarySearchNode parent) {
		super(data,parent);
	}

	/** insert toAdd keeping the tree's Binary-Search properties*/
    protected BinaryNode insert(MyObject toAdd) {
        BinaryNode nxt = this, ans = null, toReturn;
//        boolean Same = false;
        while (nxt != null /*&& !Same*/) {
            int comp = ((Integer) nxt.getData().getKeyData()).compareTo(
                    ((Integer) toAdd.getKeyData()));
            ans = nxt;
            if (comp < 0) {
                // toAdd.getKeyData() is greater
                nxt = nxt.getRight();
            } else { // toAdd.getKeyData() is less than this.getData().getKeyData()
                nxt = nxt.getLeft();
            }
        }
        BinaryNode newNode = createNode(toAdd);
        newNode.setParent(ans);
        // connecting newNode to ans as the appropriate child
        if (((Integer) ans.getData().getKeyData()).compareTo(
                ((Integer) toAdd.getKeyData())) < 0) {
            ans.setRight(newNode);
            toReturn = ans.getRight();
        } else {
            ans.setLeft(newNode);
            toReturn = ans.getLeft();
        }
        // updating height and max in the parent nodes
        ans.recUpdateHeight(); // update height recursively upto the root
        ans.recUpdateMax();
        /* Comparable mx = newNode.getMax();
        while (ans != null) {
            if (ans.getMax().compareTo(mx) < 0) {ans.setMax(mx);} //update max
            ans = ans.getParent();
        }*/
        return toReturn;
    }

    protected BinaryNode remove(Comparable toRemove) {
        // find the node whose key is toRemove
        BinarySearchNode tmp = this;
        Comparable key = tmp.getData();
        while (((Task) key).compareTo(toRemove) != 0) {
            if (((Task)key).compareTo(toRemove) < 0) {
                tmp = tmp.getRight();
            } else {
                tmp = tmp.getLeft();
            }
            if (tmp != null) // the search continues!
                key = tmp.getData();//.getKeyData();
            else
                return null; // toRemove is not part of the tree, RETURN NULL
        }
        // remove the node containing toRemove
//        if (tmp.getParent() == null) // tmp is the root of the tree
//            return null; //TODO: take care of this case!!! (remove the root)
        boolean isntRoot = !(tmp.getParent() == null);
        BinaryNode parent = tmp.getParent();
        boolean isRight; // is tmp a right-child?
        isRight = (isntRoot && ((Task)parent.getData()).compareTo(key) < 0);
        if (tmp.getHeight() == 1) { // tmp has no children
            if (isRight) {
                parent.setRight(null);
                parent.recUpdateHeight();
                parent.recUpdateMax();
            } else {
                parent.setLeft(null);
                parent.recUpdateHeight();
                parent.recUpdateMax();
            }
//            return parent;
        }
        else if (tmp.getRight() == null) { // tmp has one child - a left one
            if (!isntRoot) { // tmp is the root
                tmp.getLeft().setParent(null);
                tmp.setLeft(null);
                return null;
            }
            if (isRight) {
                parent.setRight(tmp.getLeft());
                tmp.getLeft().setParent(parent);
                parent.recUpdateHeight();
                parent.recUpdateMax();
            } else {
                if (!isntRoot) { // tmp is the root
                    tmp.getLeft().setParent(null);
                    tmp.setLeft(null);
                    return null;
                }
                parent.setLeft(tmp.getLeft());
                tmp.getLeft().setParent(parent);
                parent.recUpdateHeight();
                parent.recUpdateMax();
            }
        }
        else if (tmp.getLeft() == null) { // tmp has one child - a right one
            if (isRight) {
                if (!isntRoot) {
                    tmp.getRight().setParent(null);
                    tmp.setRight(null);
                }
                parent.setRight(tmp.getRight());
                tmp.getRight().setParent(parent);
                parent.recUpdateHeight();
                parent.recUpdateMax();
            }
            else {
                if (!isntRoot) {
                    tmp.getRight().setParent(null);
                    tmp.setRight(null);
                }
                parent.setLeft(tmp.getRight());
                tmp.getRight().setParent(parent);
                parent.recUpdateHeight();
                parent.recUpdateMax();
            }
        }
        else { /*tmp has two children!*/
            BinaryNode suc = tmp.getSuccessor();
            // IMPORTANT: the successor has no left child.
            MyObject Data = suc.getData();
            suc.setMax(-1);
            tmp.setMax(-1);
            suc.updateMaxWithoutMe();
            suc.getParent().recUpdateMax();
            suc.remove(suc.getData()); // remove suc
            tmp.setData(Data);
            tmp.setMax(tmp.getData().getMaxData());
            tmp.recUpdateHeight();
            tmp.recUpdateMax();
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

    protected MyObject overlapSearch(Comparable start,Comparable end) {
        MyObject leftSubTreeOverlap, rightSubTreeOverlap;
        if (this.getData().overlap(start, end)) {
            return this.getData();
        }
        else if ((((Integer) this.getData().getKeyData()).compareTo((Integer) end) <= 0)
                && (this.getRight() != null)) {
            rightSubTreeOverlap = this.getRight().overlapSearch(start, end);
            return rightSubTreeOverlap;
        }
        if (this.getLeft() != null && 
                ((Integer) this.getLeft().getMax()).compareTo((Integer) start) >= 0) {
            leftSubTreeOverlap = this.getLeft().overlapSearch(start, end);
            if (leftSubTreeOverlap != null) {
                return leftSubTreeOverlap;
            }
        }
        return null;
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