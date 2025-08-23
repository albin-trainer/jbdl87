package com.geeks;

public class ArrayEx1 {
public static void main(String[] args) {
	//creates a array of size 5
	int nums[]=new int[5]; //arrays are objects in java ...
	nums[0]=10;
	nums[1]=20;
	nums[2]=30;
	System.out.println("*****Traditinol for loop****");
	for(int i=0;i<nums.length;i++) {
		System.out.println(nums[i]);
	}
	
	System.out.println("***for each loop*****");
	for(int val:nums) {
		System.out.println(val);
	}
	int x;
	//System.out.println(x) ;//ERROR bcoz local variables must initialize before use....;
	System.out.println("----------------");
	
	int nums2[]= {1,2,3,4,5,6,7,8,9};
	for(int v:nums2) {
		System.out.println(v);
	}
	
}
}
