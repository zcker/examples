package com.zcker.example.easyJDK.Thread;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ThreadTest.java
 * @Description TODO
 * @createTime 2020年08月10日 22:11:00
 */

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();
        //声明并实例化一个 ThreadState 对象

        Thread thread = new Thread(state);
        //利用这个名为 state 的 ThreadState 对象来创建 Thread 对象

        System.out.println("Create new thread: " + thread.getState());
        //使用 getState() 方法来获得线程的状态，并进行输出

        thread.start();
        //使用 thread 对象的 start() 方法来启动新的线程

        System.out.println("Start the thread: " + thread.getState());
        //输出线程的状态

        Thread.sleep(100);
        //通过调用 sleep() 方法使当前这个线程休眠 100 毫秒，从而使新的线程运行 waitForAMoment() 方法

        System.out.println("Waiting for a moment (time): " + thread.getState());
        //输出线程的状态

        Thread.sleep(1000);
        //使当前这个线程休眠 1000 毫秒，从而使新的线程运行 waitForever() 方法

        System.out.println("Waiting for a moment: " + thread.getState());
        //输出线程的状态

        state.notifyNow();
        // 调用 state 的 notifyNow() 方法

        System.out.println("Wake up the thread: " + thread.getState());
        //输出线程的状态

        Thread.sleep(1000);
        //使当前线程休眠 1000 毫秒，使新线程结束

        System.out.println("Terminate the thread: " + thread.getState());
        //输出线程的状态
    }
}