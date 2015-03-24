class Node{
		private int data;
		private Node left;
		private Node right;
		private Node parent;
				
		public Node(int n, Node l, Node r, Node p){
			data = n;
			left = l;
			right = r;
			parent = p;
		}
		public void setData(int n){data = n;}
		public void setLeft(Node n){left = n;}
		public void setRight(Node n){right = n;}
		public void setParent(Node n){parent = n;}
		public int getData(){return data;}
		public Node getLeft(){return left;}
		public Node getRight(){return right;}
		public Node getParent(){return parent;}
		public Node getRightMostNode(Node focus){
			if(focus.getRight() == null)
				return focus;
			else
				return getRightMostNode(focus.getRight());
		}
		
}