import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryNode {
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;
	private MyObject data;
	private int height;
    private Comparable max;


	public BinaryNode(MyObject data) {
        this.data = data;
        left = right = parent = null;
        height = 1;
        max = data.getMaxData();
    }

	public BinaryNode(MyObject data, BinaryNode parent) {
		this.data = data;
        this.parent = parent;
        this.left = this.right = null;
        this.height = 1; 
        this.max = data.getMaxData();
	}

	protected int getHeight(){
		return this.height;
	}

	protected MyObject getData() {
        return this.data;
    }

	protected Comparable getMax() {
        return this.max;
    }
	
	protected int leftSubTreeHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.getHeight();
        }
    }

	protected int rightSubTreeHeight(){
		if (this.right == null) {
            return 0;
        } else {
            return this.right.getHeight();
        }
	}

	protected void setData(MyObject o) {
        this.data = o;
    }

	protected void setRight(BinaryNode node) {
        this.right = node;
    }

	protected void setLeft(BinaryNode node) {
        this.left = node;
    }
	
	protected void setParent(BinaryNode node) {
        this.parent = node;
    }


	protected void setHeight(int h) {
        this.height = h;
    }

	protected void setMax(Comparable max) {
        this.max = max;
    }

	

	
	
	/*
	 * String rep for the object
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return this.data.toString() + " max=" + this.max.toString() + " height=" + this.height;
    }

	/*
	 * returns left child
	 */
	protected BinaryNode getLeft(){
		return this.left;
	}

	/*
	 * returns right child
	 */
	protected BinaryNode getRight(){
		return this.right;

	}

	/*
	 * return the parent
	 */
	protected BinaryNode getParent(){
		return this.parent;

	}

	/*
	 * print the subtree by levels
	 */
	protected void printByLevels() {
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.add(this);
		while(!q.isEmpty()){
			BinaryNode node = q.poll();
            if (node != null) {
                q.add(node.left);
                q.add(node.right);
                System.out.println(node);
            } else {
                System.out.println("EMPTY NODE");
            }
		}
	}

	/*
	 * print the subtree inorder
	 */
	protected void printInOrder() {
		if(this.left!=null)
			this.left.printInOrder();

		System.out.println(this);

		if(this.right!=null)
			this.right.printInOrder();
	}
	

	/*
	 * insert a node to the subtree
	 */
	protected BinaryNode insert(MyObject toAdd){
		BinaryNode ans = null;
		if (Math.random() < 0.5) {
			if (left == null){
				left = new BinaryNode(toAdd);
				ans =  left;
			}
			else
				left.insert(toAdd);
		} else {
			if (right == null){
				right = new BinaryNode(toAdd);
				ans = right;
			}
			else
				right.insert(toAdd);
		}
		return ans;
	}

	
	//NOT REALLY IMPLEMENTED 
	protected BinaryNode remove(Comparable o){
		return null;
	}

	//NOT REALLY IMPLEMENTED 
	protected MyObject overlapSearch(Comparable start,Comparable end){
		return null;
	}

	//NOT REALLY IMPLEMENTED
	protected BinaryNode balance(){ 
		return this;
	}

    public void updateHeight() {
        // added by us, to update the height of a BinaryNode (after insertion or deletion)
        this.setHeight(Math.max(this.rightSubTreeHeight(), this.leftSubTreeHeight()) + 1);
    }


    public void recUpdateMax() { //TODO: make it stop when unnecessary to continue
        BinaryNode tmp = this;
        while (tmp != null) {
            tmp.updateMax();
            tmp = tmp.parent;
        }
    }

    public void updateMax() {
        int lmax = (Integer) this.getLeftMax();
        int thsmax = (Integer) this.getData().getMaxData();
        int rmax = (Integer) this.getRightMax();

        this.setMax(Math.max(Math.max(rmax, lmax), thsmax));
    }
    public Comparable getRightMax() {
        if (this.getRight() == null) return (-1);
        return this.getRight().getMax();
    }

    public Comparable getLeftMax() {
        if (this.getLeft() == null) return (-1);
        return this.getLeft().getMax();
    }


    public boolean isBalanced() {
        BinaryNode left = this.getLeft(), right = this.getRight();
        int rHeight = 0;
        if (left == null) {
            return right == null || right.getHeight() == 1;
        }
        if (right != null) {
            rHeight = right.getHeight();
        }
        return (Math.abs(rHeight - left.getHeight()) < 2);
    }

    public Object[] getHigherSon() {//default changed from right to left
        Object[] ans = new Object[2];
        BinaryNode left = this.getLeft(), right = this.getRight();
        if (right == null) {
            ans[0] = left;
            ans[1] = "L";
            return ans;
        } else {
            if (left == null || left.getHeight() < right.getHeight()) {
                ans[0] = right;
                ans[1] = "R";
                return ans;
            }
            ans[0] = left;
            ans[1] = "L";
            return ans;
        }
    }

    public BinaryNode getRoot() {
        BinaryNode root = this;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        return root;
    }

    public void recUpdateHeight() { //TODO: make it stop when no change has been done
        BinaryNode tmp = this;
        while (tmp != null) {
            tmp.updateHeight();
            tmp = tmp.getParent();
        }
    }

    public void updateMaxWithoutMe() {
        int lmax = (Integer) this.getLeftMax();
        int thsmax = -1;
        int rmax = (Integer) this.getRightMax();

        this.setMax(Math.max(Math.max(rmax, lmax), thsmax));
    }
}
