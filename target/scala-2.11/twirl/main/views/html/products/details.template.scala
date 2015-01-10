
package views.html.products

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
object details extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Product,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Product):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.20*/("""
"""),_display_(/*2.2*/main("Product")/*2.17*/{_display_(Seq[Any](format.raw/*2.18*/("""

"""),format.raw/*4.1*/("""<h1> Transaction Log : """),_display_(/*4.25*/product/*4.32*/.name),format.raw/*4.37*/(""" """),format.raw/*4.38*/("""</h1>
<script>
$(document).ready(function() """),format.raw/*6.30*/("""{"""),format.raw/*6.31*/("""
    """),format.raw/*7.5*/("""$('#example4').dataTable();
"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/(""" """),format.raw/*8.3*/(""");
</script>
<table id="example4" class="table table-striped table-bordered" cellspacing="0" width="100%"> <thead>
   <tr>
	<th>ID</th>
	<th>EAN</th>
	<th>Quantity</th>
	<th>Status</th>
	<th>Date</th>
	
  </tr>
</thead>
<tfoot>
            <tr>
                <th>ID</th>
				<th>EAN</th>
				<th>Quantity</th>
				<th>Status</th>
                <th>Date</th>
				
            </tr>
        </tfoot>
<tbody>
"""),_display_(/*31.2*/for(transaction <- product.transactions) yield /*31.42*/{_display_(Seq[Any](format.raw/*31.43*/("""
	 """),format.raw/*32.3*/("""<tr>
	        <td>"""),_display_(/*33.15*/transaction/*33.26*/.internalId),format.raw/*33.37*/("""</td>
			<td>"""),_display_(/*34.9*/transaction/*34.20*/.product.name),format.raw/*34.33*/("""</td>
			<td>"""),_display_(/*35.9*/transaction/*35.20*/.quantity),format.raw/*35.29*/("""</td>
			<td>"""),_display_(/*36.9*/transaction/*36.20*/.isPaid),format.raw/*36.27*/("""</td>
			<td>"""),_display_(/*37.9*/transaction/*37.20*/.buyDate),format.raw/*37.28*/("""</td>
		
	      </tr>
	      """)))}),format.raw/*40.9*/("""
		  
"""),format.raw/*42.1*/("""</tbody>
</table>

""")))}))}
  }

  def render(product:Product): play.twirl.api.HtmlFormat.Appendable = apply(product)

  def f:((Product) => play.twirl.api.HtmlFormat.Appendable) = (product) => apply(product)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jan 10 22:04:14 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/library/app/views/products/details.scala.html
                  HASH: 43fa1c8c6c0ad88010c7c5b49bb5209bc11b09f1
                  MATRIX: 735->1|841->19|868->21|891->36|929->37|957->39|1007->63|1022->70|1047->75|1075->76|1146->120|1174->121|1205->126|1259->154|1286->155|1313->156|1750->567|1806->607|1845->608|1875->611|1921->630|1941->641|1973->652|2013->666|2033->677|2067->690|2107->704|2127->715|2157->724|2197->738|2217->749|2245->756|2285->770|2305->781|2334->789|2394->819|2427->825
                  LINES: 26->1|29->1|30->2|30->2|30->2|32->4|32->4|32->4|32->4|32->4|34->6|34->6|35->7|36->8|36->8|36->8|59->31|59->31|59->31|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|68->40|70->42
                  -- GENERATED --
              */
          