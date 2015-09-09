package com.matrix.bean;

public class Matrix {
	private String matrixAsString;
	private int rowsCount;
	private int columnsCount;
	private double [][] matrixAs2D;
	
	public Matrix(){}
	
	public Matrix(String matrixAsString){
		this.matrixAsString=matrixAsString;
	}

	public String getMatrixAsString() {
		return matrixAsString;
	}

	public void setMatrixAsString(String matrixAsString) {
		this.matrixAsString = matrixAsString;
	}
	
	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getColumnsCount() {
		return columnsCount;
	}

	public void setColumnsCount(int columnsCount) {
		this.columnsCount = columnsCount;
	}
	
	public double[][] getMatrixAs2D() {
		return matrixAs2D;
	}

	public void setMatrixAs2D(double[][] matrixAs2D) {
		this.matrixAs2D = matrixAs2D;
	}
	public void initNumberMatrix(int rowSize,int columnSize){
		this.rowsCount=rowSize;
		this.columnsCount=columnSize;
		matrixAs2D=new double[rowSize][columnSize];		
	}
	public void addElement(double element,int rowIdx,int columnIdx){
		this.matrixAs2D[rowIdx][columnIdx]=element;
		
	}

	public String toString(){
		StringBuffer matrix=new StringBuffer();
		for(double [] row : this.matrixAs2D){
			for(double element : row){
				matrix.append(String.format("\t%.2f",element));
			}
			matrix.append(String.format("\n"));
		}
		return matrix.toString();
	}
	
	
}
