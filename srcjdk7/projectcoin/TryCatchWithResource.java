package projectcoin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TryCatchWithResource {

	public static void main(String[] args) {
		TryCatchWithResource resource = new TryCatchWithResource();
		resource.copyFileOldJava();
	}

	public void copyFile() {
		String aFileName = "D:\\patch\\patch_mainline.txt";
		String aNewFile = "D:\\patch\\patch_Copy.txt";
		String sCurrentLine = null;

		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(aFileName)));
				BufferedWriter outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aNewFile)))) {
			while ((sCurrentLine = in.readLine()) != null) {
				System.out.println(sCurrentLine);
				outFile.write(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFileOldJava() {
		String aFileName = "D:\\patch\\patch_mainline.txt";
		String aNewFile = "D:\\patch\\patch_Copy.txt";
		String sCurrentLine = null;
		BufferedReader in = null;
		BufferedWriter outFile = null;

		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(aFileName)));
			outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aNewFile)));
			while ((sCurrentLine = in.readLine()) != null) {
				System.out.println(sCurrentLine);
				outFile.write(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				outFile.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

	}
}
