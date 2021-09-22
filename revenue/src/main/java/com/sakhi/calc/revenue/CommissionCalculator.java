package com.sakhi.calc.revenue;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class ClientRegistration {
	private Date date;
	private String member;
	private String client;
	private double value;

	ClientRegistration(Date date, String member, String client, double value) {
		this.date = date;
		this.member = member;
		this.client = client;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public String getMonth() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String strDate = dateFormat.format(date);
		System.out.println(strDate);
		return strDate;
	}

	public String getMember() {
		return member;
	}

	public String getClient() {
		return client;
	}

	public double getValue() {
		return value;
	}

	public String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

class Commision {
	private String member;
	private String month;
	private double value;
	private int count;

	Commision(String member, String month, double value) {
		this.member = member;
		this.month = month;
		this.value = value;
		this.count = 1;

	}

	void addCommission(double value) {
		this.value += value;
		this.count++;
	}

	public int getCount() {
		return this.count;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}

public class CommissionCalculator {
	ArrayList<ClientRegistration> clientList = new ArrayList<ClientRegistration>();
	HashMap<String, Commision> commisionList = new HashMap<>();

	public double CommissionCalc() {
		return 100;
	}

	public double estimatecommission(double value) {
		return (double)(Math.floor((value+99) / 100) * 100);
	}

	public void calculate() {
//		System.out.println(clientList.size());
		String memberkey;
		double 	comValue =0;
		for (int i = 0; i < clientList.size(); i++) {    //CHECK LATER
			ClientRegistration clientRecord = clientList.get(i);
			String member = clientRecord.getMember();
			double value = clientRecord.getValue();
			String regMonth = clientRecord.getMonth();

			memberkey = member + regMonth;
			Commision commisionRec = commisionList.get(memberkey);
			if (commisionRec != null) {
				double commPct = 10;
				if (commisionRec.getCount() == 1) {
					commPct = 7;
				}
				 comValue = value * commPct / 100;
				commisionRec.addCommission(comValue);
				commisionList.put(memberkey, commisionRec);
			} else {
				 comValue = value * 5 / 100;
				commisionRec = new Commision(member, regMonth, comValue);
				commisionList.put(memberkey, commisionRec);
			}
			
		}

	}

	public double getCommision(String member, String regMonth) {
		String memberkey;
		memberkey = member + regMonth;
		double comValue = 0;

		Commision commisionRec = commisionList.get(memberkey);
		if (commisionRec != null) {
			comValue = commisionRec.getValue();
		}
//		ClientRegistration clientRecord = clientList.get(0);
//		String member1 = clientRecord.getMember();
//		double value = clientRecord.getValue();
//		String regMonth1 = clientRecord.getMonth();
//
//		String memberkey1 = member1 + regMonth1;
		return estimatecommission(Math.ceil(comValue));
//		return comValue;
	}

	public void RegisterNewClient(Date date, String member, String client, double value) {
		ClientRegistration obj = new ClientRegistration(date, member, client, value);
		clientList.add(obj);
	}
	
	public String GetContext() {
		return "" + clientList.size();
	}
}
