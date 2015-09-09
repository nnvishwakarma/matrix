package com.matrix.exceptions;

public class MatrixParseException  extends Exception{
	public MatrixParseException(){
		super("Exceptione occured during parsing of matrix");		
	}
	public MatrixParseException(String message){
		super(message);
	}

}
