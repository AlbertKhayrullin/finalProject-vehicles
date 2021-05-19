package tech.itpark.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.jdbc.domain.Auto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoRowMapper implements RowMapper<Auto> {
    public Auto mapRow (ResultSet rs, int rouNum) throws SQLException {
        return new Auto(
                rs.getLong("id"),
                rs.getString("model"),
                rs.getString("vin"),
                rs.getString("regNumber"),
                rs.getLong("ownerId")
        );
    }

}
