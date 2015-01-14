
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
object home extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Double,Double,List[User_Action],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(paid: Double, unpaid: Double, supplier_transactions: List[User_Action]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.74*/("""
"""),_display_(/*2.2*/main("User Dashboard")/*2.24*/ {_display_(Seq[Any](format.raw/*2.26*/("""
"""),format.raw/*3.1*/("""<h3>Statistics</h3>
<hr/>
<div class="row">
        <div class="row mt">
        <!-- SERVER STATUS PANELS -->
        	<div class="col-md-4 col-sm-4 mb">
        			
				<div class="row">
					<div class="col-sm-6 col-xs-6 goleft">
	    			<div class="white-header">
		  			<h5>SUPPLIER DEBT</h5>
	    			</div>
						<p><i class="fa fa-database"></i> """),_display_(/*15.42*/unpaid),format.raw/*15.48*/("""%</p>
					</div>
            		</div>
				<canvas id="serverstatus01" height="120" width="120"></canvas>
				<script>
					var doughnutData = [
							"""),format.raw/*21.8*/("""{"""),format.raw/*21.9*/("""
								"""),format.raw/*22.9*/("""value: """),_display_(/*22.17*/paid),format.raw/*22.21*/(""",
								color:"#68dff0"
							"""),format.raw/*24.8*/("""}"""),format.raw/*24.9*/(""",
							"""),format.raw/*25.8*/("""{"""),format.raw/*25.9*/("""
								"""),format.raw/*26.9*/("""value : """),_display_(/*26.18*/unpaid),format.raw/*26.24*/(""",
								color : "#fdfdfd"
							"""),format.raw/*28.8*/("""}"""),format.raw/*28.9*/("""
						"""),format.raw/*29.7*/("""];
						var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
				</script>
    			
        	</div><!-- /col-md-4-->
        	<div class="col-md-4 col-sm-4 mb">
        			
				<div class="row">
					<div class="col-sm-6 col-xs-6 goleft">
	    			<div class="white-header">
		  			<h5>CUSTOMER DEBT</h5>
	    			</div>
						<p><i class="fa fa-database"></i> """),_display_(/*41.42*/unpaid),format.raw/*41.48*/("""%</p>
					</div>
            		</div>
				<canvas id="serverstatus02" height="120" width="120"></canvas>
				<script>
					var doughnutData = [
							"""),format.raw/*47.8*/("""{"""),format.raw/*47.9*/("""
								"""),format.raw/*48.9*/("""value: """),_display_(/*48.17*/paid),format.raw/*48.21*/(""",
								color:"#68dff0"
							"""),format.raw/*50.8*/("""}"""),format.raw/*50.9*/(""",
							"""),format.raw/*51.8*/("""{"""),format.raw/*51.9*/("""
								"""),format.raw/*52.9*/("""value : """),_display_(/*52.18*/unpaid),format.raw/*52.24*/(""",
								color : "#fdfdfd"
							"""),format.raw/*54.8*/("""}"""),format.raw/*54.9*/("""
						"""),format.raw/*55.7*/("""];
						var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
				</script>
    			
        	</div><!-- /col-md-4-->
      </div><!-- /row -->
      
  	<h3>Transactions</h3>
	<hr></hr>	
     """),_display_(/*64.7*/for(transaction<-supplier_transactions) yield /*64.46*/{_display_(Seq[Any](format.raw/*64.47*/("""   
	 """),_display_(/*65.4*/transaction/*65.15*/.verb/*65.20*/ match/*65.26*/ {/*66.4*/case "Insert" =>/*66.20*/ {_display_(Seq[Any](format.raw/*66.22*/("""<p class="alert alert-success" role="alert">&bull;
      ["""),_display_(/*67.9*/transaction/*67.20*/.verb),format.raw/*67.25*/("""] """),_display_(/*67.28*/transaction/*67.39*/.description),format.raw/*67.51*/(""" """),format.raw/*67.52*/("""on <muted>"""),_display_(/*67.63*/transaction/*67.74*/.createDate),format.raw/*67.85*/("""</muted>
	  </p>""")))}/*69.6*/case "Delete" =>/*69.22*/ {_display_(Seq[Any](format.raw/*69.24*/("""
	  """),format.raw/*70.4*/("""<p class="alert alert-danger" role="alert">&bull;
      ["""),_display_(/*71.9*/transaction/*71.20*/.verb),format.raw/*71.25*/("""] """),_display_(/*71.28*/transaction/*71.39*/.description),format.raw/*71.51*/(""" """),format.raw/*71.52*/("""on <muted>"""),_display_(/*71.63*/transaction/*71.74*/.createDate),format.raw/*71.85*/("""</muted>
	  </p>""")))}}),format.raw/*73.5*/("""
	""")))}),format.raw/*74.3*/("""
           """),format.raw/*75.12*/("""</div>   
		""")))}))}
  }

  def render(paid:Double,unpaid:Double,supplier_transactions:List[User_Action]): play.twirl.api.HtmlFormat.Appendable = apply(paid,unpaid,supplier_transactions)

  def f:((Double,Double,List[User_Action]) => play.twirl.api.HtmlFormat.Appendable) = (paid,unpaid,supplier_transactions) => apply(paid,unpaid,supplier_transactions)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 12:52:40 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/home.scala.html
                  HASH: 85387f3dc099648cf8d95b35308890f469a95310
                  MATRIX: 747->1|907->73|934->75|964->97|1003->99|1030->100|1411->454|1438->460|1617->612|1645->613|1681->622|1716->630|1741->634|1801->667|1829->668|1865->677|1893->678|1929->687|1965->696|1992->702|2054->737|2082->738|2116->745|2561->1163|2588->1169|2767->1321|2795->1322|2831->1331|2866->1339|2891->1343|2951->1376|2979->1377|3015->1386|3043->1387|3079->1396|3115->1405|3142->1411|3204->1446|3232->1447|3266->1454|3543->1705|3598->1744|3637->1745|3670->1752|3690->1763|3704->1768|3719->1774|3729->1794|3754->1810|3794->1812|3879->1871|3899->1882|3925->1887|3955->1890|3975->1901|4008->1913|4037->1914|4075->1925|4095->1936|4127->1947|4162->1970|4187->1986|4227->1988|4258->1992|4342->2050|4362->2061|4388->2066|4418->2069|4438->2080|4471->2092|4500->2093|4538->2104|4558->2115|4590->2126|4638->2148|4671->2151|4711->2163
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|43->15|43->15|49->21|49->21|50->22|50->22|50->22|52->24|52->24|53->25|53->25|54->26|54->26|54->26|56->28|56->28|57->29|69->41|69->41|75->47|75->47|76->48|76->48|76->48|78->50|78->50|79->51|79->51|80->52|80->52|80->52|82->54|82->54|83->55|92->64|92->64|92->64|93->65|93->65|93->65|93->65|93->66|93->66|93->66|94->67|94->67|94->67|94->67|94->67|94->67|94->67|94->67|94->67|94->67|95->69|95->69|95->69|96->70|97->71|97->71|97->71|97->71|97->71|97->71|97->71|97->71|97->71|97->71|98->73|99->74|100->75
                  -- GENERATED --
              */
          