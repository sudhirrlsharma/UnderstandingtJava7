package file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FileHanding {
	public static void main(String[] args) {
		FileHanding file = new FileHanding();
		// file.deleteFile();
		file.iterateThroughFile();

	}

	public void deleteFile() {
		Path target = Paths.get("D:\\patch\\patch_Systest_13_06_1.txt");
		try {
			Files.delete(target);
			Files.deleteIfExists(target);
		} catch (NoSuchFileException e) {
			System.out.println("File not found");
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void copyFile() {
		Path src = Paths.get("D:\\patch\\patch_Systest_13_06.txt");
		Path dst = Paths.get("D:\\patch\\copy\\patch_Systest_13_06.txt");
		try {
			Files.copy(src, dst, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
			Files.move(src, dst, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createDirectory() {
		Path dir = Paths.get("D:\\patch\\NewDirectory");
		try {
			Files.createDirectory(dir);
//			Files.create
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
//		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
//		try {
//			Files.createDirectory(dir, attr);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	

	public void copyLink() {
		Path src = Paths.get("D:\\patch\\patch_Systest_13_06.txt");
		Path dst = Paths.get("D:\\test\\test1");
		try {
			Files.createSymbolicLink(dst, src);
			
//			Files.move(src, dst, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void iterateThroughFile() {
		Path src = Paths.get("D:\\CybageActivity");
		try {
			FileVisitor<Path> fileVisitor =new Filefinder();
			Files.walkFileTree(src,fileVisitor);
			
//			Files.move(src, dst, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class Filefinder extends SimpleFileVisitor<Path>{
		 /** {@inheritDoc} */
	    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) {
	        if (".cvs".equals(dir.getFileName().toString())) {
	            return FileVisitResult.SKIP_SUBTREE;
	        }
	        System.out.println(dir);
	        return FileVisitResult.CONTINUE;
	    }

	    /** {@inheritDoc} */
	    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) {
	        System.out.println(file);
	        return FileVisitResult.CONTINUE;
	    }
	}
}
