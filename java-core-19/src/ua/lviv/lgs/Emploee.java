package ua.lviv.lgs;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Emploee implements Serializable{
	private String name;
	private int id;
	transient private int salary;
	
	public Emploee(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emploee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
}
