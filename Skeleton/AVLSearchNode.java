public class AVLSearchNode extends BinarySearchNode {
	public AVLSearchNode(MyObject data) {
		super(data);
	}
	public AVLSearchNode(MyObject data,BinarySearchNode parent) {
		super(data,parent);
	}

	


	protected BinaryNode insert(MyObject toAdd) {
		BinaryNode tmp = super.insert(toAdd);
		//TODO
	}

	protected AVLSearchNode createNode(MyObject data){
		return new AVLSearchNode(data);
	}
	
	
	
	
	protected AVLSearchNode getParent(){
		return (AVLSearchNode)super.getParent();
	}

	protected AVLSearchNode getLeft(){
		return (AVLSearchNode)super.getLeft();
	}

	protected AVLSearchNode getRight(){
		return (AVLSearchNode)super.getRight();
	}

}
