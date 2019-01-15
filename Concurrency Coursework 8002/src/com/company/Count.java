package com.company;

public class Count
{
    // Instance variables to store semaphores
    protected static BinarySemaphore xBinarySem;
    protected static BinarySemaphore yBinarySem;
    protected static Semaphore zSem;

    /**
     * Constructor to create semaphores
     * @param xBs
     * @param yBs
     * @param zS
     */
    public Count(BinarySemaphore xBs, BinarySemaphore yBs, Semaphore zS)
    {
        this.xBinarySem = xBs;
        this.yBinarySem = yBs;
        this.zSem = zS;
    }
}
