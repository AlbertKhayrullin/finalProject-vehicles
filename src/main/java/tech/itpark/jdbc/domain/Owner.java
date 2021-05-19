package tech.itpark.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Owner {
    private long id;                 // база собственников
    private String name;
    private String dateOfBirth;
    private String drivingLicence;

}
