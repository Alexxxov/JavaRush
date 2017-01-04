package com.javarush.test.level24.lesson02.home01;

/**
 * Created by Admin on 24.11.2016.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{

    boolean marked = false;
    public SelfInterfaceMarkerImpl()
    {

    }
    private boolean isMarked()
    {
        return marked = true;
    }
    private boolean isDone()
    {
        return marked = true;
    }
    private final boolean CantbeDone()
    {
        return marked = true;
    }


}
