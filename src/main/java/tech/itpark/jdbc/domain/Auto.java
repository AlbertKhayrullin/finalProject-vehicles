package tech.itpark.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Auto {             // база зарегистрированных средств передвижения
    private long id;
    private String model;
    private String vin;
    private String regNumber;
    private long ownerId;

}
