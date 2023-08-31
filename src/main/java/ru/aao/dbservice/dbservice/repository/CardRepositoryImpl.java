package ru.aao.dbservice.dbservice.repository;

import com.clickhouse.jdbc.ClickHouseDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Slf4j
public class CardRepositoryImpl implements CardRepository {
    String url = "jdbc:ch://localhost:8123";

    Properties properties = new Properties();

    @Override
    public String getResource() {
        ClickHouseDataSource dataSource = null;
        Integer id = null;
        String name = null;
        try {
            dataSource = new ClickHouseDataSource(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (
                Connection conn = dataSource.getConnection("default", null);
                Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("select * from test");
                while(rs.next()) {
                    id = rs.getInt("id");
                    name = rs.getString("name");
                }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return name + " :: id = " + id;
    }
}
