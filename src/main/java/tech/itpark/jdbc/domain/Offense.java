package tech.itpark.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Offense {
    private long Id;
    private String regNumber;                              // детали нарушений ПДД
    private String article;
    private int amountFine;
    private String urlPhoto;
    private boolean paid;
}
