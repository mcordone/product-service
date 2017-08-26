import com.commerce.product.config.ProductConfig;
import com.commerce.product.domain.Product;
import config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestConfig.class)
//@ContextConfiguration(classes = TestConfig.class)
public class ProductResourceIT {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Test
    public void testGetProductByIdResource(){
        ResponseEntity<Product> response = restTemplate.getForEntity("products/3", Product.class);

        Product product = response.getBody();
        assertThat(product.getName()).isEqualToIgnoringCase("roduct-test--159281830");
    }
}
