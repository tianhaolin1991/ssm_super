import cn.itcast.dao.RoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.io.InputStream;

public class Test3 {
    @Test
    public void test3() throws IOException {
       InputStream is =  Resources.getResourceAsStream("classPath:mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        RoleDao mapper = sqlSession.getMapper(RoleDao.class);

    }
}
