import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
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
public class j10_自定义返回类型映射 {

    //  <resultMap id="baseMap" type="com.jumaojiang.pojo.Team">
    //        <!-- 一般主键列(唯一属性)用id, 其余列用result
    //        column: 表示数据库中的列名(不区分大小写)
    //        property: 表示实体类的属性名(区分大小写)
    //        javaType: 实体类中的属性类型(可省略)
    //        jdbcType: 数据库中的column属性类型(可省略)
    //     -->
    //        <id property="teamId" column="teamId"></id>
    //        <result property="teamName" column="teamName"></result>
    //        <result property="location" column="location"></result>
    //        <result property="createTime" column="createTime"></result>
    //    </resultMap>

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Team team = mapper.queryById(1030);
        System.out.println(team.toString());
    }
}
