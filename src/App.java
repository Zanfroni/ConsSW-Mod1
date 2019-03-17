import java.io.File;

/**
 * Aplicacao referente ao exercicio da disciplina de Construcao de Software
 * @authors Gabriel Franzoni, Gabriel Paul, Israel Deorce, Luiza Pereira, Gabriel Kurtz
 *
 */
public class App {
	public static void main(String[] args) {
		File file = new File("yamagod.txt");
		Reader reader = new Reader();
		Writer writer = new Writer();
		reader.readFile(file);
		System.out.println(SingletonMapWords.getInstance().toString());
		//writer.writeData();
	}
}
