
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css")),format.raw/*8.94*/("""">    
		
		<link href=""""),_display_(/*10.16*/routes/*10.22*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*10.65*/("""" rel="stylesheet" media="screen">
		<link rel="stylesheet" media="screen" href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.css">
		<link href=""""),_display_(/*12.16*/routes/*12.22*/.Assets.at("stylesheets/simple-sidebar.css")),format.raw/*12.66*/("""" rel="stylesheet" media="screen">
        

	    <!--external css-->
	    <link href=""""),_display_(/*16.19*/routes/*16.25*/.Assets.at("font-awesome/css/font-awesome.css")),format.raw/*16.72*/("""" rel="stylesheet" />
	    <link rel="stylesheet" type="text/css" href=""""),_display_(/*17.52*/routes/*17.58*/.Assets.at("javascripts/gritter/css/jquery.gritter.css")),format.raw/*17.114*/("""" />
	    <link rel="stylesheet" type="text/css" href=""""),_display_(/*18.52*/routes/*18.58*/.Assets.at("lineicons/style.css")),format.raw/*18.91*/("""">    
    
	    <!-- Custom styles for this template -->
	    <link href=""""),_display_(/*21.19*/routes/*21.25*/.Assets.at("stylesheets/style.css")),format.raw/*21.60*/("""" rel="stylesheet">
	    <link href=""""),_display_(/*22.19*/routes/*22.25*/.Assets.at("stylesheets/style-responsive.css")),format.raw/*22.71*/("""" rel="stylesheet">
        <script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.at("javascripts/jquery-2.1.3.min.js")),format.raw/*23.74*/("""" type="text/javascript"></script>
	    <script src=""""),_display_(/*24.20*/routes/*24.26*/.Assets.at("javascripts/chart-master/Chart.js")),format.raw/*24.73*/(""""></script>
    
	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
		<script src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>

		<link rel="shortcut icon" type="image/png" href=""""),_display_(/*33.53*/routes/*33.59*/.Assets.at("images/favicon.png")),format.raw/*33.91*/("""">
        <script src=""""),_display_(/*34.23*/routes/*34.29*/.Assets.at("javascripts/hello.js")),format.raw/*34.63*/("""" type="text/javascript"></script>       
		<script src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>

	</head>
    <body>

    <section id="container" >
        <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
        <!--header start-->
        <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
              <!--logo start-->
              <a href=""""),_display_(/*50.25*/routes/*50.31*/.Application.home()),format.raw/*50.50*/("""" class="logo"><b>RETAILS DATABASE</b></a>
              <!--logo end-->
          </header>
        <!--header end-->
        <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
        <!--sidebar start-->
        <aside>
            <div id="sidebar"  class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu" id="nav-accordion">
              
                	  <p class="centered"><a href="profile.html"><img src=""""),_display_(/*63.74*/routes/*63.80*/.Assets.at("img/ui-sam.jpg")),format.raw/*63.108*/("""" class="img-circle" width="60"></a></p>
                	  <h5 class="centered">Lala Nguyen</h5>
              	  	
                    <li class="mt">
                        <a class="active" href=""""),_display_(/*67.50*/routes/*67.56*/.Application.home()),format.raw/*67.75*/("""">
                            <i class="fa fa-dashboard"></i>
                            <span>Dashboard</span>
                        </a>
                    </li>

                    <li class="sub-menu">
                        <a href="javascript:;" >
                            <i class="fa fa-desktop"></i>
                            <span>Products</span>
                        </a>
                        <ul class="sub">
                            <li><a  href=""""),_display_(/*79.44*/routes/*79.50*/.Products.list()),format.raw/*79.66*/("""">Panel</a></li>
                            <li><a  href="buttons.html">Transactions</a></li>
                        </ul>
                    </li>

                    <li class="sub-menu">
                        <a href="javascript:;" >
                            <i class="fa fa-cogs"></i>
                            <span>Suppliers</span>
                        </a>
                        <ul class="sub">
                            <li><a  href=""""),_display_(/*90.44*/routes/*90.50*/.Suppliers.list()),format.raw/*90.67*/("""">Panel</a></li>
                            <li><a  href="gallery.html">Transactions</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
        <!--sidebar end-->
		    <!-- Page Content -->
	        <!-- **********************************************************************************************************************************************************
	        MAIN CONTENT
	        *********************************************************************************************************************************************************** -->
	        <!--main content start-->
	        <section id="main-content">
	            <section class="wrapper">
		               <div class="container-fluid">
				   	"""),_display_(/*107.10*/if(flash.containsKey("success"))/*107.42*/{_display_(Seq[Any](format.raw/*107.43*/("""
				   	  """),format.raw/*108.11*/("""<div class="alert alert-success" role="alert">
				   	    """),_display_(/*109.14*/flash/*109.19*/.get("success")),format.raw/*109.34*/("""
				   	  """),format.raw/*110.11*/("""</div>
				   	""")))}),format.raw/*111.10*/("""

				   	"""),_display_(/*113.10*/if(flash.containsKey("error"))/*113.40*/{_display_(Seq[Any](format.raw/*113.41*/("""
				   	  """),format.raw/*114.11*/("""<div class="alert alert-danger" role="alert">
				   	    """),_display_(/*115.14*/flash/*115.19*/.get("error")),format.raw/*115.32*/("""
				   	  """),format.raw/*116.11*/("""</div>
				   	""")))}),format.raw/*117.10*/("""
        """),_display_(/*118.10*/content),format.raw/*118.17*/("""
        """),format.raw/*119.9*/("""</section>
    </section>
	           <!-- /#page-content-wrapper -->
		       <!-- js placed at the end of the document so the pages load faster -->
		       <script class="include" type="text/javascript" src=""""),_display_(/*123.63*/routes/*123.69*/.Assets.at("javascripts/jquery.dcjqaccordion.2.7.js")),format.raw/*123.122*/(""""></script>
		       <script src=""""),_display_(/*124.24*/routes/*124.30*/.Assets.at("javascripts/jquery.scrollTo.min.js")),format.raw/*124.78*/(""""></script>
		       <script src=""""),_display_(/*125.24*/routes/*125.30*/.Assets.at("javascripts/jquery.nicescroll.js")),format.raw/*125.76*/("""" type="text/javascript"></script>
		       <script src=""""),_display_(/*126.24*/routes/*126.30*/.Assets.at("javascripts/jquery.sparkline.js")),format.raw/*126.75*/(""""></script>

		       <!--common script for all pages-->
		       <script type="text/javascript" src=""""),_display_(/*129.47*/routes/*129.53*/.Assets.at("javascripts/common-scripts.js")),format.raw/*129.96*/(""""></script>
		       <script type="text/javascript" src=""""),_display_(/*130.47*/routes/*130.53*/.Assets.at("javascripts/gritter/js/jquery.gritter.js")),format.raw/*130.107*/(""""></script>
		       <script type="text/javascript" src=""""),_display_(/*131.47*/routes/*131.53*/.Assets.at("javascripts/gritter-conf.js")),format.raw/*131.94*/(""""></script>

		       <!--script for this page-->
		       <script src=""""),_display_(/*134.24*/routes/*134.30*/.Assets.at("javascripts/sparkline-chart.js")),format.raw/*134.74*/(""""></script>    				 
    </body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 11 22:52:11 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/main.scala.html
                  HASH: 38001c6d26d9a02aa2275d59b2e22b514560223b
                  MATRIX: 727->1|845->31|873->33|950->84|975->89|1063->151|1077->157|1131->191|1183->216|1198->222|1262->265|1446->422|1461->428|1526->472|1641->560|1656->566|1724->613|1824->686|1839->692|1917->748|2000->804|2015->810|2069->843|2172->919|2187->925|2243->960|2308->998|2323->1004|2390->1050|2459->1092|2474->1098|2540->1143|2621->1197|2636->1203|2704->1250|3219->1738|3234->1744|3287->1776|3339->1801|3354->1807|3409->1841|4336->2741|4351->2747|4391->2766|5190->3538|5205->3544|5255->3572|5484->3774|5499->3780|5539->3799|6048->4281|6063->4287|6100->4303|6589->4765|6604->4771|6642->4788|7502->5620|7544->5652|7584->5653|7624->5664|7712->5724|7727->5729|7764->5744|7804->5755|7852->5771|7891->5782|7931->5812|7971->5813|8011->5824|8098->5883|8113->5888|8148->5901|8188->5912|8236->5928|8274->5938|8303->5945|8340->5954|8580->6166|8596->6172|8672->6225|8735->6260|8751->6266|8821->6314|8884->6349|8900->6355|8968->6401|9054->6459|9070->6465|9137->6510|9268->6613|9284->6619|9349->6662|9435->6720|9451->6726|9528->6780|9614->6838|9630->6844|9693->6885|9794->6958|9810->6964|9876->7008
                  LINES: 26->1|29->1|31->3|35->7|35->7|36->8|36->8|36->8|38->10|38->10|38->10|40->12|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|61->33|61->33|61->33|62->34|62->34|62->34|78->50|78->50|78->50|91->63|91->63|91->63|95->67|95->67|95->67|107->79|107->79|107->79|118->90|118->90|118->90|135->107|135->107|135->107|136->108|137->109|137->109|137->109|138->110|139->111|141->113|141->113|141->113|142->114|143->115|143->115|143->115|144->116|145->117|146->118|146->118|147->119|151->123|151->123|151->123|152->124|152->124|152->124|153->125|153->125|153->125|154->126|154->126|154->126|157->129|157->129|157->129|158->130|158->130|158->130|159->131|159->131|159->131|162->134|162->134|162->134
                  -- GENERATED --
              */
          