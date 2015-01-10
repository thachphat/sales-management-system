
package views.html

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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(/*7.13*/title),format.raw/*7.18*/("""</title>
    <link href=""""),_display_(/*8.18*/routes/*8.24*/.Assets.at("bootstrap/css/bootstrap.min.css")),format.raw/*8.69*/("""" rel="stylesheet" media="screen">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png")),format.raw/*9.93*/("""">
    <script src=""""),_display_(/*10.19*/routes/*10.25*/.Assets.at("javascripts/jquery-1.9.0.min.js")),format.raw/*10.70*/("""" type="text/javascript"></script>
  </head>
  <body class="container">
    """),_display_(/*13.6*/if(flash.containsKey("success"))/*13.38*/{_display_(Seq[Any](format.raw/*13.39*/("""
      """),format.raw/*14.7*/("""<div class="alert alert-success">
      """),_display_(/*15.8*/flash/*15.13*/.get("success")),format.raw/*15.28*/("""
      """),format.raw/*16.7*/("""</div>
    """)))}),format.raw/*17.6*/("""

    """),_display_(/*19.6*/if(flash.containsKey("error"))/*19.36*/{_display_(Seq[Any](format.raw/*19.37*/("""
      """),format.raw/*20.7*/("""<div class="alert alert-error">
      """),_display_(/*21.8*/flash/*21.13*/.get("error")),format.raw/*21.26*/("""
      """),format.raw/*22.7*/("""</div>
    """)))}),format.raw/*23.6*/("""
  """),_display_(/*24.4*/content),format.raw/*24.11*/("""
  """),format.raw/*25.3*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 09:52:48 ICT 2015
                  SOURCE: /Users/vinh/Desktop/warehouse/app/views/main.scala.html
                  HASH: 607a77dc1bbaff170a2dc8e423883e1ed83f0a6a
                  MATRIX: 727->1|845->31|873->33|944->78|969->83|1021->109|1035->115|1100->160|1215->249|1229->255|1281->287|1329->308|1344->314|1410->359|1513->436|1554->468|1593->469|1627->476|1694->517|1708->522|1744->537|1778->544|1820->556|1853->563|1892->593|1931->594|1965->601|2030->640|2044->645|2078->658|2112->665|2154->677|2184->681|2212->688|2242->691
                  LINES: 26->1|29->1|31->3|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13|41->13|42->14|43->15|43->15|43->15|44->16|45->17|47->19|47->19|47->19|48->20|49->21|49->21|49->21|50->22|51->23|52->24|52->24|53->25
                  -- GENERATED --
              */
          