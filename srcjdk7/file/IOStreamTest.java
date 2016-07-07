package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class IOStreamTest {
	public void readFromFileAsByte(String filePath) {
		Path path = Paths.get(filePath);
		byte[] contents = null;
		try {
			contents = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (byte b : contents) {
			System.out.print((char) b);
		}

	}

	public void writeFromFileAsByte(String filePath) {
		Path path = Paths.get(filePath);
		byte[] contents = "Some thine text".getBytes();
		try {
			Files.write(path, contents, StandardOpenOption.CREATE);
			byte[] newContents = "More content".getBytes();
			Files.write(path, newContents, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (byte b : contents) {
			System.out.print((char) b);
		}

	}

	public void readFileAsListOfString(String filePath) {

		Path path = Paths.get(filePath);
		List<String> contents = null;
		try {
			contents = Files.readAllLines(path, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String s : contents) {
			System.out.print(s);
		}

	}

	public void readFileAsBufferReader(String filePath) {
		Path path = Paths.get(filePath);
		Charset charset = Charset.forName("ISO-8859-1");
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeFileAsBufferWriter(String filePath) {
		String newName = "Vivian";
		Path file = Paths.get("/home/docs/users.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.defaultCharset(), StandardOpenOption.APPEND)) {
			writer.newLine();
			writer.write(newName, 0, newName.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
