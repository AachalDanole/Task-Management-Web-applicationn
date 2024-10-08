package TaskManagement_ServiceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;



import TaskManagement_Repository.ManagerRepository;
import TaskManagement_Service.Employee;
import TaskManagement_Service.Manager;



@Service
public class ManagerServiceImplementation   {
	
	@Autowired
	private ManagerRepository adminRepo;
	
	public void addadmin(Manager admin) {
		
		this.adminRepo.save(admin);
		
	}

	public Optional<Manager> getadminByEmail(String email) {
		
		return this.adminRepo.findByadminEmail(email);
		
	}


}
	




