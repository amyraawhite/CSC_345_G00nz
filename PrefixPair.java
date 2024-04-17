public class PrefixPair {
	public char key; 
	public String value;
	
	public PrefixPair(char k, String v) {
		this.key = k; 
		this.value = v; 
	}
	
	public char getKey() {
		return this.key; 
	}
	
	public String getValue() {
		return this.value; 
	}
	
	public String toString() {
		return key + ": " + value; 
	}
}
