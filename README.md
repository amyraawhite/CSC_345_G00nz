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
  - Method gets the desired key from hashTable; utilizes linear probing until key is found; if key is not found, returns empty KeyValuePair object / null
    
remove(K key):   
  - Method finds desired key and removes the key from the Hash Table; utilizes linear probing to find keys should they not be at the "correct" index

