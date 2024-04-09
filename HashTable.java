// Author (s): Amyra White 

public class HashTable <K, V> { 
	private int size; 
	public KeyValuePair<K, V>[] hashMap; 
	
	public HashTable() {
		this.size = 11; 
		this.hashMap = new KeyValuePair[size]; 
	}
	
	public HashTable(int capacity) {
		this.size = capacity; 
		this.hashMap = new KeyValuePair[size]; 
	}
	
	public void put(K key) {
		int hash = hash(key); 
		
		if (hashMap[hash] == null) {
			hashMap[hash] = new KeyValuePair(key, 1); 
		} else if (hashMap[hash].key == key) {
			hashMap[hash].value += 1; 
		} else {
			
		}
	}
	
	public KeyValuePair<K, V> get(K key) {
		int hash = hash(key); 
		return hashMap[hash]; 
	}

	public void remove(K key) {
		int hash = hash(key); 
	}
	
	public int hash(K key) {
		return key.hashCode() % size; 
	}
	
	public int get_size() {
		return this.size; 
	}
	
	public KeyValuePair<K, V>[] getHashTable() {
		return this.hashMap; 
	}
}
