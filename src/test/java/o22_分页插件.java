import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/15
 */
public class o22_分页插件 {

    // 1. maven中导入jar包
    // 2. Mybatis配置文件中添加插件
    // 3. 在查询之前调用设置方法 PageHelper.startPage(1, 5); (查询第一页,每页5条数据)
    // 4. 获取分页信息,在查询完毕之后传入查询的结果:  PageInfo info = new PageInfo(teamList);

    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);

        PageHelper.startPage(1, 5); // 从第一页查询, 每页5条数据
        List<Team> teamList = mapper.queryAll();
        teamList.forEach(team -> System.out.println(team));

        PageInfo info = new PageInfo(teamList);
        System.out.println("分页信息如下：");
        System.out.println("当前页:"+info.getPageNum());
        System.out.println("总页数:"+info.getPages());
        System.out.println("前一页:"+info.getPrePage());
        System.out.println("后一页:"+info.getNextPage());
        System.out.println("navigatepageNums:"+info.getNavigatepageNums());
        for (int num : info.getNavigatepageNums()) {
            System.out.print(num + " ");
        }

    }
}














