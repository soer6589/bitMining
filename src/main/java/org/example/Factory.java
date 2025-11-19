package org.example;

import java.util.Random;

public class Factory {

    public boolean produceRandomBit() {
        Random bitRandom = new Random();

        int randomNr = bitRandom.nextInt(2) - 1;
        boolean result = (randomNr == 0) ? false : true;

        return result;
    }


}
