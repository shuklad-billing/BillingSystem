package main.java.com.vz.bs.puller;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class CustomerInfoExtractor {
String infoArray[]=new String[42];
String jsonString="{\"lineofbusiness\":\"ves|vzw|cmb\",\"customerdetails\":{\"customerid\":\"VZ/1234\",\"fname\":\"suresh\",\"lname\": \"siddharth\",\"customerstatus\":\"active|suspended|disconnected|delinquent\",\"billstartdate\":\"12-APR-2015\",\"connectionaddress\":{ \"streetname\": \"10, mg road\",\"zipcode\":560102,\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\"},\"billingaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",      \"country\": \"india\"    },    \"email\": \"suresh.siddharth@gmail.com\",    \"contactnumber\":\"9500689870\",    \"dateofbirth\": \"24-mar-1993\"      },  \"existingsnp\": {     \"services\": [ {      \"servicecode\": \"ves1523\",      \"servicename\": \"pip\",      \"serviceid\": 3456789,      \"servicedate\": \"14-APR-2000\"    }    ],    \"products\": [ {      \"productcode\": \"ves123\",      \"productname\": \"instrument\",      \"productid\": 123465789,      \"quantity\": {\"max\":100,\"current\":50}    }    ]  },  \"orderhistory\":[{    \"orderid\": \"O/6728\",    \"dateoforder\": \"30-JUN-2014\",    \"duedate\": \"10-JUL-2014\",\"orderstatus\": \"new|outProvisioning|inProvisioning|complete|cancelled\",    \"services\": [ {\"servicecode\": \"ves1523\",      \"servicename\": \"pip\"    }    ],    \"products\": [ {      \"productcode\": \"ves123\",\"productname\": \"instrument\",      \"productid\": 123465789,\"quantity\":{\"max\":100,      \"current\":50      }    }    ]  }  ],  \"contractdetails\":[{    \"contractid\": \"C/2345\",    \"modeltype\":\"transactional|rtb\",    \"classofservice\":\"platinum|gold|silver|bronze|normal\",    \"fromdate\": \"18-aug-2015\",    \"todate\":\"18-aug-2016\",    \"discountpercentage\":10  }  ]}";		

	//public static void main(String[] args) {

public String[] getInfoArray() {
	return infoArray;
}

public void setInfoArray(String[] infoArray) {
	this.infoArray = infoArray;
}

public CustomerInfoExtractor(){

	String billdate="25-jun-2015";	
	String previousBalance="500";
	String paymentReceived="no";
	String balanceForward="400";
	String paymentDate="not paid";
	
	JsonReader reader=Json.createReader(new StringReader(jsonString));
	JsonObject json=reader.readObject();

	/*Customer Details*/

	infoArray[0]=json.getJsonObject("customerdetails").getString("fname")+" "+json.getJsonObject("customerdetails").getString("lname");
	infoArray[1]=json.getJsonObject("customerdetails").getString("contactnumber");
	infoArray[2]=json.getJsonObject("customerdetails").getJsonObject("connectionaddress").getString("streetname")+", \n"+json.getJsonObject("customerdetails").getJsonObject("connectionaddress").getString("city")+", \n"+json.getJsonObject("customerdetails").getJsonObject("connectionaddress").getString("state")+", \n"+json.getJsonObject("customerdetails").getJsonObject("connectionaddress").getString("country")+", \n"+json.getJsonObject("customerdetails").getJsonObject("connectionaddress").get("zipcode");
	infoArray[3]=json.getJsonObject("customerdetails").getString("customerid");
	infoArray[4]=billdate;
	
	/*previous period*/
	
	infoArray[5]=previousBalance;
	infoArray[6]=paymentReceived;
	infoArray[7]=balanceForward;
	infoArray[8]=paymentDate;

	/* Service block */
	
	infoArray[9]="price";
	infoArray[10]="servicefrom";
	infoArray[11]="serviceto";
	
	/*CURRENT CHARGES*/
	
	infoArray[12]=paymentDate;
	infoArray[13]=paymentDate;
	
	/* Bundle Price */
	
	infoArray[14]=paymentDate;
	infoArray[15]=paymentDate;
	infoArray[16]=paymentDate;
	
	/* Taxes */
	
	infoArray[17]=paymentDate;
	infoArray[18]=paymentDate;
	infoArray[19]=paymentDate;

	/* Surcharges */
	
	infoArray[20]=paymentDate;
	infoArray[21]=paymentDate;
	infoArray[22]=paymentDate;
	infoArray[23]=paymentDate;
	infoArray[24]=paymentDate;
	infoArray[25]=paymentDate;
	infoArray[26]=paymentDate;
	infoArray[27]=paymentDate;
	infoArray[28]=paymentDate;
	
	/* Other Charges */
	
	infoArray[29]=paymentDate;
	
	/* online Backup and Sharing */
	
	infoArray[30]=paymentDate;
	infoArray[31]=paymentDate;
	infoArray[32]=paymentDate;
	
	/* Set Top Box */
	
	infoArray[33]=paymentDate;
	infoArray[34]=paymentDate;
	infoArray[35]=paymentDate;

	/* DVR */
	
	infoArray[36]=paymentDate;
	infoArray[37]=paymentDate;
	infoArray[38]=paymentDate;

	/* Subtotal */
	
	infoArray[39]=paymentDate;

	/* Due Date */
	
	infoArray[40]=paymentDate;
	infoArray[41]=paymentDate;

	for (int j = 0; j < infoArray.length; j++) 
	System.out.println(infoArray[j]);
}



}
