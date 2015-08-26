package main.java.com.vz.bs.re;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class VESBill implements IVESBill {
	Connection con;

	/*
	 * ,int services, double discount, int minProducts, int maxProducts,
	 * contract to an end ~ penalty=2(calc for max-min),
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vz.bs.re.IVESBill#rateOnUsage(double, int, int, int, double)
	 */
	@Override
	public double calculateRateOnUsage(double usage, int billingPeriod, int daysInMonth) {
		float rate = (float) 14.5;
		double usageAmount;
		if (billingPeriod < daysInMonth) {
			rate = billingPeriod * (rate / daysInMonth);
			usageAmount = usage * (rate / 100);
		} else {
			usageAmount = usage * (rate / 100);
		}
		return usageAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vz.bs.re.IVESBill#taxRates(int, int, int, int)
	 */
	@Override
	public double calculateTaxRates(int product_id, int state_code, int billingPeriod,
			int DaysInMonth) {
		int taxId = 0;
		double taxTotal = 0, taxRate = 0;
		try {
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select TAX_ID,TAX_RATE,SUM(TAX_RATE) as TAX_TOTAL from TAX_MASTER where PRODUCT_ID="
							+ product_id + " or STATE_CODE=" + state_code);
			while (rs.next()) {
				taxId = rs.getInt("TAX_ID");
				taxRate = rs.getDouble("TAX_RATE");
				taxTotal = rs.getDouble("TAX_TOTAL");
			}
			if (billingPeriod < DaysInMonth) {
				taxTotal = billingPeriod * (taxTotal / DaysInMonth);
			}
			System.out.println(taxId + "\t" + taxRate + "\t" + taxTotal);
			return taxTotal;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taxRate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vz.bs.re.IVESBill#nonRecurringCharges()
	 */
	@Override
	public double calculateNonRecurringCharges() {
		double charges = 5000;
		return charges;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vz.bs.re.IVESBill#monthlyRecurringCharges()
	 */
	@Override
	public double calculateMonthlyRecurringCharges() {
		double charges = 5000;
		return charges;
	}

	@Override
	public double calculateDiscount(double discount,double amount) {
		amount=amount-(amount*(discount/100));
		return amount;
	}

	@Override
	public double calculatePenalty(int minProducts, int maxProducts) {
		double penaltyAmount;
		if(maxProducts!=minProducts)
		{
			penaltyAmount=2*(maxProducts-minProducts);
			return penaltyAmount;
			
		}
		else 
			return 0;
	}

}