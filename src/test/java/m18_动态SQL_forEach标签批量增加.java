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
public class m18_动态SQL_forEach标签批量增加 {

    // 批量增加foreach标签
    // 集合类型collection填入"list"
    // separator指定分隔符

    //<insert id="addList" parameterType="Team">
    //    INSERT INTO `team` (teamName,location) VALUES
    //    <foreach collection="list" item="t" separator=",">
    //        (#{t.teamName},#{t.location})
    //    </foreach>
    //</insert>

    @Test
    public void test001() {

        List<Team> teamList = new ArrayList<>();
        for(int i=0; i<5; i++){
            Team team = new Team(null, "小可"+i, "北京"+i, new Date());
            teamList.add(team);
        }
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Integer integer = mapper.addList(teamList);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(integer);

    }
}
