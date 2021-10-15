import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/14
 */
public class i9_返回基本数据类型 {

    // 单行单列基本数据类型
    // SQL语句配置中的resultType配置java.lang.xxx基本数据类型的完全限定名
    @Test
    public void test001(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        String s = mapper.queryByName("%侠%");
        System.out.println(s);
    }

    // 单行多列基本数据类型,使用Map接收
    // SQL语句配置中的resultType配置java.util.Map (Map类型的完全限定名)
    @Test
    public void test002(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Map<String,?> map = mapper.queryByName2("%侠%");
        Set<String> set = map.keySet();
        set.forEach(team -> {
            System.out.println(team + " : " + map.get(team));
        });
    }


    // 多行多列基本数据类型,使用集合List<Map>接收
    // SQL语句配置中的resultType配置 java.util.Map 配置集合中元素的数据类型
    @Test
    public void test003(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Map<String, ?>> maps = mapper.queryByLocation("%州%");
        maps.forEach(team -> {
            Set<String> strings = team.keySet();
            strings.forEach(t -> {
                System.out.print(t + ": " + team.get(t) + "  ");
            });
            System.out.println();
        });
    }

}
