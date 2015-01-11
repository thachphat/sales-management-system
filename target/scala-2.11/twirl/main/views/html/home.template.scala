
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
object home extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Double,Double,List[Supplier_Transaction],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(paid: Double, unpaid: Double, supplier_transactions: List[Supplier_Transaction]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.83*/("""
"""),_display_(/*2.2*/main("Suppliers catalogue")/*2.29*/ {_display_(Seq[Any](format.raw/*2.31*/("""
"""),format.raw/*3.1*/("""<div class="row">
    <div class="col-lg-9 main-chart">
        <div class="row mt">
        <!-- SERVER STATUS PANELS -->
        	<div class="col-md-4 col-sm-4 mb">
        		<div class="white-panel pn donut-chart">
        			<div class="white-header">
		  			<h5>SUPPLIER DEBT</h5>
        			</div>
				<div class="row">
					<div class="col-sm-6 col-xs-6 goleft">
						<p><i class="fa fa-database"></i> """),_display_(/*14.42*/unpaid),format.raw/*14.48*/("""%</p>
					</div>
            		</div>
				<canvas id="serverstatus01" height="120" width="120"></canvas>
				<script>
					var doughnutData = [
							"""),format.raw/*20.8*/("""{"""),format.raw/*20.9*/("""
								"""),format.raw/*21.9*/("""value: """),_display_(/*21.17*/paid),format.raw/*21.21*/(""",
								color:"#68dff0"
							"""),format.raw/*23.8*/("""}"""),format.raw/*23.9*/(""",
							"""),format.raw/*24.8*/("""{"""),format.raw/*24.9*/("""
								"""),format.raw/*25.9*/("""value : """),_display_(/*25.18*/unpaid),format.raw/*25.24*/(""",
								color : "#fdfdfd"
							"""),format.raw/*27.8*/("""}"""),format.raw/*27.9*/("""
						"""),format.raw/*28.7*/("""];
						var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
				</script>
            	</div><! --/grey-panel -->
        	</div><!-- /col-md-4-->
        	

        	<div class="col-md-4 col-sm-4 mb">
        		<div class="white-panel pn">
        			<div class="white-header">
		  			<h5>TOP PRODUCT</h5>
        			</div>
				<div class="row">
					<div class="col-sm-6 col-xs-6 goleft">
						<p><i class="fa fa-heart"></i> 122</p>
					</div>
					<div class="col-sm-6 col-xs-6"></div>
            		</div>
            		<div class="centered">
						<img src="assets/img/product.png" width="120">
            		</div>
        		</div>
        	</div><!-- /col-md-4 -->
        	
		<div class="col-md-4 mb">
			<!-- WHITE PANEL - TOP USER -->
			<div class="white-panel pn">
				<div class="white-header">
					<h5>TOP USER</h5>
				</div>
				<p><img src="assets/img/ui-zac.jpg" class="img-circle" width="80"></p>
				<p><b>Zac Snider</b></p>
				<div class="row">
					<div class="col-md-6">
						<p class="small mt">MEMBER SINCE</p>
						<p>2012</p>
					</div>
					<div class="col-md-6">
						<p class="small mt">TOTAL SPEND</p>
						<p>$ 47,60</p>
					</div>
				</div>
			</div>
		</div><!-- /col-md-4 -->
        	

      </div><!-- /row -->
      
      				
	<div class="row">
		<!-- TWITTER PANEL -->
		<div class="col-md-4 mb">
        		<div class="darkblue-panel pn">
        			<div class="darkblue-header">
		  			<h5>DROPBOX STATICS</h5>
        			</div>
				<canvas id="serverstatus02" height="120" width="120"></canvas>
				<script>
					var doughnutData = [
							"""),format.raw/*87.8*/("""{"""),format.raw/*87.9*/("""
								"""),format.raw/*88.9*/("""value: 60,
								color:"#68dff0"
							"""),format.raw/*90.8*/("""}"""),format.raw/*90.9*/(""",
							"""),format.raw/*91.8*/("""{"""),format.raw/*91.9*/("""
								"""),format.raw/*92.9*/("""value : 40,
								color : "#444c57"
							"""),format.raw/*94.8*/("""}"""),format.raw/*94.9*/("""
						"""),format.raw/*95.7*/("""];
						var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
				</script>
				<p>April 17, 2014</p>
				<footer>
					<div class="pull-left">
						<h5><i class="fa fa-hdd-o"></i> 17 GB</h5>
					</div>
					<div class="pull-right">
						<h5>60% Used</h5>
					</div>
				</footer>
        		</div><! -- /darkblue panel -->
		</div><!-- /col-md-4 -->
		
		
		<div class="col-md-4 mb">
			<!-- INSTAGRAM PANEL -->
			<div class="instagram-panel pn">
				<i class="fa fa-instagram fa-4x"></i>
				<p><br/>
					5 min. ago
				</p>
				<p><i class="fa fa-comment"></i> 18 | <i class="fa fa-heart"></i> 49</p>
			</div>
		</div><!-- /col-md-4 -->
		
		<div class="col-md-4 col-sm-4 mb">
			<!-- REVENUE PANEL -->
			<div class="darkblue-panel pn">
				<div class="darkblue-header">
					<h5>REVENUE</h5>
				</div>
				<div class="chart mt">
					<div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4" data-data="[200,135,667,333,526,996,564,123,890,464,655]"></div>
				</div>
				<p class="mt"><b>$ 17,980</b><br/>Month Income</p>
			</div>
		</div><!-- /col-md-4 -->
		
	</div><!-- /row -->
	
	<div class="row mt">
        <!--CUSTOM CHART START -->
        <div class="border-head">
            <h3>VISITS</h3>
        </div>
        <div class="custom-bar-chart">
            <ul class="y-axis">
                <li><span>10.000</span></li>
                <li><span>8.000</span></li>
                <li><span>6.000</span></li>
                <li><span>4.000</span></li>
                <li><span>2.000</span></li>
                <li><span>0</span></li>
            </ul>
            <div class="bar">
                <div class="title">JAN</div>
                <div class="value tooltips" data-original-title="8.500" data-toggle="tooltip" data-placement="top">85%</div>
            </div>
            <div class="bar ">
                <div class="title">FEB</div>
                <div class="value tooltips" data-original-title="5.000" data-toggle="tooltip" data-placement="top">50%</div>
            </div>
            <div class="bar ">
                <div class="title">MAR</div>
                <div class="value tooltips" data-original-title="6.000" data-toggle="tooltip" data-placement="top">60%</div>
            </div>
            <div class="bar ">
                <div class="title">APR</div>
                <div class="value tooltips" data-original-title="4.500" data-toggle="tooltip" data-placement="top">45%</div>
            </div>
            <div class="bar">
                <div class="title">MAY</div>
                <div class="value tooltips" data-original-title="3.200" data-toggle="tooltip" data-placement="top">32%</div>
            </div>
            <div class="bar ">
                <div class="title">JUN</div>
                <div class="value tooltips" data-original-title="6.200" data-toggle="tooltip" data-placement="top">62%</div>
            </div>
            <div class="bar">
                <div class="title">JUL</div>
                <div class="value tooltips" data-original-title="7.500" data-toggle="tooltip" data-placement="top">75%</div>
            </div>
        </div>
        <!--custom chart end-->
	</div><!-- /row -->	
	
    </div><!-- /col-lg-9 END SECTION MIDDLE -->
    
<!-- **********************************************************************************************************************************************************
RIGHT SIDEBAR CONTENT
*********************************************************************************************************************************************************** -->                  
            
            <div class="col-lg-3 ds">
              <!--COMPLETED ACTIONS DONUTS CHART-->
				<h3>ACTIVITIES</h3>
               """),_display_(/*192.17*/for(transaction<-supplier_transactions) yield /*192.56*/{_display_(Seq[Any](format.raw/*192.57*/("""                  
                """),format.raw/*193.17*/("""<!-- First Action -->
                <div class="desc">
                	<div class="thumb">
                		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                	</div>
                	<div class="details">
                		<p><muted>"""),_display_(/*199.30*/transaction/*199.41*/.buyDate),format.raw/*199.49*/("""</muted><br/>
                		   Imported  <a href="#"> """),_display_(/*200.46*/transaction/*200.57*/.quantity),format.raw/*200.66*/("""</a> of """),_display_(/*200.75*/transaction/*200.86*/.product.name),format.raw/*200.99*/(""" """),format.raw/*200.100*/("""from """),_display_(/*200.106*/transaction/*200.117*/.supplier.name),format.raw/*200.131*/("""<br/>
                		</p>
                	</div>
                </div>
				""")))}),format.raw/*204.6*/("""
                """),format.raw/*205.17*/("""<!-- Second Action -->
                <div class="desc">
                	<div class="thumb">
                		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                	</div>
                	<div class="details">
                		<p><muted>3 Hours Ago</muted><br/>
                		   <a href="#">Diana Kennedy</a> purchased a year subscription.<br/>
                		</p>
                	</div>
                </div>
                <!-- Third Action -->
                <div class="desc">
                	<div class="thumb">
                		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                	</div>
                	<div class="details">
                		<p><muted>7 Hours Ago</muted><br/>
                		   <a href="#">Brandon Page</a> purchased a year subscription.<br/>
                		</p>
                	</div>
                </div>
                <!-- Fourth Action -->
                <div class="desc">
                	<div class="thumb">
                		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                	</div>
                	<div class="details">
                		<p><muted>11 Hours Ago</muted><br/>
                		   <a href="#">Mark Twain</a> commented your post.<br/>
                		</p>
                	</div>
                </div>
                <!-- Fifth Action -->
                <div class="desc">
                	<div class="thumb">
                		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                	</div>
                	<div class="details">
                		<p><muted>18 Hours Ago</muted><br/>
                		   <a href="#">Daniel Pratt</a> purchased a wallet in your store.<br/>
                		</p>
                	</div>
                </div>
			   	<script type="text/javascript">
			           $(document).ready(function () """),format.raw/*250.45*/("""{"""),format.raw/*250.46*/("""
			           """),format.raw/*251.15*/("""var unique_id = $.gritter.add("""),format.raw/*251.45*/("""{"""),format.raw/*251.46*/("""
			               """),format.raw/*252.19*/("""// (string | mandatory) the heading of the notification
			               title: 'Welcome to Dashgum!',
			               // (string | mandatory) the text inside the notification
			               text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
			               // (string | optional) the image to display on the left
			               image: '"""),_display_(/*257.28*/routes/*257.34*/.Assets.at("img/ui-sam.jpg")),format.raw/*257.62*/("""',
			               // (bool | optional) if you want it to fade out on its own or just sit there
			               sticky: true,
			               // (int | optional) the time you want it to be alive for before fading out
			               time: '',
			               // (string | optional) the class name you want to apply to that specific message
			               class_name: 'my-sticky-class'
			           """),format.raw/*264.15*/("""}"""),format.raw/*264.16*/(""");

			           return false;
			           """),format.raw/*267.15*/("""}"""),format.raw/*267.16*/(""");
			   	</script>
	
              
                
            </div><!-- /col-lg-3 -->
        </div><! --/row -->
		""")))}))}
  }

  def render(paid:Double,unpaid:Double,supplier_transactions:List[Supplier_Transaction]): play.twirl.api.HtmlFormat.Appendable = apply(paid,unpaid,supplier_transactions)

  def f:((Double,Double,List[Supplier_Transaction]) => play.twirl.api.HtmlFormat.Appendable) = (paid,unpaid,supplier_transactions) => apply(paid,unpaid,supplier_transactions)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 11 22:56:22 ICT 2015
                  SOURCE: /Users/mac/Downloads/activator-1.2.12/sales-management-system/app/views/home.scala.html
                  HASH: ab87d6307934150922d7eaa2d86d274be7d14117
                  MATRIX: 756->1|925->82|952->84|987->111|1026->113|1053->114|1491->525|1518->531|1697->683|1725->684|1761->693|1796->701|1821->705|1881->738|1909->739|1945->748|1973->749|2009->758|2045->767|2072->773|2134->808|2162->809|2196->816|3878->2471|3906->2472|3942->2481|4011->2523|4039->2524|4075->2533|4103->2534|4139->2543|4211->2588|4239->2589|4273->2596|8279->6574|8335->6613|8375->6614|8439->6649|8737->6919|8758->6930|8788->6938|8875->6997|8896->7008|8927->7017|8964->7026|8985->7037|9020->7050|9051->7051|9086->7057|9108->7068|9145->7082|9257->7163|9303->7180|11259->9107|11289->9108|11333->9123|11392->9153|11422->9154|11470->9173|12014->9689|12030->9695|12080->9723|12521->10135|12551->10136|12626->10182|12656->10183
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|42->14|42->14|48->20|48->20|49->21|49->21|49->21|51->23|51->23|52->24|52->24|53->25|53->25|53->25|55->27|55->27|56->28|115->87|115->87|116->88|118->90|118->90|119->91|119->91|120->92|122->94|122->94|123->95|220->192|220->192|220->192|221->193|227->199|227->199|227->199|228->200|228->200|228->200|228->200|228->200|228->200|228->200|228->200|228->200|228->200|232->204|233->205|278->250|278->250|279->251|279->251|279->251|280->252|285->257|285->257|285->257|292->264|292->264|295->267|295->267
                  -- GENERATED --
              */
          