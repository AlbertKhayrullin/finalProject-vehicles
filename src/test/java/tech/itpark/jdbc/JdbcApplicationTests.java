package tech.itpark.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class JdbcApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception{
        mockMvc.perform(get("/autos/1"))
                .andExpect(content()
                        .json("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"model\": \"BMW\",\n" +
                        "  \"yearOfIssue\": 2010,\n" +
                        "  \"regNumber\": \"b005mw_116\",\n" +
                        "  \"ownerId\": 1\n" +
                        "}"))
        ;
        mockMvc.perform(get("/protocols/b005mw_116?paid=false")
                .queryParam("regNumber", "b005mw_116")
                .queryParam("paid", "false"))
                .andExpect(content()
                        .json("[\n" +
                                "  {\n" +
                                "    \"id\": 6,\n" +
                                "    \"model\": \"BMW\",\n" +
                                "    \"yearOfIssue\": 2010,\n" +
                                "    \"regNumber\": \"b005mw_116\",\n" +
                                "    \"name\": \"Ivanov\",\n" +
                                "    \"yearOfBirth\": 1990,\n" +
                                "    \"drivingLicence\": \"1601984257\",\n" +
                                "    \"article\": \"12.9.2\",\n" +
                                "    \"amountFine\": 500,\n" +
                                "    \"urlPhoto\": \"/media/f52b0c75-57c1-4f35-ad6d-6fa518d69bc7.jpeg\",\n" +
                                "    \"paid\": false\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"id\": 9,\n" +
                                "    \"model\": \"BMW\",\n" +
                                "    \"yearOfIssue\": 2010,\n" +
                                "    \"regNumber\": \"b005mw_116\",\n" +
                                "    \"name\": \"Ivanov\",\n" +
                                "    \"yearOfBirth\": 1990,\n" +
                                "    \"drivingLicence\": \"1601984257\",\n" +
                                "    \"article\": \"12.9.4\",\n" +
                                "    \"amountFine\": 2500,\n" +
                                "    \"urlPhoto\": \"/media/f52b0c75-57c1-4f35-ad6d-6fa518d69bc7.jpeg\",\n" +
                                "    \"paid\": false\n" +
                                "  }\n" +
                                "]"))
        ;
    }
}
