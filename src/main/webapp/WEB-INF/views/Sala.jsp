<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.entidades.*" %>
<%@page import="com.negocio.*" %>
<%@page import="com.accesoadatos.*" %>
<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    Hashtable ListaFunciones = FuncionBL.Instancia().ListadoFuncion(Integer.parseInt(request.getParameter("id")));
    Enumeration eFunciones = ListaFunciones.elements();
    FuncionesEL oFuncion = FuncionBL.Instancia().BuscarFuncion(Integer.parseInt(request.getParameter("idfuncion")));
    int filas = 0;
    int butacas = 0;
    //String titulo = "titulo";
    //String poster = "titulo";
    //String descripcion = "titulo";
    //String genero = "titulo";
    int sala = Integer.parseInt(request.getParameter("idSala"));
    while (eFunciones.hasMoreElements())
    {
        FuncionesEL aux = (FuncionesEL) eFunciones.nextElement();
        if (aux.getSala().getIdSala() == sala)
        {
            filas = aux.getSala().getFilas();
            butacas = aux.getSala().getButacasporfila();
        }
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content">
    <div class="maincontentinner">
        <div class="content">
            <div class="contenttitle radiusbottom0">
                <h2 class="table"><span>Lista de Funciones</span></h2>
            </div><!--contenttitle-->   
            <div style="height:270px; overflow: auto">
                <table cellspacing="0" cellpadding="0" border="0" class="stdtable stdtablecb" id="asientos">
                    <colgroup>
                        <col class="con1">
                        <col class="con0">
                        <col class="con1">
                        <col class="con0">
                        <col class="con1">
                        <col class="con0">
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head1"></th>
                            <%
                                for (int y = 1; y <= butacas; y++)
                                {
                            %> 
                            <th class="head1">Columna <%= y%></th>
                            <%}%>
                        </tr>
                    </thead>                                    
                    <tbody>                                    
                        <%

                            for (int x = 1; x <= filas; x++)
                            {
                        %> 
                        <tr>
                            <td class="center">

                                <p>Fila <%= x%></p>
                            </td>
                            <%
                                for (int y = 1; y <= butacas; y++)
                                {
                            %> 
                            <td class="center">
                                <%
                                    if (!ButacaBL.Instancia().ButacaOcupada(oFuncion, x, y))
                                    {
                                %>
                                <input type="checkbox" name="columna" id="<%= x%>" value="<%= y%>" />
                                <%
                                }
                                else
                                {
                                %>
                                <p style="color:red">Reservado</>
                                    <%                                    }
                                    %>
                            </td>
                            <%}%>
                        </tr> 
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $("#asientos").change(function () {
        var items = [];
        var asientos=[];
        $(":checkbox:checked").each( function() {
            var valor=$(this);
            items.push(valor);
        });       
        $('.my-new-list').remove();
        $('#reservaAsientos').children().remove();
        $('#selectmostrartasientos').children().remove();
        $.each( items, function(i, l){
            var columna=$(l).val();
            var fila=$(l).attr("id");
            var texto="columna:" + columna + "fila: " + fila;
            asientos.push(texto);
            valor=i+1;
            $('#reservaAsientos').append('<input type="hidden" name="asientoc'+valor+'"  value="'+columna+'" />');
            $('#reservaAsientos').append('<input type="hidden" name="asientof'+valor+'"  value="'+fila+'" />');
            $('#selectmostrartasientos').append('<option> columma= '+columna+' fila= '+fila+'</option>');
        });
        $('#cantbutacas').attr("value",valor);  
    })    
</script>            
</body>
</html>