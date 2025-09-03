package com.plf.tool.common.sql;


import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

/**
 * @author panlf
 * @date 2025/9/2
 */
public class SqlParse {
    public static void main(String[] args) {
        String sql = "SELECT u.name, o.amount FROM users u JOIN orders o ON u.id = o.user_id WHERE u.age > 18";

        try {
            Select select = (Select) CCJSqlParserUtil.parse(sql);
            PlainSelect plainSelect = select.getPlainSelect();

            // 遍历 FROM 子句中的表
            if (plainSelect.getFromItem() instanceof Table) {
                System.out.println("主表: " + ((Table) plainSelect.getFromItem()).getName());
            }

            // 遍历 JOIN
            plainSelect.getJoins().forEach(join -> {
                if (join.getRightItem() instanceof Table) {
                    System.out.println("JOIN 表: " + ((Table) join.getRightItem()).getName());
                }
            });


            System.out.println(plainSelect.getWhere());
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
    }
}
