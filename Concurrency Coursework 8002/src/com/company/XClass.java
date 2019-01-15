package com.company;

import java.util.Random;

public class XClass extends Thread
{
    // Instance variables
    private Count count;
    private char letter;

    /**
     * Constructor for X class. Takes count object and a character
     * @param count
     * @param letter
     */
    public XClass(Count count, char letter)
    {
        this.count = count;
        this.letter = letter;
    }

    /**
     * Override run method of super class
     */
    @Override
    public void run()
    {
        // random object
        Random random = new Random();

        while(true)
        {
            try
            {
                // Make X binary semaphore 0
                count.xBinarySem.P();
                // Make Z binary semaphore 0
                count.zSem.P();
                System.out.print(letter);
                // Sleep for a random amount of time
                Thread.currentThread().sleep(random.nextInt(2000));
            }catch (InterruptedException e) { }

            // Make Y binary semaphore 1
            count.yBinarySem.V();
        }
    }
}
