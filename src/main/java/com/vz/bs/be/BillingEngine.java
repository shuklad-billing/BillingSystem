package main.java.com.vz.bs.be;

import java.io.StringReader;
import java.sql.ResultSet;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import main.java.com.vz.bs.helper.SQLHelper;
import main.java.com.vz.bs.puller.JsonGet;
import main.java.com.vz.bs.re.RatingEngine;


public class BillingEngine {

	String jsonCreationString[]=new String[40];

		public void jsonExtractor() {
			JsonGet jg=new JsonGet();
			String jsonString = jg.getJsonString();
			JsonReader reader=Json.createReader(new StringReader(jsonString));
			JsonObject jsonObj=reader.readObject();
			//System.out.println(json.get("lineofbusiness"));


			System.out.println(jsonObj.toString());
		}
	
	public void toBillFormatter(){
		jsonCreationString[0]="Sagga";
		for(int i=0;i<40;i++)
		jsonCreationString[i]="DaVinci";
		BillFormatter billFormatter=new BillFormatter(jsonCreationString);
		System.out.println(billFormatter.getGeneratedBill());
	}
	
	public void calculateBill() {
		double billedAmount=0;
		double amountReceived=0;
		double outstandingAmount=0;
		BillingEngine be = new BillingEngine();
		SQLHelper sqlHelp=new SQLHelper();
		@SuppressWarnings("unused")
		RatingEngine re = new RatingEngine();
		
		int accountNumber = 0;
		try {
			ResultSet rs=sqlHelp.SELECT( "PAYMENTS_SUMMARY i, PAYMENTS_OUTSTANDING_SUMMARY j", "i.BILLED_AMOUNT, i.AMOUNT_RECEIVED,j.OUTSTANDING_AMOUNT", "i.ACCOUNT_NUMBER="+accountNumber+"and j.ACCOUNT_NUMBER="+accountNumber);
			while (rs.next()) {
				outstandingAmount=rs.getDouble("OUTSTANDING_AMOUNT");
				billedAmount = rs.getDouble("BILLED_AMOUNT") + outstandingAmount;
				amountReceived = rs.getDouble("AMOUNT_RECEIVED");
			}
			outstandingAmount=billedAmount-amountReceived;
			sqlHelp.UPDATE("payments_outstanding_summary", "outstanding_amount ="+outstandingAmount, "account_number="+accountNumber);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void billing(){
// to get from sent box
		String portfolio;
	/*	if(portfolio=="C")
			
		else if(portfolio=="V")
		
		else if(portfolio=="W")
			
		else 
			System.out.println("error");
*/
	}
	
	public static void main(String[] args) {
		BillingEngine be=new BillingEngine();
	//	be.toBillFormatter();
		be.jsonExtractor();
		
		
	}
}
