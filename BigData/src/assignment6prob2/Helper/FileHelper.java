package assignment6prob2.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
	public static String[] SplitTextFromFile(Path filePath, String delimiter) throws IOException
	{
		String content = new String(Files.readAllBytes(filePath));
		return SplitTextFromContent(content, delimiter);
	}
	
	public static String[] SplitTextByLineBreak(Path filePath) throws IOException
	{
		String content = new String(Files.readAllBytes(filePath));
		return SplitTextFromContent(content, "\n");
	}
	
	public static String[] SplitTextFromContent(String content, String delimiter)
	{
		return content.split(delimiter);
	}
	
	public static Path GetFilePath(String sourceDir, String fileName)
	{
		return Paths.get(sourceDir, fileName);
	}
}
