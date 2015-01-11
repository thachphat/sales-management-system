
package views.html.suppliers

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
object details extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Supplier,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(supplier: Supplier):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.22*/("""
"""),_display_(/*2.2*/main("Supplier")/*2.18*/{_display_(Seq[Any](format.raw/*2.19*/("""

"""),format.raw/*4.1*/("""<h1> """),_display_(/*4.7*/supplier/*4.15*/.name),format.raw/*4.20*/(""" """),format.raw/*4.21*/("""</h1>
<a href=""""),_display_(/*5.11*/routes/*5.17*/.Supplier_Transactions.newTransaction(supplier.name)),format.raw/*5.69*/(""""><button type="submit" class="btn btn-default">Add Transaction</button></a>
<script>
$(document).ready(function() """),format.raw/*7.30*/("""{"""),format.raw/*7.31*/("""
    """),format.raw/*8.5*/("""$('#example').dataTable();
"""),format.raw/*9.1*/("""}"""),format.raw/*9.2*/(""" """),format.raw/*9.3*/(""");
</script>
<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"> <thead>
   <tr>
	<th>ID</th>
	<th>Product ID</th>
	<th>Quantity</th>
	<th>Status</th>
	<th>Date</th>
	<th></th>
	
  </tr>
</thead>
<tfoot>
            <tr>
                <th>ID</th>
				<th>Product ID</th>
				<th>Quantity</th>
				<th>Status</th>
                <th>Date</th>
				<th></th>
				
            </tr>
        </tfoot>
<tbody>
"""),_display_(/*34.2*/for(transaction <- supplier.transactions) yield /*34.43*/{_display_(Seq[Any](format.raw/*34.44*/("""
	 """),format.raw/*35.3*/("""<tr>
	        <td>"""),_display_(/*36.15*/transaction/*36.26*/.internalId),format.raw/*36.37*/("""</td>
			<td>"""),_display_(/*37.9*/transaction/*37.20*/.product.id),format.raw/*37.31*/("""</td>
			<td>"""),_display_(/*38.9*/transaction/*38.20*/.quantity),format.raw/*38.29*/("""</td>
			<td>"""),_display_(/*39.9*/transaction/*39.20*/.isPaid),format.raw/*39.27*/("""</td>
			<td>"""),_display_(/*40.9*/transaction/*40.20*/.buyDate),format.raw/*40.28*/("""</td>
			<td>
			<a href=""""),_display_(/*42.14*/routes/*42.20*/.Suppliers.details(supplier.name)),format.raw/*42.53*/(""""><span class="glyphicon glyphicon-pencil"></span></a>
			<a onclick="del('"""),_display_(/*43.22*/routes/*43.28*/.Suppliers.delete(supplier.name)),format.raw/*43.60*/("""')"><span class="glyphicon glyphicon-remove"></span></a>
			</td>
	      </tr>
	      """)))}),format.raw/*46.9*/("""
		  
"""),format.raw/*48.1*/("""</tbody>
</table>

""")))}))}
  }

  def render(supplier:Supplier): play.twirl.api.HtmlFormat.Appendable = apply(supplier)

  def f:((Supplier) => play.twirl.api.HtmlFormat.Appendable) = (supplier) => apply(supplier)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 11 22:52:11 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/suppliers/details.scala.html
                  HASH: 42354063f7c5e624ca88642ae433bd764e16aaef
                  MATRIX: 737->1|845->21|872->23|896->39|934->40|962->42|993->48|1009->56|1034->61|1062->62|1104->78|1118->84|1190->136|1332->251|1360->252|1391->257|1444->284|1471->285|1498->286|1973->735|2030->776|2069->777|2099->780|2145->799|2165->810|2197->821|2237->835|2257->846|2289->857|2329->871|2349->882|2379->891|2419->905|2439->916|2467->923|2507->937|2527->948|2556->956|2610->983|2625->989|2679->1022|2782->1098|2797->1104|2850->1136|2967->1223|3000->1229
                  LINES: 26->1|29->1|30->2|30->2|30->2|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|36->8|37->9|37->9|37->9|62->34|62->34|62->34|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|70->42|70->42|71->43|71->43|71->43|74->46|76->48
                  -- GENERATED --
              */
          