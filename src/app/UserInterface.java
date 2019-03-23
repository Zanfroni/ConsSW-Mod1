package app;
import java.io.File;
import java.util.Scanner;

/**
 * This app is an exercise for the subject of Software Construction from PUCRS
 * 
 * @authors Gabriel Franzoni, Gabriel Paul, Israel Deorce, Luiza Pereira,
 *          Gabriel Kurtz
 *
 */
public class UserInterface {
	private Scanner in;

	public UserInterface() {
		in = new Scanner(System.in);
	}
	
	/**
	 * Starts and tries to find the input file
	 */
	public void start() {
		File fileIn = getFile();
		Reader reader = new Reader();
		reader.readFile(fileIn);
		
		File fileOut = makeFile(fileIn.getName());
		Writer writer = new Writer();
		if(writer.writeData(fileOut)) {
			System.out.println("Análise realizada. Arquivo " + fileOut.getName() + " gerado.");			
		}
	}

	/**
	 * Checks if input file exists in directory
	 * @return
	 */
	private File getFile() {
		System.out.println("Por favor, digite o nome do arquivo-texto de entrada: ");
		boolean filenameIsValid = false;
		File file;
		do {
			file = new File(in.nextLine());
			if (file.exists()) {
				filenameIsValid = true;
			} else {
				System.out.println("ERRO: arquivo inexistente.");
			}
		} while (!filenameIsValid);
		return file;
	}
	
	/**
	 * Creates the new output file
	 * @param filename
	 * @return
	 */
	private File makeFile(String filename) {
		String newFilename = filename.replace(".txt", "-xref.txt");
		return new File(newFilename);		
	}
}

