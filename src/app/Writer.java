package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This app is an exercise for the subject of Software Construction from PUCRS
 * 
 * @authors Gabriel Franzoni, Gabriel Paul, Israel Deorce, Luiza Pereira,
 *          Gabriel Kurtz
 *
 */
public class Writer {

	private final String encodingFormat = "UTF-8";
	private final String errorMessage = "ERRO: geração do arquivo de saída.";
	private PrintWriter writer;

	public Writer() {
	}

	/**
	 * Writes the data from the map structure to a given file
	 * 
	 * @param file
	 * @return
	 */
	public boolean writeData(File file) {
		try {
			writer = new PrintWriter(file, encodingFormat);
			writer.print(SingletonMapWords.getInstance().toString());
			writer.flush();
		} catch (FileNotFoundException exception) {
			System.out.println(errorMessage);
			return false;
		} catch (IOException ex) {
			System.out.println(errorMessage);
			return false;
		}
		return true;
	}
}
