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
public class k12_关系映射_引入关联对象的Mapper映射 {

    // 如果每次查询都需要关联再用

    // 引入需要关联对象的Mapper映射文件中定义过的resultMap (需要填如需要关联对象映射文件的完全限定名)
    // <resultMap id="JoinTeamResult2" type="Player" extends="baseMap">
    //    <association property="team2" javaType="Team" resultMap="com.jumaojiang.mapper.TeamMapper.baseMap"></association>
    // </resultMap>

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryPlayerAndTeamByPlayerId2(1);
        System.out.println(player.toString());
    }
}
