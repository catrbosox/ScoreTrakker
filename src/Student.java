
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	

	@Override
	public String toString() {
		return name + " " + score;
	}



	@Override
	public int compareTo(Student other) {
		if (this.score < other.score)
			return -1;
		else if (this.score > other.score)
			return 1;
		else {
			//If scores are equal, compare names
			int result = this.name.compareTo(other.name);
			return result;
		}
			
			
	}

}
