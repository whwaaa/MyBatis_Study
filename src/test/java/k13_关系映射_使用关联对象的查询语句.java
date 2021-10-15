import com.jumaojiang.mapper.PlayerMapper;
import com.jumaojiang.pojo.Player;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/14
 */
public class k13_关系映射_使用关联对象的查询语句 {

    // 偶尔查询使用, 需要关联对对象的Mapper中存在SQL语句

    // 相当于两次查询结果的综合, 用首次查询的结果中的一个字段(column="teamId")作为引入的关联对象SQL语句的参数进行查询
    // 需要填入关联对象Mapper的完全限定名
    // <resultMap id="JoinTeamResult3" type="Player" extends="baseMap">
    //    <association property="team3" column="teamId" select="com.jumaojiang.mapper.TeamMapper.queryById"></association>
    //</resultMap>

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryPlayerAndTeamByPlayerId3(1);
        System.out.println(player.toString());
    }
}
