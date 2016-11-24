<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       	 <link href="<c:url value="/resources/diseño/css/style_window.css"/>" rel="stylesheet" type="text/css"/>
         <script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.min.js"/>"></script>
         <script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.form.js"/>"></script>
         <script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.validate.min.js"/>"></script>
         <script type="text/javascript" src="<c:url value="/resources/diseño/js/error.js"/>"></script>
</head>
<body>
<div id="popup" style="height:240px !important"> 
            <div style="text-align:center; width:100%;">
                <h2><span>Iniciar sesión</span></h2>
            </div>
             <frm:form action="VerificarAcceso" method="post" >
                <p>
                    <label>Usuario</label>
                    <span class="field"><frm:input path="Usuario" type="text" class="longinput required" id="Usuario" name="Usuario"></frm:input></span>
                </p>
                <p>
                    <label>Password</label>
                    <span class="field"><frm:input path="Password" type="password" class="longinput required" id="Password" name="Password"></frm:input></span>
                </p>
                <br>
                    <p class="stdformbutton">
                        <button  class="button">Ingresar</button>
                    </p>
                    <div id="ajaxLogin"></div>
            </frm:form>
        </div>
</body>
    <script>
         $('#formLogin').ajaxForm({
            target: '#ajaxLogin',
            success: function() {
                $('#ajaxLogin').fadeIn('slow');
            }
        });
    </script>
</html>