import cn.itcast.dao.UserDao;
import cn.itcast.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class Test2 {

    @Autowired
    private UserDao userDao;
    @Test
    public void myTest(){
        List<String> ids= new ArrayList<>();
        ids.add("8C82FA87D039474CA41EE9DFE89208DB");
        ids.add("7EE54D89507F402A983C25A87BB1064D");
        List<UserInfo> users = userDao.findByIds(ids);
        for (UserInfo user : users) {
            System.out.println(user);
        }
    }
}
