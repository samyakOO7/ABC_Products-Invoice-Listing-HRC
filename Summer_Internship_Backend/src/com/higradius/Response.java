package com.higradius;

public class Response {
private String custname;
private String custnumber;
private String invoice;
private String amt;
private String duedate;
private String cleardate;
private String notes;

public String getcust_name() {
	return custname;
}
public String getcust_number() {
	return custnumber;
}
public String getinvoice_id() {
	return invoice;
}
public String getAmount() {
	return amt;
}
public String getdue_date() {
	return duedate;
}
public String getclear_date() {
	return cleardate;
}
public String get_notes() {
	return notes;
}



public void setcust_name(String custname) {
	this.custname = custname;
}
public void setcust_number(String custnumber) {
	this.custnumber = custnumber;
}

public void setinvoice_id(String invoice) {
	this.invoice = invoice;
}

public void setAmount(String amt) {
	this.amt = amt;
}

public void setdue_date(String duedate) {
	this.duedate = duedate;
}

public void setclear_date(String cleardate) {
	this.cleardate = cleardate;
}

public void set_notes(String notes) {
	this.notes = notes;
}







}
