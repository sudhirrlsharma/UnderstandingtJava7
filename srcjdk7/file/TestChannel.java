package file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
	public static void main(String[] args) {
		TestChannel channel = new TestChannel();
		channel.rendomAccessReadChannel();
	}

	private void rendomAccessReadChannel() {
		int bufferSize = 8;
		Path path = Paths.get("/home/docs/users.txt");
		try (SeekableByteChannel sbc = Files.newByteChannel(path)) {
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			sbc.position(4);
			sbc.read(buffer);
			for (int i = 0; i < 5; i++) {
				System.out.print((char) buffer.get(i));
			}
			System.out.println();
			buffer.clear();
			sbc.position(0);
			sbc.read(buffer);
			for (int i = 0; i < 4; i++) {
				System.out.print((char) buffer.get(i));
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void rendomAccessWriteChannel() {
		final String newLine = System.getProperty("line.separator");
		
		Path path = Paths.get("/home/docs/users.txt");
		try (SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE)) {
			ByteBuffer buffer;
			long position = sbc.size();
			sbc.position(position);
			System.out.println("Position: " + sbc.position());
			buffer = ByteBuffer.wrap((newLine + "Paul").getBytes());
			sbc.write(buffer);
			System.out.println("Position: " + sbc.position());
			buffer = ByteBuffer.wrap((newLine + "Carol").getBytes());
			sbc.write(buffer);
			System.out.println("Position: " + sbc.position());
			buffer = ByteBuffer.wrap((newLine + "Fred").getBytes());
			sbc.write(buffer);
			System.out.println("Position: " + sbc.position());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
