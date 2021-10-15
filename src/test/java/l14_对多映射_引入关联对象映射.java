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
public class l14_对多映射_引入关联对象映射 {

    // 对多用List接收
    // javaType填入List完全限定名(java.util.List)
    // 还需指定List的元素类型, ofType="Player"
    // <resultMap id="JoninPlayerResult" type="Team" extends="baseMap">
    //    <collection property="playerList1" javaType="java.util.List" ofType="Player"
    //                resultMap="com.jumaojiang.mapper.PlayerMapper.baseMap"/>
    // </resultMap>


    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList = mapper.queryTeamAndPlayerById(1025);
        teamList.forEach(team -> System.out.println(team.toString()));
    }
}
