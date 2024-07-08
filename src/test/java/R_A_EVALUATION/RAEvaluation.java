package R_A_EVALUATION;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class RAEvaluation {
  
	//String accessToken = "ed4d1da4facf30118f4df4d90462a0ccf41e7aa160948863318443104d5930f2" ;
	@Test(enabled = true)
	public void Simple_Books_API() {
		Response rep = given().get("https://crypto-wallet-server.mock.beeceptor.com");
		int statuscodevar = rep.getStatusCode();
		Assert.assertEquals(statuscodevar,200);
		
	}
	
	@Test  (enabled = false)
	public void Register_a_user_and_create_his_her_wallet() {
		
		JSONObject js = new JSONObject();
		
		js.put("username", "user123");
		js.put("password", "securepassword");
		js.put("email", "user@example.com");
		
		given().body(js.toJSONString()).when().post("https://json-placeholder.mock.beeceptor.com/api/v1/register").then().statusCode(200).log().all();		
	
	}
	
	@Test  (enabled = false)
	public void Login_the_user_and_generate_a_session_token() {
		
		JSONObject js = new JSONObject();
		
		js.put("username", "user123");
		js.put("password", "securepassword");
		
		
		given().body(js.toJSONString()).when().post("https://json-placeholder.mock.beeceptor.com/api/v1/login").then().statusCode(200).log().all();		
	
	}
	@Test  (enabled = false)
	public void Retrieve_the_wallet_balance () {
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/balance").then().statusCode(200).log().all();
	}
	
	@Test  (enabled = false)
	public void List_all_the_transactions_done_by_the_user () {
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();
	}
	@Test  (enabled = true)
	public void Transfer_5_ETH_to_a_recipient() {
		
		JSONObject js = new JSONObject();
		
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", 5.0);
		js.put("currency", "ETH");
		
		given().body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();		
	
	}
	@Test  (enabled = true)
	public void Calculate_transaction_fees_and_return_estimated_cost() {
		
		JSONObject js = new JSONObject();
		
		js.put("amount", 2.5);
		js.put("currency", "BTC");
		js.put("recipient_address", "0x1234567890ABCDEF");
		
		given().body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transaction_fee").then().statusCode(200).log().all();		
	
	}
	
	@Test  (enabled = true)
	public void Get_an_object_with_all_available_currency_exchange_rates () {
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/exchange_rates").then().statusCode(200).log().all();
	}
	
	
	
	
	
}
