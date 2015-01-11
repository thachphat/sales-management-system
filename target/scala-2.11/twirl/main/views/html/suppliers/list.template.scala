
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
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Supplier],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(suppliers: List[Supplier]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main("Suppliers catalogue")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

  """),format.raw/*5.3*/("""<h2>All Suppliers</h2>
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
   <table class="table table-striped">
    <thead>
      <tr>
		<th>Name</th>
	  </tr>
	</thead>
	<tbody>
	"""),_display_(/*24.3*/for(supplier <- suppliers) yield /*24.29*/ {_display_(Seq[Any](format.raw/*24.31*/("""
		 """),format.raw/*25.4*/("""<tr>
		        <td><a href=""""),_display_(/*26.25*/routes/*26.31*/.Suppliers.details(supplier.name)),format.raw/*26.64*/("""">
		          """),_display_(/*27.14*/supplier/*27.22*/.name),format.raw/*27.27*/("""
		        """),format.raw/*28.11*/("""</a></td>
				<td>
				<a href=""""),_display_(/*30.15*/routes/*30.21*/.Suppliers.details(supplier.name)),format.raw/*30.54*/("""">
				<span class="glyphicon glyphicon-pencil"></span></a>
				<a onclick="del('"""),_display_(/*32.23*/routes/*32.29*/.Suppliers.delete(supplier.name)),format.raw/*32.61*/("""')">
				<span class="glyphicon glyphicon-remove"></span></a>
				</td>
		      </tr>
		      """)))}),format.raw/*36.10*/("""

		    """),format.raw/*38.7*/("""</tbody>
		   </table>
     <a href=""""),_display_(/*40.16*/routes/*40.22*/.Suppliers.newSupplier()),format.raw/*40.46*/(""""><button type="submit" class="btn btn-default">Create New</button></a>
	
	""")))}))}
  }

  def render(suppliers:List[Supplier]): play.twirl.api.HtmlFormat.Appendable = apply(suppliers)

  def f:((List[Supplier]) => play.twirl.api.HtmlFormat.Appendable) = (suppliers) => apply(suppliers)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 11 22:52:11 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/suppliers/list.scala.html
                  HASH: b441ea540b5b79aa1164a6cc23d6b169c267c70a
                  MATRIX: 740->1|855->28|883->31|918->58|957->60|987->64|1071->121|1099->122|1126->123|1159->130|1186->131|1213->132|1300->191|1329->192|1357->193|1403->212|1431->213|1459->214|1487->215|1517->218|1545->219|1573->220|1718->339|1760->365|1800->367|1831->371|1887->400|1902->406|1956->439|1999->455|2016->463|2042->468|2081->479|2141->512|2156->518|2210->551|2319->633|2334->639|2387->671|2513->766|2548->774|2613->812|2628->818|2673->842
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|40->12|41->13|41->13|42->14|42->14|43->15|43->15|44->16|52->24|52->24|52->24|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|58->30|58->30|58->30|60->32|60->32|60->32|64->36|66->38|68->40|68->40|68->40
                  -- GENERATED --
              */
          