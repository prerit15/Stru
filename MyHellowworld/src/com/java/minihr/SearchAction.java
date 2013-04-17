package com.java.minihr;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ArrayList<Employee> results;
	EmployeeService service=new EmployeeService();
	SearchForm searchForm=(SearchForm) form;
	  String name=searchForm.getName();
	  String ssNum=searchForm.getSsNum();
	  if(name!=null && name.trim().length()>0){
	   results=service.searchByName(name);
	  }else {
		  results=service.searchBySsNum(ssNum);
	  }
	  searchForm.setResults(results);
	return mapping.getInputForward();
	}

}
