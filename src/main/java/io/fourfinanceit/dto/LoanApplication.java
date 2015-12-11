package io.fourfinanceit.dto;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class LoanApplication {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private long appId;
	//private long clientId;
	private long loanId;
	private int loanTerm;
	private int loanAmount;
	private Date loanStartDate;
	private String ip;
	
	/*public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}*/
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Date getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
