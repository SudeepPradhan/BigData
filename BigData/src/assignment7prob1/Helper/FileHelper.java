package assignment7prob1.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
	
	public static String ReadLine(String content, int index)
	{
		return SplitTextFromContent(content, "\n")[index];
	}
	
	public static String[] SplitTextFromContent(String content, String delimiter)
	{
		return content.split(delimiter);
	}
}
