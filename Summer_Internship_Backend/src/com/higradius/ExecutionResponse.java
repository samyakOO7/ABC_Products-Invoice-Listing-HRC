package com.higradius;

public class ExecutionResponse {
private String custname;
private String custnumber;
private String invoice;
private String amt;
private String duedate;
private String cleardate;

private String notes;

public String getCustname() {
	return custname;
}
public void setCustname(String custname) {
	this.custname = custname;
}
public String getCustnumber() {
	return custnumber;
}
public void setCustnumber(String custnumber) {
	this.custnumber = custnumber;
}
public String getInvoice() {
	return invoice;
}
public void setInvoice(String invoice) {
	this.invoice = invoice;
}
public String getAmt() {
	return amt;
}
public void setAmt(String amt) {
	this.amt = amt;
}
public String getDuedate() {
	return duedate;
}
public void setDuedate(String duedate) {
	this.duedate = duedate;
}
public String getCleardate() {
	return cleardate;
}
public void setCleardate(String cleardate) {
	this.cleardate = cleardate;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}




}
