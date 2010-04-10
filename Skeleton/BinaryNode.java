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
        height = 1; //TODO: should this be zero??
        max = data.getMaxData();
    }

	public BinaryNode(MyObject data, BinaryNode parent) {
		this.data = data;
        this.parent = parent;
        this.left = this.right = null;
        this.height = 1; //TODO: should this be zero??
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
            return this.left.height;
        }
    }

	protected int rightSubTreeHeight(){
		if (this.right == null) {
            return 0;
        } else {
            return this.right.height;
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
		}
		else {
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

}
