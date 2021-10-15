import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import com.jumaojiang.vo.QueryTeamVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/15
 */
public class m17_动态SQL_set标签在update中的使用 {

    // set标签中,一个if是一个判断条件
    // 每一条语句后用逗号","分隔

    //<update id="updateByMany" parameterType="Team">
    //    update team
    //    <set>
    //        <if test="teamName!=null">
    //            teamName=#{teamName},
    //        </if>
    //        <if test="location!=null">
    //            location=#{location},
    //        </if>
    //        <if test="createTime!=null">
    //            createTime=#{createTime},
    //        </if>
    //    </set>
    //    where teamId=#{teamId}
    //</update>

    @Test
    public void test001() {
        Team team = new Team(1053, "小白", "北京", new Date());
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Integer integer = mapper.updateByMany(team);
        sqlSession.commit();
        MyBatisUtil.close();
        System.out.println(integer);
    }
}
