import cn.itcast.dao.RoleDao;
import cn.itcast.dao.TravellerDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.Traveller;
import cn.itcast.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-dao.xml"})
public class MyTest {
    @Autowired
    private TravellerDao travellerDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    public MyTest() {
    }

    @Test
    public void testFindById(){
        Traveller traveller = travellerDao.findById("EE7A71FB6945483FBF91543DBE851960");
        System.out.println(traveller);
    }

    @Test
    public void testRoleFindByUserId(){
        List<Role> roles = roleDao.findByUserId("001");
        for(Role role:roles){
            System.out.println(role);
        }
    }

    @Test
    public void testUserFindByName(){
        UserInfo user = userDao.findByName("zhangsan");
        List<Role> roles = user.getRoles();

    }

}
