
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
object details extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Supplier_Transaction,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(transaction: Supplier_Transaction):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.37*/("""

"""),_display_(/*3.2*/main("Transaction")/*3.21*/{_display_(Seq[Any](format.raw/*3.22*/("""

"""),format.raw/*5.1*/("""<h1> Transaction ID : """),_display_(/*5.24*/transaction/*5.35*/.internalId),format.raw/*5.46*/(""" """),format.raw/*5.47*/("""</h1>
<p>Supplier: """),_display_(/*6.15*/transaction/*6.26*/.supplier.name),format.raw/*6.40*/("""</p>
<p>Product: """),_display_(/*7.14*/transaction/*7.25*/.product.name),format.raw/*7.38*/("""</p>
<p>Quantity: """),_display_(/*8.15*/transaction/*8.26*/.quantity),format.raw/*8.35*/("""</p>

""")))}))}
  }

  def render(transaction:Supplier_Transaction): play.twirl.api.HtmlFormat.Appendable = apply(transaction)

  def f:((Supplier_Transaction) => play.twirl.api.HtmlFormat.Appendable) = (transaction) => apply(transaction)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 11:01:05 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/supplier_transactions/details.scala.html
                  HASH: f40d8914bb57e43f3726b8acf1539935d65fb458
                  MATRIX: 761->1|884->36|912->39|939->58|977->59|1005->61|1054->84|1073->95|1104->106|1132->107|1178->127|1197->138|1231->152|1275->170|1294->181|1327->194|1372->213|1391->224|1420->233
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8
                  -- GENERATED --
              */
          