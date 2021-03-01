package Rest.Assured;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Run {
	
	@Test
	public void first() {
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		String s=given().log().all().queryParam("key","qaclick123").body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "")
		.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("status",equalTo("OK")).extract().asString();
		
		JsonPath js = new JsonPath(s);
		
		String json=js.get("place_id");
		
		System.out.println(json);
		
		
		//GET
		
		
		
		String nice=given().queryParam("key","qaclick123").queryParam("plac",json)
				.when().get("/maps/api/place/get/json?place_id=plac&&key=qaclick123")
				.then().log().all().assertThat().body("name",equalTo("Frontline house")).extract().response().asString();
				
				System.out.println(nice);
				
		
		
		//PUT
		
		String putted=given().queryParam("key", "qaclick123").body("{\r\n"
				+ "\"place_id\":\""+json+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		
		.when().put("maps/api/place/update/json?place_id="+json+"&key=qaclick123")
		.then().log().all().extract().response().asString();
		
		
		System.out.println(putted);
		
		System.out.println("Now begins new Get");
		
		//GET
		
		String good=given().queryParam("key", "qaclick123")
		.when().get("maps/api/place/get/json?place_id="+json+"&key=qaclick123")
		.then().log().all().extract().response().asString();
		
		JsonPath path = new JsonPath(good);
		
		String cool=path.get("address");
		
		System.out.println(cool);
		
	}
}