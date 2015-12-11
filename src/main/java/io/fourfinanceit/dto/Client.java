package io.fourfinanceit.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String surname;
	private int age;
	
	@ElementCollection
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ID_SEQUENCE")
	@SequenceGenerator(name="APP_ID_SEQUENCE",sequenceName="APP_ID_SEQUENCE",allocationSize=1)
	@CollectionId(columns = { @Column(name="app_id") }, generator = "APP_ID_SEQUENCE", type = @Type(type="long"))
	private List <LoanApplication> loanApplications = new ArrayList<LoanApplication>();
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List <LoanApplication> getLoanApplications() {
		return loanApplications;
	}
	public void setLoanApplications(List <LoanApplication> loanApplications) {
		this.loanApplications = loanApplications;
	}

}
