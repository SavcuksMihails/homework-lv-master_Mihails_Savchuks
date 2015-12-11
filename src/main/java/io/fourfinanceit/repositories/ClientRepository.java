package io.fourfinanceit.repositories;

import io.fourfinanceit.dto.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
}


