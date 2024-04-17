# CSC_345_G00nz
Huffman Encoding 

Group Members: Amyra White, Suhani Surana, Chitrangada Juneja, Garegin Mazmanyan 

INSERT EXPLANATIONS OF FINAL CODE PRODUCT AND FUNCTIONALITY 

**Frequencies Class:**<br> 
The Frequencies<T> class calculates the frequencies of the items by using the HashTable class. After frequencies have been calculated it returns an array of all the unique values and characters 

**Methods Implemented:**<br> 

Constructor: 

- Frequencies(String input): Constructs a new instance of the Frequencies class with the given line of text from the user.

Methods:

- calculateFrequencies(String input): This method calculates the frequencies of each character from the user's input

- returnUniques(): method returns an array only containing unique characters; rides of null placeholders from HashTable 


**TreeNode Class:**<br>
The TreeNode class utilizes the fact that as Huffman Encoding proceeds, we end up with a Tree; therefore instead of creating two different classes for this, we give a Node the ability to be identified as a subtree; therefore essentially, we dont deal with nodes, we deal with subtrees where its possible to have just a single node. This reduces our code, and makes it easier to implement the printing and merging of the nodes during debugging, especially since most of this will be accomplished recursively. 

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
  - Constructor to create and initialize a minHeap of size i.

parentIndex( int i):
  - calculates and returns the parent index of the curr heap index i.

leftIndex( int i):
  - calculates and returns the left child's index of the curr heap index i.

rightIndex (int i):
  - calculates and returns the right child's index of the curr heap index i.

getSize():
  - returns the current size of the min heap, where current size= number of TreeNodes set.

insert(TreeNode curr):
  - we insert the TreeNode curr into the heap's next open slot, and then call the heapify method to make it into a min heap again.

swap (int i , int swap):
  - swaps the TreeNode objects at index i and swap in the minHeap.

getMin():
  - if the heap isnt empty, we return heap[0], which is the minimum value in our heap, but we don't remove it from our heap.

heapify():
  - we reheap the min heap by calling sink function all parent Nodes of the current minHeap.

sink(int index):
  - we recursively swap the smallest child with the current parent index, and call sink after swapping it again, until all children are greater
    than their parents.

removeMin():
  - we remove the minimum value in the heap at heap[0] , and then reheapify it after updating our size.

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



## Huffman Class

The Huffman class is specifically designed for encoding and decoding text using Huffman coding.

### Overview

This class involves constructing a Huffman tree based on character frequencies derived from the input text. It then generates unique Huffman codes for each character and uses these codes for efficient text compression and decompression.

### Components

- **TreeNode**: Represents nodes in the Huffman tree, each containing frequency data and character information.
- **Frequencies**: A utility class that counts the frequency of each character in the input text.
- **minHeap**: A custom implementation used to build the Huffman tree efficiently, ensuring that characters with lower frequencies are given longer codes and those with higher frequencies receive shorter codes.
- **PrefixMap**: A special data structure designed to store and manage Huffman codes associated with each character in the input text.

### Key Methods

- **buildTree(Frequencies frequencies)**: Utilizes a `minHeap` to construct the Huffman tree from the frequency data of characters.
- **buildCodes(TreeNode node, String code)**: Recursively traverses the Huffman tree to generate and assign binary codes to each character, storing these codes in the `PrefixMap`.
- **encode(String text)**: Converts plain text into a string of binary codes using the Huffman codes stored in the `PrefixMap`.
- **decode(String encodedText)**: Reconstructs the original text from the encoded string by interpreting the binary codes through the Huffman tree structure.

### Usage

- **Encoding**: Converts input text to a compressed format using Huffman codes, optimizing data storage by using variable-length codes for different characters based on their frequencies.
- **Decoding**: Reverses the encoding process, rebuilding the original text from the encoded data using the generated Huffman tree.

**PrefixMap Class:**<br> 
The class builds/constructs a HashMap that will hold the character along with the prefix code associated with that character. Utilizes resizing and load factor 

**Methods Implemented:**<br> 

PrefixMap(): 
  - Constructor for initialization of HashTable with no size input
    
PrefixMap(int size):  
  - Constructor for initialization of HashTable with a size input
    
put(char key, String prefixCode): 
  - 
    
get(char key): 
  - Method gets the desired key from hashTable; utilizes linear probing until the key is found; if the key is not found, returns empty KeyValuePair object / null
    
remove(char key):   
  - Method finds the desired key and removes the key from the Hash Table; utilizes linear probing to find keys should they not be at the "correct" index

resizeUp(): 
 - method resizes the PrefixMap to be the next prime number and rehashes all of the values present in the hashMap

putExisitng(PrefixPair key): 
  - Method takes an existing Prefix pair and inserts it into the new PrefixMap to preserve its current frequency

resizeDown(): 
  - method resizes PrefixMap to be the next smallest prime number and rehashes all of the values present in the Hash Table

isPrime(int num): 
  - method returns a boolean that says if the passed number was prime or not

nextSmallestPrime(int num): 
  - Method finds the next smallest prime number and uses isPrime to validate the number

nextLargestPrime(int num): 
  - Method find the next largest prime number and uses isPrime to validate that number

hash(char key): 
  - function returns the hash Value of the current key
    
get_size(): 
  - Method returns the current size of the table

getHashTable(): 
  - Method returns the current Prefix Map<br>

















