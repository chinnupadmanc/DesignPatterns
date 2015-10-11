public class Student {
	
	private String name;
	private int redId;
	private float gpa;

	public Student(String name, int redId, float gpa)
	{
		this.name = name;
		this.redId = redId;
		this.gpa = gpa;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getRedId() 
	{
		return redId;
	}

	public void setRedId(int redId) 
	{
		this.redId = redId;
	}

	public float getGpa() 
	{
		return gpa;
	}

	public void setGpa(float gpa) 
	{
		this.gpa = gpa;
	}

	// Overriding toStrin() method of Student class
	public String toString() {
		String studentData = name + "," + redId + "," + gpa;
		return studentData;		
	}

} // End of Student class