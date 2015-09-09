package com.matrix.logica;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class Stack {

	
	public static final int DEFAULT_SIZE=10;
	
	public static final int LOCK_TRY_IN_MILISECOND=10;
	
	public static final TimeUnit LOCK_TRY_TIME_UNIT=TimeUnit.MILLISECONDS;
	
	private ReentrantLock Lock;
	private ReentrantLock popLock;
	private String [] stack;	
	private int top;
	private int size;
	
	public Stack(){
		this.size=DEFAULT_SIZE;
		this.stack=new String[this.size];
		this.top=-1;
		Lock=new ReentrantLock();
		popLock=new ReentrantLock();
	}
	
	public Stack(int size){
		this.size=size;
		this.stack=new String[this.size];
		this.top=-1;
		Lock=new ReentrantLock();
		popLock=new ReentrantLock();
	}

	public int getTop() {
		return top;
	}	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public void push(String item){
		if(item!=null && item.trim().equals("")){
			try{
				Lock.tryLock(LOCK_TRY_IN_MILISECOND,LOCK_TRY_TIME_UNIT);
				this.stack[++top]=item;
			} catch(InterruptedException e){
				e.printStackTrace();
			} finally{
				Lock.unlock();
			}
		}
	}
	
	
}
