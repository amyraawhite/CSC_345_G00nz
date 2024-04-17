// Author (s): Amyra White 

public class PrefixMap {
	private int size;
	private int occupied;
	private PrefixPair[] PrefixMap;

	public PrefixMap() {
		// initialize PrefixMap without any parameters passed 
		this.size = 11;
		this.PrefixMap = new PrefixPair[size];
		occupied = 0;
	}

	public PrefixMap(int capacity) {
		// initialize PrefixMap with parameters passed 
		this.size = capacity;
		this.PrefixMap = new PrefixPair[size];
		occupied = 0;
	}

	public void put(char key, String prefixCode) {
		// resize Prefix Map if load factor is too high 
		if (occupied / size > 1 / 2) {
			resizeUp();
		}
		// get hash value of the key 
		int hash = hash(key);

		// Prefix map at hash if null; place key-value pair 
		if (PrefixMap[hash] == null) {
			PrefixMap[hash] = new PrefixPair(key, prefixCode);
			occupied++;
		} else {
			// find place for new key-value pair 
			int i = hash;
			while (true) {
				// found a null place in the array 
				if (PrefixMap[i] == null) {
					PrefixMap[i] = new PrefixPair(key, prefixCode);
					occupied++;
					break;
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}

				// break loop; no sport was found 
				if (i == hash) {
					break;
				}
			}
		}
	}

	public PrefixPair get(char key) {
		// get hash value 
		int hash = hash(key);

		// Prefix map at hash was null; place key-value pair 
		if (PrefixMap[hash].key == key) {
			return PrefixMap[hash];
		} else {
			// find the next key via iteration through table using linear probing 
			int i = hash;
			while (true) {
				// pair is found return the pair 
				if (PrefixMap[i] != null && PrefixMap[i].key == key) {
					return PrefixMap[i];
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}

				// exit array, pair was not found 
				if (i == hash) {
					return null;
				}
			}
		}
	}

	public void remove(char key) {
		// load facot ris too low; resize array down 
		if (occupied / size < 1 / 8) {
			resizeDown();
		}
		// get hash value 
		int hash = hash(key);

		// map at hash was empty; remove pair 
		if (PrefixMap[hash].key == key) {
			PrefixMap[hash] = null;
			occupied--;
		} else {
			int i = hash;
			while (true) {
				// remove the found key 
				if (PrefixMap[i] != null && PrefixMap[i].key == key) {
					PrefixMap[i] = null;
					occupied--;
					return;
				}
				i++;
				// wrap around 
				if (i == size) {
					i = 0;
				}

				// exit array, item not found 
				if (i == hash) {
					return;
				}
			}
		}
	}

	public void resizeUp() {
		// find new size; next largest prime value 
		int newSize = nextLargestPrime(size + 1);

		// create new instance of a prefix map 
		PrefixMap replacement = new PrefixMap(newSize);

		// rehash all values and add to new instance 
		for (int i = size - 1; i >= 0; i--) {
			if (PrefixMap[i] != null) {
				replacement.putExisting(PrefixMap[i]);
			}
		}

		// update size and prefix map 
		this.size = newSize; 
		PrefixMap = replacement.PrefixMap; 
	}

	public void putExisting(PrefixPair key) {
		// get hash value of key 
		int hash = hash(key.key);

		// place if hash index is null 
		if (PrefixMap[hash] == null) {
			PrefixMap[hash] = key;
		} else {
			// find next place to insert 
			int i = hash;
			while (true) {
				//Place item in the prefix map at the next null 
				if (PrefixMap[i] == null) {
					PrefixMap[i] = key;
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
		// get next smallest prime number 
		int newSize = nextSmallestPrime(size - 1);

		// create new instance of prefix map 
		PrefixMap replacement = new PrefixMap(newSize);

		// put existing keys into the array 
		for (int i = size; i <= 0; i--) {
			if (PrefixMap[i] != null) {
				replacement.putExisting(PrefixMap[i]);
			}
		}

		PrefixMap = replacement.PrefixMap;
	}

	public static boolean isPrime(int num) {
		// if number is 1 or 0 return false 
		if (num <= 1) {
			return false;
		}

		// if number is divisible by any number less than or equal to its sqrt return false 
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int nextLargestPrime(int num) {
		// find next prime number via iteration 
		while (true) {
			if (isPrime(num)) {
				return num;
			}
			num++;
		}
	}

	public static int nextSmallestPrime(int num) {
		// find next smallest prime number via iteration
		while (true) {
			if (isPrime(num)) {
				return num;
			}
			num++;
		}
	}

	public int hash(char key) {
		// get hash value of character 
		Character c = Character.valueOf(key); 
		return Math.abs(c.hashCode() % size);
	}

	public int get_size() {
		// return the current size of map 
		return this.size;
	}
	
	public int getOccupied() {
		// return current num of elements in the map 
		return this.occupied; 
	}

	public PrefixPair[] getHashTable() {
		// return current map 
		return this.PrefixMap;
	}

}
