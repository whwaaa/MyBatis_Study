package com.jumaojiang.mapper;

import com.jumaojiang.pojo.Player;
import org.apache.ibatis.annotations.Param;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/14
 */
public interface PlayerMapper {

    // k11_关系映射_通过关联对象打点调用属性
    // 查询编号1的球员及所在的球队
    public Player queryPlayerAndTeamByPlayerId(@Param("playerId") Integer paleyId);

    // k12_关系映射_引入关联对象的Mapper映射
    // 查询编号1的球员及所在的球队
    public Player queryPlayerAndTeamByPlayerId2(@Param("playerId") Integer paleyId);

    // k13_关系映射_使用关联对象的查询语句
    // 查询编号1的球员及所在的球队
    public Player queryPlayerAndTeamByPlayerId3(@Param("playerId") Integer paleyId);
}
