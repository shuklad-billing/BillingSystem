package main.java.com.vz.om.exports;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
public class AccountsJsonStringSender {
    @GET
   @Produces(MediaType.TEXT_PLAIN)
   public String sendProfile(){
    
		String jsonString="{\"accountNo\":[\"2345\",\"1287\",\"1209\"],\"totalNumOfAcc\":\"3\"}";		
		return jsonString;
     
   }	

   public static void main(String args[])
   {
	   AccountsJsonStringSender fr=new AccountsJsonStringSender();
	   System.out.println(fr.sendProfile());
	  
   }
}