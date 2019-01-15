package com.company;

import java.util.Random;

public class ZClass extends Thread
{
    // Instance variables
    private Count count;
    private char letter;

    /**
     * Constructor for Z class. Takes count object and a character
     * @param count
     * @param letter
     */
    public ZClass(Count count, char letter)
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
                // Make Z binary semaphore 1
                count.zSem.V();
                System.out.print(letter);
                // Sleep for a random amount of time
                Thread.currentThread().sleep(random.nextInt(2000));
            }catch (InterruptedException e) { }
        }
    }
}
