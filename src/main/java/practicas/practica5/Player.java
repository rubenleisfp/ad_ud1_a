package practicas.practica5;

public class Player {
	private int year;
	private String name;
	private String team;
	private double salary;
	
	public Player(int year, String name, String team, double salary) {
		super();
		this.year = year;
		this.name = name;
		this.team = team;
		this.salary = salary;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Player [year=" + year + ", name=" + name + ", team=" + team + ", salary=" + salary + "]";
	}

};