import com.jumaojiang.pojo.Team;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public class b2_引入日志 {

    // 1. pom.xml中引入依赖
    // 2. 创建log4j.properties配置文件
    // 3. MyBatis.xml全局配置文件中开启日志

    private final String resourceName = "MyBatis.xml";
    private SqlSession sqlSession;

    @Test
    public void test001(){
        List<Team> teamList = sqlSession.selectList("com.jumaojiang.pojo.Team.queryAll");
        teamList.forEach(team -> System.out.println(team.toString()));
    }

    @Before
    public void before(){
        try {
            Reader resource = Resources.getResourceAsReader(this.resourceName);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
            sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
