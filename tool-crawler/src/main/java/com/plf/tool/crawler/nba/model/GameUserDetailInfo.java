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
@Table(tableName = "game_user_detail_info",create = false)
public class GameUserDetailInfo extends Model<GameUserDetailInfo> {
    @PrimaryKey
    private Long id;

    private Long gameNo;

    private Integer userType;

    private String teamName;

    private String userName;
    //篮球中 G、F、C 分别代表后卫、前锋、中锋的位置。
    //G是英文Guard的缩写，在篮球比赛中就是后卫。
    //F是英文Forward的缩写，在篮球比赛中就是前锋。
    //C是英文Center的缩写，在篮球比赛中就是中锋。

     /*
        +/- ：指球员在场上时球队的净胜分
        PG ：控球后卫
        SG ：得分后卫
        G ：后卫
        SF ：小前锋
        PF ：大前锋
        F ：前锋
        G/F ：后卫/前锋
        C ：中锋
        F/C ：前锋/中锋
    */
    private String userPosition;

    //时间
    private Integer userTime;

    //投篮
    private String shooting;

    //3分
    private String threeScore;

    //罚球
    private String penaltyKick;

    //前场板
    private Integer frontCourtBoard;

    //后场板
    private Integer backCourtBoard;
    //篮板
    private Integer backboard;
    //助攻
    private Integer assists;
    //犯规
    private Integer foul;
    //抢断
    private Integer steals;
    //失误
    private Integer blunder;
    //封盖
    private Integer capping;
    //得分
    private Integer score;

    //+/-
    private String winningMargin;

    private String opTime;
}
