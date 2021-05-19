package tech.itpark.jdbc.mapper;

import tech.itpark.jdbc.domain.Protocol;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProtocolRowMapper implements RowMapper<Protocol> {
    public Protocol mapRow (ResultSet rs, int nouNum) throws SQLException {
        return new Protocol(
        rs.getLong("id"),
        rs.getString("model"),
        rs.getString("vin"),
        rs.getString("regNumber"),
        rs.getString("name"),
        rs.getString("dateOfBirth"),
        rs.getString("drivingLicence"),
        rs.getString("article"),
        rs.getInt("amountFine"),
        rs.getString("urlPhoto"),
        rs.getBoolean("paid")
        );
    }
}
