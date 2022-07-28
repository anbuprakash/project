package com.smail.page;

public class SmailData {
	String fname,lname,smail,spass,scpass,smob,sremail;
 String	to,cc,bcc,sub,text,file;
 SmailData(String to,String cc,String bcc,String sub,String text,String file)
 {
	this.to=to;
	this. cc=cc;
	this.bcc=bcc;
	this. sub=sub;
	this. text=text;
	this. file =file;
 }
 public String getto()
 {
	 return to;
 }
 public String getcc()
 {
	 return cc;
 }
 public String getbcc()
 {
	 return bcc;
 }
 public String getsub()
 {
	 return sub;
 }
 public String gettext()
 {
	 return text;
 }
 public String getfile()
 {
	 return file;
 }

}
