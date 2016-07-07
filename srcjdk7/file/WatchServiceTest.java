package file;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class WatchServiceTest {
	public static void main(String[] args) {
		Path target = Paths.get("D:\\patch");
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			target.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			while (true) {
				WatchKey watckKey = watcher.take();
				List<WatchEvent<?>> events = watckKey.pollEvents();
				for (WatchEvent event : events) {
					if (event.kind() == ENTRY_CREATE) {
						System.out.println("Created: " + event.context().toString());
					}
					if (event.kind() == ENTRY_DELETE) {
						System.out.println("Delete: " + event.context().toString());
					}
					if (event.kind() == ENTRY_MODIFY) {
						System.out.println("Modify: " + event.context().toString());
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
