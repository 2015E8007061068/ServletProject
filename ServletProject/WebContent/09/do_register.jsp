<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	 String userName = request.getParameter("userName");
	 String skills = "";
	 String[] skillArr = request.getParameterValues("skills");

	if(skillArr != null && skillArr.length>0){
		for(String skill : skillArr){
			skills =skills + skill+" ";
		}
	}
	
	request.setAttribute("userName", userName);
	request.setAttribute("skills", skills);
	
%>

<jsp:forward page = "welcome.jsp"></jsp:forward>