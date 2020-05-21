package com.java.initialGoal;

import java.util.Scanner;

public class Rextester {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	       
       String initial = sc.next();
       String goal = sc.next();
       int res = Solution.minimumConcat(initial, goal);
       System.out.println(res);

	}

}
