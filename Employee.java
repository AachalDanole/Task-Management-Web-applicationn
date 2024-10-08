package TaskManagement_Service;
import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Employee")
@DynamicUpdate

public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employee_id;
	
	@Column(name="employee_name",nullable = false)
	String employee_name;
	
	@Column(name="employee_mail",nullable = false)
	String employee_mail;
	
	@Column(name="password",nullable = false)
	String password;
	
	@Column(name="employee_name",nullable = false)
	String task;
	
	@Column(name="dueDate",nullable = false)
	Date dueDate;
	
	
	
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_mail() {
		return employee_mail;
	}
	public void setEmployee_mail(String employee_mail) {
		this.employee_mail = employee_mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_mail="
				+ employee_mail + ", password=" + password + ", task=" + task + ", dueDate=" + dueDate + "]";
	}
	
}
