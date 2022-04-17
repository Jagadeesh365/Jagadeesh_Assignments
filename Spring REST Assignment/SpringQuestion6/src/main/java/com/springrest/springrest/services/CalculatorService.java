package com.springrest.springrest.services;

public interface CalculatorService {
	public long add(long firstNumber, long secondNumber);

	public long subtract(long firstNumber, long secondNumber);

	public long multiply(long firstNumber, long secondNumber);
	
	public long divide(long firstNumber, long secondNumber);

	public long sqrt(double number);
}
