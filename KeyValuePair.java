public class KeyValuePair <K, V> {
	public K key; 
	public int value;
	
	public KeyValuePair(K k, int v) {
		this.key = k; 
		this.value = v; 
	}
	
	public K getKey() {
		return this.key; 
	}
	
	public int getValue() {
		return this.value; 
	}
	
	public String toString() {
		return key + ": " + value; 
	}
}
