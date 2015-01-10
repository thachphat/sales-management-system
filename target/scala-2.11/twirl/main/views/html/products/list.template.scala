
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
"""),_display_(/*2.2*/main("Products catalogue")/*2.28*/ {_display_(Seq[Any](format.raw/*2.30*/("""

  """),format.raw/*4.3*/("""<h2>All products</h2>

    <script>
     function del(urlToDelete) """),format.raw/*7.32*/("""{"""),format.raw/*7.33*/("""
        """),format.raw/*8.9*/("""$.ajax("""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
          """),format.raw/*9.11*/("""url: urlToDelete,
          type: 'DELETE',
          success: function(results) """),format.raw/*11.38*/("""{"""),format.raw/*11.39*/("""
            """),format.raw/*12.13*/("""// Refresh the page
            location.reload();
          """),format.raw/*14.11*/("""}"""),format.raw/*14.12*/("""
        """),format.raw/*15.9*/("""}"""),format.raw/*15.10*/(""");
      """),format.raw/*16.7*/("""}"""),format.raw/*16.8*/("""
   """),format.raw/*17.4*/("""</script>

   <table class="table table-striped">
    <thead>
      <tr>
        <th>EAN</th>
        <th>Name</th>
        <th>Description</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    """),_display_(/*29.6*/for(product <- products) yield /*29.30*/ {_display_(Seq[Any](format.raw/*29.32*/("""

      """),format.raw/*31.7*/("""<tr>
        <td><a href=""""),_display_(/*32.23*/routes/*32.29*/.Products.details(product.ean)),format.raw/*32.59*/("""">
          """),_display_(/*33.12*/product/*33.19*/.ean),format.raw/*33.23*/(""" 
        """),format.raw/*34.9*/("""</a></td>
        <td><a href=""""),_display_(/*35.23*/routes/*35.29*/.Products.details(product.ean)),format.raw/*35.59*/("""">"""),_display_(/*35.62*/product/*35.69*/.name),format.raw/*35.74*/("""</a></td>
        <td><a href=""""),_display_(/*36.23*/routes/*36.29*/.Products.details(product.ean)),format.raw/*36.59*/("""">"""),_display_(/*36.62*/product/*36.69*/.name),format.raw/*36.74*/("""</a></td>
        <td>
          <a href=""""),_display_(/*38.21*/routes/*38.27*/.Products.details(product.ean)),format.raw/*38.57*/(""""><i class="icon icon-pencil">Edit</i></a>
          <a onclick="javascript:del('"""),_display_(/*39.40*/routes/*39.46*/.Products.delete(product.ean)),format.raw/*39.75*/("""')"><i class="icon icon-trash">Delete</i></a>
        </td>
      </tr>
      """)))}),format.raw/*42.8*/("""
  
    """),format.raw/*44.5*/("""</tbody>
   </table>

    <a href=""""),_display_(/*47.15*/routes/*47.21*/.Products.newProduct()),format.raw/*47.43*/(""" """),format.raw/*47.44*/("""class="btn"><i class="icon-plus"></i>New product</a>
""")))}))}
  }

  def render(products:List[Product]): play.twirl.api.HtmlFormat.Appendable = apply(products)

  def f:((List[Product]) => play.twirl.api.HtmlFormat.Appendable) = (products) => apply(products)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 09:54:17 ICT 2015
                  SOURCE: /Users/vinh/Desktop/warehouse/app/views/products/list.scala.html
                  HASH: 615edfaa0758e01247e7fc12df80a8f96722cba4
                  MATRIX: 738->1|851->26|878->28|912->54|951->56|981->60|1075->127|1103->128|1138->137|1172->144|1200->145|1238->156|1347->237|1376->238|1417->251|1506->312|1535->313|1571->322|1600->323|1636->332|1664->333|1695->337|1926->542|1966->566|2006->568|2041->576|2095->603|2110->609|2161->639|2202->653|2218->660|2243->664|2280->674|2339->706|2354->712|2405->742|2435->745|2451->752|2477->757|2536->789|2551->795|2602->825|2632->828|2648->835|2674->840|2744->883|2759->889|2810->919|2919->1001|2934->1007|2984->1036|3093->1115|3128->1123|3191->1159|3206->1165|3249->1187|3278->1188
                  LINES: 26->1|29->1|30->2|30->2|30->2|32->4|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|40->12|42->14|42->14|43->15|43->15|44->16|44->16|45->17|57->29|57->29|57->29|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|66->38|66->38|66->38|67->39|67->39|67->39|70->42|72->44|75->47|75->47|75->47|75->47
                  -- GENERATED --
              */
          