package com.java.minihr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SearchForm extends ActionForm{
private String name;
private String ssNum;
private List results;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSsNum() {
	return ssNum;
}
public void setSsNum(String ssNum) {
	this.ssNum = ssNum;
}
public List getResults() {
	return results;
}
public void setResults(List results) {
	this.results = results;
}
@Override
public void reset(ActionMapping mapping, HttpServletRequest request) {

name=null;
ssNum=null;
results=null;
}
@Override
public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	ActionErrors errors=new ActionErrors();
	boolean nameEntered=false;
	boolean ssNumEntered=false;
	if(name==null || name.equals("") || name.length()<0)
	{
	   nameEntered=true;
	}
	if(ssNum==null || ssNum.equals("") || ssNum.length()<0)
	{
		ssNumEntered=true;
	}
	if(nameEntered==true || ssNumEntered==true)
	{
		errors.add(null, new ActionMessage("error.search.criteia.missing"));
	}
	else if(!validSsNumValue(ssNum)){
		errors.add("ssNum", new ActionMessage("error.search.ssNum.invalid"));
	}
	return errors;
}
private boolean validSsNumValue(String ssNum2) 
{
	if(ssNum2.length()<11){
    return false;	
  }
	for(int i=0;i<11;i++){
		if(i==3 || i==6){
			if(ssNum2.charAt(i)!='-'){
				return false;
			}
			
		}
	}
	return true;
	}

}
