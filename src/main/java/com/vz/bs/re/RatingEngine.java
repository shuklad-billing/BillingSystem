package main.java.com.vz.bs.re;


import java.sql.Connection;



public class RatingEngine {
	Connection con;
	ICMBBill cmbBill = new CMBBill();
	IWirelessBill wirelessBill = new WirelessBill();
	IVESBill vesBill = new VESBill();
	double usage;
	
	
	public void rating(){
	
	}
}

/*
	public static void main(String[] args) {
		RatingEngine re = new RatingEngine();
		RatingEngine.PullProfile PP = re.new PullProfile();
		PP.puller();
	}
*/