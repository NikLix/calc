package com.MyProject.test.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examples")
public class examples {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String LeftOperand,RightOperand,Operation,Result;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLeftOperand() {
		return LeftOperand;
	}
	public void setLeftOperand(String leftOperand) {
		LeftOperand = leftOperand;
	}
	public String getRightOperand() {
		return RightOperand;
	}
	public void setRightOperand(String rightOperand) {
		RightOperand = rightOperand;
	}
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String operation) {
		Operation = operation;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	
	public examples() {
		
	}
	public examples(String leftOperand, String rightOperand, String operation, String result) {
		LeftOperand = leftOperand;
		RightOperand = rightOperand;
		Operation = operation;
		Result = result;
	}
		
}
