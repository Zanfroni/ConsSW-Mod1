package app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * This app is an exercise for the subject of Software Construction from PUCRS
 * 
 * @authors Gabriel Franzoni, Gabriel Paul, Israel Deorce, Luiza Pereira,
 *          Gabriel Kurtz
 *
 */
public class Reader {
	
	private Map<String, ArrayList<Integer>> mapIdentifiers;
	
	public Reader() {
		mapIdentifiers = SingletonMapWords.getInstance().getMap();
	}

	/**
	 * Receives a File, reads its content and saves it into a map structure
	 * 
	 * @param file
	 */
	public void readFile(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String sCurrentLine;
			int line = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] split = sCurrentLine.split(" ");
				for (int i = 0; i < split.length; i++) {
					feedMap(split[i], line);
				}
				line++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Filter the identifers and feeds the map
	 * 
	 * @param identificador
	 * @param line
	 */
	private void feedMap(String identifier, int line) {
		if(identifier.contains(".")) {
			identifier = identifier.substring(0, identifier.indexOf("."));
		}
		identifier = identifier.replaceAll("[^a-zA-Z0-9_]", "");
		if(identifier.isEmpty()) {
			return;
		}
		System.out.println(identifier);
		if (mapIdentifiers.containsKey(identifier)) {
			mapIdentifiers.get(identifier).add(line);
		} else {
			mapIdentifiers.put(identifier, new ArrayList<Integer>());
			mapIdentifiers.get(identifier).add(line);			
		}
	}
	
}
