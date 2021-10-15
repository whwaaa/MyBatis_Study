import com.jumaojiang.mapper.TeamMapper;
import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/15
 */
public class n21_二级缓存开启步骤 {

    // 注意必须是同一个SqlSessionFactory打开的连接才可以, 必须要整SqlSessionFactory单例
    // 单独二级缓存的禁用: 在SQL语句中的select配置useCache=false

    // 开启步骤:
    // 1. 在Mybatis框架的全局配置文件中开启二级缓存
    // <settings>
    //    <!-- 是否开启二级缓存, (默认)false不开启, true开启 -->
    //    <setting name="cacheEnabled" value="true"/>
    // </settings>

    // 2. 在需要二级缓存的Mapper映射文件中添加缓存标志
    // <mapper namespace="com.jumaojiang.mapper.TeamMapper">
    //   <cache></cache>
    // </mapper>

    // 3. 实体类必须实现Serializable序列化接口
    // public class Team implements Serializable


    @Test
    public void test001() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Team team = mapper.queryById(1025);
        System.out.println(team.toString());
        // 关闭SqlSession重新打开, 一级缓存清空, 二级缓存存在
        MyBatisUtil.close();

        sqlSession = MyBatisUtil.openSession();
        mapper = sqlSession.getMapper(TeamMapper.class);
        Team team2 = mapper.queryById(1025);
        System.out.println(team2.toString());
        MyBatisUtil.close();


    }
}
