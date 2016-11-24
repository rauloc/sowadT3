<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ page session="false" %>
<html>
<head>
<title>Cinema T3</title>
	<link media="screen, all" type="text/css" href="<c:url value="/resources/diseño/css/master.css"/>" rel="stylesheet"/>
	<link  media="screen, all" type="text/css" href="<c:url value="/resources/diseño/css/skeleton.css?ver=3.4.2"/>" rel="stylesheet"/>
	<link  media="screen, all" type="text/css" href="<c:url value="/resources/diseño/css/style_window.css"/>" rel="stylesheet"/>
	<link id="googleFonts-css" media="all" type="text/css" href="<c:url value="/resources/diseño/http://fonts.googleapis.com/css?family=Oswald%3A400%2C+300%2C+700&ver=3.4.2"/>" rel="stylesheet">
	<link id="general-css-css" media="all" type="text/css" href="<c:url value="/resources/diseño/css/style2.css?ver=3.4.2"/>" rel="stylesheet"/>
	<link id="prettyPhoto-css-css" media="screen, all" type="text/css" href="<c:url value="/resources/diseño/css/prettyPhoto.css?ver=3.4.2"/>" rel="stylesheet"/>
	<link id="flexslider-css-css" media="screen, all" type="text/css" href="<c:url value="/resources/diseño/css/flexslider.css?ver=3.4.2"/>" rel="stylesheet"/>
	<link id="color-css-css" media="screen, all" type="text/css" href="<c:url value="/resources/diseño/css/color.css?ver=3.4.2"/>" rel="stylesheet"/>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.form.js"/>" type="text/javascript"></script>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/plugins/jquery.smartWizard-2.0.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/error.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/jquery.flexslider-min.js"/>"></script> 
	<script type="text/javascript"  src="<c:url value="/resources/diseño/js/fancy.js"/>"></script> 
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/function_wizard.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/diseño/js/fancyreservas.js"/>"></script>

</head>
<body>

