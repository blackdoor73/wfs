package com.sakhi.robot.revenue;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sakhi.calc.revenue.CommissionCalculator;

public class WfsRfKwLib {
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
	private CommissionCalculator mCalc;

	public void RegisterNewClient(String date, String member, double value) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
		  Date date1= formatter.parse(date);  
		  mCalc.RegisterNewClient(date1, member, "Dummy", value);
		} catch (Exception e) {}
	}

	public double GetComissionIndividual( String regmonth,String member) {
		double commision;
		mCalc.calculate();
		commision = mCalc.getCommision(member, regmonth);

		return commision;
	}

	public void StartNewSession() {
		this.mCalc = new CommissionCalculator();
	}
	
	public String GetContext(){
//		mCalc.GetContext;
		return mCalc.GetContext();
	}
}



