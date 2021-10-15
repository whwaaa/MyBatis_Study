import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/15
 */
public class n20_一级缓存的清空方法 {

    // 1. session.clearCache();
    // 2. excuto update (执行增删改操作)
    // 3. 映射文件的SQL配置中配置flushcache="true"
    // 4. rollback;
    // 5. commit;
    // 6. session.close()



    @Test
    public void test001() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList1 = mapper.queryAll();
        System.out.println("teamList1 size: " + teamList1.size());

        // 2. excuto update (执行增删改操作)
//        Team team = new Team(1053, "白白", null, null);
//        Integer integer = mapper.updateByMany(team);
//        System.out.println(integer);

        // 1. session.clearCache();
//        sqlSession.clearCache();

        // 4. rollback;
//        sqlSession.rollback();

        // 5. commit;
//        sqlSession.commit();

        // 6. session.close()
//        MyBatisUtil.close();
//        sqlSession = MyBatisUtil.openSession();
//        mapper = sqlSession.getMapper(TeamMapper.class);


        List<Team> teamList2 = mapper.queryAll();
        System.out.println("teamList2 size: " + teamList2.size());
//        teamList2.forEach(team -> System.out.println(team.toString()));


    }
}
