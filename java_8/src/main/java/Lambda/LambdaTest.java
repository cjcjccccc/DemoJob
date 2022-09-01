package Lambda;

import org.junit.Test;


/**
 * @author 陈境聪
 * @date 2022年09月01日 10:53
 */
public class LambdaTest {

/*
举例： （o1,o2） -> {
                    Integer.compare(o1,o2)
              };
格式：
		-> : lambda操作符
		->左边 : lambda形参列表 （其实就是接口中的抽象方法的形参列表）
		->右边 : lambda体  （其实就是重写的抽象方法体）
 * */

// 无参数，无返回
    @Test
    public void noArgument() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名接口实现");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("lambda实现");
//        由此看出，lambda表达式的本质就是接口的实例
        r2.run();
    }


}
