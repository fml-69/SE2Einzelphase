package com.task01.se2einzelphase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberWorker extends Thread{
    private List<Integer> inputNumbers = new ArrayList<>();
    private List<Integer> evenNumbers = new ArrayList<>();
    private List<Integer> oddNumbers = new ArrayList<>();
    private String outputString = "";

    public NumberWorker(String in){
        for(int i = 0; i<in.length(); i++){
            inputNumbers.add(Character.getNumericValue(in.charAt(i)));
        }
    }

    public void run(){
        for(int number : inputNumbers){
            System.out.println(number);
            if(number%2==0){
                evenNumbers.add(number);
            } else{
                oddNumbers.add(number);
            }
        }
        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);
        for(int number : evenNumbers){
            outputString = outputString + number;
            System.out.println("even number: " + number);
        }
        for(int number : oddNumbers){
            outputString = outputString + number;
            System.out.println("odd number: " + number);
        }
    }

    public String getOutputString(){
        return this.outputString;
    }

}
