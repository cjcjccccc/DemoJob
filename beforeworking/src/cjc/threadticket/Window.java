package cjc.threadticket;

/**
 * @author 陈境聪
 * @date 2022年08月18日 16:34
 */

public class Window implements Runnable {
    //    创建10个窗口卖票，总票数为100张
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) { //锁。任何一个类的对象，都可以充当锁。 要求：多个线程必须要共用同一把锁
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName()+ "在卖票，票号为： " + ticket);
                        ticket--;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
            }

        }

    }
}