<div id="bodychild">
  <div id="outercontainer"> 
    
    <!-- HEADER -->
    
    <div id="outerheader">
      <div class="header-bglight">
        <header id="top">
          <div class="container">
            <div id="container-logomenu" class="twelve columns"> <span class="logo-light"></span>
              <div id="logo" class="three columns alpha">                
              </div>
              <section id="navigation" class="nine columns omega">
                <nav id="nav-wrap">
                  <ul id="topnav" class="sf-menu">
                    <li id="menu-item-664" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-664"><a target="_blank" id="userLogueado"></a></li>
                    <li id="reservas" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-664" style="display:none"><a target="_blank" id="misreservas" href="#">Mis reservas</a></li>
                    <li id="login" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-664"><a target="_blank" id="window" class="login" href="${pageContext.request.contextPath}/Inicia">Ingresar</a></li>
                    <li id="registrarme" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-664"><a target="_blank" id="window" href="${pageContext.request.contextPath}/Registrar">Registrarme</a></li>
                    <li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-664"><a target="_blank"  href="#" id="salir"></a></li>
                  </ul>
                </nav>
                <!-- nav -->
                <div class="clear"></div>
              </section>
              <div class="clear"></div>
            </div>
          </div>
        </header>
        <div id="headertext">
          <div class="container">
            <div class="headertitle">
              <h1 class="pagetitle">Bienvenido</h1>
              <span class="pagedesc">Una forma más facil de reservar tu entrada al cine</span> </div>
          </div>
        </div>
      </div>
      
      <!-- SLIDER -->
      <div id="outerslider">
        <div id="slidercontainer">
          <section id="slider">
            <div id="slideritems" class="flexslider">
              <ul class="slides">
                <li><img src="<c:url value="/resources/imagenes/cine.jpg"/>" alt="">
                  <div class="flex-caption">
                    <div class="slidertext">
                      <h1>¿Quieres ir al cine?</h1>
                    </div>
                  </div>
                </li>
                <li><img src="<c:url value="/resources/imagenes/1960.jpg"/>" alt="">
                  <div class="flex-caption">
                    <div class="slidertext">
                      <h1>Estas en el sitio correcto</h1>
                    </div>
                  </div>
                </li>
                <li><img src="<c:url value="/resources/imagenes/cinema.jpg"/>" alt="">
                  <div class="flex-caption">
                    <div class="slidertext">
                      <h1>Realiza tu reserva, ¡Ya!</h1>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <div id="slidershadow"></div>
          </section>
        </div>
      </div>
      <!-- END SLIDER --> 
      
    </div>
    <!-- END HEADER --> 
    
    <!-- MAIN CONTENT -->
    <div id="outermain" class="inner">
      <div class="container">
        <section id="maincontent" class="twelve columns">
          <div id="post-94" class="post-94 page type-page status-publish hentry">
            <div class="entry-content">
              <div class="highlight-content">
                <div class="highlight-container">
                  <h1>Películas en cartelera</h1>
                  <p><span>Es .</span></p>
                </div>
              </div>
              <div class="separator">
                <div></div>
              </div>
              <% //while (ePeliculas.hasMoreElements())
              //{
                    //Pelicula aux = (Pelicula) ePeliculas.nextElement();
              %>
              <div class="boxed-container">
                <div class="boxed three columns alpha">
                  <div class="boxed-content">
                      <a id="trailer" href="trailer.jsp?idvideo=<%//=aux.getIdVideo() %>"> <img height="135" src="<%//=aux.getPoster()%>" alt="" class="imgopacity"></a>
                    <h3 class="titleUppercase"><%//=aux.getGenero()%></h3>
                    <div class="sep"><span class="sep2"></span></div>
                    <p> <%//=aux.getTitulo()%> </p>
                    <a  id="reserva" href="reserva.jsp?id=<%//=aux.getIdPelicula()%>" class="button">Reservar</a></div>
                  <div class="shadow-220"></div>
                </div>
              </div>
               <%//}%>
         
            
           
              <div class="clear"></div>
              
              <div class="separator line">
                <div></div>
              </div>
            </div>
            <!-- .entry-content --> 
          </div>
          <!-- #post -->
          
          <div id="comments">
            <p class="nocomments">Comments are closed.</p>
          </div>
          <!-- #comments -->
          
          <div class="clear"></div>
          <!-- clear float --> 
        </section>
        <!-- maincontent --> 
      </div>
    </div>
    <!-- END MAIN CONTENT -->
    
    <div id="shadowbottom"></div>
    
    <!-- FOOTER SECTION -->
    <div id="footersection"> 
      
      <!-- FOOTER SIDEBAR -->
      <div id="outerfootersidebar">
        <div class="container">
          <div id="footersidebarcontainer" class="twelve columns">
            <footer id="footersidebar">
              <div id="footcol1" class="three columns alpha">
                <div class="widget-area">
                  <div class="widget-bottom">
                    <ul>
                      <li id="ts-recent-posts-2" class="widget-container widget_ts_recent_posts">
                        <h2 class="widget-title"><span> Cinema T3</span></h2>
                        <ul class="ts-recent-post-widget">
                          <li>
                            <h3> <a target="_blank" title="Permanent Link to Hello world!" rel="bookmark" href="">Java </a> </h3>
                            <span class="lp-text">Sistema realizado en Eclipse-Spring MVC</span> <span class="clear"></span> </li>
                          <li>
                            <h3> <a target="_blank" title="SOWAD" rel="bookmark" href="">SOWAD</a> </h3>
                            <span class="lp-text"></span> <span class="clear"></span> </li>
                        </ul>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="footcol2" class="three columns">
                <div class="widget-area">
                  <div class="widget-bottom">
                    <ul>
                      <li id="text-2" class="widget-container widget_text">
                        <h2 class="widget-title"><span>Ramos - Ocola</span></h2>
                        <div class="textwidget">
                          <ul class="sn">
                            <li><a target="_blank" href="#"><span class="icon-img" style="background-image:url(images/twitter.png)"></span></a></li>
                            <li><a target="_blank" href="#"><span class="icon-img" style="background-image:url(images/fb.png)"></span></a></li>
                            <li><a target="_blank" href="#"><span class="icon-img" style="background-image:url(images/googleplus.png)"></span></a></li>
                            <li><a target="_blank" href="#" style="background-image:url(images/pinterest.png)"></span></a></li>
                          </ul>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="footcol3" class="three columns">
                <div class="widget-area">
                  <div class="widget-bottom">
                    <ul>
                      <li id="simple-flickr-photos-widget-2" class="widget-container Simple_Flickr_Photos">
                        <h2 class="widget-title"><span>nazareno oviedo</span></h2>
                        <!--simple flickr photos-->
                        <style type="text/css">
#flickr {text-align:center;}
#flickr img {
display:inline;
margin:3px;
padding:1px;
border:1px solid #ccc;}
</style>
                        <div class="textwidget">
                          <ul class="sn">
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/twitter.png)"></span></a></li>
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/fb.png)"></span></a></li>
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/googleplus.png)"></span></a></li>
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/pinterest.png)"></span></a></li>
                          </ul>
                        </div>
                        <!--simple flickr photos ends--></li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="footcol4" class="three columns omega">
                <div class="widget-area">
                  <div class="widget-bottom">
                    <ul>
                      <li id="text-3" class="widget-container widget_text">
                        <h2 class="widget-title"><span>facundo sirvent</span></h2>
                        <div class="textwidget">
                          <ul class="sn">
                            <li><a target="_blank"  href=""><span class="icon-img" style="background-image:url(images/twitter.png)"></span></a></li>
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/fb.png)"></span></a></li>
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/googleplus.png)"></span></a></li>
                            <li><a target="_blank" href=""><span class="icon-img" style="background-image:url(images/pinterest.png)"></span></a></li>
                          </ul>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="clear"></div>
            </footer>
          </div>
        </div>
      </div>
    </div>
   
  </div>
</div>

<script type="text/javascript">
function cargaIndex(){
$(document).ready(function() {
    jQuery('.flexslider').flexslider({
          animation: "fade",
		  animationDuration: 600,
		  directionNav: false,
		  controlNav: true        });
		 
});

$(document).ready(function(){
	 $('#window').fancy();
         $('#trailer').fancy();
	 $('#reserva').function_wizard();
         $('#misreservas').fancyreservas();
})


$(document).ready(function(){
  $('#salir').click(function(e) {
    var url = $(this).attr('href');
    $('#bodychild').load(url);
    e.preventDefault();
  })
});
}
cargaIndex();

</script> 

</body>
</html>
