package com.promineotech;

import java.util.Random;

public class TestDemo {
  
//Method to determine If both parameters are positive (greater than zero) return the sum of the parameters.
  public int addPositive(int a, int b) {
    if (a > 0 && b > 0) {
      return a + b;
      
     } else {
        throw new IllegalArgumentException("Both parameters must be positive!");
    }
  }
  
//A method to check if a number is even or odd
  public String checkEvenOrOdd(int number) {
      if (number % 2 == 0) {
          return "Even";
      } else {
          return "Odd";
      }
  }
  
//Mocking a Class - TestDemo
  int getRandomInt() {
    Random random = new Random();
    return random.nextInt(10) + 1;
  }
  public int randomNumberSquared() {
    int randomNumber = getRandomInt(); 
    return randomNumber * randomNumber; 
  }
}