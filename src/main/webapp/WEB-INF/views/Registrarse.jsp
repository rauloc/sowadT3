<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/resources/diseño/css/style_window.css"/>" rel="stylesheet" type="text/css"/>
	<script src="<c:url value="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/diseño/js/jquery.validate.min.js"/>"></script>
	<script src="<c:url value="/resources/diseño/js/jquery.form.js"/>" type="text/javascript"></script>
</head>
<body>
<div id="popup" style="top:0px;">
<div style="text-align:center; width:100%;">
<h2><span>Registrarme</span></h2>
</div>
    <frm:form action="${pageContext.request.contextPath}/RegistroUsuario" method="post" class="stdform">
          <p>
             <frm:label path="usuario">Usuario</frm:label>
             <span class="field"><frm:input path="usuario" type="text" class="longinput required" id="usuario" name="usuario"></frm:input></span>
             </p>
				<p>
                  <frm:label path="password">Password</frm:label>
                  <span class="field"><frm:input path="password" type="password" class="longinput required" id="password" name="password"></frm:input></span>
                  </p>
                  <p>
                   <frm:label path="nombre">Nombre</frm:label>
                   <span class="field"><frm:input path="nombre" type="text" class="longinput required" id="nombre" name="nombre"></frm:input></span>
                    </p>
                     <p>
                    <frm:label path="apellido">Apellido</frm:label>
                      <span class="field"><frm:input path="apellido" type="text" class="longinput required" id="apellido" name="apellido"></frm:input></span> 
                       </p>
						<p>
                    <frm:label path="dNI">DNI</frm:label>
                    <span class="field"><frm:input path="dNI" type="text" class="longinput required number" id="dni" name="dni"></frm:input></span> 
                     </p>                  
                     <br>
                      <p class="stdformbutton">
                       <button class="button" id="btnRegistrarme">Registrarse</button>
           				 </script>
                      </p>
                     <div id="ajaxRegistro2"></div>
                </frm:form>
                </div>
<script>
$(document).ready(function(){
$('#formRegistro').ajaxForm({
            target: '#ajaxRegistro2',
            success: function() {
                $('#ajaxRegistro2').fadeIn('slow');
            }
        });
});
</script>
            
            
<script src="<c:url value="/resources/diseño/js/error.js"/>"></script>
</body>
</html>