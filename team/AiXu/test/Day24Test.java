import com.csnobugteam.java.homework.day24.RandomGenerateTwoColorBallNum;
import com.csnobugteam.java.homework.day24.User;
import com.csnobugteam.java.homework.day24.UserList;
import org.junit.Test;

import java.util.List;

/**
 * 测试类
 */
public class Day24Test {
    @Test
    public void testGetTowColorBallNums() {
        new RandomGenerateTwoColorBallNum().generateTowColorNums().forEach(ball -> System.out.println(ball.getColor() + " : " + ball.getValue()));
    }

    // 进行方法测试
    @Test
    public void testRemoveDuplicateUserKeepOnlyOne() {
        UserList userList = new UserList();
        // 初始化数据
        List<User> oldUsers = userList.testUserList;
        System.out.println("oldUsers: "+oldUsers.size());
        // 进行去重后的数据
        List<User> newUser = userList.removeDuplicateUserKeepOnlyOne();
        System.out.println("newUser: "+ newUser.size());
    }
}
