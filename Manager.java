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
@Table(name = "Manager")
@DynamicUpdate

public class Manager {

	@Column(name="manager_name",nullable = false)

	private String  manager_name;
	
	@Column(name="manager_mail",nullable = false)

	private String manager_mail;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="password",nullable = false)

	private String password;
	
	@Column(name="task",nullable = false)
	private String task;
	
	@Column(name="dateOfSubmission",nullable = false)
	private Date dateOfSubmission;

	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	//setters and getters methods
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_mail() {
		return manager_mail;
	}
	public void setManager_mail(String manager_mail) {
		this.manager_mail = manager_mail;
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
	public Date getDateOfSubmission() {
		return dateOfSubmission;
	}
	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}
	
	public Manager(String managername,String managermail,String task,String password)
	{
		this.manager_mail=managermail;
		this.manager_name=managername;
		this.task=task;
		this.password=password;
		
		
	}
	@Override
	public String toString() {
		return "Manager [manager_name=" + manager_name + ", manager_mail=" + manager_mail + ", id=" + id + ", password="
				+ password + ", task=" + task + ", dateOfSubmission=" + dateOfSubmission + "]";
	}
	
	
	
}
