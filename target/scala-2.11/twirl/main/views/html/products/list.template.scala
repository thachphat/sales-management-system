
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
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Product],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: List[Product]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.27*/("""

"""),_display_(/*3.2*/main("Products catalogue")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""

  """),format.raw/*5.3*/("""<h2>All products</h2>
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
    """),format.raw/*19.5*/("""$('#example2').dataTable();
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/(""" """),format.raw/*20.3*/(""");
</script>
<table id="example2" class="table table-striped table-bordered" cellspacing="0" width="100%"> <thead>
   <tr>
	<th>EAN</th>
	<th>Name</th>
	<th>Description</th>
	<th>In Stocks</th>
	
	<th></th>
  </tr>
</thead>
<tfoot>
            <tr>
			<th>EAN</th>
			<th>Name</th>
			<th>Description</th>
			<th>In Stocks</th>
			
			<th></th>
			
            </tr>
        </tfoot>
<tbody>
	"""),_display_(/*44.3*/for(product <- products) yield /*44.27*/ {_display_(Seq[Any](format.raw/*44.29*/("""
		 """),format.raw/*45.4*/("""<tr>
		        <td><a href=""""),_display_(/*46.25*/routes/*46.31*/.Products.details(product.ean)),format.raw/*46.61*/("""">
		          """),_display_(/*47.14*/product/*47.21*/.ean),format.raw/*47.25*/("""
		        """),format.raw/*48.11*/("""</a></td>
		<td>"""),_display_(/*49.8*/product/*49.15*/.name),format.raw/*49.20*/("""</td>
		<td>"""),_display_(/*50.8*/product/*50.15*/.description),format.raw/*50.27*/("""</td>
        <td>"""),_display_(/*51.14*/product/*51.21*/.instock),format.raw/*51.29*/("""</td>
		<td><a href=""""),_display_(/*52.17*/routes/*52.23*/.Products.update(product.ean)),format.raw/*52.52*/("""">
				<span class="glyphicon glyphicon-pencil"></span></a>
				<a onclick="del('"""),_display_(/*54.23*/routes/*54.29*/.Products.delete(product.ean)),format.raw/*54.58*/("""')">
				<span class="glyphicon glyphicon-remove"></span></a></td

		      </tr>
		      """)))}),format.raw/*58.10*/("""

		    """),format.raw/*60.7*/("""</tbody>
		   </table>
     <a href=""""),_display_(/*62.16*/routes/*62.22*/.Products.newProduct()),format.raw/*62.44*/(""""><button type="submit" class="btn btn-default">Create New</button></a>
	
	""")))}))}
  }

  def render(products:List[Product]): play.twirl.api.HtmlFormat.Appendable = apply(products)

  def f:((List[Product]) => play.twirl.api.HtmlFormat.Appendable) = (products) => apply(products)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 13:06:20 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/products/list.scala.html
                  HASH: d3bf8d2e73d4f47f80a7100d9b10a1680db87323
                  MATRIX: 738->1|851->26|879->29|913->55|952->57|982->61|1065->117|1093->118|1120->119|1153->126|1180->127|1207->128|1294->187|1323->188|1351->189|1397->208|1425->209|1453->210|1481->211|1511->214|1539->215|1567->216|1644->265|1673->266|1705->271|1760->299|1788->300|1816->301|2236->695|2276->719|2316->721|2347->725|2403->754|2418->760|2469->790|2512->806|2528->813|2553->817|2592->828|2635->845|2651->852|2677->857|2716->870|2732->877|2765->889|2811->908|2827->915|2856->923|2905->945|2920->951|2970->980|3079->1062|3094->1068|3144->1097|3265->1187|3300->1195|3365->1233|3380->1239|3423->1261
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|40->12|41->13|41->13|42->14|42->14|43->15|43->15|44->16|46->18|46->18|47->19|48->20|48->20|48->20|72->44|72->44|72->44|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|82->54|82->54|82->54|86->58|88->60|90->62|90->62|90->62
                  -- GENERATED --
              */
          