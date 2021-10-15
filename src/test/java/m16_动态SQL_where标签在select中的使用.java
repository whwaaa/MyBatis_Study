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
public class m16_动态SQL_where标签在select中的使用 {

    // 多条件使用where标签, 一个条件用一个<if test="teamName!=null"></if>标签
    // 字符拼接用concat("字符a","字符b"), 拼接两个%: concat(concat("%",#{teamName}),"%")
    // 每一条语句前用"and"进行连接, 第一条可用可不用, 用了会自动去掉

    // <select id="queryTeamByMany" parameterType="QueryTeamVO" resultType="Team">
    //    SELECT * from team
    //    <!-- where teamName LIKE "%鹿%" and createTime>="1946-01-01" and createTime<="2021-10-11" and location LIKE "%北%" -->
    //    <where>
    //        <if test="teamName!=null">
    //            and teamName LIKE concat(concat("%",#{teamName}),"%")
    //        </if>
    //        <if test="beginTime!=null">
    //            and createTime&gt;=#{beginTime}
    //        </if>
    //        <if test="endTime!=null">
    //            and createTime&lt;=#{endTime}
    //        </if>
    //        <if test="location!=null">
    //            and location LIKE concat(concat("%",#{location}),"%")
    //        </if>
    //    </where>
    // </select>

    @Test
    public void test001(){
//        SELECT * from team where teamName LIKE "%鹿%" and createTime>="2021-03-02" and createTime<="2021-10-15 and location LIKE "%北%";

        QueryTeamVO queryTeamVO = new QueryTeamVO();
        queryTeamVO.setTeamName("鹿");
        queryTeamVO.setLocation("北");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = null;
        try {
            begin = sdf.parse("2021-03-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        queryTeamVO.setBeginTime(begin);
        queryTeamVO.setEndTime(new Date());


        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team> teamList = mapper.queryTeamByMany(queryTeamVO);
        teamList.forEach(team -> System.out.println(team));
    }
}
