import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/14
 */
public class e5_插入数据获取自增的ID {
    // 新增一个<selectKey>节点的sql, 执行两次sql

    //    <insert id="add" parameterType="com.jumaojiang.pojo.Team">
    //        <!-- keyProperty:新增成功之后将自增的id赋值给参数属性teamId
    //             order: AFTER/BEFORE两个数值,表示selectkey中的sql语句在insert之前还是之后执行
    //         -->
    //        <selectKey keyProperty="teamId" order="AFTER" resultType="java.lang.Integer">
    //            select LAST_INSERT_ID()
    //        </selectKey>
    //        INSERT INTO `team` (`teamName`, `location`, `createTime`) VALUES (#{teamName}, #{location}, #{createTime})
    //    </insert>
    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Team team = new Team(null, "小鹅", "土地", new Date());
        Integer integer = mapper.add2(team);
        sqlSession.commit();
        MyBatisUtil.close();
        System.out.println(integer);
        System.out.println("返回新添加数据的id: " + team.getTeamId());
    }
}
