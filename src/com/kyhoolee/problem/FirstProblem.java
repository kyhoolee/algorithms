package com.kyhoolee.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FirstProblem {
	
	
	public static int chooseBestTeam(List<Integer> scores, int teamSize) {
		int result = 0;
		
		// 1. Sorting student-score
		for(int i = 0 ; i < scores.size() ; i ++) {
			for(int j = i + 1; j < scores.size() ; j ++) {
				if(scores.get(i) < scores.get(j)) {
					int temp = scores.get(i);
					scores.set(i, scores.get(j));
					scores.set(j, temp);
				}
			}
		}
		
		
		// 2. Choose students for best-team
		for(int i = 0 ; i < teamSize ; i ++) {
			result += scores.get(i * 2);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// Problem constants
		int numberStudents = 10;
		int teamSize = 3;
		
		// Problem variables
		List<Integer> scores = new ArrayList<Integer>();
		int result = 0;
		
		
		try{
			
			// 1. Read data from console
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    
		    for(int i = 0 ; i < numberStudents ; i ++) {
		    	String s = bufferRead.readLine();
		    	int score = Integer.parseInt(s);
		    	scores.add(score);
		    }
		    
		    result = chooseBestTeam(scores, teamSize);
		    
		    
		    // 2. Write to console
		    System.out.println(result);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
