import java.util.LinkedList;
import java.util.Queue;


public class BinaryNode {
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;
	private MyObject data;
	private int height;
	private Comparable  max;

	public BinaryNode(MyObject data) {
		//TODO
	}

	public BinaryNode(MyObject data, BinaryNode parent) {
		//TODO
	}

	protected int getHeight(){
		//TODO
	}

	protected MyObject getData(){
		//TODO
	}

	protected Comparable getMax(){
		//TODO
	}
	
	protected int leftSubTreeHeight(){
		//TODO
	}

	protected int rightSubTreeHeight(){
		//TODO
	}

	protected void setData(MyObject o){
		//TODO
	}

	protected void setRight(BinaryNode node){
		//TODO
	}

	protected void setLeft(BinaryNode node){
		//TODO
	}
	
	protected void setParent(BinaryNode node){
		//TODO;
	}


	protected void setHeight(int h){
		//TODO
	}

	protected void setMax(Comparable max){
		//TODO	
	}

	

	
	
	/*
	 * String rep for the object
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return this.data.toString()+" max="+this.max.toString()+" height="+this.height;
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
			if(node!=null){
				q.add(node.left);
				q.add(node.right);
				System.out.println(node);
			}
			else
				System.out.println("EMPTY NODE");
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
