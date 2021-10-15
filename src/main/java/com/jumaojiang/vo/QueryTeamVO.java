package com.jumaojiang.vo;

import java.util.Date;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/15
 */
public class QueryTeamVO {

    private String teamName;
    private Date beginTime;
    private Date endTime;
    private String location;

    @Override
    public String toString() {
        return "QueryTeamVO{" +
                "teamName='" + teamName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                '}';
    }

    public QueryTeamVO() {
    }

    public QueryTeamVO(String teamName, Date beginTime, Date endTime, String location) {
        this.teamName = teamName;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
