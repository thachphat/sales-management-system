
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
      <input type="text" class="form-control" readonly="readonly" name="ean" placeholder="""),_display_(/*9.91*/productForm("ean")/*9.109*/.valueOr("Ean")),format.raw/*9.124*/(""" """),format.raw/*9.125*/("""value="""),_display_(/*9.132*/productForm("ean")/*9.150*/.value()),format.raw/*9.158*/(""">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="description" placeholder="""),_display_(/*16.79*/productForm("description")/*16.105*/.valueOr("Description")),format.raw/*16.128*/(""" """),format.raw/*16.129*/("""value="""),_display_(/*16.136*/productForm("description")/*16.162*/.value()),format.raw/*16.170*/(""">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" placeholder="""),_display_(/*23.72*/productForm("name")/*23.91*/.valueOr("Name")),format.raw/*23.107*/(""" """),format.raw/*23.108*/("""value="""),_display_(/*23.115*/productForm("name")/*23.134*/.value()),format.raw/*23.142*/(""">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Quantity</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="instock" placeholder="""),_display_(/*29.75*/productForm("instock")/*29.97*/.valueOr("2")),format.raw/*29.110*/(""" """),format.raw/*29.111*/("""value="""),_display_(/*29.118*/productForm("instock")/*29.140*/.value()),format.raw/*29.148*/(""">
    </div>
  </div>
  """),_display_(/*32.4*/if(productForm.hasErrors)/*32.29*/ {_display_(Seq[Any](format.raw/*32.31*/("""
      """),format.raw/*33.7*/("""<div class="alert alert-error">
          """),_display_(/*34.12*/if(productForm.errors.size() > 0)/*34.45*/ {_display_(Seq[Any](format.raw/*34.47*/("""
              """),_display_(/*35.16*/for((key, value) <- productForm.errors) yield /*35.55*/ {_display_(Seq[Any](format.raw/*35.57*/("""
                  """),_display_(/*36.20*/key/*36.23*/.toString()),format.raw/*36.34*/(""" """),format.raw/*36.35*/(""": 
                      """),_display_(/*37.24*/for(err <- value) yield /*37.41*/ {_display_(Seq[Any](format.raw/*37.43*/("""
                          """),_display_(/*38.28*/err/*38.31*/.message().toString()),format.raw/*38.52*/("""
                      """)))}),format.raw/*39.24*/("""
              """)))}),format.raw/*40.16*/("""
          """)))}/*41.13*/else/*41.18*/{_display_(Seq[Any](format.raw/*41.19*/("""No error returned.""")))}),format.raw/*41.38*/("""
      """),format.raw/*42.7*/("""</div>
  """)))}),format.raw/*43.4*/("""    
  """),format.raw/*44.3*/("""<div class="form-group">
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
                  DATE: Wed Jan 14 13:23:38 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/products/update.scala.html
                  HASH: abdd4ea499ca0291df68dcb1d64e63f3b0964c43
                  MATRIX: 755->1|898->56|926->59|954->79|992->80|1019->81|1122->158|1136->164|1172->180|1417->399|1444->417|1480->432|1509->433|1543->440|1570->458|1599->466|1867->707|1903->733|1948->756|1978->757|2013->764|2049->790|2079->798|2333->1025|2361->1044|2399->1060|2429->1061|2464->1068|2493->1087|2523->1095|2781->1326|2812->1348|2847->1361|2877->1362|2912->1369|2944->1391|2974->1399|3025->1424|3059->1449|3099->1451|3133->1458|3203->1501|3245->1534|3285->1536|3328->1552|3383->1591|3423->1593|3470->1613|3482->1616|3514->1627|3543->1628|3596->1654|3629->1671|3669->1673|3724->1701|3736->1704|3778->1725|3833->1749|3880->1765|3911->1778|3924->1783|3963->1784|4013->1803|4047->1810|4087->1820|4121->1827
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|33->5|33->5|33->5|37->9|37->9|37->9|37->9|37->9|37->9|37->9|44->16|44->16|44->16|44->16|44->16|44->16|44->16|51->23|51->23|51->23|51->23|51->23|51->23|51->23|57->29|57->29|57->29|57->29|57->29|57->29|57->29|60->32|60->32|60->32|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|68->40|69->41|69->41|69->41|69->41|70->42|71->43|72->44
                  -- GENERATED --
              */
          