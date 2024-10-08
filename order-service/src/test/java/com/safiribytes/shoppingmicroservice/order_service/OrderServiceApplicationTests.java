package com.safiribytes.shoppingmicroservice.order_service;

import com.safiribytes.shoppingmicroservice.order_service.stubs.InventoryClientStub;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import io.restassured.RestAssured;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

/**
 * INTERGRATION TESTING.
 */
@Import(TestcontainersConfiguration.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0) // CMD + click on AutoConfigureWireMock then download service. // 0 will assign random port
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void shouldSubmitOrder(){
		String submitOrderJson = """
				{
				    "skuCode": "pixel_8",
				    "price": "100000",
				    "quantity": 100
				}
				""";

		InventoryClientStub.stubInventoryCall("pixel_8", 100);

		var responseBodyString = 	RestAssured.given()
				.contentType("application/json")
				.body(submitOrderJson)
				.when()
				.post("/api/order")
				.then()
				.log().all()
				.statusCode(201)
				.extract()
				.body().asString();


//		assertThat(responseBodyString, Matchers.is("Order placed successfully."));
		assertThat(responseBodyString).matches("Order placed successfully.");
	}

}
