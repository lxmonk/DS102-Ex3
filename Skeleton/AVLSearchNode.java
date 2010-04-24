public class AVLSearchNode extends BinarySearchNode {
	public AVLSearchNode(MyObject data) {
		super(data);
	}

    public AVLSearchNode(MyObject data, BinarySearchNode parent) {
        super(data, parent);
    }

	


	protected BinaryNode insert(MyObject toAdd) {
		BinaryNode tmp = super.insert(toAdd);
        BinaryNode A = tmp;
        while (A != null && A.isBalanced()) { // find the 1st unbalanced
            // node - or the root (then A == null)
            A = A.getParent();
        }
        if (A == null) return tmp; // the tree is balanced upto its root
        else {
            Object[] B_raw = A.getHigherSon();
            BinaryNode B = (BinaryNode) B_raw[0];
            Object[] C_raw = B.getHigherSon();
            BinaryNode C = (BinaryNode) C_raw[0];
            BinaryNode D = A.getParent();
            String chooseAlgorithm = B_raw[1] + C_raw[1];
            if (chooseAlgorithm == "RR") {
                RR(A, B, D);
            } else if (chooseAlgorithm == "LL") {
                LL(A, B, D);
            } else if (chooseAlgorithm == "RL") {
                RL(A, B, C, D);
            } else { // if (chooseAlgorithm == "LR")
                LR(A, B, C, D);
            }


	}

    private void LR(BinaryNode A, BinaryNode B, BinaryNode C, BinaryNode D) {
    }

    private void RL(BinaryNode A, BinaryNode B, BinaryNode C, BinaryNode D) {
        A.setLeft(C.getRight());
        B.setRight(C.getLeft());
        C.setLeft(B);
        C.setRight(A);
        if (D == null) {
            
        }
        }

    }

    private void LL(BinaryNode A, BinaryNode B, BinaryNode D) {
    }

    private void RR(BinaryNode A, BinaryNode B, BinaryNode d) {
        
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
