// Author (s): Amyra White 

public class PrefixMap {
	private int size;
	private int occupied;
	private PrefixPair[] PrefixMap;

	public PrefixMap() {
		this.size = 11;
		this.PrefixMap = new PrefixPair[size];
		occupied = 0;
	}

	public PrefixMap(int capacity) {
		this.size = capacity;
		this.PrefixMap = new PrefixPair[size];
		occupied = 0;
	}

	public void put(char key, String prefixCode) {
		if (occupied / size > 1 / 2) {
			resizeUp();
		}
		int hash = hash(key);

		if (PrefixMap[hash] == null) {
			PrefixMap[hash] = new PrefixPair(key, prefixCode);
			occupied++;
		} else {
			int i = hash;
			while (true) {
				if (PrefixMap[i] == null) {
					PrefixMap[i] = new PrefixPair(key, prefixCode);
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

	public PrefixPair get(char key) {
		int hash = hash(key);

		if (PrefixMap[hash].key == key) {
			return PrefixMap[hash];
		} else {
			int i = hash;
			while (true) {
				if (PrefixMap[i] != null && PrefixMap[i].key == key) {
					return PrefixMap[i];
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

	public void remove(char key) {
		if (occupied / size < 1 / 8) {
			resizeDown();
		}
		int hash = hash(key);

		if (PrefixMap[hash].key == key) {
			PrefixMap[hash] = null;
			occupied--;
		} else {
			int i = hash;
			while (true) {
				if (PrefixMap[i] != null && PrefixMap[i].key == key) {
					PrefixMap[i] = null;
					occupied--;
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
		PrefixMap replacement = new PrefixMap(newSize);

		for (int i = size - 1; i >= 0; i--) {
			if (PrefixMap[i] != null) {
				replacement.putExisting(PrefixMap[i]);
			}
		}
		
		this.size = newSize; 
		PrefixMap = replacement.PrefixMap; 
	}

	public void putExisting(PrefixPair key) {
		int hash = hash(key.key);

		if (PrefixMap[hash] == null) {
			PrefixMap[hash] = key;
		} else {
			int i = hash;
			while (true) {
				if (PrefixMap[i] == null) {
					PrefixMap[i] = key;
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
		PrefixMap replacement = new PrefixMap(newSize);

		for (int i = size; i <= 0; i--) {
			if (PrefixMap[i] != null) {
				replacement.putExisting(PrefixMap[i]);
			}
		}

		PrefixMap = replacement.PrefixMap;
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

	public int hash(char key) {
		Character c = Character.valueOf(key); 
		return Math.abs(c.hashCode() % size);
	}

	public int get_size() {
		return this.size;
	}
	
	public int getOccupied() {
		return this.occupied; 
	}

	public PrefixPair[] getHashTable() {
		return this.PrefixMap;
	}

}
