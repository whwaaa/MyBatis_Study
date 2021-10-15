import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public class d4_使用Mapper接口动态代理 {

    // 1. 创建mapper包,编写mapper接口
    // 2. 创建mapper.xml映射文件, 跟之前的ORM配置文件一致, 注意对应修改namespace(改为接口的完全限定名)
    // 3. 获取代理对象

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList = mapper.queryAll();
        teamList.forEach(team -> System.out.println(team.toString()));
    }

    @Test
    public void add(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Team team = new Team();
        team.setTeamName("小鹿");
        team.setLocation("北京");
        team.setCreateTime(new Date());
        Integer add = mapper.add(team);
        sqlSession.commit();
        System.out.println(add);

    }
}
