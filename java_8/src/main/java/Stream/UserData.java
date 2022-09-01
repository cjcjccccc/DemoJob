package Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈境聪
 * @date 2022年09月01日 15:07
 */

public class UserData {

    public static List<User> getUsers() {
        List<User> list = new ArrayList<>();

        list.add(new User(1001,"陈龙",50,6000.5));
        list.add(new User(1002,"陈小春",38,5000.3));
        list.add(new User(1003,"陈奕迅",35,6000.5));
        list.add(new User(1004,"陈一",18,9000.5));
        list.add(new User(1005,"陈几十块",30,90.5));
        list.add(new User(1006,"陈法",25,800.5));
        list.add(new User(1007,"陈人",60,5000.5));
        list.add(new User(1007,"陈人",60,5000.5));
        return list;
    }
}
