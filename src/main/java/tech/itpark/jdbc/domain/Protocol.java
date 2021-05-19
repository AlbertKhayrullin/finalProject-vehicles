package tech.itpark.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Protocol {
    private long id;
    private String model;
    private String vin;
    private String regNumber;
    private String name;
    private String dateOfBirth;
    private String drivingLicence;
    private String article;
    private int amountFine;
    private String urlPhoto;
    private boolean paid;

}
