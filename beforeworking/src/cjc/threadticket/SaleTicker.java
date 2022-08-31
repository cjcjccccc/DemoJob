package cjc.threadticket;

/**
 * @author 陈境聪
 * @date 2022年08月18日 16:52
 */

public class SaleTicker {

    public static void main(String[] args) {
        Window w = new Window();
        new Thread(w,"窗口1").start();
        new Thread(w,"窗口2").start();
        new Thread(w,"窗口3").start();
        new Thread(w,"窗口4").start();
        new Thread(w,"窗口5").start();
        new Thread(w,"窗口6").start();
        new Thread(w,"窗口7").start();
        new Thread(w,"窗口8").start();
        new Thread(w,"窗口9").start();
        new Thread(w,"窗口10").start();
    }
}
