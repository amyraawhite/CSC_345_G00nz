// Suhani Surana && Amyra White 


import java.util.Scanner; 

// Class to calculate frequencies of characters in a string
public class Frequencies {
	private String input; 
    private HashTable<Character, Integer> freqTable; // Hash table to store frequencies
    // Constructor to initialize the hash table
    public Frequencies(String input) {
        freqTable = new HashTable<>();
    }
    
    public void calculateFrequencies(String input) {
    	System.out.println(input);
        int i = 0; 
        while (i < input.length()) {
		// Put each character into the hash table
        	freqTable.put(input.charAt(i));
        	i++; 
        }  
        
    }
    
    public KeyValuePair<Character, Integer>[] returnUniques(){
    	KeyValuePair[] uniques = new KeyValuePair[freqTable.getOccupied()]; 
    	int index = 0; 
    	for (KeyValuePair item: freqTable.hashMap) {
    		if (item != null) {
			// Processing unique key-value pairs from the hash table
    			uniques[index] = item; 
    			index++; 
    		}
    	}
         
    	return uniques; 
    }
}
