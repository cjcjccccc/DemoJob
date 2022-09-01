package Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 陈境聪
 * @date 2022年09月01日 14:55
 */

public class StreamAPITest {
    /*
    * Stream实例化
    * */

    @Test
    public void test() {
        List<String> list = Arrays.asList("aaa", "bbb", "cccc");

//        stream() : 顺序流
        Stream<String> stream = list.stream();

//       parallelStream() : 并行流
        Stream<String> parallelStream = list.parallelStream();

    }

    /*
    * 一系列中间操作
    * */

//    筛选和切片
    @Test
    public void test2() {
        List<User> users = UserData.getUsers();
//         filter(Predicate p)   --- Predicate断言  接收Lambda表达式，从流中排除某些元素
        users.stream().filter(user -> user.getAge()>25).forEach(System.out::println);
        System.out.println();
//        limit(n) 截断流 ----只取n条数据
        users.stream().limit(3).forEach(System.out::println);
        System.out.println();

//        skip(n) 跳过流 ----不要前n条数据
        users.stream().skip(3).forEach(System.out::println);
        System.out.println();

//        skip(n) 跳过流 ----不要前n条数据
        users.stream().skip(3).forEach(System.out::println);
        System.out.println();

//        distinct 去重 ----
        users.stream().distinct().forEach(System.out::println);
        System.out.println();
    }

//    映射  map() Stream的map方法可以将集合中的每个对象转化为其他对象。
//    可以理解为将每个对象都进行处理、转换。
    @Test
    public void test3() {
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三", 24);
        Student stu2 = new Student("李四", 22);
        Student stu3 = new Student("王五", 25);
        Collections.addAll(list, stu1, stu2, stu3);
        List<Teacher> teacList = list.stream().map(stu -> {
            String name = stu.getName();
            int age = stu.getAge();
            return new Teacher(name, age);
        }).collect(Collectors.toList());
        teacList.stream().forEach(teacher -> System.out.println(teacher));
        //Teacher{name='张三', age=24}
        //Teacher{name='李四', age=22}
        //Teacher{name='王五', age=25}
    }


//    排序
    @Test
    public void test4() {
//        sorted()   ---自然排序
        List<Integer> list = Arrays.asList(23, 12, 455, 32, 4, 20);
        list.stream().sorted().forEach(l -> System.out.println(l));

//        sorted(Comparator com)  ---定制排序
        List<User> users = UserData.getUsers();
        users.stream().sorted((u1,u2) -> {
            int compare = Double.compare(u1.getSalary(), u2.getSalary());
            if (compare !=0) {
                return compare;
            }else {
                return Integer.compare(u1.getId(), u2.getId());
            }
        }).forEach(System.out::println);

    }

}
