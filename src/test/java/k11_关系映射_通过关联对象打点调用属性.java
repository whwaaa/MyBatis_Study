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
public class k11_关系映射_通过关联对象打点调用属性 {

    // 一般不用

    // 1. pojo中的对象有关联对象的属性(private Team team)及相应get方法
    //<!-- 查询编号1的球员及所在的球队 -->
    //    <select id="queryPlayerAndTeamByPlayerId" resultMap="JoinTeamResult">
    //        SELECT * FROM player p INNER JOIN team t on p.teamId=t.teamId where p.playerId=#{playerId}
    //    </select>
    //    <resultMap id="baseMap" type="Player">
    //        <id column="playerId" property="playerId"/>
    //        <result column="palyerName" property="playerName"/>
    //        <result column="playerNum" property="playerNum"/>
    //        <result column="teamId" property="teamId"/>
    //    </resultMap>
    //    <resultMap id="JoinTeamResult" type="Player" extends="baseMap">
    //        <id property="team1.teamId" column="teamId"/>
    //        <result property="team1.teamName" column="teamName"/>
    //        <result property="team1.location" column="location"/>
    //        <result property="team1.createTime" column="createTime"/>
    //    </resultMap>

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryPlayerAndTeamByPlayerId(1);
        System.out.println(player.toString());
    }
}
