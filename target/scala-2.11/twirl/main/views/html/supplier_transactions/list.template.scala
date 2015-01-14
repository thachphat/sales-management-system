
package views.html.supplier_transactions

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
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Supplier_Transaction],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(transactions: List[Supplier_Transaction]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.44*/("""

"""),_display_(/*3.2*/main("Transactions catalogue")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

  """),format.raw/*5.3*/("""<h2>All Transactions</h2>
<script>
function del(urlToDelete)"""),format.raw/*7.26*/("""{"""),format.raw/*7.27*/("""
"""),format.raw/*8.1*/("""$.ajax("""),format.raw/*8.8*/("""{"""),format.raw/*8.9*/("""
"""),format.raw/*9.1*/("""url: urlToDelete,
type:'DELETE',
success: function(results)"""),format.raw/*11.27*/("""{"""),format.raw/*11.28*/("""
"""),format.raw/*12.1*/("""location.reload();
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/("""
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/(""");
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""
"""),format.raw/*16.1*/("""</script> 
<script>
$(document).ready(function() """),format.raw/*18.30*/("""{"""),format.raw/*18.31*/("""
    """),format.raw/*19.5*/("""$('#example5').dataTable();
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/(""" """),format.raw/*20.3*/(""");
</script>
<table id="example5" class="table table-striped table-bordered" cellspacing="0" width="100%"> <thead>
   <tr>
	<th>ID</th>
	<th>Supplier ID</th>
	<th>Quantity</th>
	<th>Product</th>
	<th>Status</th>
	<th></th>
  </tr>
</thead>
<tfoot>
            <tr>
			<th>ID</th>
			<th>Supplier ID</th>
			<th>Quantity</th>
			<th>Product</th>
			<th>Status</th>
			<th></th>
			
            </tr>
        </tfoot>
<tbody>
	"""),_display_(/*44.3*/for(transaction <- transactions) yield /*44.35*/ {_display_(Seq[Any](format.raw/*44.37*/("""
		 """),format.raw/*45.4*/("""<tr>
		        <td><a href=""""),_display_(/*46.25*/routes/*46.31*/.Supplier_Transactions.details(transaction.internalId)),format.raw/*46.85*/("""">
		          """),_display_(/*47.14*/transaction/*47.25*/.internalId),format.raw/*47.36*/("""
		        """),format.raw/*48.11*/("""</a></td>
		<td>"""),_display_(/*49.8*/transaction/*49.19*/.supplier.name),format.raw/*49.33*/("""</td>
		<td>"""),_display_(/*50.8*/transaction/*50.19*/.quantity),format.raw/*50.28*/("""</td>
        <td>"""),_display_(/*51.14*/transaction/*51.25*/.product.name),format.raw/*51.38*/("""</td>
        <td>"""),_display_(/*52.14*/transaction/*52.25*/.isPaid),format.raw/*52.32*/("""</td>
		<td><a href=""""),_display_(/*53.17*/routes/*53.23*/.Supplier_Transactions.details(transaction.internalId)),format.raw/*53.77*/("""">
				<span class="glyphicon glyphicon-pencil"></span></a>
				<a onclick="del('"""),_display_(/*55.23*/routes/*55.29*/.Supplier_Transactions.delete(transaction.internalId)),format.raw/*55.82*/("""')">
				<span class="glyphicon glyphicon-remove"></span></a></td

		      </tr>
		      """)))}),format.raw/*59.10*/("""

		    """),format.raw/*61.7*/("""</tbody>
		   </table>	
	""")))}))}
  }

  def render(transactions:List[Supplier_Transaction]): play.twirl.api.HtmlFormat.Appendable = apply(transactions)

  def f:((List[Supplier_Transaction]) => play.twirl.api.HtmlFormat.Appendable) = (transactions) => apply(transactions)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 11:35:01 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/supplier_transactions/list.scala.html
                  HASH: 10645b0be2b63a8727b3a558ce8b3b65cf8d87f9
                  MATRIX: 764->1|894->43|922->46|960->76|999->78|1029->82|1116->142|1144->143|1171->144|1204->151|1231->152|1258->153|1345->212|1374->213|1402->214|1448->233|1476->234|1504->235|1532->236|1562->239|1590->240|1618->241|1695->290|1724->291|1756->296|1811->324|1839->325|1867->326|2319->752|2367->784|2407->786|2438->790|2494->819|2509->825|2584->879|2627->895|2647->906|2679->917|2718->928|2761->945|2781->956|2816->970|2855->983|2875->994|2905->1003|2951->1022|2971->1033|3005->1046|3051->1065|3071->1076|3099->1083|3148->1105|3163->1111|3238->1165|3347->1247|3362->1253|3436->1306|3557->1396|3592->1404
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|40->12|41->13|41->13|42->14|42->14|43->15|43->15|44->16|46->18|46->18|47->19|48->20|48->20|48->20|72->44|72->44|72->44|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|83->55|83->55|83->55|87->59|89->61
                  -- GENERATED --
              */
          