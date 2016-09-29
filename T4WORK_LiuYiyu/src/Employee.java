
public class Employee {
	private String id;
	private String name;
	private String position;
	private int holidays;
	private double salary;  
	public double sumSalary(){
		return salary - holidays*salary/30.0; 
	}
	public Employee(String id, String name, String position, int holidays, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.holidays = holidays;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getHolidays() {
		return holidays;
	}
	public void setHolidays(int holidays) {
		this.holidays = holidays;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", holidays=" + holidays
				+ ", salary=" + sumSalary() + "]";
	}
	
}
