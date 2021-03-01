package Rest.Assured;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class EverythingNew {
	
	@Test
	
	public void ground() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		
		String response=given().log().all().queryParam("key", "qaclick123").body(Json.change())
		.when().post("/maps/api/place/add/json").then().log().all().extract().response().asString();
		
		JsonPath path = new  JsonPath(response);
		String place =path.get("purchaseAmount");
		
		System.out.println("place is "+place);
		
		
		System.out.println("Now starts get");
		
		//GET
		
		given().queryParam("key", "qaclick").when().get("maps/api/place/get/json?purchaseAmount="+place+"&key=qaclick123").then().log().all();
		
		
		
	}

}
