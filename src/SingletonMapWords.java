import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingletonMapWords {

	private static SingletonMapWords instance;
	private static Map<String, ArrayList<Integer>> theMap;
	
	/**
	 * Singleton(): Initializing Instance
	 */
	private SingletonMapWords() {
		theMap = new HashMap<>();
	}
	
	/**
	 * Initiates the instance if it hasn't initiated yet, and
	 * returns the instance
	 * @return
	 */
	public static synchronized SingletonMapWords getInstance(){
		if (instance == null)
			instance = new SingletonMapWords();
		return instance;
	}

	/**
	 * Returns an instance of the map of keywords with the list of lines which they
	 * appear
	 * 
	 * @return
	 */
	public Map<String, ArrayList<Integer>> getMap() {
		return theMap;
	}

	/**
	 * Print the data stored inside the map structure
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<String, ArrayList<Integer>> entry : theMap.entrySet()) {
			str.append(entry.getKey() + ": ");
			for (Integer line : entry.getValue()) {
				str.append(line + ",");
			}
			str.append("\n");
		}
		return str.toString();
	}

}