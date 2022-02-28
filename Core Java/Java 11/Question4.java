package in.lpu.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Question4 {

	public static void main(String[] args) {
		var path = "D:\\Digdata\\Java11Assignments_StudentList.txt";
		try {
			String data = Files.readString(Path.of(path));
			List<String> sl = data.lines().collect(Collectors.toList());
			int count = 0;
			for (String string : sl) {
				if (string.isBlank()) {
					continue;
				}
				System.out.println(string);
				count++;
			}
			System.out.println("\nTotal Number of students are : " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
