package com.higradius;

public class EditResponse {

private String invoice;
private String amt;

private String notes;


public String getNotes() {
	return notes;
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
public void setNotes(String notes) {
	this.notes = notes;
}




}
