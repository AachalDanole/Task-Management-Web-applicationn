package TaskManagement_Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import TaskManagement_Service.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager ,Integer>{
	
	@Query(value = "SELECT * FROM manager u WHERE u.manager_mail = ?1 AND u.manager_password = ?2 ",nativeQuery = true  )

	public Optional<Manager> findByEmailAndPassword(String email, String Password);



	@Query(value = "SELECT * FROM manager u WHERE u.user_email = ?1",nativeQuery = true  )
	public Optional<Manager> findByadminEmail(String email);
	
	
	
	
}
