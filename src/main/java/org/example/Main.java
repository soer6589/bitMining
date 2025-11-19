package org.example;

public class Main {
    public static void main(String[] args) {

        Factory bitMining = new Factory();

        /*
        for (int i = 0; i < 100; i++) {
            boolean temp;
            temp = bitMining.produceRandomBit();

            System.out.println(temp);
        }
         */

        bitMining.produceByte(6 );


    }
}