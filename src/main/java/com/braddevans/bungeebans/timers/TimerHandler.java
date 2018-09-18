package com.braddevans.bungeebans.timers;

import java.util.Observable;

public class TimerHandler extends Observable implements Runnable{

    @Override
    public void run() {
        this.setChanged();
        this.notifyObservers();
    }
}
