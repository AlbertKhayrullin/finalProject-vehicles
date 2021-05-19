package tech.itpark.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.jdbc.domain.Offense;

import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.List.of;

public class OffenseRowMapper implements RowMapper<Offense> {

    public Offense mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Offense(
                rs.getLong("id"),
                rs.getString("regNumber"),
                rs.getString("article"),
                rs.getInt("amountFine"),
                rs.getString("urlPhoto"),
                rs.getBoolean("paid")
                );
    }
}