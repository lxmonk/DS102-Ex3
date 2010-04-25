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
            String chooseAlgorithm = (String) B_raw[1] + (String) C_raw[1];
//            System.out.println("(chooseAlgorithm.equalsIgnoreCase(\"RR\")) = "
//                    + (chooseAlgorithm.equalsIgnoreCase("RR")));
            if (chooseAlgorithm.equalsIgnoreCase("RR")) {
                RR(A, B, D);
            } else if (chooseAlgorithm.equalsIgnoreCase("LL")) {
                LL(A, B, D);
            } else if (chooseAlgorithm.equalsIgnoreCase("RL")) {
                RL(A, B, C, D);
            } else if (chooseAlgorithm.equalsIgnoreCase("LR")) {
                LR(A, B, C, D);
            }
        }
        return tmp;
    }

    private void LR(BinaryNode A, BinaryNode B, BinaryNode C, BinaryNode D) {
        A.setLeft(C.getRight());
        if (C.getRight() != null) {
            C.getRight().setParent(A);
        }
        B.setRight(C.getLeft());
        if (C.getLeft() != null) {
            C.getLeft().setParent(B);
        }
        C.setLeft(B);
        B.setParent(C);
        C.setRight(A);
        A.setParent(C);
        if (D != null) {
            if (D.getRight() != null &&
                    D.getRight().getData().compareTo(A.getData()) == 0) {
                D.setRight(C);
            } else {
                D.setLeft(C);
            }
        }
        C.setParent(D);
        A.updateHeight();
        B.updateHeight();
        C.recUpdateHeight();
        A.updateMax();
        B.updateMax();
        C.recUpdateMax();
    }

    private void RL(BinaryNode A, BinaryNode B, BinaryNode C, BinaryNode D) {
        B.setLeft(C.getRight());
        if (C.getRight() != null) {
            C.getRight().setParent(B);
        }
        A.setRight(C.getLeft());
        if (C.getLeft() != null) {
            C.getLeft().setParent(A);
        }
        C.setRight(B);
        B.setParent(C);
        C.setLeft(A);
        A.setParent(C);
        if (D != null) {
            if (D.getRight() != null &&
                    D.getRight().getData().compareTo(A.getData()) == 0) {
                D.setRight(C);
            } else {
                D.setLeft(C);
            }
        }
        C.setParent(D);
        A.updateHeight();
        B.updateHeight();
        C.recUpdateHeight();
        A.updateMax();
        B.recUpdateMax();
        B.updateMax();
        C.recUpdateMax();
    }



    private void LL(BinaryNode A, BinaryNode B, BinaryNode D) {
        A.setLeft(B.getRight());
        if (B.getRight() != null) {
            B.getRight().setParent(A);
        }
        B.setRight(A);
        A.setParent(B);
        if (D != null) {
            if (D.getRight() != null &&
                    D.getRight().getData().compareTo(A.getData()) == 0) {
                D.setRight(B);
            } else {
                D.setLeft(B);
            }
        }
        B.setParent(D);
        A.updateHeight();
        B.recUpdateHeight();
        B.updateMax(); // probably unnecessary
        A.recUpdateMax();
    }

    private void RR(BinaryNode A, BinaryNode B, BinaryNode D) {
        A.setRight(B.getLeft());
        if (B.getLeft() != null) {
            B.getLeft().setParent(A);
        }
        B.setLeft(A);
        A.setParent(B);
        if (D != null) {
            if (D.getRight() != null &&
                    D.getRight().getData().compareTo(A.getData()) == 0) {
                D.setRight(B);
            } else {
                D.setLeft(B);
            }
        }
        B.setParent(D);
        A.updateHeight();
        B.recUpdateHeight();
        B.updateMax(); // probably unnecessary
        A.recUpdateMax();
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
