import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/*
This program developed by Susan Wolfgram for CSE 373 Homework 1.
Program prints out student information as well as lists of random 
and sorted random numbers. 
 */
public class BrushUpJava {
	public static void main(String[] args) {
		System.out.println("This program was developed by Susan Wolfgram");
		System.out.println("having UWNetID skwolf");
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		
		//instance of class Random using seed 0
		Random rand = new Random(0);
		
		//print first 10 random numbers
		nums.add(rand.nextInt(99));
		System.out.print("The first 10 random numbers: " + nums.get(0));
		for (int i = 0; i < 9; i++) {
			nums.add(rand.nextInt(99));
			System.out.print(", " + nums.get(i + 1));
		}
		System.out.println();
		
		//sort and print first 10 random numbers
		Collections.sort(nums);
		System.out.print("The (sorted) first 10 random numbers: " + nums.get(0));
		for (int i = 0; i < 9; i++) {
			System.out.print(", " + nums.get(i + 1));
		}
		System.out.println();
		System.out.println("The last three digits of my student number: 601");
		nums.clear(); 
		
		//instance of class Random using seed 601
		Random newRand = new Random(601); 
		
		//print 10 new random numbers
		nums.add(newRand.nextInt());
		System.out.print("Ten new random numbers: " + nums.get(0));
		for (int i = 0; i < 9; i++) {
			nums.add(newRand.nextInt());
			System.out.print(", " + nums.get(i + 1));
		}
		System.out.println();
		
		//sort and print new random numbers 
		Collections.sort(nums);
		System.out.print("Now sorted: " + nums.get(0));
		for (int i = 0; i < 9; i++) {
			System.out.print(", " + nums.get(i + 1));
		}
	}
}
