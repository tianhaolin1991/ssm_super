import cn.itcast.dao.TravellerDao;
import cn.itcast.domain.Traveller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-dao.xml"})
public class MyTest {
    @Autowired
    private TravellerDao travellerDao;
    @Test
    public void testFindById(){
        Traveller traveller = travellerDao.findById("EE7A71FB6945483FBF91543DBE851960");
        System.out.println(traveller);
    }


}
