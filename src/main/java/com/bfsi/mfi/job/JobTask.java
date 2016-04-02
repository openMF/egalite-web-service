package com.bfsi.mfi.job;

abstract public class JobTask implements Runnable {
	private int iterationSize = 3;
	public int num = 0;

	public int getIterationSize() {
		return iterationSize;
	}

	public void setIterationSize(int iterationSize) {
		this.iterationSize = iterationSize;
	}

}
