import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reader {
	
	private Map<String, ArrayList<Integer>> mapIdentifiers;
	
	public Reader() {
		mapIdentifiers = SingletonMapWords.getInstance().getMap();
	}

	/**
	 * Recebe o nome do arquivo a ser lido, processa as informações e armazena em
	 * uma estrutura de dados do tipo dicionario
	 * 
	 * @param file
	 */
	public void readFile(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String sCurrentLine;
			int line = 0;
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
	 * Método privado que alimenta o dicionario
	 * 
	 * @param identificador
	 * @param line
	 */
	private void feedMap(String identifier, int line) {
		if (mapIdentifiers.containsKey(identifier)) {
			mapIdentifiers.get(identifier).add(line);
		} else {
			mapIdentifiers.put(identifier, new ArrayList<Integer>());
		}
	}
	
}
