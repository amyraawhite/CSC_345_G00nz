public class PrefixPair {
	public char key; 
	public String value;
	
	public PrefixPair(char k, String v) {
		// initialize variables via parameters 
		this.key = k; 
		this.value = v; 
	}
	
	public char getKey() {
		// return current character key 
		return this.key; 
	}
	
	public String getValue() {
		// return current value 
		return this.value; 
	}
	
	public String toString() {
		// return string presentation of key value pair 
		return key + ": " + value; 
	}
}
