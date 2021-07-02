package com.test;

public class MainClass {

	public static void main(String[] args) {
		VoteThread voteLocation1 = new VoteThread();
		VoteThread voteLocation2 = new VoteThread();
		VoteThread voteLocation3 = new VoteThread();
		
		Thread location1 = new Thread(voteLocation1, "A");
		Thread location2 = new Thread(voteLocation2, "B");
		Thread location3 = new Thread(voteLocation3, "B");
		
		location1.start();
		location2.start();
		location3.start();
		
		System.out.println(Thread.currentThread().getName());
		
	}

}
