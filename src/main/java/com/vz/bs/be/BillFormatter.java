package main.java.com.vz.bs.be;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class BillFormatter 
{
	String generatedBill;
		public BillFormatter(String billData[])
		{
			JsonObjectBuilder Bill_Details=Json.createObjectBuilder();
			Bill_Details.add("Name",billData[0]);
			Bill_Details.add("Primary Phone",billData[1]);
			Bill_Details.add("Address", billData[2]);
			Bill_Details.add("AccountNumber", billData[3]);
			Bill_Details.add("BillDate", billData[4]);
			
			JsonObjectBuilder Account_Summary=Json.createObjectBuilder();
			JsonObjectBuilder Details_of_current_charges=Json.createObjectBuilder();
			
			
			JsonObjectBuilder Previous_Period=Json.createObjectBuilder();
			Previous_Period.add("PreviousBalance", billData[5]);
			Previous_Period.add("PaymentReceived", billData[6]);
			Previous_Period.add("BalanceForward", billData[7]);
			Previous_Period.add("PaymentDate", billData[8]);
			
			JsonObjectBuilder Service_bundle=Json.createObjectBuilder();
			Service_bundle.add("Price",billData[9]);
			Service_bundle.add("Servicefrom",billData[10]);
			Service_bundle.add("Serviceto",billData[11]);
			
			JsonObjectBuilder Current_Charges=Json.createObjectBuilder();
			Current_Charges.add("FIOSTV_Internet_and_Phone_Bundle", Service_bundle);
			Current_Charges.add("Additional_Services_and_Equipment", billData[12]);
			Current_Charges.add("Fees_and_Other_Charges", billData[13]);
		
			JsonObjectBuilder Bundle_Price=Json.createObjectBuilder();
			Bundle_Price.add("Price",billData[14]);
			Bundle_Price.add("Service_from",billData[15]);
			Bundle_Price.add("Service_to",billData[16]);
			
			JsonObjectBuilder Bundle_Details=Json.createObjectBuilder();
			Bundle_Details.add("Bundle_Price",Bundle_Price);
			
			
			
			
			JsonObjectBuilder Taxes_and_govt_fees=Json.createObjectBuilder();
			Taxes_and_govt_fees.add("Federal_excise Tax",billData[17]);
			Taxes_and_govt_fees.add("State_sales_tax",billData[18]);
			Taxes_and_govt_fees.add("911_system_emerg_resp_fee", billData[19]);
			
			JsonObjectBuilder Verizon_surcharges=Json.createObjectBuilder();
			Verizon_surcharges.add("Federal_Universal_Service",billData[20]);
			Verizon_surcharges.add("Regularity_recovery_fee",billData[21]);
			Verizon_surcharges.add("VLD_CCRC", billData[22]);
			Verizon_surcharges.add("Federal_Subscriber_line_and_access",billData[23]);
			Verizon_surcharges.add("Video_Franchise_fee",billData[24]);
			Verizon_surcharges.add("VLD_long_distance_Administrative_charge", billData[25]);
			Verizon_surcharges.add("CATV_Universal_access_fund",billData[26]);
			Verizon_surcharges.add("Regional_Sports_Network_fee",billData[27]);
			Verizon_surcharges.add("FIOS_TV_Broadcast_fee", billData[28]);
						
			
			JsonObjectBuilder Fees_and_other_charges=Json.createObjectBuilder();
			Fees_and_other_charges.add

("Taxes_and_Governmental_fees_and_Surcharges",Taxes_and_govt_fees);
			Fees_and_other_charges.add

("Verizon_surcharges_and_fees",Verizon_surcharges);
			Fees_and_other_charges.add("Subtotal", billData[29]);
			
			JsonObjectBuilder Online_Backup_and_Sharing=Json.createObjectBuilder();
			Online_Backup_and_Sharing.add("Price",billData[30]);
			Online_Backup_and_Sharing.add("Service_from",billData[31]);
			Online_Backup_and_Sharing.add("Service_to",billData[32]);
			
			JsonObjectBuilder Services=Json.createObjectBuilder();
			Services.add("Online_Backup_and_Sharing",Online_Backup_and_Sharing);
			
			
			JsonObjectBuilder Set_top_box=Json.createObjectBuilder();
			Set_top_box.add("Price",billData[33]);
			Set_top_box.add("Service_from",billData[34]);
			Set_top_box.add("Service_to",billData[35]);
			
			JsonObjectBuilder DVR=Json.createObjectBuilder();
			DVR.add("Price",billData[36]);
			DVR.add("Service_from",billData[37]);
			DVR.add("Service_to",billData[38]);
			
			JsonObjectBuilder Equipment=Json.createObjectBuilder();
			Equipment.add("Set_Top_Box",Set_top_box);
			Equipment.add("HD_MultiRoom_DVR",DVR);
						
			JsonObjectBuilder Additional_Services=Json.createObjectBuilder();
			Additional_Services.add("Services",Services);
			Additional_Services.add("Equipment",Equipment);
			Additional_Services.add("Subtotal",billData[39]);
			
					
			Account_Summary.add("Previous_Period",Previous_Period);
			Account_Summary.add("Current_Charges",Current_Charges);
			
			Details_of_current_charges.add

("Fios_TV_Internet_and_Phone_Bundle",Bundle_Details);
			Details_of_current_charges.add

("Additional_Services_and_Equipment",Additional_Services);
			Details_of_current_charges.add("Fees_and_other_charges", 

Fees_and_other_charges);
			
			Bill_Details.add("Account_Summary",Account_Summary);
			Bill_Details.add("Total_Due_by_Date",billData[40]);
			Bill_Details.add("Details_of_Current_Charges",Details_of_current_charges);
			Bill_Details.add("Total_Due" , billData[41]);
			
			JsonObject jo=Bundle_Price.build();
			jo=Online_Backup_and_Sharing.build();
			jo=Set_top_box.build();
			jo=DVR.build();
			
			jo=Taxes_and_govt_fees.build();
			jo=Verizon_surcharges.build();
			
			
			jo=Bundle_Details.build();
			
			jo=Services.build();
			jo=Equipment.build();
			
			jo=Additional_Services.build();
			jo=Fees_and_other_charges.build();
			
				
			
			jo=Service_bundle.build();
			jo=Current_Charges.build();
			jo=Previous_Period.build();
			jo=Account_Summary.build();
			
			
			
		
			jo=Bill_Details.build();
			
			
		/*	Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(jo);*/
						
			generatedBill=jo.toString();

		}
		
		public String getGeneratedBill()
		{
			return generatedBill;
		}
		/*public static void main(String[] args) 
		{
			String a[]=new String[40];
			for(int i=0;i<40;i++)
			a[i]="DaVinci";
			BillFormatter bf=new BillFormatter(a);
			System.out.println(bf.getGeneratedBill());
		}
*/
}
		