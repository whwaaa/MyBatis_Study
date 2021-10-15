package com.jumaojiang.dao;

import com.jumaojiang.pojo.Team;

import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public interface TeamDao {

    /**
     * 查询所有
     * @return
     */
    public List<Team> queryAll();
}
