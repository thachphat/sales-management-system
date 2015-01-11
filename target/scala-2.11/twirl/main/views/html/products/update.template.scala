
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
object update extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[Product],List[Supplier],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(productForm: Form[Product], suppliers: List[Supplier]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main("Product form")/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""
"""),format.raw/*4.1*/("""<h1> Product form </h1>
<form class="form-horizontal" method="POST" action=""""),_display_(/*5.54*/routes/*5.60*/.Products.save()),format.raw/*5.76*/("""">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">EAN</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="ean" placeholder="""),_display_(/*9.71*/productForm("ean")/*9.89*/.valueOr("Ean")),format.raw/*9.104*/(""" """),format.raw/*9.105*/("""value="""),_display_(/*9.112*/productForm("ean")/*9.130*/.value()),format.raw/*9.138*/(""">
    </div>
  </div>
  """),_display_(/*12.4*/productForm("ean")/*12.22*/.errors()),format.raw/*12.31*/("""
  """),format.raw/*13.3*/("""<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="description" placeholder="""),_display_(/*16.79*/productForm("description")/*16.105*/.valueOr("Description")),format.raw/*16.128*/(""" """),format.raw/*16.129*/("""value="""),_display_(/*16.136*/productForm("description")/*16.162*/.value()),format.raw/*16.170*/(""">
    </div>
  </div>
  """),_display_(/*19.4*/productForm("description")/*19.30*/.errors()),format.raw/*19.39*/("""
  
  """),format.raw/*21.3*/("""<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" placeholder="""),_display_(/*24.72*/productForm("name")/*24.91*/.valueOr("Name")),format.raw/*24.107*/(""" """),format.raw/*24.108*/("""value="""),_display_(/*24.115*/productForm("name")/*24.134*/.value()),format.raw/*24.142*/(""">
    </div>
  </div>
  """),_display_(/*27.4*/productForm("name")/*27.23*/.errors()),format.raw/*27.32*/("""
  
  """),format.raw/*29.3*/("""<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  </div>
</form>

""")))}))}
  }

  def render(productForm:Form[Product],suppliers:List[Supplier]): play.twirl.api.HtmlFormat.Appendable = apply(productForm,suppliers)

  def f:((Form[Product],List[Supplier]) => play.twirl.api.HtmlFormat.Appendable) = (productForm,suppliers) => apply(productForm,suppliers)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 11 22:52:11 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/products/update.scala.html
                  HASH: 0c64d3e17103e2a933bab887b1f4a31d145b2255
                  MATRIX: 755->1|898->56|926->59|954->79|992->80|1019->81|1122->158|1136->164|1172->180|1397->379|1423->397|1459->412|1488->413|1522->420|1549->438|1578->446|1629->471|1656->489|1686->498|1716->501|1957->715|1993->741|2038->764|2068->765|2103->772|2139->798|2169->806|2220->831|2255->857|2285->866|2318->872|2545->1072|2573->1091|2611->1107|2641->1108|2676->1115|2705->1134|2735->1142|2786->1167|2814->1186|2844->1195|2877->1201
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|33->5|33->5|33->5|37->9|37->9|37->9|37->9|37->9|37->9|37->9|40->12|40->12|40->12|41->13|44->16|44->16|44->16|44->16|44->16|44->16|44->16|47->19|47->19|47->19|49->21|52->24|52->24|52->24|52->24|52->24|52->24|52->24|55->27|55->27|55->27|57->29
                  -- GENERATED --
              */
          