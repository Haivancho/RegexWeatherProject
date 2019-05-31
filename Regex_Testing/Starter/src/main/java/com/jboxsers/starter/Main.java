package com.jboxsers.starter;


public class Main {
    public static void main(String[] args) {

        StartThread startThread = new StartThread();

        Thread thread = new Thread(startThread);
        thread.start();



    }

}
