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
public class f6_传入多个参数之顺序占位符 {

    // mybatis3.3版本以前   : 可以直接写#{0} #{1}
    // 从mybatis3.4开始    :  #{arg0} #{arg1}.. 或者是#{param1} #{param2}

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList = mapper.queryByScopeId(1030, 1050);
        teamList.forEach(team -> System.out.println(team));
    }

}
