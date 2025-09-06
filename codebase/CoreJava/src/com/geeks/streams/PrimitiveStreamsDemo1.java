package com.geeks.streams;
import java.util.stream.IntStream;
public class PrimitiveStreamsDemo1 {
public static void main(String[] args) {
	int nums[]= {1,2,3,4,5,6,7,8,9,23,44,33,46,778,6,68,899,668,789};
	//sum of even nums
	int sum=IntStream.of(nums).filter(n->n%2==0).sum();
	System.out.println(sum);
	//to find the sum of nos
	sum=IntStream.of(nums).sum();
	System.out.println("sum of all nos "+sum);
}
}
