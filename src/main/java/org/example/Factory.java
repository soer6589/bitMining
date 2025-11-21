package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class that creats a byteArray consisting of 8 randome bytes
 * There are methods find the binaryValue of the Byte
 * And method to convert the binaryValue to the ascii char
 */
public class Factory {

    StringBuilder sb = new StringBuilder();
    int validNr = 0;
    int invalidNr = 0;
    ArrayList<Character> asciiSentence = new ArrayList<Character>();
    int[] byteArray = new int[8];        //Creates array with 8 elemetens, because a byte is made of 8 bits


    /**
     * Recursion loop method that initialize the whole production of the byteArray
     *
     * @param counter
     */
    public void produceByte(int counter) {
        if (counter == 0) return;


        fillArrayByte(byteArray);      //Method to fill the byte with 8 bits
        calculateByte(byteArray);      //Method call to find the value of the binary code

        counter--;
        produceByte(counter);       //Recursion loop method call
    }


    /**
     * Fill byte array
     *
     * @param byteArray
     */
    public void fillArrayByte(int[] byteArray) {
        for (int i = 0; i <= 7; i++) {
            byteArray[i] = produceRandomBit();       //Call method 8 times to find randome number 8 times to fill out byteArray
        }
    }


    /**
     * Creates a randome number between 0-1 to simulate a bit (True/false)
     *
     * @return result (the bit)
     */
    public int produceRandomBit() {
        Random bitRandom = new Random();

        int randomNr = bitRandom.nextInt(2);
        //boolean result = (randomNr == 0) ? false : true;        //Shorthand If to find if the bit is true or false

        return randomNr;
    }


    /**
     * Method to find the binary value of the randome byteArray
     *
     * @param bitArray
     * @return binaryValue
     */
    public int calculateByte(int[] bitArray) {
        int binaryValue = 0;
        for (int i = 0; i <= 7; i++) {
            if (bitArray[i] == 1) {     //If statement to find all 'true' (1) in byteArray
                binaryValue += Math.pow(2, i);      //Finding the binary value of the of all the on position of the byteArray
            }
        }
        isLetterValid(binaryValue);
        //printArray(binaryValue, bitArray);      //Method call to print out the array + the binary value (binaryValue)
        return binaryValue;
    }


    public int isLetterValid(int binaryValue) {
        if (binaryValue >= 97 && binaryValue <= 122) {
            printArray(binaryValue, byteArray);
            produceChar(binaryValue);
            validNr++;
        } else {
            produceByte(1);
            invalidNr++;
        }
        return validNr + invalidNr;
    }


    public void goodOrBadCounter() {
        System.out.printf("%d were valid numbers\n", validNr);
        System.out.printf("%d were invalid\n", invalidNr);
    }



    /**
     * Method that prints out the byteArray and the binaryValue of the byteArray
     *
     * @param binaryValue
     * @param bitArray
     */
    public void printArray(int binaryValue, int[] bitArray) {
        System.out.println(Arrays.toString(bitArray) + " - Binary code is: " + binaryValue);        //Printing the bitArray + binary value(sum)
    }


    /**
     * Method that finds the ascii char of the binaryValue
     *
     * @param binaryValue
     */
    public void produceChar(int binaryValue) {
        char ascii = (char) binaryValue;        //Finding the ascii char from the binaryValue
        sb.append(ascii);
        printAscii(ascii);      //Method call to print out the ascii
    }


    public void stringBuilder () {
        System.out.println(sb.toString());
    }


    /**
     * Method that prints the found ascii char
     *
     * @param ascii
     */
    public void printAscii(char ascii) {
        System.out.print("ascii: " + ascii);
        System.out.println("\n");
    }
}
