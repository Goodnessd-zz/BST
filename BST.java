public class BST {
	
	Node root;
	int count = 0;
////////////////////////////////////////////////	
	/*
   *printMenu prints the menu options in the main class
   *
   */
   public void printMenu(){      
		System.out.println("I insert a value");
		System.out.println("D Delete a value");
		System.out.println("P Find predecessor");
		System.out.println("S find successor");
		System.out.println("E exit the program");
		System.out.println("H Display the message");
	}
////////////////////////////////////////////////
/*
   *preOrder recursively calls itself to print the Root first
   *then the left branch, then the right branch.Returns String
   */	
	public String preOrder(Node n){
		if(n == null)
			return "";
		return n.getData() + " " + this.preOrder(n.getLeft()) + this.preOrder(n.getRight());
	}
////////////////////////////////////////////////
/*
   *inOrder recursively calls itself to print the left branch first
   *then the root, then the right branch. Returns String
   */		
	public String inOrder(Node n){
		if(n == null)
			return "";
		return  this.inOrder(n.getLeft()) + n.getData() + " " + this.inOrder(n.getRight());
	}
	
	public int getSize(Node n){
		if(n==null)
			return 0;
		count++;
		this.getSize(n.getLeft());
		this.getSize(n.getRight());
		return count;
	}
//////	//no arg inOrder method. returns String
	public String inOrder(){
		Node n = root;
		if(n == null)
			return "";
		return  this.inOrder(n.getLeft()) + n.getData() + " " + this.inOrder(n.getRight());
	}
////////////////////////////////////////////////
/*
   *postOrder recursively calls itself to print the left branch first
   *then the right branch, then the root. Returns String
   */	
	public String postOrder(Node n){
		if(n == null)
			return "";
		return  this.postOrder(n.getLeft()) + this.postOrder(n.getRight()) + n.getData() + " ";
	}
////////////////////////////////////////////////
	/*
   *public boolean add takes in a value, creates a node w/ that value,
   *then attempts to store it in the BST by calling the store method.
   *returns true if store is successful.
   */	
	public boolean add(int n){
		boolean didItStore = true;
		Node newnode = new Node(n, null, null, null);//create the node w/ value = n.
		if(root == null){
			root = newnode;
			newnode.setParent(null);
		}
		else{
			Node focusNode = root;
			didItStore = store(focusNode, n);   //call the store method
		}
		return didItStore;
	}
////////////////////////////////////////////////
	/*
   *public boolean store is an extension of the add method.
   *takes in a focus node and value, then recursively decides where to
   *store it. If the value already exists, do not store, boolean = false.
   */	
	public boolean store(Node focus, int val){
		boolean didItStore = true;
		if(val < focus.getData()){
			if(focus.getLeft() == null)
				focus.setLeft(new Node(val, null, null, focus));
			else{
				focus = focus.getLeft();
				store(focus, val);
			}
		}
		else if(val == focus.getData()){
			System.out.println(val + " already exists, ignore.");
			didItStore = false;
		}
		else{
			if(focus.getRight()== null)
				focus.setRight(new Node(val, null, null, focus));
			else{
				focus = focus.getRight();
				store(focus, val);   //recursive step
			}
		}
		return didItStore;
	}
////////////////////////////////////////////////	
	/*
   *public void gogogadgetString is the toString method for this BST
   *prints every element in the array in pre-, in-, and post order.
   */
	public void gogogadgetString(){
		//Node head = root;
		System.out.println("Pre-order: " + this.preOrder(root));
		System.out.println("In-order: " + this.inOrder(root));
		System.out.println("Post-order: " + this.postOrder(root));
		System.out.println("Tree length: " + getSize(root));
	}
////////////////////////////////////////////////	
	/*
   *public Delete finds the node with the given value passed in
   *if leaf, it makes its parent reference to null
   *if internal node w/ one child, makes the parent point to its only child
   *if internal node w/ two children:
      *find largest smaller value
      *remove that node from tree
      *replace value of the node to delete with this node
   */
	 
//recursively find a node, given a value
	Node cursor = root;
	public Node findNode(Node n, int target){
		if(n == null)
			return null;
		else
			if(cursor.getData() == target)		//base case: if cursor value == target value, return cursor
				return cursor;
			else if(cursor.getData() < target)	//if cursor value is less than target value, move to left branch
				cursor = findNode(cursor.getLeft(), target);
			else					
				cursor = findNode(cursor.getRight(), target);//if cursor value is greater than target value, move to right branch
		return cursor;
	  }
	
////////////////////////////////////////////////
	/*
   *public void findPred takes in integer and finds which value would
   *be placed right before it in an in-order traversal
   */
	public void findPred(int n){
		String tree = inOrder(root); //print the inorder traversal
		String[] array = tree.split(" "); //put each number into an array
		int[] numArray = new int[array.length];
		for(int i = 0; i < numArray.length; i++){
				numArray[i] = Integer.parseInt(array[i]);
		}
		for(int i = 0; i < numArray.length; i++){
			if(numArray[i] == n)
			try{
				System.out.println(numArray[i-1]); //i-1 cooresponds to value in the index before it
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("No predecessor found");
			}
		}
	}
////////////////////////////////////////////////
/*
   *public void findPred takes in integer and finds which value would
   *be placed right after it in an in-order traversal
   */	
	public void findSuc(int n){
		String tree = inOrder(root);
		String[] array = tree.split(" ");
		int[] numArray = new int[array.length];
		for(int i = 0; i < numArray.length; i++){
				numArray[i] = Integer.parseInt(array[i]);
		}
		for(int i = 0; i < numArray.length; i++){
			if(numArray[i] == n)
			try{
				System.out.println(numArray[i+1]);
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("No successor found");//in case they want successor of last value
			}
		}
	}
}
   
   //public boolean isLeaf(Node n)