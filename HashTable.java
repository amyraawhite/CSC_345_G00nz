// Author (s): Amyra White 

public class HashTable <K, V> { 
	private int size; 
	private int occupied; 
	public KeyValuePair<K, V>[] hashMap; 
	
	public HashTable() {
		this.size = 11; 
		this.hashMap = new KeyValuePair[size]; 
		occupied = 0; 
	}
	
	public HashTable(int capacity) {
		this.size = capacity; 
		this.hashMap = new KeyValuePair[size]; 
		occupied = 0; 
	}
	
	public void put(K key) {
		int hash = hash(key); 
		
		
		if (hashMap[hash] == null) {
			hashMap[hash] = new KeyValuePair(key, 1); 
			occupied++;
		} else if (hashMap[hash].key == key) {
			hashMap[hash].value += 1; 
			occupied++;
		} else {
			int i = hash;
			while (true) {
				if (hashMap[i] == null) {
					hashMap[i] = new KeyValuePair(key, 1); 
					occupied++; 
					break; 
				}
				i++; 
				if (i == size) {
					i = 0; 
				}
				if (i == hash) {
					break; 
				}
			}
		}
	}
	
	public KeyValuePair<K, V> get(K key) {
		int hash = hash(key); 
		
		if (hashMap[hash].key == key) {
			return hashMap[hash];
		} else {
			int i = hash;
			while (true) {
				if (hashMap[i] != null && hashMap[i].key == key) {
					return  hashMap[i]; 
				}
				i++; 
				if (i == size) {
					i = 0; 
				}
				if (i == hash) {
					return null; 
				}
			}
		}
	}

	public void remove(K key) {
		int hash = hash(key); 
				
		if (hashMap[hash].key == key) {
			hashMap[hash] = null; 
		} else {
			int i = hash;
			while (true) {
				if (hashMap[i] != null && hashMap[i].key == key) {
					hashMap[i] = null; 
					return; 
				}
				i++; 
				if (i == size) {
					i = 0; 
				}
				if (i == hash) {
					return; 
				}
			}
		}
	}
	
	public void resizeUp() {
		int newSize = nextLargestPrime(size + 1); 
		HashTable<K, V> replacement = new HashTable<K, V>(newSize); 
		
		for (int i = size; i <= 0; i--) {
			if (hashMap[i] != null) {
				replacement.putExisting(hashMap[i]);
			}
		}
		
		hashMap = replacement.hashMap; 
	}
	
	public void putExisting(KeyValuePair<K, V> key) {
		int hash = hash(key.key); 
		
		
		if (hashMap[hash] == null) {
			hashMap[hash] = key; 
			occupied++;
		} else {
			int i = hash;
			while (true) {
				if (hashMap[i] == null) {
					hashMap[i] = key; 
					occupied++; 
					break; 
				}
				i++; 
				if (i == size) {
					i = 0; 
				}
				if (i == hash) {
					break; 
				}
			}
		}
	}
	
	public void resizeDown() {
		int newSize = nextSmallestPrime(size - 1); 
		HashTable<K, V> replacement = new HashTable<K, V>(newSize); 
		
		for (int i = size; i <= 0; i--) {
			if (hashMap[i] != null) {
				replacement.putExisting(hashMap[i]);
			}
		}
		
		hashMap = replacement.hashMap; 
	}
	
	public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int nextLargestPrime(int num) {
        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }
    
    public static int nextSmallestPrime(int num) {
        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }
	
	public int hash(K key) {
		return Math.abs(key.hashCode() % size); 
	}
	
	public int get_size() {
		return this.size; 
	}
	
	public KeyValuePair<K, V>[] getHashTable() {
		return this.hashMap; 
	}
	
}
