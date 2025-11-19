package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

public class Factory {

    public boolean produceRandomBit() {
        Random bitRandom = new Random();

        int randomNr = bitRandom.nextInt(2) - 1;
        boolean result = (randomNr == 0) ? false : true;

        return result;
    }


    public void produceByte(int counter) {
        int[] bitArray = new int[8];

        if (counter == 0) return;
        int sum = fillArrayByte(bitArray);

        System.out.println(Arrays.toString(bitArray) + " - Binary code is: " + sum);
        produceChar(sum);

        counter--;
        produceByte(counter);
    }

    public int fillArrayByte(int[] bitArray) {
        boolean temp;
        int sum = 0;
        for (int j = 0; j <= 7; j++) {
            if (temp = produceRandomBit() == true) {
                sum += Math.pow(2, j);
            }
            bitArray[j] = (temp == true) ? 1 : 0;
        }
        return sum;
    }



    public void produceChar(int sum) {

        char ascii = (char) sum;
        System.out.print("ascii: " + ascii);
        System.out.println("\n");
    }
}
