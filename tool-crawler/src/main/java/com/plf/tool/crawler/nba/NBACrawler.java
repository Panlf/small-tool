package com.plf.tool.crawler.nba;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.plf.tool.common.read.ReadResourcesUtils;
import com.plf.tool.crawler.nba.model.GameInfo;
import com.plf.tool.crawler.nba.model.GameSectionInfo;
import com.plf.tool.crawler.nba.model.GameUserDetailInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author panlf
 * @date 2024/3/4
 */
public class NBACrawler {

    public static void main(String[] args) {
        Long gameNo = 165486L;
        String html = HttpUtil.get("https://nba.hupu.com/games/boxscore/"+gameNo);
       // System.out.println(result);
        Date date = new Date();

        //String html = ReadResourcesUtils.readTxtToString("nba-demo.txt");


        GameInfo gameInfo = getGameInfo(html);
        gameInfo.setGameNo(gameNo);
        gameInfo.setOpTime(DateUtil.format(date,"yyyy-MM-dd HH:mm"));
        gameInfo.save();

        //System.out.println(JSONUtil.toJsonStr(gameInfo));
        List<GameSectionInfo> gameSectionInfoList = getGameSectionInfo(html);
        for(GameSectionInfo gameSectionInfo:gameSectionInfoList){
            gameSectionInfo.setGameNo(gameNo);
            gameSectionInfo.setOpTime(DateUtil.format(date,"yyyy-MM-dd HH:mm"));
            gameSectionInfo.save();
        }
        //System.out.println(JSONUtil.toJsonStr(gameSectionInfoList));

        List<GameUserDetailInfo> gameUserDetailInfoList = getGameUserDetailInfo(html);
        //System.out.println(JSONUtil.toJsonStr(gameUserDetailInfoList));
        for(GameUserDetailInfo gameUserDetailInfo:gameUserDetailInfoList){
            gameUserDetailInfo.setGameNo(gameNo);
            gameUserDetailInfo.setOpTime(DateUtil.format(date,"yyyy-MM-dd HH:mm"));
            gameUserDetailInfo.save();
        }

    }

    public static List<GameUserDetailInfo> getGameUserDetailInfo(String html){
        List<GameUserDetailInfo> gameUserDetailInfoList = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements table_list_live = doc.getElementsByClass("table_list_live");
        Element elementA = table_list_live.get(0);
        String teamA = elementA.getElementsByClass("clearfix").select("h2").text();
        //System.out.println(teamA);
        Elements teamAContent = elementA.getElementById("J_away_content").select("tr");
        // 0 是首发  1 是 替补
        int userType = 0;
        for(int i=1;i<teamAContent.size()-2;i++){
            Elements td = teamAContent.get(i).select("td");
           // for(int j=0;j<td.size();j++){
                //System.out.println(td.get(j).text());
            GameUserDetailInfo gameUserDetailInfo = new GameUserDetailInfo();
           // System.out.println(td);
            if(td.get(0).text().equalsIgnoreCase("替补")){
                userType = 1;
                continue;
            }

            gameUserDetailInfo.setTeamName(teamA);
            gameUserDetailInfo.setUserName(td.get(0).text());
            gameUserDetailInfo.setUserType(userType);
            gameUserDetailInfo.setUserPosition(td.get(1).text());
            gameUserDetailInfo.setUserTime(Integer.valueOf(td.get(2).text()));
            gameUserDetailInfo.setShooting(td.get(3).text());
            gameUserDetailInfo.setThreeScore(td.get(4).text());
            gameUserDetailInfo.setPenaltyKick(td.get(5).text());
            gameUserDetailInfo.setFrontCourtBoard(Integer.valueOf(td.get(6).text()));
            gameUserDetailInfo.setBackCourtBoard(Integer.valueOf(td.get(7).text()));
            gameUserDetailInfo.setBackboard(Integer.valueOf(td.get(8).text()));
            gameUserDetailInfo.setAssists(Integer.valueOf(td.get(9).text()));
            gameUserDetailInfo.setFoul(Integer.valueOf(td.get(10).text()));
            gameUserDetailInfo.setSteals(Integer.valueOf(td.get(11).text()));
            gameUserDetailInfo.setBlunder(Integer.valueOf(td.get(12).text()));
            gameUserDetailInfo.setCapping(Integer.valueOf(td.get(13).text()));
            gameUserDetailInfo.setScore(Integer.valueOf(td.get(14).text()));
            gameUserDetailInfo.setWinningMargin(td.get(15).text());
            gameUserDetailInfoList.add(gameUserDetailInfo);
            //}
        }


        Element elementB = table_list_live.get(1);
        String teamB = elementB.getElementsByClass("clearfix").select("h2").text();
        //System.out.println(teamB);
        userType = 0;
        Elements teamBContent = elementB.getElementById("J_home_content").select("tr");
        for(int i=1;i<teamBContent.size()-2;i++){
            Elements td = teamBContent.get(i).select("td");

            if(td.get(0).text().equalsIgnoreCase("替补")){
                userType = 1;
                continue;
            }
            // for(int j=0;j<td.size();j++){
            //System.out.println(td.get(j).text());
            GameUserDetailInfo gameUserDetailInfo = new GameUserDetailInfo();
            gameUserDetailInfo.setTeamName(teamB);
            gameUserDetailInfo.setUserName(td.get(0).text());
            gameUserDetailInfo.setUserType(userType);
            gameUserDetailInfo.setUserPosition(td.get(1).text());
            gameUserDetailInfo.setUserTime(Integer.valueOf(td.get(2).text()));
            gameUserDetailInfo.setShooting(td.get(3).text());
            gameUserDetailInfo.setThreeScore(td.get(4).text());
            gameUserDetailInfo.setPenaltyKick(td.get(5).text());
            gameUserDetailInfo.setFrontCourtBoard(Integer.valueOf(td.get(6).text()));
            gameUserDetailInfo.setBackCourtBoard(Integer.valueOf(td.get(7).text()));
            gameUserDetailInfo.setBackboard(Integer.valueOf(td.get(8).text()));
            gameUserDetailInfo.setAssists(Integer.valueOf(td.get(9).text()));
            gameUserDetailInfo.setFoul(Integer.valueOf(td.get(10).text()));
            gameUserDetailInfo.setSteals(Integer.valueOf(td.get(11).text()));
            gameUserDetailInfo.setBlunder(Integer.valueOf(td.get(12).text()));
            gameUserDetailInfo.setCapping(Integer.valueOf(td.get(13).text()));
            gameUserDetailInfo.setScore(Integer.valueOf(td.get(14).text()));
            gameUserDetailInfo.setWinningMargin(td.get(15).text());
            gameUserDetailInfoList.add(gameUserDetailInfo);
            //}
        }

        return gameUserDetailInfoList;
    }

