package tech.itpark.jdbc.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.jdbc.domain.Offense;
import tech.itpark.jdbc.mapper.OffenseRowMapper;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component

public class OffenseManager {
    private final NamedParameterJdbcTemplate template;
    private final OffenseRowMapper rowMapper = new OffenseRowMapper();

    public List<Offense> getAll() {
        return template.query("SELECT id, regNumber, article, amountFine, urlPhoto, paid FROM offenses ORDER BY id",
                rowMapper);
    }


    public Offense getById(long id) {
        return template.queryForObject("SELECT id, regNumber, article, amountFine, urlPhoto, paid FROM offenses WHERE id=:id",
                Map.of("id", id),
                rowMapper);
    }

    public Offense save(Offense item) {
        if (item.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update("INSERT INTO offenses (regNumber, article, amountFine, urlPhoto, paid) VALUES (:regNumber, :article, :amountFine, :urlPhoto, :paid )",
                    new MapSqlParameterSource(Map.of(
                            "regNumber", item.getRegNumber(),
                            "article", item.getArticle(),
                            "amountFine", item.getAmountFine(),
                            "urlPhoto", item.getUrlPhoto(),
                            "paid", item.isPaid()
                            )),
                    keyHolder
                    );
             long id = keyHolder.getKey().longValue();
            return getById(id);
        }

        template.update("UPDATE offenses SET regNumber=:regNumber, article=:article, amountFine=:amountFine, urlPhoto=:urlPhoto, paid=:paid WHERE id=:id",
                Map.of(
                        "id", item.getId(),
                        "regNumber", item.getRegNumber(),
                        "article", item.getArticle(),
                        "amountFine", item.getAmountFine(),
                        "urlPhoto", item.getUrlPhoto(),
                        "paid", item.isPaid()
                )
        );
        return getById(item.getId());
    }

}