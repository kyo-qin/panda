package com.tao.panda.common.test;

import java.util.List;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.wall.spi.WallVisitorUtils;

public class DBTest {
    public static void main(String[] args) {
        WallVisitorUtils.getValue(SQLUtils.toSQLExpr("1 < 2"));

        String sql = "select user from emp_table where a>1 and b<1";
        String dbType = JdbcConstants.MYSQL;

        // 格式化输出
        String result = SQLUtils.format(sql, dbType);
        System.out.println(result); // 缺省大写格式

        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        // 解析出的独立语句的个数
        System.out.println("size is:" + stmtList.size());
        
        for (int i = 0; i < stmtList.size(); i++) {
            
            SQLStatement stmt = stmtList.get(i);
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);
 
            //获取表名称
            System.out.println("Tables : " + visitor.getCurrentTable());
            //获取操作方法名称,依赖于表名称
            System.out.println("Manipulation : " + visitor.getTables());
            //获取字段名称
            System.out.println("fields : " + visitor.getColumns());
            
        }
    }
}