    public static List<GameSectionInfo> getGameSectionInfo(String html){
        List<GameSectionInfo> gameSectionInfoList = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements itineraryTable = doc.getElementsByClass("itinerary_table");
        Elements away_score = itineraryTable.select(".away_score").select("td");
        String awayTeam = away_score.get(0).text();
        for(int i=1;i<away_score.size()-1;i++){
            GameSectionInfo gameSectionInfo = new GameSectionInfo();
            gameSectionInfo.setTeamName(awayTeam);
            gameSectionInfo.setSectionName(i);
            gameSectionInfo.setScore(Integer.parseInt(away_score.get(i).text()));
            gameSectionInfoList.add(gameSectionInfo);
        }

        Elements home_score = itineraryTable.select(".home_score").select("td");
        String homeTeam = home_score.get(0).text();
        for(int i=1;i<home_score.size()-1;i++){
            GameSectionInfo gameSectionInfo = new GameSectionInfo();
            gameSectionInfo.setTeamName(homeTeam);
            gameSectionInfo.setSectionName(i);
            gameSectionInfo.setScore(Integer.parseInt(home_score.get(i).text()));
            gameSectionInfoList.add(gameSectionInfo);
        }
        return gameSectionInfoList;
    }

    public static GameInfo getGameInfo(String html){
        GameInfo gameInfo = new GameInfo();
        Document doc = Jsoup.parse(html);
        Elements team_vs = doc.getElementsByClass("team_vs");
        //客队
        Elements team_a = team_vs.select(".team_a>.message");
        String team_a_score = team_a.select("h2").text();
        String team_a_name = team_a.select("p").text();
        gameInfo.setAwayTeam(team_a_name);
        gameInfo.setAwayScore(Integer.parseInt(team_a_score));

        Elements team_b = team_vs.select(".team_b>.message");
        String team_b_score = team_b.select("h2").text();
        String team_b_name = team_b.select("p").text();
        gameInfo.setHomeTeam(team_b_name);
        gameInfo.setHomeTeamScore(Integer.parseInt(team_b_score));

        Elements aboutFontsClearfix = team_vs.select(".about_fonts");
        String time = aboutFontsClearfix.select(".time_f").text();
        String address = aboutFontsClearfix.select(".arena").text();
        gameInfo.setGameDay(time);
        gameInfo.setGameAddress(address);
        return gameInfo;
    }
}
