<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面访问计数</title>
</head>
<body>

<% 
	Object obj = application.getAttribute("counter");
	if(obj == null){
		application.setAttribute("counter", new Integer(1));
		out.println("该页面被访问了1次");
	}else{
		int conterValue = Integer.parseInt(obj.toString());
		conterValue++;
		System.out.println(conterValue);
		out.println("该页面被访问了"+conterValue+"次<br/>");
		application.setAttribute("counter", conterValue);
	}

%>	

</body>
</html>