package com.java.initialGoal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int minimumConcat(String initial, String goal) {
	       //Put your code here		
	       int n = goal.length();
	       //ArrayList<String> substr = new ArrayList<String>();
	       int index = -1;
	       String curr = "";
	       //substr = subSeq(initial, initial.length(), index, curr); 
	       List<String> substr = new ArrayList<String>();
	        for ( int i = 1; i <= (1<<(initial.length()))-1; i++ ) {
	            StringBuilder builder = new StringBuilder();
	            for ( int j = 0; j < initial.length(); j++ ) {
	                if ( (i & (1<<j)) != 0) {
	                    char ch = initial.charAt(j);
	                    builder.append(Character.toString(ch));
	                }
	            }
	            substr.add(builder.toString());
	        }  
	        char c=' ';
	        String s="";
	        String init="";
	        int count = 0;
	        int len = 0;
	        //System.out.println(substr);
	        for (int i = 0; i < goal.length(); i += len){
	             len = 0;
	            for (int j = i; j < goal.length(); j++){
	                c = goal.charAt(j);
	                s = init.concat(Character.toString(c));
	                //System.out.println(s);
	                if (substr.contains(s)){
	                    init = s;
	                    len ++;
	                    //System.out.println(len);
	                }
	                else{
	                    break;
	                }
	            }
	            if (len > 0){
	                count ++;
	               
	                init = "";
	                s = "";
	            }
	            else if (len == 0){
	                count = -1;
	                break;
	            }
	        }    
	        return count;
	   }
	
	public static void main(String args[])
   {
       Scanner sc = new Scanner(System.in);
       
       String initial = sc.next();
       String goal = sc.next();
       int res = minimumConcat(initial, goal);
       System.out.println(res);
   }

}
