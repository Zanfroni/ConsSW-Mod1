import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Aplicacao referente ao exercicio da disciplina de Construcao de Software
 * @authors Gabriel Franzoni, Gabriel Paul, Israel Deorce, Luiza Pereira, Gabriel Kurtz
 *
 */
public class App {

	private static Scanner in = new Scanner(System.in);
	

	// TODO: Importar chamadas dos modulos correspondentes
	public static void main(String[] args) {
		String filename = printTelaInicial();
		readFile(filename);
		writeFile(filename);
	}

	/**
	 * Pede ao usuário para informar o nome do arquivo a ser lido
	 * 
	 * @return
	 */
	public static String printTelaInicial() {
		System.out.println("Por favor, digite o nome do arquivo-texto de entrada: ");
		String filename = in.nextLine();
		if (!(new File(filename).exists())) {
			System.out.println("Arquivo inexistente");
			System.exit(1);
		}
		return filename;
	}


	/**
	 * Escreve em um arquivo, de acordo com o dicionario
	 * FALTA TERMINAR (INCOMPLETO)
	 * @param filename
	 */
	public static void writeFile(String filename) {
		String newFilename = filename + "-xref.txt";
		FileWriter fw;
		PrintWriter pw;
		try {
			fw = new FileWriter(newFilename);
			pw = new PrintWriter(fw);
			pw.println("+Resultado+");
			for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
				pw.print(entry.getKey() + ";");
				for (Integer line : entry.getValue()) {
					pw.print(line + ",");
				}
				pw.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
