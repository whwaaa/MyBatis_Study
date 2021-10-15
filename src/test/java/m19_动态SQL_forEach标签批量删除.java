import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/15
 */
public class m19_动态SQL_forEach标签批量删除 {

    // 批量删除用forEach标签
    // 参数是集合, conllection值填入"list"
    // 参数可以是Integer的集合, 也可以是对象集合, 注意parameterType对应使用
    // 逗号分隔:separator=","   开始符号:open="("    结束符号:close=")"

    //<delete id="deleteList" parameterType="Team">
    //    delete from team  where teamId in
    //    <foreach collection="list" item="t" separator="," open="(" close=")">
    //        #{t.teamId}
    //    </foreach>
    //</delete>

    @Test
    public void test001() {

        List<Team> teamList = new ArrayList<>();
        for(int i=0; i<5; i++){
            Team team = new Team();
            team.setTeamId(1135 + i);
            teamList.add(team);
        }
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Integer integer = mapper.deleteList(teamList);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(integer);

    }
}
