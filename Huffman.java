/**
 * @author gareginmazmanyan
 */

import java.util.Scanner;

public class Huffman {
	private TreeNode root; // Root node of the Huffman tree
	private PrefixMap codes; // Stores the Huffman codes for each character

	/**
	 * Constructor initializes the Huffman tree root and the code map.
	 */
	public Huffman() {
		this.root = null;
		this.codes = new PrefixMap();
	}

	/**
	 * Builds the Huffman tree using frequencies from the provided Frequencies
	 * object.
	 * 
	 * @param frequencies The Frequencies object containing character frequencies.
	 */
	public void buildTree(Frequencies frequencies) {
		minHeap heap = new minHeap(frequencies.returnUniques().length); // Min heap for building the Huffman tree
		KeyValuePair<Character, Integer>[] freqPairs = frequencies.returnUniques(); // Array of character frequencies

		// Insert all frequencies into the minHeap
		for (KeyValuePair<Character, Integer> pair : freqPairs) {
			if (pair != null) {
				TreeNode newNode = new TreeNode(pair.value, pair.key); // Create a new tree node for each frequency
				heap.insert(newNode);
			}
		}

		// Combine nodes until one node remains (the root of the Huffman tree)
		while (heap.getSize() > 1) {
			TreeNode left = heap.removeMin(); // Remove the smallest frequency node
			TreeNode right = heap.removeMin(); // Remove the next smallest frequency node

			// Merge the two nodes into a new node and insert back into the heap
			TreeNode merged = new TreeNode(left.getFrequency() + right.getFrequency(), '\0');
			merged.setLeft(left);
			merged.setRight(right);

			heap.insert(merged);
		}

		// Set the last remaining node as the root of the Huffman tree
		root = heap.getMin();
		buildCodes(root, ""); // Start building Huffman codes from the root
	}

	/**
	 * Recursively generates Huffman codes for each character and stores them in the
	 * PrefixMap.
	 * 
	 * @param node Current node in the Huffman tree
	 * @param code Accumulated Huffman code for the current node
	 */
	private void buildCodes(TreeNode node, String code) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				// Leaf node; store the code in PrefixMap
				codes.put(node.getKey(), code);
			} else {
				// Recursively generate codes for both subtrees
				buildCodes(node.getLeft(), code + "0");
				buildCodes(node.getRight(), code + "1");
			}
		}
	}

	/**
	 * Encodes the input text using the generated Huffman codes.
	 * 
	 * @param input Text to encode
	 * @return Encoded string using Huffman codes
	 */
	public String encode(String input) {
		StringBuilder encoded = new StringBuilder();
		for (char c : input.toCharArray()) {
			PrefixPair pair = codes.get(c); // Retrieve Huffman code for each character
			if (pair != null) {
				encoded.append(pair.value);
			}
		}
		return encoded.toString();
	}

	/**
	 * Decodes an encoded string back to the original text using the Huffman tree.
	 * 
	 * @param encoded Encoded text using Huffman codes
	 * @return Decoded original text
	 */
	public String decode(String encoded) {
		StringBuilder decoded = new StringBuilder();
		TreeNode current = root;
		for (int i = 0; i < encoded.length(); i++) {
			// Traverse the Huffman tree based on the 0/1 of the encoded message
			current = encoded.charAt(i) == '0' ? current.getLeft() : current.getRight();

			// If a leaf node is reached, append the corresponding character to the result
			if (current.getLeft() == null && current.getRight() == null) {
				decoded.append(current.getKey());
				current = root; // Reset to the root for the next character
			}
		}
		return decoded.toString();
	}

	/**
	 * Main method for testing Huffman encoding and decoding.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your text:");
		String text = scanner.nextLine();
		Frequencies frequencies = new Frequencies(text);
		frequencies.calculateFrequencies(text);

		Huffman huffman = new Huffman();
		huffman.buildTree(frequencies);
		System.out.println("Huffman Codes:");
		for (PrefixPair pair : huffman.codes.getHashTable()) {
			if (pair != null && pair.value != null) {
				System.out.println(pair.key + ": " + pair.value);
			}
		}

		String encoded = huffman.encode(text);
		System.out.println("Encoded Text: " + encoded);
		System.out.println("Decoded Text: " + huffman.decode(encoded));

		scanner.close();
	}
}
