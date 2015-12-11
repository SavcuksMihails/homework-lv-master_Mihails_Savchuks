package io.fourfinanceit.repositories;

import io.fourfinanceit.dto.Loan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{

}
