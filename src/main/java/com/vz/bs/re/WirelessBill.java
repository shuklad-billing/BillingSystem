package main.java.com.vz.bs.re;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WirelessBill implements IWirelessBill {
	Connection con;
	/* (non-Javadoc)
	 * @see com.vz.bs.re.IWirelessBill#rateOnUsage(double, int, int)
	 */
	@Override
	public double calculateRateOnUsage(double usage, int billingPeriod,
			int daysInMonth) {
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

	/* (non-Javadoc)
	 * @see com.vz.bs.re.IWirelessBill#TaxRates(int, int, int, int)
	 */
	@Override
	public double calculateTaxRates(int productId, int stateCode,
			int billingPeriod, int daysInMonth) {
		int taxId = 0;
		double taxTotal = 0, taxRate = 0;
		try {
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select TAX_ID,TAX_RATE,SUM(TAX_RATE) as TAX_TOTAL from TAX_MASTER where PRODUCT_ID="
							+ productId + " or STATE_CODE=" + stateCode);
			while (rs.next()) {
				taxId = rs.getInt("TAX_ID");
				taxRate = rs.getDouble("TAX_RATE");
				taxTotal = rs.getDouble("TAX_TOTAL");
			}
			if (billingPeriod < daysInMonth) {
				taxTotal = billingPeriod * (taxTotal / daysInMonth);
			}
			System.out.println(taxId + "\t" + taxRate + "\t" + taxTotal);
			return taxTotal;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taxTotal;
	}

	/* (non-Javadoc)
	 * @see com.vz.bs.re.IWirelessBill#nonRecurringCharges()
	 */
	@Override
	public double calculateNonRecurringCharges()
	{
		double charges=5000;
		return charges;
	}
	
	/* (non-Javadoc)
	 * @see com.vz.bs.re.IWirelessBill#monthlyRecurringCharges()
	 */
	@Override
	public double calculateMonthlyRecurringCharges()
	{
		double charges=5000;
		return charges;
	}
	
}
