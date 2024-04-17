// Suhani Surana && Amyra White 


import java.util.Scanner; 

public class Frequencies {
	private String input; 
    private HashTable<Character, Integer> freqTable;

    public Frequencies(String input) {
        freqTable = new HashTable<>();
    }

    public void calculateFrequencies(String input) {
    	System.out.println(input);
        int i = 0; 
        while (i < input.length()) {
        	freqTable.put(input.charAt(i));
        	i++; 
        }  
        
    }
    
    public KeyValuePair<Character, Integer>[] returnUniques(){
    	KeyValuePair[] uniques = new KeyValuePair[freqTable.getOccupied()];  
    	int index = 0; 
    	for (KeyValuePair item: freqTable.hashMap) {
    		if (item != null) {
    			uniques[index] = item; 
    			index++; 
    		}
    	}
         
    	return uniques; 
    }
}
