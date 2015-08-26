package main.java.com.vz.bs.exports;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/selfservice")
public class SelfService {
    @GET
   @Produces(MediaType.TEXT_HTML)
   public String sendFinance(){
    
    	return "Self Service JSON";
     
   }	
   
//   @GET
//   @Path("/finance")
//   @Produces(MediaType.TEXT_HTML)
//   public String getMys(){
//     
//      return "<html><body><h1>My Users</h1></body></html>";
//   }	
//   
//   @POST
//	
//   @Path("/send")
//
//   @Consumes(MediaType.APPLICATION_JSON)
//
//   public String consumeJSON( String student ) {
//	   
//	return student;
//			
//
//   }
   public static void main(String args[])
   {
	   
	  
   }
}