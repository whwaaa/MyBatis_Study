import com.jumaojiang.pojo.Team;
import com.jumaojiang.dao.TeamDaoImp;
import org.junit.Test;

import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public class c3_原有Dao开发_使用ThreadLocal {

    @Test
    public void test001(){
        TeamDaoImp teamDaoImp = new TeamDaoImp();
        List<Team> teamList = teamDaoImp.queryAll();
        teamList.forEach(team -> System.out.println(team.toString()));
    }
}
