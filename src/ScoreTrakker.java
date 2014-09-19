import java.util.*;
import java.io.*;


public class ScoreTrakker {
	private ArrayList<Student> students;
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String scores = in.nextLine();
			int score = Integer.parseInt(scores);
			students.add(new Student(line, score));
			}
		in.close();
		}
	public void printInOrder() {
		Collections.sort(students);
		for (Student currentStudent : students)
			System.out.println(currentStudent);
	}
	public void processFiles(String file) throws FileNotFoundException {
		loadDataFromFile(file);
		printInOrder();
	}
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker scoreTracker = new ScoreTrakker();
		scoreTracker.processFiles("scores.txt");
	}
		
}

