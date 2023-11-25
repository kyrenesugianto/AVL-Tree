package structures;

public class AVLTree <T extends Comparable<T>> implements BSTInterface<T> {
	protected BSTNode<T> root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	public boolean isEmpty() {
		// DO NOT MODIFY
		return root == null;
	}

	public int size() {
		// DO NOT MODIFY
		return size;
	}

	public BSTNode<T> getRoot() {
		// DO NOT MODIFY
		return root;
	}
	
	public void printTree() {
		System.out.println("------------------------");
		if (root != null) root.printSubtree(0);
	}

	public boolean remove(T element) {
		// Do not need to implement this method.
		return false;
	}

	public T get(T element) {
		// Do not need to implement this method.
		return null;
	}

	public int height() {
		return height(this.root);
	}

	public int height(BSTNode<T> node) {
		// return the node height
		//return node != null ? node.getHeight() : -1;
		if (node == null) {
			return -1;
		}
		return node.getHeight();
	}

	private void setHeight(int h) {
		int height = h;
	} 
	
	public void updateHeight(BSTNode<T> node) {
		// TODO: update node height to 1 + the maximal height between left and right subtree
		int leftHeight = height(node.getLeft());
		int rightHeight = height(node.getRight());
		// set node's new height
		node.setHeight((Math.max(leftHeight, rightHeight) + 1));

	}

	public int balanceFactor(BSTNode<T> node) {
		// TODO: compute the balance factor by substracting right subtree height by left subtree height
		// height (left subtree) - height(right subtree)
		//int balanceF = 0;
		//int leftHeight = height(node.getLeft());
		//int rightHeight = height(node.getRight());
		
		//balanceF = rightHeight - leftHeight;
		return height(node.getRight()) - height(node.getLeft());
		//return balanceF;
	}

	public BSTNode<T> rotateLeft(BSTNode<T> node) {
		// TODO: implement left rotation algorithm
		BSTNode<T> b = node.getRight();
		BSTNode<T> c = b.getLeft();
		b.setLeft(node);
		node.setRight(c);
		node.setParent(b);
		updateHeight(node);
		updateHeight(b);
		return b;
		
	}
	
	public BSTNode<T> rotateRight(BSTNode<T> node) {
		// TODO: implement right rotation algorithm
		//BSTNode<T> x = node.getLeft();
		BSTNode<T> a = node.getLeft();
		BSTNode<T> c = a.getRight();
		a.setRight(node);
		node.setLeft(c);
		node.setParent(a);
		updateHeight(node);
		updateHeight(a);
		return a;
	}

	// When inserting a new node, updating the height of each node in the path from root to the new node.
	// Check the balance factor of each updated height and run rebalance algorithm if the balance factor
	// is less than -1 or larger than 1 with following algorithm
	// 1. if the balance factor is less than -1
	//    1a. if the balance factor of left child is less than or equal to 0, apply right rotation
	//    1b. if the balance factor of left child is larger than 0, apply left rotation on the left child,
	//        then apply right rotation
	// 2. if the balance factor is larger than 1
	//    2a. if the balance factor of right child is larger than or equal to 0, apply left rotation
	//    2b. if the balance factor of right child is less than 0, apply right rotation on the right child,
	//        then apply left rotation
	public void add(T t) {
		// TODO
		if (t == null) {
			throw new NullPointerException();
		}
		//root = addHelper(root, new BSTNode<T>(t, null, null), t);
		root = addHelper(root, t);
	}

	private int treeSize(BSTNode<T> rootNode) {
		int treeSize = 0;
		if (rootNode == null) {
			return treeSize;
		}
		else {
			treeSize = treeSize(rootNode.getLeft()) + treeSize(rootNode.getRight()) + 1;
		}
		return treeSize;
	}

	private BSTNode<T> addHelper(BSTNode<T> rootNode, T t) {
		if (rootNode == null) {
			return new BSTNode<T>(t, null, null);
		}
		// if element is greater than root, set to right of root 
		if (rootNode.getData().compareTo(t) < 0) {
			rootNode.setRight(addHelper(rootNode.getRight(), t));
			rootNode.getRight().setParent(rootNode);
		} 
		// if element is less than root, set to left of root
		else {
			rootNode.setLeft(addHelper(rootNode.getLeft(), t));
			rootNode.getLeft().setParent(rootNode);
		}
		size = treeSize(rootNode);
		
		int balanceFactor = height(rootNode.getLeft()) - height(rootNode.getRight());
		// if left heavy
		if (balanceFactor > 1) {
			// height(left) - height(right)
			int balanceOfRight = height(rootNode.getLeft().getLeft()) - height(rootNode.getLeft().getRight());
			// if a node is inserted in the left subtree of the left subtree, the tree then needs a right rotation
			if (balanceOfRight == 1) {
				return rotateRight(rootNode);
			} 
			//Left Right Case: 2,-1
			else {
				// if a node has been inserted into the right subtree of the left subtree
				rootNode.setLeft(rotateLeft(rootNode.getLeft()));
				return rotateRight(rootNode);
			}
		}
		// if right heavy
		if (balanceFactor < -1) {
			// height(left) - height(right)
			int balanceOfLeft = height(rootNode.getRight().getLeft()) - height(rootNode.getRight().getRight());
			if (balanceOfLeft == -1) {
				// if node is inserted into the right subtree of the right subtree, then we perform a single left rotation
				return rotateLeft(rootNode);  //single left for -1
			}
			//Right left case: -2,1 
			else {
				// if a node has been inserted into the left subtree of the right subtree
				rootNode.setRight(rotateRight(rootNode.getRight()));
				return rotateLeft(rootNode);
			}
		}
		updateHeight(rootNode);
		return rootNode;
	}
}