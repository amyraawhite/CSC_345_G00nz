# CSC_345_G00nz
Huffman Encoding 

Group Members: Amyra White, Suhani Surana, Chitrangada Juneja, Garegin Mazmanyan 

INSERT EXPLANATIONS OF FINAL CODE PRODUCT AND FUNCTIONALITY 

Huffman Class:

Building the Huffman tree using the Frequency objects and the MinHeap.
Generating Huffman codes for each character.
Encoding and decoding text using the generated codes.

Possible Methods
buildTree(MinHeap heap)
Construct the Huffman tree from the Frequency objects in the MinHeap.


generateCodes(Node root, String code)
Recursively generate Huffman codes.
encode(String text)
Encode the text using the Huffman codes.
decode(String encodedText)
Decode the encoded text back to the original text.



Huffman would use the extractMin() method of MinHeap to repeatedly get the two Frequency objects with the lowest frequencies during the Huffman tree construction process.



