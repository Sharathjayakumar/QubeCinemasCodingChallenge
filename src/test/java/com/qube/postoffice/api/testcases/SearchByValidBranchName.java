package com.qube.postoffice.api.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qube.postoffice.base.BaseClass;
import com.qube.postoffice.util.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SearchByValidBranchName extends BaseClass{

	@Test(dataProvider = "getData")
	public void searchWithValidBranchTest(String branchName,String BT,String DS,String Cir, String Dis,String Div,String Reg,String st,String cou, String pinCode ) {
		

		RestAssured.baseURI =prop.getProperty("HOST");
		
		given().pathParam("POSTOFFICEBRANCHNAME", branchName).
		when().
		get("/postoffice/{POSTOFFICEBRANCHNAME}").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		and().body("Status", hasItems("Success")).
		and().body("PostOffice[0].Name", hasItems(branchName)).
		and().body("PostOffice[0].BranchType", hasItems(BT)).
		and().body("PostOffice[0].DeliveryStatus", hasItems(DS)).
		and().body("PostOffice[0].Circle", hasItems(Cir)).
		and().body("PostOffice[0].District", hasItems(Dis)).
		and().body("PostOffice[0].Division", hasItems(Div)).
		and().body("PostOffice[0].Region", hasItems(Reg)).
		and().body("PostOffice[0].State", hasItems(st)).
		and().body("PostOffice[0].Country", hasItems(cou)).
		and().body("PostOffice[0].Pincode", hasItems(pinCode));
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		Object[][] data = ExcelUtil.getTestData(2);
		return data;
		
	}
	
	
}
