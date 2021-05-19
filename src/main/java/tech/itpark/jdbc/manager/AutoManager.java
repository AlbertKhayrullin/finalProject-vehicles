package tech.itpark.jdbc.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import tech.itpark.jdbc.domain.Auto;
import tech.itpark.jdbc.mapper.AutoRowMapper;
import java.util.*;

@RequiredArgsConstructor
@Component

public class AutoManager {
    private final NamedParameterJdbcTemplate template;
    private final AutoRowMapper rowMapper = new AutoRowMapper();

    public List<Auto> getAll() {
        return template.query("SELECT id, model, vin, regNumber, ownerId FROM autos ORDER BY id",
                rowMapper);
    }

    public Auto getById(long id) {
        return template.queryForObject("SELECT id, model, vin, regNumber, ownerId FROM autos WHERE id = :id",
                Map.of("id", id),
                rowMapper);
    }

    public Auto save(Auto item) {
        if (item.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update("INSERT INTO autos (model, vin, regNumber, ownerId) VALUES (:model, :vin, :regNumber, :ownerId)",
                    new MapSqlParameterSource(Map.of(
                            "model", item.getModel(),
                            "vin", item.getVin(),
                            "regNumber", item.getRegNumber(),
                            "ownerId", item.getOwnerId()
                    )),
                    keyHolder);
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }

        template.update("UPDATE autos SET model=:model, vin=:vin, regNumber=:regNumber, ownerId=:ownerId WHERE id=:id",
                Map.of(
                        "id", item.getId(),
                        "model", item.getModel(),
                        "vin", item.getVin(),
                        "regNumber", item.getRegNumber(),
                        "ownerId", item.getOwnerId()
                )
        );
        return getById(item.getId());
    }

    public Auto removeById(long id) {
        Auto item = getById(id);
        template.update("DELETE FROM autos WHERE id=:id",
                Map.of("id", item.getId()));
        return item;
    }
}