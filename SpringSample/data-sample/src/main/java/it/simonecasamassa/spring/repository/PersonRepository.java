package it.simonecasamassa.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.simonecasamassa.spring.entity.PersonTB;


@Repository
@Transactional
public interface PersonRepository extends JpaRepository<PersonTB, Long>{
	 
	public final static String QUERY_LIKE_SURNAME= "SELECT p FROM PersonTB p where p.surname like 'A%'";
	
	public final static String QUERY_NATIVE_LIKE_SURNAME= "SELECT p.* FROM PERSON p where p.SURNAME like 'A%'";

	PersonTB findOneByName(String name);
	
	PersonTB findOneBySurname(String surname);
	
	PersonTB save(PersonTB Person);
	
	List<PersonTB> findAll();
	
	List<PersonTB> findByAgeOrName(int age, String name);
	
	@Query(value = QUERY_LIKE_SURNAME)
	List<PersonTB> customQuery();
	
	@Query(value = QUERY_NATIVE_LIKE_SURNAME, nativeQuery = true)
	List<PersonTB> customNativeQuery();
}


