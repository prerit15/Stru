package com.java.minihr;

import java.util.ArrayList;

public class EmployeeService {

	private static Employee[] employees={
		new Employee("Bob Mark","123-44-3234"),
		new Employee("john","133-14-3234"),
		new Employee("martin","223-44-3232")};
		
	
	public ArrayList<Employee> searchByName(String name) {
		ArrayList resultlist=new ArrayList();

	     for(Employee employee:employees){
	    //	 if(employee.equals(name)){
	    	 if(employee.getName().toUpperCase().indexOf(name.toUpperCase())!=-1)
	    	 {
	    		resultlist.add(employee);
	    		
	    	 }
	     }
		return resultlist;
	     
	}


	public ArrayList<Employee> searchBySsNum(String ssNum) {
         ArrayList resultlist=new ArrayList();
	     for(Employee employee:employees){
	    	 if(employee.equals(ssNum)){
	    		 resultlist.add(employee);
	    	 }
	}
		return resultlist;
	}
}
