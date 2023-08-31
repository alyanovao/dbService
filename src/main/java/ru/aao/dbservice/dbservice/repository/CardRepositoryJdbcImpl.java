package ru.aao.dbservice.dbservice.repository;

import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.aao.dbservice.dbservice.CardDao;
import ru.aao.dbservice.dbservice.exception.ApplicationException;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CardRepositoryJdbcImpl implements CardRepository {

    private final JdbcTemplate jdbcTemplate;

    public CardRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getResource() {
        val card = jdbcTemplate.query("select id, name from test", new CardMap())
                .stream()
                .findFirst()
                .orElseThrow(ApplicationException::new);
        return card.getName() + " :: id = " + card.getName();
    }

    private static class CardMap implements RowMapper<CardDao> {
        @Override
        public CardDao mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            return new CardDao(id, name);
        }
    }
}
