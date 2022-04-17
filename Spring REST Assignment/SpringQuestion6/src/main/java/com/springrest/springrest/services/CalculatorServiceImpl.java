package com.springrest.springrest.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public long add(long firstNumber, long secondNumber) {
		return firstNumber+secondNumber;
	}

	@Override
	public long subtract(long firstNumber, long secondNumber) {
		return firstNumber-secondNumber;
	}

	@Override
	public long multiply(long firstNumber, long secondNumber) {
		return firstNumber*secondNumber;
	}

	@Override
	public long sqrt(double number) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long divide(long firstNumber, long secondNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

}
