package com.jumaojiang.pojo;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/14
 */
public class Player {

    private Integer playerId;
    private String playerName;
    private String playerNum;
    private String teamId;

    // 关联对象
    private Team team1;
    private Team team2;
    private Team team3;

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerNum='" + playerNum + '\'' +
                ", teamId='" + teamId + '\'' +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", team3=" + team3 +
                '}';
    }

    public Player() {
    }

    public Player(Integer playerId, String playerName, String playerNum, String teamId, Team team1, Team team2, Team team3) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerNum = playerNum;
        this.teamId = teamId;
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(String playerNum) {
        this.playerNum = playerNum;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Team getTeam3() {
        return team3;
    }

    public void setTeam3(Team team3) {
        this.team3 = team3;
    }
}
