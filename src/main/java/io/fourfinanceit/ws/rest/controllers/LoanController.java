package io.fourfinanceit.ws.rest.controllers;

import io.fourfinanceit.dto.Loan;
import io.fourfinanceit.repositories.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/loans")
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@RequestMapping
	public Iterable<Loan> getAllLoans() {

		return loanRepository.findAll();

	}
	
	// Add new loan to Loan table
	@RequestMapping(value = "/addLoan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Loan addLoan(@RequestBody Loan loan) {
		return loanRepository.save(loan);
	}
	
	// Get loan by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Loan getOnlyById(@PathVariable Long id) {
		return loanRepository.findOne(id);
	}
}
