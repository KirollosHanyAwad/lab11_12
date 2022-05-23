package com.company;

public class Priority_task3 implements Runnable {
    Thread thread;
    int count;
    static boolean stop = false;
    static String currentName;

    Priority_task3(String name){
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run(){
        System.out.println(thread.getName() + "starts operating");
        do {
            count++;
            if (currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                System.out.println(currentName + " is executed");
            }
        }
            while (stop == false && count < 10_000_000);
            stop = true;
            System.out.println("\n" + thread.getName() + "finished running");


        }

    }

class priorityDemo{
    public static void main(String[] args){
        Priority_task3 mt1 = new Priority_task3("Hight priority thread");
        Priority_task3 mt2 = new Priority_task3("Thread with low priority");
        Priority_task3 mt3 = new Priority_task3("Thread #1 with normal priority");
        Priority_task3 mt4 = new Priority_task3("Thread #2 with normal priority");
        Priority_task3 mt5 = new Priority_task3("Thread #3 with normal priority");

        mt1.thread.setPriority(Thread.MAX_PRIORITY);
        mt2.thread.setPriority(Thread.MIN_PRIORITY);

        mt1.thread.start();
        mt2.thread.start();
        mt3.thread.start();
        mt4.thread.start();
        mt5.thread.start();
        try {
            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
        }
        catch (InterruptedException e){System.out.println("The main thread starts running");}

        System.out.println("\nHigh priority thread counted to " + mt1.count);
        System.out.println("The low priority thread added to " + mt2.count);
        System.out.println("#1 Normal priority thread added to " + mt3.count);
        System.out.println("#2 Normal priority thread added to " + mt4.count);
        System.out.println("#3 Normal priority thread added to " + mt5.count);

    }
}