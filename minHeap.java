/* Author: Chitrangada Juneja
 * here, we assume the frequencies class has 
 * each char in the index representing its index; 
 * either way, we find a way to get the char, frequency
 * Taking it for granted our nodes have a char-int as a 
 * key
 */

public class minHeap {

	public TreeNode [] heap;
	
	public int heapSize;//the max number of elements in the heap
	public int currSize;
	
	public static final int front=1;
	//the front of the heap is always index 1
	
	public minHeap (int i) {
		heap= new TreeNode[i];
		heapSize=i;
		currSize=0;
		
	}
	// to get the indices of the parent, 
	// and left and right child
	public int parentIndex ( int i) {
		return (i-1)/2;
	}
		 
	public int leftIndex( int i) {
		return 2*i+1;
	}
	
	public int rightIndex (int i) {
		return (2*i +2);
	}
	//if we need current size
	public int getSize() {
		return currSize;
	}
	
	// need to insert into the heap
	public void insert ( TreeNode curr) {
		/* to insert TreeNode curr into the heap,
		 * we need to ensure we place it in the 
		 * next available index , and then basically 
		 * reheapify the entire minHeap. We also 
		 * increment currSize to maintain an accurate
		 * count of elements in the heap.
		 * 
		 */
		
		
		int index=currSize;
		heap[currSize]=curr;
		currSize++;
		heapify();
		
		// we need to check we insert and still maintain our heap
		//order, therefore we need to check against the parent 
		// of the index we are putting in our new node
		
		
		
		
		//our final val for index is the one where the parent < curr
		// so we just use that to get our spot 
		
		// this works because we can automatically assume
		// that until this insert, we had a perfect min heap order
		//implying that whatever the parent is, its the smallest 
		//out of all in a subtree. therefore, we only need to check 
		//against the parent, and not worry about other children
		// in other subtrees. this idea is easier when we think about the tree
		// as being a set of small subtrees, instead of this huge rooted one.
	
		
	}
	// need a swap function to swap when removing
	//and returning the min
	
	public void swap (int i, int swap) {
		TreeNode temp= heap[i];
		heap[i]=heap[swap];
		heap[swap]=temp;
		
	}
	// method to get the min , very easy getter
	public TreeNode getMin() {
		if (currSize!=0) {
			return heap[0];
			
		}
		return null;
	}
	
	public 	void  heapify( ) {
		/*
		 * this method is to reheapify the heap after we
		 * remove a node from it, and basically reset
		 * our entire heap. it is recursive, which makes 
		 * it easier for us to understand the call stack, 
		 * and the work being done.
		 * we use a helper function to sink.
		 */
		int size=currSize;
		for ( int i=(currSize/2)-1; i>=0;i--) {
			sink(i);
			
		}
		
	}
	public void sink( int index) {
		int smallest= index;
		int leftChild=leftIndex(index);
		int rightChild=rightIndex(index);
		// if left childs frequency is the least
		 if (leftChild < currSize && heap[leftChild].getFrequency() < heap[index].getFrequency()) {
			 smallest=leftChild;
			  
		 }
		 if (rightChild < currSize && heap[rightChild].getFrequency() < heap[index].getFrequency()) {
			 
			 smallest=rightChild;
		 }
		 if (smallest!=index) {
			 TreeNode temp= heap[index];
			 heap[index]= heap[smallest];
			 heap[smallest]=temp;
			 sink(smallest);
		 }
		
		
	}
	/*
	 * we implement this by simply replacing the curr
	 * min with the last indexed element, and then 
	 * reduce the current size
	 * 
	 */
	public TreeNode removeMin() {
		if (currSize!=0) {
			TreeNode currMin= heap[0];
			heap[0]= heap[currSize-1];
			currSize--;
			heapify();
			return currMin;
		}
		return null;
		
	}
	

	
	
	
		 
	 
}
