package no.kdrs.grouse;

import no.kdrs.grouse.model.Functionality;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles()
public class ClientIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createClient() {

        Functionality functionality = new Functionality();
        functionality.setFunctionalityNumber("99");
        functionality.setDescription("description");
        functionality.setTitle("title");

        ResponseEntity<Functionality> responseEntity =
                restTemplate.postForEntity("/funksjon", functionality, Functionality.class);
        Functionality client = responseEntity.getBody();
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("description", client.getDescription());
    }
}
