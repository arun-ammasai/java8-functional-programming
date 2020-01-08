package com.java8.features.parallel_streams;

import java.util.stream.IntStream;

public class ParallelWhenNotToUseExample1 {

	public static void main(String[] args) {
		Calculation cal = new Calculation();

		IntStream.rangeClosed(0, 2000).forEach(cal::calculate);
		System.out.println("Result in Seq:"+cal.getTotal());
		
		IntStream.rangeClosed(0, 2000).parallel().forEach(cal::calculate);
		System.out.println("Result in Parallel:"+cal.getTotal());
	}

}

class Calculation {
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void calculate(int in) {
		total += in;
	}
}
