package com.matrix.exceptions;

public class MatrixCalculatorException extends Exception{
	public MatrixCalculatorException(){
		super("Exception occured during matrix operation...");
	}
	public MatrixCalculatorException(String message){
		super(message);
	}	
}
