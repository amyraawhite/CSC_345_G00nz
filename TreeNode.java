/*
 * since we have every node, eventually becoming 
 * a tree as we add the frequencies and merge, 
 * it makes more sense to combine the Tree and Node
 * classes, instead of having a Node being created 
 * in every Tree instance. This reduces our code, and makes
 * it easier to implement the printing and merging of the 
 * nodes during debugging, especially since most of this will
 * be accomplished recursively. 
 * this method has been created specifically for a key value pair 
 * consisting of a char-int; however it can be modified to 
 * general data types.
 * 
 */
public class TreeNode {
	public char key ; //key is the char in the string
	public int frequency=-1;
	
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	private boolean isLeaf=false;
	//every node is created singularly first; hence, 
	// the isLeaf changes only when we start making them trees
	
	//constructor to set the curr object with a key,value pair
	public TreeNode (int freq, char currChar ) {
		this.key= currChar;
		this.frequency= freq;
		
	}
	//getters and setters; standard stuff
	
	public TreeNode getParent() {
		return this.parent;
	}
	public TreeNode getLeft() {
		return this.left;
	}
	public TreeNode getRight() {
		return this.right;
	}
	public char getKey() {
		return this.key;
	}
	public int getFrequency() {
		return this.frequency;
	}
	public boolean getLeaf() {
		return this.isLeaf;
	}
	
	
	public void setParent(TreeNode currParent) {
		this.parent= currParent;
	}
	
	public void setLeft (TreeNode currLeft) {
		this.left=currLeft;
	}
	
	public void setRight(TreeNode currRight) {
		this.right=currRight;
	}
	public void setKey(char currKey) {
		this.key=currKey;
	}
	public void setFrequency(int currFreq) {
		this.frequency=currFreq;
		
	}
	public void setLeaf(boolean val) {
		this.isLeaf=val;
	}
	

	
	
}

	


