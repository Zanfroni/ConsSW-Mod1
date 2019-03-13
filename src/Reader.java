import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reader {

	/**
	 * Recebe o nome do arquivo a ser lido, processa as informações e armazena em
	 * uma estrutura de dados do tipo dicionario
	 * 
	 * @param filename
	 */
	public static void readFile(String filename) {
		Map<String, ArrayList<Integer>> map = new HashMap<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
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
		// Retornar mapa lido 
		
	}
	
	/**
	 * Método privado que alimenta o dicionario
	 * 
	 * @param identificador
	 * @param line
	 */
	private static void feedMap(String identificador, int line) {
		if (map.containsKey(identificador)) {
			map.get(identificador).add(line);
		} else {
			map.put(identificador, new ArrayList<Integer>());
		}
	}
	
}
