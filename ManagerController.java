package TaskManagement_Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import TaskManagement_Repository.ManagerRepository;
import TaskManagement_Service.Employee;
import TaskManagement_Service.Manager;
import TaskManagement_ServiceImplementation.EmployeeServiceImplementaton;

import TaskManagement_ServiceImplementation.ManagerServiceImplementation;


@CrossOrigin(origins = "http://localhost:4200")  
@RestController
@RequestMapping("/Manager")
public  class ManagerController {
	
	
	//private EmployeeServiceImplementaton service;
	
	@Autowired
	private ManagerRepository managerrepository;
	
	@Autowired
	public ManagerServiceImplementation managerService;
	



	@PostMapping("/signup")
	public ResponseEntity<Map<String,String>> singup(@RequestBody Manager admin)
	{
		this.managerService.addadmin(admin);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "Admin registered!!");
		
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		Optional<Manager> existingAdmin=this.managerService.getadminByEmail(email);
		Map<String,String> response=new HashMap<String,String>();
		if(existingAdmin.isPresent())
		{
			if(existingAdmin.get().getPassword().equals(password))
			{
				
				response.put("status", "success");
				response.put("message", "admin authenticated");
				response.put("adminId",String.valueOf( existingAdmin.get().getId()) );
				
				response.put("adminName", existingAdmin.get().getManager_name());
				return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
			}
			else
			{
				response.put("status", "Failed");
				response.put("message", "admin password inncorrect");
				return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);
			}
		}		
		else
		{
			response.put("status", "Failed");
			response.put("message", "admin email does not exist");
			return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);
		}
	}}
	