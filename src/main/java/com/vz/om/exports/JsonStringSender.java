package main.java.com.vz.om.exports;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/profile")
public class JsonStringSender {
    @GET
   @Produces(MediaType.TEXT_HTML)
   public String sendProfile(){
    
		String jsonString="{\"lineofbusiness\":\"ves|vzw|cmb\",\"customerdetails\":{\"customerid\":\"VZ/1234\",\"fname\":\"suresh\",\"lname\": \"siddharth\",\"customerstatus\":\"active|suspended|disconnected|delinquent\",\"billstartdate\":\"12-APR-2015\",\"connectionaddress\":{\"streetname\":\"10, mg road\",\"zipcode\":560102,\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\"},\"email\":\"suresh.siddharth@gmail.com\",\"contactnumber\":\"9500689870\",\"dateofbirth\":\"24-mar-1993\"},\"existingsnp\":{\"services\":[{\"servicecode\":\"ves1523\",\"servicename\":\"pip\",\"serviceid\":3456789,\"servicedate\":\"14-APR-2000\"}],\"products\":[{\"productcode\":\"ves123\",\"productname\":\"instrument\",\"productid\":123465789,\"quantity\":{\"max\":100,\"current\":50}}]},\"orderhistory\":[{\"orderid\":\"O/6728\",\"dateoforder\":\"30-JUN-2014\",\"duedate\":\"10-JUL-2014\",\"orderstatus\":\"new|outProvisioning|inProvisioning|complete|cancelled\"}]}],\"contractdetails\":[{\"contractid\":\"C/2345\",\"modeltype\":\"transactional|rtb\",\"classofservice\":\"platinum|gold|silver|bronze|normal\",\"fromdate\":\"18-aug-2015\",\"todate\":\"18-aug-2016\",\"discountpercentage\":10}]}";		
		return jsonString;
     
   }	

    
    
   public static void main(String args[])
   {
	   JsonStringSender fr=new JsonStringSender();
	   System.out.println(fr.sendProfile());
	  
   }
}