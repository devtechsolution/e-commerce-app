package org.as.devtechsolution.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@LocalServerPort
	private Integer port;
	@Autowired
	private TestcontainersConfiguration testcontainersConfiguration;



	@BeforeEach
	void setup(){
		RestAssured.baseURI= "http://localhost";
		RestAssured.port= this.port;
		testcontainersConfiguration.mongoDbContainer().start();

	}

	@Test
	void shouldCreateProduct() {

		String requestBody= """
				{
				    "name": "Dell g15 8885",
				    "description": "Dell gaming laptop",
				    "skuCode": "0003",
				    "price": 1200000
				  }
				
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("Dell g15 8885"))
				.body("description", Matchers.equalTo("Dell gaming laptop"))
				.body("price", Matchers.equalTo(1200000));

	}

}
