import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reader {

	/**
	 * Recebe o nome do arquivo a ser lido, e chama o Processor
	 * Enviando linha por linha com o numero da linha tambem
	 * 
	 * @param filename
	 */
	public static void readFile(String filename) {
		//Map<String, ArrayList<Integer>> map = new HashMap<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String sCurrentLine;
			int line = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				Processor.process(sCurrentLine, line+1);
			}
				line++;
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Inexistente");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro generico de I/O");
			e.printStackTrace();
		}
	}
}

