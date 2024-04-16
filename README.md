# CSC_345_G00nz
Huffman Encoding 

Group Members: Amyra White, Suhani Surana, Chitrangada Juneja, Garegin Mazmanyan 

INSERT EXPLANATIONS OF FINAL CODE PRODUCT AND FUNCTIONALITY 

**Huffman Class:**<br> 
Building the Huffman tree using the Frequency objects and the MinHeap.
Generating Huffman codes for each character.
Encoding and decoding text using the generated codes.

**Possible Methods:** <br>
buildTree(MinHeap heap) --> Construct the Huffman tree from the Frequency objects in the MinHeap.<br> 
generateCodes(Node root, String code) --> Recursively generate Huffman codes.<br> 
encode(String text) --> Encode the text using the Huffman codes.<br> 
decode(String encodedText) --> Decode the encoded text back to the original text.<br> 

Huffman would use the extractMin() method of MinHeap to repeatedly get the two Frequency objects with the lowest frequencies during the Huffman tree construction process.

**HashTable Class:**<br> 
Class builds/constructs a HashTable that will hold the frequencies of characters found
within a user's input value. Hash Table will utilize resizing and load factor management. 

**Methods Implemented:**<br> 

HashTable(): 
  - Constructor for initialization of HashTable with no size input
    
HashTable(int size):  
  - Constructor for initialization of HashTable with a size input
    
put(K key): 
  - Method places the key into the Hash Table; utilizes Linear Probing for collision management
    
get(K key): 
  - Method gets the desired key from hashTable; utilizes linear probing until the key is found; if the key is not found, returns empty KeyValuePair object / null
    
remove(K key):   
  - Method finds the desired key and removes the key from the Hash Table; utilizes linear probing to find keys should they not be at the "correct" index

resizeUp(): 
 - method resizes the Hash Table to be the next prime number and rehashes all of the values present in the hashMap

putExisitng(KeyValuePair<K, V> key: 
  - Method takes an existing Key/Value pair and inserts it into the new Hash Table to preserve its current frequency

resizeDown(): 
  - method resizes Hash Table to be the next smallest prime number and rehashes all of the values present in the Hash Table


isPrime(int num): 
  - method returns a boolean that says if the passed number was prime or not

nextSmallestPrime(int num): 
  - Method finds the next smallest prime number and uses isPrime to validate the number

nextLargestPrime(int num): 
  - Method find the next largest prime number and uses isPrime to validate that number

hash(K key): 
  - function returns the hash Value of the current key


get_size(): 
  - Method returns the current size of the table

getHashTable(): 
  - Method returns the current Hash Table<br>

**TreeNode Class:**<br>
The TreeNode class utilizes the fact that as Huffman Encoding proceeds, we end up with a Tree; therefore instead of creating two different classes for this, we give a Node the ability to be identified as a subtree; therefore essentially, we dont deal with nodes, we deal with subtrees where its possible to have just a single node. This reduces our code, and makesit easier to implement the printing and merging of the nodes during debugging, especially since most of this will be accomplished recursively. 

**Methods Implemented:**<br>

TreeNode( int freq , char currChar):
  - Constructor to create a TreeNode using the currChar as our key, and accessing the frequency as our value.

getParent():
  - Method to get the parent subtree of this TreeNode. For single nodes, this is null.

getLeft():
  - Method to get the left child of this TreeNode. For single nodes, this is null.

getRight():
  - Method to get the right child of this TreeNode. For single nodes, this is null.

getKey():
  - Method to get the key, which is the character associated with curr TreeNode.

getFrequency():
  - Method to get the value, which is the frequency associated with curr TreeNode.

getLeaf():
  - Method to get the status of the TreeNode: whether it is a leaf or not.

setParent(TreeNode currParent):
  - Method to set the parent of curr TreeNode.

setLeft(TreeNode currLeft):
  - Method to set the left child of curr TreeNode.

setRight(TreeNode currRight):
  - Method to set the right child of curr TreeNode.

setKey(char currKey):
  - Method to set the char/key of curr TreeNode.

setFrequency(int currFreq):
  - Method to set the frequency/value of curr TreeNode.

setLeaf( boolean val):
 - Method to set the isLeaf attribute of a TreeNode to val.


**minHeap Class**<br>
The minHeap class creates a minimum Heap , utilising an Array made up of TreeNodes. 

**Methods Implemented:**<br>

minHeap(int i):
  - Constructor to create and initialize a minHeap of size i, 



**Frequencies Class:**<br> 
The Frequencies<T> class calculates the frequencies of the items stored in the Hashtable class. 

**Methods Implemented:**<br> 

Constructor: 

- Frequencies(): Constructs a new instance of the Frequencies class.

Methods:

- calculateFrequencies(T[] items): This method calculates the frequencies of each item from the HashTable Class.

- displayFrequencies(): This method displays the calculated frequencies to the console. This would be a useful method for debugging and testing the working of our algorithm.




