package com.springrest.springrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Numbers {

	private long firstNumber;
	private long secondNumber;
	public Numbers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Numbers(long firstNumber, long secondNumber) {
		super();
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	public long getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(long firstNumber) {
		this.firstNumber = firstNumber;
	}
	public long getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(long secondNumber) {
		this.secondNumber = secondNumber;
	}
	

}
