import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/14
 */
public class g7_传入多个参数之注解配置 {

    // 使用@Param("")注解
    // 只需@Param中的value要和Mapper.xml映射文件中SQL语句的#{}中的value一致就行

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList = mapper.queryByScope2Id(1030, 1050);
        teamList.forEach(team -> System.out.println(team));
    }
}
