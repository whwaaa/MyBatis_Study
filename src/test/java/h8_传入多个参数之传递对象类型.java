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
public class h8_传入多个参数之传递对象类型 {

    //  只需在 Mapper.xml ORM映射文件的SQL语句中配置paramType(参数对象的完全限定名)

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Team team = new Team();
        team.setTeamId(1020);
        team.setTeamName("%侠%");
        Team team1 = mapper.queryByTeam(team);
        System.out.println(team1.toString());
    }
}
