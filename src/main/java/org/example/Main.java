package org.example;
public class Main {
    public static void main(String[] args) {

        Factory bitMining = new Factory();

        for (int i = 0; i < 10; i++) {
            boolean temp;
            temp = bitMining.produceRandomBit();

            System.out.println(temp);
        }



    }
}