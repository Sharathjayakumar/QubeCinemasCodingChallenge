package com.qube.postoffice.api.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qube.postoffice.base.BaseClass;
import com.qube.postoffice.util.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SearchByInValidBranchName extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void searchWithInValidPINCodeTest(String branch, String status, String message) {
		RestAssured.baseURI =prop.getProperty("HOST");
		given().pathParam("POSTOFFICEBRANCHNAME", branch).
		when().
		get("/postoffice/{POSTOFFICEBRANCHNAME}").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		and().body("Status", hasItems(status)).
		and().body("Message", hasItems(message));
		
		
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		Object[][] data = ExcelUtil.getTestData(3);
		return data;
		
	}
	
	
	
	
	

}
