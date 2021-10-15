package com.jumaojiang.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public class Team implements Serializable {

    private Integer teamId;
    private String teamName;
    private String location;
    private Date createTime;

    // 对多关联对象集合
    private List<Player> playerList1;
    private List<Player> playerList2;

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", location='" + location + '\'' +
                ", createTime=" + createTime +
                ", playerList1=" + playerList1 +
                ", playerList2=" + playerList2 +
                '}';
    }

    public Team(Integer teamId, String teamName, String location, Date createTime) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.location = location;
        this.createTime = createTime;
    }

    public Team(Integer teamId, String teamName, String location, Date createTime, List<Player> playerList1, List<Player> playerList2) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.location = location;
        this.createTime = createTime;
        this.playerList1 = playerList1;
        this.playerList2 = playerList2;
    }

    public Team() {
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Player> getPlayerList1() {
        return playerList1;
    }

    public void setPlayerList1(List<Player> playerList1) {
        this.playerList1 = playerList1;
    }

    public List<Player> getPlayerList2() {
        return playerList2;
    }

    public void setPlayerList2(List<Player> playerList2) {
        this.playerList2 = playerList2;
    }
}
