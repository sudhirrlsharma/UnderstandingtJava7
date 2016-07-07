package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathManagement {

	public void printFile() {
		Path target = Paths.get("D:\\patch\\patch_mainline.txt");
		try {
			String sCurrentLine = null;
			BufferedReader reader = Files.newBufferedReader(target, StandardCharsets.UTF_8);
			while ((sCurrentLine = reader.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void traverseDirectory() {
		Path srcPath = Paths.get("D:");
		Iterator<Path> directories = srcPath.iterator();
		while (directories.hasNext()) {
			Path file = directories.next();
			System.out.println(file.toString());

		}
	}

	public void printFilesFile() {
		Path p = Paths.get("D:\\", "patch", "patch_mainline.txt");
		// print current path
		System.out.println(p);

		// print root directory
		System.out.println(p.getRoot());

		Path target = Paths.get("D:\\");
		Path newPath = target.resolve("patch/");

		// resolve new path
		System.out.println(newPath);

		// copy file

	}

	public static void main(String[] args) {
		PathManagement management = new PathManagement();
//		management.testPathInfo();
//		 management.printFile();
		 management.printFilesFile();
//		management.traverseDirectory();
		management.testDerictoryStream();

	}

	public void testPathInfo() {
		Path target = Paths.get("D:\\patch\\");
		System.out.println(" Number of nodes : " + target.getNameCount());
		System.out.println(" File name: " + target.getFileName());
		System.out.println(" root: " + target.getRoot());
		System.out.println(" Parent: " + target.getParent());

	}

	public void testDerictoryStream() {
		Path target = Paths.get("D:\\patch\\");
		try (DirectoryStream<Path> dir = Files.newDirectoryStream(target, "*.{c,h,cpp,hpp,java,txt}")) {
			for (Path file : dir) {
				System.out.println(file.getFileName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
