import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class Writer {
	
	private final String encodingFormat = "UTF-8";
	private PrintWriter writer;

	public Writer() {
	}

	public void writeData(File file) {
		Map<String, ArrayList<Integer>> mapWords = SingletonMapWords.getInstance().getMap();
		try {
			writer = new PrintWriter(file, encodingFormat);
			for (Map.Entry<String, ArrayList<Integer>> entry : mapWords.entrySet()) {
				writer.print(entry.getKey() + ";");
				for (Integer line : entry.getValue()) {
					writer.print(line + ",");
				}
				writer.println();
			}
			writer.flush();
		} catch (FileNotFoundException exception) {
			System.out.println("The file " + file.getPath() + " was not found.");
		} catch (IOException ex) {
			System.out.println(ex);
		} 
	}

}

