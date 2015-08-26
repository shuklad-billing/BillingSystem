package main.java.com.vz.bs.puller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
@Path("/getter")
public class JsonGet {
	
		String jsonString;
		@GET
	//@Consumes(MediaType.TEXT_PLAIN)
		@Produces(MediaType.TEXT_PLAIN)

	public String JssonGet() {

			ClientConfig config = new ClientConfig();
			  Client client = ClientBuilder.newClient(config);
			  WebTarget target= client.target("http://localhost"). path("rest").path("profile");
			  // getting String data
			  jsonString=target.request(MediaType.TEXT_PLAIN).get(String.class);
			  System.out.println(jsonString);
			  // getting JSON data
//			  System.out.println(service. path('restPath').path('resourcePath').accept(MediaType.APPLICATION_XML).get(String.class));
			return "success";
}
/*
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String str()
	{
		String jsonString="{\"lineofbusiness\":\"ves|vzw|cmb\",\"customerdetails\":{\"customerid\":\"VZ/1234\",\"fname\":\"suresh\",\"lname\": \"siddharth\",\"customerstatus\":\"active|suspended|disconnected|delinquent\",\"billstartdate\":\"12-APR-2015\",\"connectionaddress\":{ \"streetname\": \"10, mg road\",\"zipcode\":560102,\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\"},\"billingaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",      \"country\": \"india\"    },    \"email\": \"suresh.siddharth@gmail.com\",    \"contactnumber\":\"9500689870\",    \"dateofbirth\": \"24-mar-1993\"      },  \"existingsnp\": {     \"services\": [ {      \"servicecode\": \"ves1523\",      \"servicename\": \"pip\",      \"serviceid\": 3456789,      \"servicedate\": \"14-APR-2000\"    }    ],    \"products\": [ {      \"productcode\": \"ves123\",      \"productname\": \"instrument\",      \"productid\": 123465789,      \"quantity\": {\"max\":100,\"current\":50}    }    ]  },  \"orderhistory\":[{    \"orderid\": \"O/6728\",    \"dateoforder\": \"30-JUN-2014\",    \"duedate\": \"10-JUL-2014\",\"orderstatus\": \"new|outProvisioning|inProvisioning|complete|cancelled\",    \"services\": [ {\"servicecode\": \"ves1523\",      \"servicename\": \"pip\"    }    ],    \"products\": [ {      \"productcode\": \"ves123\",\"productname\": \"instrument\",      \"productid\": 123465789,\"quantity\":{\"max\":100,      \"current\":50      }    }    ]  }  ],  \"contractdetails\":[{    \"contractid\": \"C/2345\",    \"modeltype\":\"transactional|rtb\",    \"classofservice\":\"platinum|gold|silver|bronze|normal\",    \"fromdate\": \"18-aug-2015\",    \"todate\":\"18-aug-2016\",    \"discountpercentage\":10  }  ]}";		
		JsonReader reader=Json.createReader(new StringReader(jsonString));
		JsonObject json=reader.readObject();
		return json.get("lineofbusiness").toString();
	}
*/	
	public String getJsonString() {
		return jsonString;
	}
	
	public static void main(String[] args) {
		JsonGet js=new JsonGet();
		//System.out.println(js.toString());
	}

}
