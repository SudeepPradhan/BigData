package assignment5prob4next;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {
	public static String[] SplitTextFromFile(Path filePath, String delimiter) throws IOException
	{
		String content = new String(Files.readAllBytes(filePath));
		return content.split(delimiter);
	}
}
