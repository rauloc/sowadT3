<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true" %>
<%@page import="com.accesoadatos.*"%>
<%@page import="com.entidades.*"%>
<%@page import="com.negocio.*"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try {
 	int idFuncion = Integer.parseInt(request.getParameter("ReservaIdFucion"));
    String nombreFuncion="";
    int cantbutacas = Integer.parseInt(request.getParameter("cantbutacas"));
    
    if (idFuncion != 0)
    {
        FuncionesEL oFuncion = FuncionBL.Instancia().BuscarFuncion(idFuncion);
        Date auxdate = new Date();
        UsuarioEL us=new UsuarioEL();
        ReservasEL r=new ReservasEL();
        r.setFuncion(oFuncion);
        //HttpSession session = request.getSession();
		UsuarioEL usuario = (UsuarioEL) session.getAttribute("usuario");
        r.setUsuario(usuario);
        nombreFuncion= request.getParameter("ReservaNombre");
        
        if (nombreFuncion != "")
        {
            r.setNombre(request.getParameter("ReservaNombre"));
            double precio = (oFuncion.getHorario().getPrecio()) * cantbutacas;
            int c=(int)precio;
            r.setPrecio(c);
            ReservaBL.Instancia().InsertarReserva(r);
        }
    } 
    if (cantbutacas != 0)
    {
        for (int x = 1; x <= cantbutacas; x++)
        {
        	ReservasEL r=new ReservasEL();
            int columna = Integer.parseInt(request.getParameter("asientoc" + x));
            int fila = Integer.parseInt(request.getParameter("asientof" + x));
            ButacasEL bt = new ButacasEL(r.getFuncion(), fila, columna);
            ButacaDL.Instancia().ReservarButaca(bt);
        }
    }
    
    if ((idFuncion!=0) && (cantbutacas!=0) && (!nombreFuncion.equals("")))
    {
    	%><script>$('.buttonFinish').hide();setTimeout(function(){$('#popup1').fadeOut(3000);$('#fancy1').fadeOut(3000)} , 000)</script><h2 id="gracias" style="color: yellowgreen;font-size: 20px;left: 42px;position: relative;  top: 13px;">Gracias por su reserva.</h2><% 
    }
    else
    {
    	%><script>$('.buttonFinish').hide();setTimeout(function(){$('#error').fadeOut(1000);$('.buttonFinish').fadeIn(3000);} , 1000)</script><h2 id="error" style="color: red;font-size: 20px;left: 42px;position: relative;  top: 13px;">Error, faltan datos.</h2><%
    }
	
} catch (Exception e) {

}
%>
</body>
</html>