package Rest.Assured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Parsing {
	
	@Test
	public void start() {
		
		JsonPath parse = new JsonPath(Json.change());
		
		int sum =0;
		
		String value=parse.getString("dashboard.website");
		
		System.out.println(value);
		
		int course=parse.getInt("courses.size()");
		
		for(int i=0;i<course;i++) {
			
			System.out.println(parse.get("courses["+i+"].title"));
		}
		
		for(int i=0;i<course;i++) {
			
			sum = sum + parse.getInt("courses["+i+"].price");
		}
		
		System.out.println(sum);
		
		
	}

}
