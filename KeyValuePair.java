public class KeyValuePair <K, V> {
	public K key; 
	public V value;
	
	public KeyValuePair(K k, V v) {
		this.key = k; 
		this.value = v; 
	}
	
	public K getKey() {
		return this.key; 
	}
	
	public V getValue() {
		return this.value; 
	}
}
