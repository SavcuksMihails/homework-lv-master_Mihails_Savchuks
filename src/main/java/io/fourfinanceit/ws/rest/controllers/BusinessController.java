package io.fourfinanceit.ws.rest.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.fourfinanceit.dto.Client;
import io.fourfinanceit.dto.Loan;
import io.fourfinanceit.dto.LoanApplication;
import io.fourfinanceit.repositories.ClientRepository;
import io.fourfinanceit.repositories.LoanRepository;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/business")
public class BusinessController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private LoanRepository loanRepository;
	
	// Add loan to particular client;
	@RequestMapping(value = "/applyLoan/{clientId}/{loanTerm}/{loanAmount}/{loanId}", method = RequestMethod.POST)
	public Client applyLoan(HttpServletRequest requestContext, @PathVariable Long clientId, @PathVariable int loanTerm, @PathVariable int loanAmount, @PathVariable long loanId) {
		Client client = clientRepository.findOne(clientId);
		Loan loan = loanRepository.findOne(loanId);
		if (client == null || loan == null){
			//don`t perform any action if client or loan is not found;
			return null;
		}
		
		List<LoanApplication> clientLoans = client.getLoanApplications();
		
		boolean isClosedTime = false;
		
		int maxPossibleAmount = loan.getMaxPossibleAmount();		
		boolean ipCountPassed = false;	
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		try {
			isClosedTime = dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("00:00"))
					&& dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("08:00"));
		} catch (ParseException e) {
			//error handler
			e.printStackTrace();
			return null;
		}
		
		String requesterIP = requestContext.getRemoteAddr().toString();	
		
		int ipCount = 0;
		
		for (LoanApplication clientLoan:clientLoans){
			if (clientLoan.getIp().equals(requesterIP) && DateUtils.isSameDay(clientLoan.getLoanStartDate(), date)){
				ipCount++;
			}
		}
		
		ipCountPassed = (ipCount < 3)?true:false;
		
		if (isClosedTime && (loanAmount > maxPossibleAmount)){
			//first condition is not passed
			return null;
		} else if (!ipCountPassed){
			//second condition is not passed
			return null;		
		} else{
			LoanApplication loanApp = new LoanApplication();
			loanApp.setLoanId(loan.getId());
			loanApp.setLoanTerm(loanTerm);
			loanApp.setLoanAmount(loanAmount);
			loanApp.setLoanStartDate(new Date());
			loanApp.setIp(requesterIP);
			client.getLoanApplications().add(loanApp);
			clientRepository.save(client);	
			return client;
		}		
	}
	
	// Get client`s loans
	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public List<LoanApplication> getClientLoans(@PathVariable Long clientId) {
		Client client = clientRepository.findOne(clientId);
		if (client != null){
			return client.getLoanApplications();
		} else{
			return null;
		}
	}
}
