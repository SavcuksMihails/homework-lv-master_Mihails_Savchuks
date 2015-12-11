package io.fourfinanceit.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String loantype;
	private String description;
	private int originalterm;
	private int maxPossibleAmount;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
	public int getOriginalterm() {
		return originalterm;
	}
	public void setOriginalterm(int originalterm) {
		this.originalterm = originalterm;
	}
	public int getMaxPossibleAmount() {
		return maxPossibleAmount;
	}
	public void setMaxPossibleAmount(int maxPossibleAmount) {
		this.maxPossibleAmount = maxPossibleAmount;
	}
	
}
