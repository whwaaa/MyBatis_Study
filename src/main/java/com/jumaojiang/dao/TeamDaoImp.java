package com.jumaojiang.dao;

import com.jumaojiang.pojo.Team;
import com.jumaojiang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public class TeamDaoImp implements TeamDao{

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Team> queryAll() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        return sqlSession.selectList("com.jumaojiang.pojo.Team.queryAll");
    }
}
