
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
object update extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[Supplier_Transaction],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(transactionForm: Form[Supplier_Transaction],name: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.60*/("""

"""),_display_(/*3.2*/main("transaction form")/*3.26*/{_display_(Seq[Any](format.raw/*3.27*/("""
"""),format.raw/*4.1*/("""<h1> transaction form </h1>
<form class="form-horizontal" method="POST" action=""""),_display_(/*5.54*/routes/*5.60*/.Supplier_Transactions.save(name)),format.raw/*5.93*/("""">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Product</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="product_ean">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Supplier</label>
    <div class="col-sm-9">
      <input readonly="readonly" type="text" class="form-control" name="supplier_name" placeholder="""),_display_(/*15.101*/name),format.raw/*15.105*/(""" """),format.raw/*15.106*/("""value="""),_display_(/*15.113*/name),format.raw/*15.117*/(""">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Quantity</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="quantity" placeholder="""),_display_(/*21.76*/transactionForm("name")/*21.99*/.valueOr("Name")),format.raw/*21.115*/(""" """),format.raw/*21.116*/("""value="""),_display_(/*21.123*/transactionForm("name")/*21.146*/.value()),format.raw/*21.154*/(""">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Status</label>
    <div class="col-sm-9">
	<div class="checkbox checkbox-inline">
	      <label><input type="checkbox" name="status" value="true">Paid</label>
	    </div>
	    <div class="checkbox checkbox-inline">
	      <label><input type="checkbox" name="status" value="false">Not Paid</label>
	    </div>
		</div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  </div>
</form>

""")))}))}
  }

  def render(transactionForm:Form[Supplier_Transaction],name:String): play.twirl.api.HtmlFormat.Appendable = apply(transactionForm,name)

  def f:((Form[Supplier_Transaction],String) => play.twirl.api.HtmlFormat.Appendable) = (transactionForm,name) => apply(transactionForm,name)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 11 22:52:11 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/supplier_transactions/update.scala.html
                  HASH: a56843280ccfab84837a244ae1e0b5e15e1d23b7
                  MATRIX: 773->1|919->59|947->62|979->86|1017->87|1044->88|1151->169|1165->175|1218->208|1696->658|1722->662|1752->663|1787->670|1813->674|2068->902|2100->925|2138->941|2168->942|2203->949|2236->972|2266->980
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|33->5|33->5|33->5|43->15|43->15|43->15|43->15|43->15|49->21|49->21|49->21|49->21|49->21|49->21|49->21
                  -- GENERATED --
              */
          