package main.java.com.vz.bs.exports;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ordermanagement")
public class OrderManagement {
    @GET
   @Produces(MediaType.TEXT_HTML)
   public String sendToOrderManagement(){
       PortfolioBillDateJson request=new PortfolioBillDateJson();
	   return request.sendOrderManagementJson("C", "20-AUG-2015");
     
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

}