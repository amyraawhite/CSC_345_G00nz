// Suhani Surana
public class Frequencies<T> {
    private HashTable<T, Integer> frequencyTable;

    public Frequencies() {
        frequencyTable = new HashTable<>();
    }

    public void calculateFrequencies(T[] items) {
        for (T item : items) {
            KeyValuePair<T, Integer> keyValue = frequencyTable.get(item);
            if (keyValue != null) {
                frequencyTable.put(item, keyValue.getValue() + 1); // Update existing key's value
            } else {
                frequencyTable.put(item, 1); // Initialize new key with frequency 1
            }
        }
    }

    public void displayFrequencies() {
        for (KeyValuePair<T, Integer> entry : frequencyTable.getHashTable()) {
            if (entry != null) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    #public static void main(String[] args) {
        #Frequencies<Character> frequencies = new Frequencies<>();
        #Character[] items = {'a', 'b', 'a', 'c', 'b', 'a'};
        #frequencies.calculateFrequencies(items);
        #frequencies.displayFrequencies();
    }
}
