package ertu.app.recordModify;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String department;
	
	private Date birthday;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date creationTime) {
		this.birthday = creationTime;
	}
	
	@Override
	public String toString() {
		return "Employee{" +
				"name='" + getName() + '\'' +
				", age='" + getAge() + '\'' +
				'}';
	}
}
