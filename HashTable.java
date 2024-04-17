// Author (s): Amyra White 

public class HashTable<K, V> {
	private int size;
	private int occupied;
	public KeyValuePair<K, V>[] hashMap;

	public HashTable() {
		// initialize variables for a new HT w/o parameters 
		this.size = 11;
		this.hashMap = new KeyValuePair[size];
		occupied = 0;
	}

	public HashTable(int capacity) {
		// initialize variables for a new HT w/ size parameter 
		this.size = capacity;
		this.hashMap = new KeyValuePair[size];
		occupied = 0;
	}

	public void put(K key) {
		// condition that resizes HashTable is load factor gets too high 
		if (occupied / size > 1 / 2) {
			resizeUp();
		}
		// hash key value 
		int hash = hash(key);

		// case for a null placement in the HT 
		if (hashMap[hash] == null) {
			hashMap[hash] = new KeyValuePair(key, 1);
			occupied++;

		// case for the same key; add to the value of the key 
		} else if (hashMap[hash].key == key) {
			hashMap[hash].value += 1;
		} else {
			// initialize start for linear probe 
			int i = hash;
			while (true) {
				// place if found 
				if (hashMap[i] == null) {
					hashMap[i] = new KeyValuePair(key, 1);
					occupied++;
					break;
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}
				// exit loop 
				if (i == hash) {
					break;
				}
			}
		}
	}

	public KeyValuePair<K, V> get(K key) {
		// hash key value 
		int hash = hash(key);

		// get is at hash value 
		if (hashMap[hash].key == key) {
			return hashMap[hash];
		} else {
			// get the starting point for linear probing 
			int i = hash;
			while (true) {
				// if key is found return that key 
				if (hashMap[i] != null && hashMap[i].key == key) {
					return hashMap[i];
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}

				// exit loop and return null because key was not found 
				if (i == hash) {
					return null;
				}
			}
		}
	}

	public void remove(K key) {
		// resize the HT down if load factor is too small 
		if (occupied / size < 1 / 8) {
			resizeDown();
		}

		// get hash value 
		int hash = hash(key);

		// key is at hashh value 
		if (hashMap[hash].key == key) {
			hashMap[hash] = null;
			occupied--;
		} else {
			// getting starting point for linear probe 
			int i = hash;
			while (true) {
				// key is found and removed, return 
				if (hashMap[i] != null && hashMap[i].key == key) {
					hashMap[i] = null;
					occupied--;
					return;
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}

				// key is not found 
				if (i == hash) {
					return;
				}
			}
		}
	}

	public void resizeUp() {
		// get the next largest prime number 
		int newSize = nextLargestPrime(size + 1);

		// create a new instance of the hash table 
		HashTable<K, V> replacement = new HashTable<K, V>(newSize);


		// add keys to copy HT 
		for (int i = size - 1; i >= 0; i--) {
			if (hashMap[i] != null) {
				// put existing key-value pair into new hashTable 
				replacement.putExisting(hashMap[i]);
			}
		}

		// update size and Hash Table 
		this.size = newSize; 
		hashMap = replacement.hashMap; 
	}

	public void putExisting(KeyValuePair<K, V> key) {
		// get hash value 
		int hash = hash(key.key);

		// hash points to a null, insert key 
		if (hashMap[hash] == null) {
			hashMap[hash] = key;
		} else {
			// get starting point for linear probing 
			int i = hash;
			while (true) {
				// place key in next available index 
				if (hashMap[i] == null) {
					hashMap[i] = key;
					break;
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}

				// exit loop
				if (i == hash) {
					break;
				}
			}
		}
	}

	public void resizeDown() {
		// Find the next smallest prime for size reduction 
		int newSize = nextSmallestPrime(size - 1);

		// create new instance of HT 
		HashTable<K, V> replacement = new HashTable<K, V>(newSize);

		// place all key-value pairs into new ht instance 
		for (int i = size; i <= 0; i--) {
			if (hashMap[i] != null) {
				replacement.putExisting(hashMap[i]);
			}
		}

		// replace old hashmap with new one 
		hashMap = replacement.hashMap;
	}

	public static boolean isPrime(int num) {
		// if number it 1 or lower, is not prime 
		if (num <= 1) {
			return false;
		}

		// if number is divisible by any numbers smaller than its sqrt; return false 
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		// number is prime 
		return true;
	}

	public static int nextLargestPrime(int num) {
		// loop gets next largest prime 
		while (true) {
			if (isPrime(num)) {
				return num;
			}
			num++;
		}
	}

	public static int nextSmallestPrime(int num) {
		// loop gets next smallest prime 
		while (true) {
			if (isPrime(num)) {
				return num;
			}
			num++;
		}
	}

	public int hash(K key) {
		// gets the abs value of the hashcode function from java; hashcode does not always return positive nums 
		return Math.abs(key.hashCode() % size);
	}

	public int get_size() {
		// return the current size of the hash table 
		return this.size;
	}
	
	public int getOccupied() {
		// get the current number of occupied spaces in the hash table 
		return this.occupied; 
	}

	public KeyValuePair<K, V>[] getHashTable() {
		// return the current hash table
		return this.hashMap;
	}

}
