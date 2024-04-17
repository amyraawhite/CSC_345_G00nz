public class KeyValuePair <K, V> {
	public K key; 
	public int value;
	
	public KeyValuePair(K k, int v) {
		// initialize key and value 
		this.key = k; 
		this.value = v; 
	}
	
	public K getKey() {
		// return the current key value 
		return this.key; 
	}
	
	public int getValue() {
		// return the value associated with the given key 
		return this.value; 
	}
	
	public String toString() {
		// return a string representation of the key-value pair 
		return key + ": " + value; 
	}
}
