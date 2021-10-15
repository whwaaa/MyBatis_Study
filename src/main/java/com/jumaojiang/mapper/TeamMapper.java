package com.jumaojiang.mapper;

import com.jumaojiang.pojo.Team;
import com.jumaojiang.vo.QueryTeamVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public interface TeamMapper {

    /**
     * 查询所有
     * @return
     */
    public List<Team> queryAll();

    /**
     * 添加一条数据
     * @param team
     * @return
     */
    public Integer add(Team team);

    // e5_插入数据获取自增的ID
    public Integer add2(Team team);

    // f6_传入多个参数之顺序占位符
    public List<Team> queryByScopeId(Integer id1, Integer id2);

    // g7_传入多个参数之注解配置
    public List<Team> queryByScope2Id(@Param("min") Integer id1, @Param("max") Integer id2);

    // h8_传入多个参数之传递对象类型
    public Team queryByTeam(Team team);

    // i9_返回基本数据类型 (单行单列)
    public String queryByName(@Param("teamName") String teamName);

    // i9_返回基本数据类型 (单行多列)
    public Map<String,?> queryByName2(@Param("teamName") String teamName);

    // i9_返回基本数据类型 (多行多列)
    public List<Map<String, ?>> queryByLocation(@Param("location") String location);

    // j10_自定义返回类型映射
    public Team queryById(@Param("teamId") Integer teamId);

    // l14_对多映射_引入关联对象映射
    public List<Team> queryTeamAndPlayerById(@Param("teamId") Integer teamId);

    // l15_对多映射_引入关联对象映射
    public List<Team> queryTeamAndPlayerById2(@Param("teamId") Integer teamId);

    // m16_动态SQL_where标签在select中的使用
    public List<Team> queryTeamByMany(QueryTeamVO queryTeamVO);

    // m17_动态SQL_set标签在update中的使用
    public Integer updateByMany(Team team);

    // m18_动态SQL_forEach标签批量增加
    public Integer addList(List<Team> teamList);

    // m19_动态SQL_forEach标签批量删除
    public Integer deleteList(List<Team> teamList);
}
