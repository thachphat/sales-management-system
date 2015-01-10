// @SOURCE:/Users/vinh/Desktop/warehouse/conf/routes
// @HASH:a00da631c7962a6f4f6d4717f17775057786a9ab
// @DATE:Sun Jan 04 20:52:55 ICT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:11
private[this] lazy val controllers_Products_list2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products"))))
private[this] lazy val controllers_Products_list2_invoker = createInvoker(
controllers.Products.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "list", Nil,"GET", """""", Routes.prefix + """products"""))
        

// @LINE:13
private[this] lazy val controllers_Products_newProduct3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/new"))))
private[this] lazy val controllers_Products_newProduct3_invoker = createInvoker(
controllers.Products.newProduct(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "newProduct", Nil,"GET", """""", Routes.prefix + """products/new"""))
        

// @LINE:15
private[this] lazy val controllers_Products_details4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"),DynamicPart("ean", """[^/]+""",true))))
private[this] lazy val controllers_Products_details4_invoker = createInvoker(
controllers.Products.details(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "details", Seq(classOf[String]),"GET", """""", Routes.prefix + """products/$ean<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_Products_save5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products"))))
private[this] lazy val controllers_Products_save5_invoker = createInvoker(
controllers.Products.save(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "save", Nil,"POST", """""", Routes.prefix + """products"""))
        

// @LINE:19
private[this] lazy val controllers_Products_delete6_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"),DynamicPart("ean", """[^/]+""",true))))
private[this] lazy val controllers_Products_delete6_invoker = createInvoker(
controllers.Products.delete(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "delete", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """products/$ean<[^/]+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products""","""controllers.Products.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/new""","""controllers.Products.newProduct()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/$ean<[^/]+>""","""controllers.Products.details(ean:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products""","""controllers.Products.save()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/$ean<[^/]+>""","""controllers.Products.delete(ean:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:9
case controllers_Assets_at1_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:11
case controllers_Products_list2_route(params) => {
   call { 
        controllers_Products_list2_invoker.call(controllers.Products.list())
   }
}
        

// @LINE:13
case controllers_Products_newProduct3_route(params) => {
   call { 
        controllers_Products_newProduct3_invoker.call(controllers.Products.newProduct())
   }
}
        

// @LINE:15
case controllers_Products_details4_route(params) => {
   call(params.fromPath[String]("ean", None)) { (ean) =>
        controllers_Products_details4_invoker.call(controllers.Products.details(ean))
   }
}
        

// @LINE:17
case controllers_Products_save5_route(params) => {
   call { 
        controllers_Products_save5_invoker.call(controllers.Products.save())
   }
}
        

// @LINE:19
case controllers_Products_delete6_route(params) => {
   call(params.fromPath[String]("ean", None)) { (ean) =>
        controllers_Products_delete6_invoker.call(controllers.Products.delete(ean))
   }
}
        
}

}
     