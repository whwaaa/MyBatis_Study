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
public class l15_对多映射_引入关联对象单独查询 {

    // 偶尔使用
    // 引入关联对象的Mapper中的SQL查询
    // 相当于用第一次查询的结果中某个列column的值作为引入的关联对象查询语句的参数再次查询, 最后将结果综合
    // <resultMap id="JoninPlayerResult2" type="Team" extends="baseMap">
    //    <collection property="playerList2" javaType="java.util.List" ofType="Player"
    //                column="teamId" select="com.jumaojiang.mapper.PlayerMapper.queryById"/>
    //</resultMap>

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList = mapper.queryTeamAndPlayerById2(1025);
        teamList.forEach(team -> System.out.println(team.toString()));
    }
}
