package Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 陈境聪
 * @date 2022年09月01日 16:43
 */

public class StreamAPITest2 {

    /*
     * stream 终止操作
     * */

    // 1-匹配与查找
    @Test
    public void test1() {

        List<User> users = UserData.getUsers();

        // allMatch(Predicate p) - 检查是否匹配所有元素。  ---是否所有的员工的年龄都大于18
        boolean match = users.stream().allMatch(user -> user.getAge() > 18);
        System.out.println(match);

        // anyMatch(Predicate p) - 检查是否至少匹配一个元素。 ---是否存在员工的工资大于10000
        boolean b = users.stream().allMatch(user -> user.getSalary() > 10000);
        System.out.println(b);

        // noneMatch(Predicate p) - 检查是否没有匹配的元素。(没有返回true，有返回false) --是否存在员工姓"雷"
        boolean noneMatch = users.stream().allMatch(user -> user.getName().startsWith("雷"));
        System.out.println(noneMatch);

        // findFirst - 返回第一个元素
        Optional<User> first = users.stream().findFirst();
        if (!first.isPresent()){
            return;
        }else {
            first.get().setAge(111);
        }
        System.out.println(first.get());

        // findAny - 返回当前流中的任意元素
        Optional<User> any = users.stream().findAny();
        System.out.println(any.get());

        // count - 返回流中元素的总个数
        long count = users.stream().filter(user -> user.getSalary() > 5000).count();
        System.out.println(count);

        // max(Comparator c) - 返回流中最大值   ---------返回最高的工资：
        Stream<Double> salaryStream = users.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

        // min(Comparator c) - 返回流中最小值  ---------返回最低工资的员工
        Optional<User> user = users.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        // Optional[User(id=1005, name=陈几十块, age=30, salary=90.5)]
        System.out.println(user);

        // forEach(Consumer c) - 内部迭代
        users.stream().forEach(System.out::println);
    }

    // 2-归约
    @Test
    public void test2() {

        // reduce(T identity,BinaryOperator) - 可以将流中元素反复结合起来，得到一个值。返回 T
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        // 55
        System.out.println(sum);

        // reduce(BinaryOperator) - 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>   ----计算公司所有员工工资的总和
        List<User> users = UserData.getUsers();
        Optional<Double> reduce = users.stream().map(user -> user.getSalary()).reduce((s1, s2) -> s1 + s2);
        System.out.println(reduce.get());   // 36893.8

    }

    // 3-收集
    @Test
    public void test3() {

        List<User> users = UserData.getUsers();

        // collect(Collector c):将流转换为其他形式。接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法
        // ----查找工资大于 6000 的员工，结果返回为一个 List 或者 set
        List<User> userList = users.stream().filter(user -> user.getSalary() > 6000).collect(Collectors.toList());
        userList.forEach(System.out::println);

        Set<User> userSet = users.stream().filter(user -> user.getSalary() > 6000).collect(Collectors.toSet());
        userSet.forEach(System.out::println);

    }

}
