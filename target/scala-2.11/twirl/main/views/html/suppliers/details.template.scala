
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
<script>
$(document).ready(function() """),format.raw/*6.30*/("""{"""),format.raw/*6.31*/("""
    """),format.raw/*7.5*/("""$('#example').dataTable();
"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/(""" """),format.raw/*8.3*/(""");
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
"""),_display_(/*33.2*/for(transaction <- supplier.transactions) yield /*33.43*/{_display_(Seq[Any](format.raw/*33.44*/("""
	 """),format.raw/*34.3*/("""<tr>
	        <td>"""),_display_(/*35.15*/transaction/*35.26*/.internalId),format.raw/*35.37*/("""</td>
			<td>"""),_display_(/*36.9*/transaction/*36.20*/.product.id),format.raw/*36.31*/("""</td>
			<td>"""),_display_(/*37.9*/transaction/*37.20*/.quantity),format.raw/*37.29*/("""</td>
			<td>"""),_display_(/*38.9*/transaction/*38.20*/.isPaid),format.raw/*38.27*/("""</td>
			<td>"""),_display_(/*39.9*/transaction/*39.20*/.buyDate),format.raw/*39.28*/("""</td>
			<td>
			<a href=""""),_display_(/*41.14*/routes/*41.20*/.Suppliers.details(supplier.name)),format.raw/*41.53*/(""""><span class="glyphicon glyphicon-pencil"></span></a>
			<a onclick="del('"""),_display_(/*42.22*/routes/*42.28*/.Suppliers.delete(supplier.name)),format.raw/*42.60*/("""')"><span class="glyphicon glyphicon-remove"></span></a>
			</td>
	      </tr>
	      """)))}),format.raw/*45.9*/("""
		  
"""),format.raw/*47.1*/("""</tbody>
</table>
<a href=""""),_display_(/*49.11*/routes/*49.17*/.Supplier_Transactions.newTransaction(supplier.name)),format.raw/*49.69*/(""""><button type="submit" class="btn btn-default">Add Transaction</button></a>

""")))}))}
  }

  def render(supplier:Supplier): play.twirl.api.HtmlFormat.Appendable = apply(supplier)

  def f:((Supplier) => play.twirl.api.HtmlFormat.Appendable) = (supplier) => apply(supplier)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 13:26:10 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/suppliers/details.scala.html
                  HASH: ff0a7fc0fe3e9f9075f72bd42012ce5140343ee8
                  MATRIX: 737->1|845->21|872->23|896->39|934->40|962->42|993->48|1009->56|1034->61|1062->62|1133->106|1161->107|1192->112|1245->139|1272->140|1299->141|1774->590|1831->631|1870->632|1900->635|1946->654|1966->665|1998->676|2038->690|2058->701|2090->712|2130->726|2150->737|2180->746|2220->760|2240->771|2268->778|2308->792|2328->803|2357->811|2411->838|2426->844|2480->877|2583->953|2598->959|2651->991|2768->1078|2801->1084|2856->1112|2871->1118|2944->1170
                  LINES: 26->1|29->1|30->2|30->2|30->2|32->4|32->4|32->4|32->4|32->4|34->6|34->6|35->7|36->8|36->8|36->8|61->33|61->33|61->33|62->34|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|69->41|69->41|70->42|70->42|70->42|73->45|75->47|77->49|77->49|77->49
                  -- GENERATED --
              */
          