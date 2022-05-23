package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("the main thread starts running");

        myThreads m1 = myThreads.createAndStart("child thread 1");
        myThreads m2 = myThreads.createAndStart("child thread 2");
        myThreads m3 = myThreads.createAndStart("child thread 3");
        try {
            m1.threadName.join();
            m2.threadName.join();
            m3.threadName.join();

        }
        catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("The main thread is exiting");
        }
        System.out.println("The main thread is exiting");
    }
}

class myThreads implements Runnable{

    Thread threadName;

     myThreads(String name) {
        threadName = new Thread(this, name);
    }

    public static myThreads createAndStart(String name){
         myThreads mt = new myThreads(name);
         mt.threadName.start();
         return mt;
    }

    public void run(){
        System.out.println(threadName.getName() + "starts operating");
        try {
            for (int count = 0; count < 10; count++){
                Thread.sleep(100);
                System.out.println(threadName.getName() + "is executed, the value of the counter is: "+ count);
            }
        }
        catch (InterruptedException e){
            System.out.println(threadName.getName() + "System has been interrupted");
        }
        System.out.println(threadName.getName() + "finished running");
    }
}


