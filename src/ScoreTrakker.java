import java.util.*;
import java.io.*;


public class ScoreTrakker {
	private ArrayList<Student> students;
	private static String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			String name = "";
			String line = "";
			try {
				name = in.nextLine();
				line = in.nextLine();
				int score = Integer.parseInt(line);
				students.add(new Student(name, score));
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + name + " not a valid score: " + line + "\n");
			}
		}
	}
	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for (Student currentStudent : students)
			System.out.println(currentStudent);
		System.out.println(" ");
	}
	public void processFiles(String[] files){
		for (String currentFile : files) {
			try {	
				loadDataFromFile(currentFile);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + currentFile);
			}
		}
	}
	public static void main(String[] args) {
		ScoreTrakker scoreTracker = new ScoreTrakker();
		scoreTracker.processFiles(files);
	}
		
}

