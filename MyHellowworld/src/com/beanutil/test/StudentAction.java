package com.beanutil.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class StudentAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Student student=new Student();
		PropertyUtils.setSimpleProperty(student,"name", "prerit");
		PropertyUtils.setSimpleProperty(student,"rollno", 36);
		String name1=(String)PropertyUtils.getProperty(student, "name");
		System.out.println(name1);
		
		return null;
		
	}
}