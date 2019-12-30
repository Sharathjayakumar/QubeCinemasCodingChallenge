package com.qube.postoffice.api.testcases;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qube.postoffice.base.BaseClass;
import com.qube.postoffice.util.ExcelUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;


public class SearchByValidPINCode extends BaseClass {
	
	
	@Test(dataProvider = "getData")
	public void searchWithValidPINCodeTest(String PinCode,String Name,String BT,String DS,String Cir, String Dis,String Div,String Reg,String Bl,String st,String cou ) {
		
		/*RestAssured.baseURI ="https://api.postalpincode.in";
		given().pathParam("PINCODE", "600007").
		when().
		get("/pincode/{PINCODE}").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		and().body("PostOffice[0].Name", hasItems("Vepery")).
		and().body("PostOffice[0].BranchType", hasItems("Sub Post Office")).
		and().body("PostOffice[0].DeliveryStatus", hasItems("Delivery")).
		and().body("PostOffice[0].Circle", hasItems("Tamilnadu")).
		and().body("PostOffice[0].District", hasItems("Chennai")).
		and().body("PostOffice[0].Division", hasItems("Chennai City North")).
		and().body("PostOffice[0].Region", hasItems("Chennai Region")).
		and().body("PostOffice[0].Block", hasItems("Perambur Purasawalkam")).
		and().body("PostOffice[0].State", hasItems("Tamil Nadu")).
		and().body("PostOffice[0].Country", hasItems("India")).
		and().body("PostOffice[0].Pincode", hasItems("600007"));
	}*/
		RestAssured.baseURI =prop.getProperty("HOST");
		
		given().pathParam("PINCODE", PinCode).
		when().
		get("/pincode/{PINCODE}").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		and().body("Status", hasItems("Success")).
		and().body("PostOffice[0].Name", hasItems(Name)).
		and().body("PostOffice[0].BranchType", hasItems(BT)).
		and().body("PostOffice[0].DeliveryStatus", hasItems(DS)).
		and().body("PostOffice[0].Circle", hasItems(Cir)).
		and().body("PostOffice[0].District", hasItems(Dis)).
		and().body("PostOffice[0].Division", hasItems(Div)).
		and().body("PostOffice[0].Region", hasItems(Reg)).
		and().body("PostOffice[0].Block", hasItems(Bl)).
		and().body("PostOffice[0].State", hasItems(st)).
		and().body("PostOffice[0].Country", hasItems(cou)).
		and().body("PostOffice[0].Pincode", hasItems(PinCode));
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		Object[][] data = ExcelUtil.getTestData(0);
		return data;
		
	}
}