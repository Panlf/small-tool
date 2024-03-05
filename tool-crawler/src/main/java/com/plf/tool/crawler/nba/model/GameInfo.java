package com.plf.tool.crawler.nba.model;

import kim.zkp.quick.orm.annotation.PrimaryKey;
import kim.zkp.quick.orm.annotation.Table;
import kim.zkp.quick.orm.model.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author panlf
 * @date 2024/3/4
 */
@Data
@Table(tableName = "game_info",create = false)
public class GameInfo extends Model<GameInfo> {
    @PrimaryKey
    private Long id;
    //主队
    private String homeTeam;
    //主队分数
    private Integer homeTeamScore;
    //客队
    private String awayTeam;
    //客队分数
    private Integer awayScore;
    //比赛时间
    private String gameDay;
    //比赛球馆
    private String gameAddress;
    //比赛编号
    private Long gameNo;

    private String opTime;
}
