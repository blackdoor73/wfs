package com.sakhi.calc.revenue;

import java.util.*;

class ClientRegistration{
	private Date date;
	private String member;
	private String client;
	private double value;
	
	ClientRegistration(Date date,String member,String client,double value){
		this.date = date;
		this.member = member;
		this.client = client;
		this.value = value;
	}
	public Date getDate() {
		return date;
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
	
}

class Commisson{
	private String member;
	private String month;
	private double value;
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
	  HashMap<String, Commisson> commisionList = new HashMap<>();
	public double CommissionCalc() {
		return 100;
	}

	public double estimatecommission() {
		double rounded = ((CommissionCalc() + 99) / 100) * 100;
		return rounded;
	}

	public void calculate() {
		//roll over the clientlist 
		// calculate monthly commission per member		
		
		// clent+"_"+month - how many entries are there
		// 
		// commisionList.put(clent+"_"+month) = 23
	}

	public double getCommision(String client, String month) 
	{
		// browse through commisionList and return where you find a matching client and month
		return 100;
	}

	public void RegisterNewClient(Date date, String member, String client, double value) {
		ClientRegistration obj = new ClientRegistration(date,member,client,value);
		clientList.add(obj);
	}
}
