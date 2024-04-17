//Gar

import java.util.Scanner;

public class Huffman {
    private TreeNode root;
    private PrefixMap codes;

    public Huffman() {
        this.root = null;
        this.codes = new PrefixMap();
    }

    public void buildTree(Frequencies frequencies) {
        minHeap heap = new minHeap(frequencies.returnUniques().length);
        KeyValuePair<Character, Integer>[] freqPairs = frequencies.returnUniques();

        for (KeyValuePair<Character, Integer> pair : freqPairs) {
            if (pair != null) {
                TreeNode newNode = new TreeNode(pair.value, pair.key);
                heap.insert(newNode);
            }
        }

        while (heap.getSize() > 1) {
            TreeNode left = heap.removeMin();
            TreeNode right = heap.removeMin();

            TreeNode merged = new TreeNode(left.getFrequency() + right.getFrequency(), '\0');
            merged.setLeft(left);
            merged.setRight(right);

            heap.insert(merged);
        }

        root = heap.getMin();
        buildCodes(root, "");
    }

    private void buildCodes(TreeNode node, String code) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                codes.put(node.getKey(), code);
            } else {
                buildCodes(node.getLeft(), code + "0");
                buildCodes(node.getRight(), code + "1");
            }
        }
    }

    public String encode(String input) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            PrefixPair pair = codes.get(c);
            if (pair != null) {
                encoded.append(pair.value);
            }
        }
        return encoded.toString();
    }

    public String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        TreeNode current = root;
        for (int i = 0; i < encoded.length(); i++) {
            current = encoded.charAt(i) == '0' ? current.getLeft() : current.getRight();
            if (current.getLeft() == null && current.getRight() == null) { // Leaf node
                decoded.append(current.getKey());
                current = root; // Reset to start for next character
            }
        }
        return decoded.toString();
    }

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
