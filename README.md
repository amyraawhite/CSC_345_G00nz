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
  - Method returns the current Hash Table
**Frequencies Class:**<br> 
The Frequencies<T> class calculates the frequencies of the items stored in the Hashtable class. 

**Methods Implemented:**<br> 

Constructor: 

- Frequencies(): Constructs a new instance of the Frequencies class.

Methods:

- calculateFrequencies(T[] items): This method calculates the frequencies of each item from the HashTable Class.

- displayFrequencies(): This method displays the calculated frequencies to the console. This would be a useful method for debugging and testing the working of our algorithm.




