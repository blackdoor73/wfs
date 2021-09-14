package com.sakhi.robot.revenue;

import org.hibernate.Session;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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

	public double GetComissionIndividual(String client, String month) {
		double commision;
		mCalc.calculate();
		commision = mCalc.getCommision(client, month);

		return commision;
	}

	public void StartNewSession() {
		this.mCalc = new CommissionCalculator();
	}
}
