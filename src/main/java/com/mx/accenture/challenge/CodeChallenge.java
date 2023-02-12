package com.mx.accenture.challenge;

/*
**** Code Challenge JAVA 2023 ****

* Instructions:
Given an array of integers, and an integer representing a target sum.
Write a Java program that can read the array and display a pair of numbers that sum up to the target sum.
Example:
    Input:
        [2,7,11,15], target =18
    Expected output:
        7,11

* Test Cases:
    TC 1: Happy path
    Input: [2,7,11,15], target =18
    Expected output: 7,11

    TC 2: There is no pair to achieve the target sum
    Input: [2,7,11,15], target =11
    Expected output: null

    TC 3: 2 possible solutions
    Input: [2,7,11,15,3], target =18
    Expected output: 7,11

    TC 4: negative case,
    Input: [], target =0
    Expected output: null
*/

import java.util.HashMap;

public class CodeChallenge {
    public Integer[]  resolve(Integer[] numbers, Integer target){
    	// The logic , we populate the map with the array of integers
        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
        	// Get the complement for the current number against the target
            int complement = target - numbers[i];
            // validate if complement is stored in the numbersMap 
            if (numbersMap.containsKey(complement)) {
            	return new Integer[] { complement, numbers[i] };
            	
            }
            numbersMap.put(numbers[i], i);
        }
        
        return null;

    }
}
