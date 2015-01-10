
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
object details extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Product],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(productForm: Form[Product]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
import helper.twitterBootstrap._

Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Product form")/*5.22*/ {_display_(Seq[Any](format.raw/*5.24*/("""
  """),format.raw/*6.3*/("""<h1>Product form</h1>
  """),_display_(/*7.4*/helper/*7.10*/.form(action = routes.Products.save())/*7.48*/ {_display_(Seq[Any](format.raw/*7.50*/("""
    """),format.raw/*8.5*/("""<fieldset>
      <legend>Product ("""),_display_(/*9.25*/productForm("name")/*9.44*/.valueOr("New")),format.raw/*9.59*/(""")</legend>
      """),_display_(/*10.8*/helper/*10.14*/.inputText(productForm("ean"), '_label -> "EAN")),format.raw/*10.62*/("""
      """),_display_(/*11.8*/helper/*11.14*/.inputText(productForm("name"),'_label -> "Name")),format.raw/*11.63*/("""
      """),_display_(/*12.8*/helper/*12.14*/.textarea(productForm("description"), '_label -> "Description")),format.raw/*12.77*/("""
    """),format.raw/*13.5*/("""</fieldset>
      <input type="submit" class="btn btn-primary" value="Save">
    <a class="btn" href=""""),_display_(/*15.27*/routes/*15.33*/.Application.index()),format.raw/*15.53*/("""">Cancel</a>
  """)))}),format.raw/*16.4*/("""
""")))}))}
  }

  def render(productForm:Form[Product]): play.twirl.api.HtmlFormat.Appendable = apply(productForm)

  def f:((Form[Product]) => play.twirl.api.HtmlFormat.Appendable) = (productForm) => apply(productForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 09:52:48 ICT 2015
                  SOURCE: /Users/vinh/Desktop/warehouse/app/views/products/details.scala.html
                  HASH: 0bf0b73773f46da552021806698ac6f2229f0a3b
                  MATRIX: 741->1|905->29|932->81|959->83|987->103|1026->105|1055->108|1105->133|1119->139|1165->177|1204->179|1235->184|1296->219|1323->238|1358->253|1402->271|1417->277|1486->325|1520->333|1535->339|1605->388|1639->396|1654->402|1738->465|1770->470|1900->573|1915->579|1956->599|2002->615
                  LINES: 26->1|30->1|31->4|32->5|32->5|32->5|33->6|34->7|34->7|34->7|34->7|35->8|36->9|36->9|36->9|37->10|37->10|37->10|38->11|38->11|38->11|39->12|39->12|39->12|40->13|42->15|42->15|42->15|43->16
                  -- GENERATED --
              */
          