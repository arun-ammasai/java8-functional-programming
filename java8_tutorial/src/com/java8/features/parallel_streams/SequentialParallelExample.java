package com.java8.features.parallel_streams;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequentialParallelExample {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		String str[] = {"1","2","3","4","5","6","7","8","9","10"};
		System.out.println("--- Sequential Run ----");
		printStream(Arrays.stream(str).sequential());
		System.out.println("--- Parallel Run ----");
		printStream(Arrays.stream(str).parallel());
		
	}
	
	static void printStream(Stream<String> stream) {
		stream.forEach(s-> {
			System.out.println(LocalTime.now()+" Value :"+s+" - thread :"+Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
