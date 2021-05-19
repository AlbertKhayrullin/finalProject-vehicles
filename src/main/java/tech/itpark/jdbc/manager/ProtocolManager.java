package tech.itpark.jdbc.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import tech.itpark.jdbc.domain.Protocol;
import tech.itpark.jdbc.mapper.ProtocolRowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ProtocolManager {

    private final NamedParameterJdbcTemplate template;
    private final ProtocolRowMapper rowMapper = new ProtocolRowMapper();

    public List<Protocol> getAll() {
        return template.query("" +
                "SELECT model, vin, aa.regNumber, name, dateOfBirth, drivingLicence, " +
                "aa.id, article, amountFine, urlPhoto, paid " +
                "FROM owners ow JOIN " +
                "(SELECT model, vin, a.regNumber, ownerId, o.id, article, amountFine, urlPhoto, paid " +
                "FROM autos a JOIN offenses o ON a.regNumber = o.regNumber)aa ON ow.id = aa.ownerId",
                rowMapper);

    }

    public List<Protocol> getByRegNumberPaid(String regNumber, boolean paid) {
        return template.query("" +
                        "SELECT model, vin, aa.regNumber, name, dateOfBirth, drivingLicence, " +
                        "aa.id, article, amountFine, urlPhoto, paid " +
                        "FROM owners ow JOIN " +
                        "(SELECT model, vin, a.regNumber, ownerId, o.id, article, amountFine, urlPhoto, paid " +
                        "FROM autos a JOIN offenses o ON a.regNumber = o.regNumber)aa ON ow.id = aa.ownerId " +
                        "WHERE regNumber=:regNumber AND paid=:paid",
                Map.of ("regNumber", regNumber,
                        "paid", paid),
                rowMapper);
    }

    private final DataSource dataSource;
    public int getByRegNumberSumNoPaid(String regNumber) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT SUM(amountFine) AS sum FROM offenses" +
                                " WHERE paid='false' AND regNumber=?"
                );
        ) {
            int index = 0;
            statement.setString(++index, regNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("sum");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Protocol> getByName(String name) {
        return template.query("" +
                        "SELECT model, vin, aa.regNumber, name, dateOfBirth, drivingLicence, " +
                        "aa.id, article, amountFine, urlPhoto, paid " +
                        "FROM owners ow JOIN " +
                        "(SELECT model, vin, a.regNumber, ownerId, o.id, article, amountFine, urlPhoto, paid " +
                        "FROM autos a JOIN offenses o ON a.regNumber = o.regNumber)aa ON ow.id = aa.ownerId WHERE name=:name",
                Map.of ("name", name),
                rowMapper);
    }

    public int getByNameSumNoPaid(String name) {
        try (
                Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT SUM(amountFine) AS sum FROM " +
                "offenses o JOIN autos a on o.regNumber = a.regNumber" +
                " JOIN owners ow on ownerId = ow.id WHERE paid='false' AND name=?"
        );
        ) {
            int index = 0;
            statement.setString(++index, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("sum");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}







