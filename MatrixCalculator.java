package com.matrix.logica;

import com.matrix.bean.Matrix;
import com.matrix.exceptions.MatrixCalculatorException;

public class MatrixCalculator {
	
	public Matrix addMatrix(Matrix a,Matrix b) throws MatrixCalculatorException{
		if(a.getRowsCount()!=b.getRowsCount() || a.getColumnsCount()!=b.getColumnsCount())
			throw new MatrixCalculatorException(String.format("A[%d,%d], b[%d,%d] Dimenssion is not matching. Failed Addition.....",
										a.getRowsCount(),a.getColumnsCount(),b.getRowsCount(),b.getColumnsCount()));
		
		Matrix result=new Matrix();
		int rowSize=a.getRowsCount();
		int columnSize=a.getColumnsCount();
		result.initNumberMatrix(rowSize, columnSize);
		
		double [][] matrixA=a.getMatrixAs2D();
		double [][] matrixB=b.getMatrixAs2D();
		for(int r=0;r<rowSize;r++){
			for(int c=0;c<columnSize;c++){
				result.addElement(matrixA[r][c]+matrixB[r][c], r,c);
			}
		}	
		return result;
	}
	public Matrix substractMatrix(Matrix a,Matrix b) throws MatrixCalculatorException{
		if(a.getRowsCount()!=b.getRowsCount() || a.getColumnsCount()!=b.getColumnsCount())
			throw new MatrixCalculatorException(String.format("A[%d,%d], b[%d,%d] Dimenssion is not matching. Failed Substraction.....",
										a.getRowsCount(),a.getColumnsCount(),b.getRowsCount(),b.getColumnsCount()));
		
		Matrix result=null;
		int rowSize=a.getRowsCount();
		int columnSize=a.getColumnsCount();		
		double [][] matResult=new double[rowSize][columnSize];
		double [][] matrixA=a.getMatrixAs2D();
		double [][] matrixB=b.getMatrixAs2D();
		for(int r=0;r<rowSize;r++){
			for(int c=0;c<columnSize;c++){
				matResult[r][c]=matrixA[r][c]-matrixB[r][c];
			}
		}
		result=new Matrix();
		result.setMatrixAs2D(matResult);
		return result;
	}
	public Matrix transpose(Matrix a){
		Matrix result=new Matrix();
		int rowSize=a.getRowsCount();
		int columnSize=a.getColumnsCount();
		result.initNumberMatrix(rowSize, columnSize);
		
		double [][] matrixA=a.getMatrixAs2D();
		
		for(int r=0;r<rowSize;r++){
			for(int c=0;c<columnSize;c++){
				result.addElement(matrixA[c][r], r,c);
			}
		}	
		return result;
	}
}
