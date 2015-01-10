
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
        


		<link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.53*/routes/*16.59*/.Assets.at("images/favicon.png")),format.raw/*16.91*/("""">
        <script src=""""),_display_(/*17.23*/routes/*17.29*/.Assets.at("javascripts/hello.js")),format.raw/*17.63*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*18.23*/routes/*18.29*/.Assets.at("javascripts/jquery-2.1.3.min.js")),format.raw/*18.74*/("""" type="text/javascript"></script>
       
<script src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>

	</head>
    <body>
	
	
	<div id="wrapper">

	        <!-- Sidebar -->
	        <div id="sidebar-wrapper">
	            <ul class="sidebar-nav">
	                <li class="sidebar-brand">
	                    <a href="#">
						Retails Database         
	                    </a>
	                </li>
	                <li>
	                    <a href="#">Dashboard</a>
	                </li>
	                <li>
	                    <a href=""""),_display_(/*40.32*/routes/*40.38*/.Products.list()),format.raw/*40.54*/("""">Products</a>
	                </li>
	                <li>
	                    <a href=""""),_display_(/*43.32*/routes/*43.38*/.Suppliers.list()),format.raw/*43.55*/("""">Suppliers</a>
	                </li>
	                <li>
	                    <a href="#">Transactions</a>
	                </li>
	            </ul>
	        </div>
	        <!-- /#sidebar-wrapper -->
		    <!-- Page Content -->
		           <div id="page-content-wrapper">
		               <div class="container-fluid">
				   	"""),_display_(/*54.10*/if(flash.containsKey("success"))/*54.42*/{_display_(Seq[Any](format.raw/*54.43*/("""
				   	  """),format.raw/*55.11*/("""<div class="alert alert-success" role="alert">
				   	    """),_display_(/*56.14*/flash/*56.19*/.get("success")),format.raw/*56.34*/("""
				   	  """),format.raw/*57.11*/("""</div>
				   	""")))}),format.raw/*58.10*/("""

				   	"""),_display_(/*60.10*/if(flash.containsKey("error"))/*60.40*/{_display_(Seq[Any](format.raw/*60.41*/("""
				   	  """),format.raw/*61.11*/("""<div class="alert alert-danger" role="alert">
				   	    """),_display_(/*62.14*/flash/*62.19*/.get("error")),format.raw/*62.32*/("""
				   	  """),format.raw/*63.11*/("""</div>
				   	""")))}),format.raw/*64.10*/("""
        """),_display_(/*65.10*/content),format.raw/*65.17*/("""
		"""),format.raw/*66.3*/("""<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
		
	    </div>
	           </div>
	           <!-- /#page-content-wrapper -->
			   <!-- Menu Toggle Script -->
			       <script>
			       $("#menu-toggle").click(function(e) """),format.raw/*73.47*/("""{"""),format.raw/*73.48*/("""
			           """),format.raw/*74.15*/("""e.preventDefault();
			           $("#wrapper").toggleClass("toggled");
			       """),format.raw/*76.11*/("""}"""),format.raw/*76.12*/(""");
			       </script>
				 
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
                  DATE: Sat Jan 10 13:28:40 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/library/app/views/main.scala.html
                  HASH: e2998835fa0518c8479ba713a65de4b9e94ce9e7
                  MATRIX: 727->1|845->31|873->33|950->84|975->89|1063->151|1077->157|1131->191|1183->216|1198->222|1262->265|1446->422|1461->428|1526->472|1651->570|1666->576|1719->608|1771->633|1786->639|1841->673|1925->730|1940->736|2006->781|2634->1382|2649->1388|2686->1404|2804->1495|2819->1501|2857->1518|3218->1852|3259->1884|3298->1885|3337->1896|3424->1956|3438->1961|3474->1976|3513->1987|3560->2003|3598->2014|3637->2044|3676->2045|3715->2056|3801->2115|3815->2120|3849->2133|3888->2144|3935->2160|3972->2170|4000->2177|4030->2180|4315->2437|4344->2438|4387->2453|4497->2535|4526->2536
                  LINES: 26->1|29->1|31->3|35->7|35->7|36->8|36->8|36->8|38->10|38->10|38->10|40->12|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|68->40|68->40|68->40|71->43|71->43|71->43|82->54|82->54|82->54|83->55|84->56|84->56|84->56|85->57|86->58|88->60|88->60|88->60|89->61|90->62|90->62|90->62|91->63|92->64|93->65|93->65|94->66|101->73|101->73|102->74|104->76|104->76
                  -- GENERATED --
              */
          