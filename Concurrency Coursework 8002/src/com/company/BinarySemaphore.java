package com.company;

public class BinarySemaphore extends Semaphore
{
    /**
     * Role: Sets the value to 0 by calling the super class constructor
     */
    public BinarySemaphore()
    {
        super();
    }

    /**
     * Role: Creates a binary semaphore object whose value will be either 0 or 1
     * @param initial
     */
    public BinarySemaphore(int initial)
    {
        // call the super class constructor
        super(initial);

        // if initial > 0 set value to 1 else set value to 0
        value = (initial > 0) ? 1:0;
    }

    /**
     * Role: Set the value to 0 and notifies the waiting thread. If already 0 wait
     * @throws InterruptedException
     */
    @Override
    public synchronized void P() throws InterruptedException
    {
        while (value==0)
        {
            wait();
        }

        value = 0;
        notify();
    }

    /**
     * Role: Sets the value to 1 and notifies the wait thread
     */
    @Override
    public synchronized void V()
    {
        value = 1;
        notify();
    }
}
