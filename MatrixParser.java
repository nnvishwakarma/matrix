package com.matrix.logica;

import java.util.StringTokenizer;

import com.matrix.bean.Matrix;
import com.matrix.exceptions.MatrixParseException;
public class MatrixParser {
	
	
	public static final String COLUMN_SEPERATOR=",";
	
	public static final String ROW_SEPERATOR=";";	 
	
	private Matrix matrix;
	
	
	public MatrixParser(){		
	}
	
	public MatrixParser(Matrix matrxi) {
		this.matrix=matrxi;
	}
	/*private void initNumberMatrix(int rowSize,int columnSize){
		matrixAs2D=new double[rowSize][columnSize];
		
	}*/
	private void addRowToMatrix(String rowAsString,String delimiter,int rowIndex){
		String str[]=rowAsString.split(delimiter);		
		for(int i=0;i<str.length;i++){
			getMatrix().addElement(Double.parseDouble(str[i]), rowIndex, i);
		}
	}

	public void parseMatrix() throws MatrixParseException{
		
		if(matrix==null){
			throw new MatrixParseException("Not Matrix Available to parse....");
		}
		String localMatris=getMatrix().getMatrixAsString();
		StringTokenizer rowTokernizer=null;		
		int rowIndex=0;
		int rowSize=0;
		int columnSize=0;
		boolean initNumberMatrix=true;
		try{
			rowTokernizer=new StringTokenizer(localMatris, ROW_SEPERATOR);
			rowSize=rowTokernizer.countTokens();		
			String currentRowToken=null;
			while(rowTokernizer.hasMoreTokens()){
				currentRowToken=rowTokernizer.nextToken();
				if(initNumberMatrix){
					columnSize = currentRowToken.split(COLUMN_SEPERATOR).length;
					getMatrix().initNumberMatrix(rowSize, columnSize);
					initNumberMatrix=false;
				}
				addRowToMatrix(currentRowToken, COLUMN_SEPERATOR, rowIndex++);
			}			
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			rowTokernizer=null;
		}
		
	}
	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}
	

	public void printMatrix(){
		System.out.println("=================================");
		for(double [] row : getMatrix().getMatrixAs2D()){
			for(double element : row){
				System.out.printf("\t%.2f",element);
			}
			System.out.println();
		}
		System.out.println("=================================");
	}
	public static void main(String []a) throws Exception{
		String matrix="2,3,4;5,2;4,5,2;1;1,2,3;3,45,6";
		Matrix m=new Matrix(matrix);
		MatrixParser mp=new MatrixParser(m);
		mp.parseMatrix();
		mp.printMatrix();
	}
}
