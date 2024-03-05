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
@Table(tableName = "game_section_info",create = false)
public class GameSectionInfo extends Model<GameSectionInfo> {
    @PrimaryKey
    private Long id;
    //比赛编号
    private Long gameNo;

    private String teamName;

    private Integer sectionName;

    private Integer score;

    private String opTime;
}
