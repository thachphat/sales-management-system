// @SOURCE:/Users/mac/Downloads/activator-1.2.12/sales-management-system/conf/routes
// @HASH:6d69c74ce2c4bf1738ee180c3aa45e6ed44e8749
// @DATE:Wed Jan 14 11:13:12 ICT 2015


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
private[this] lazy val controllers_Application_home0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_home0_invoker = createInvoker(
controllers.Application.home(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "home", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:11
private[this] lazy val controllers_Products_list2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"))))
private[this] lazy val controllers_Products_list2_invoker = createInvoker(
controllers.Products.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "list", Nil,"GET", """ Product routes""", Routes.prefix + """products/"""))
        

// @LINE:12
private[this] lazy val controllers_Products_newProduct3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/new"))))
private[this] lazy val controllers_Products_newProduct3_invoker = createInvoker(
controllers.Products.newProduct(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "newProduct", Nil,"GET", """""", Routes.prefix + """products/new"""))
        

// @LINE:13
private[this] lazy val controllers_Products_details4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"),DynamicPart("ean", """[^/]+""",true))))
private[this] lazy val controllers_Products_details4_invoker = createInvoker(
controllers.Products.details(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "details", Seq(classOf[String]),"GET", """""", Routes.prefix + """products/$ean<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_Products_update5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"),DynamicPart("ean", """[^/]+""",true),StaticPart("/edit"))))
private[this] lazy val controllers_Products_update5_invoker = createInvoker(
controllers.Products.update(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "update", Seq(classOf[String]),"GET", """""", Routes.prefix + """products/$ean<[^/]+>/edit"""))
        

// @LINE:15
private[this] lazy val controllers_Products_save6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"))))
private[this] lazy val controllers_Products_save6_invoker = createInvoker(
controllers.Products.save(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "save", Nil,"POST", """""", Routes.prefix + """products/"""))
        

// @LINE:16
private[this] lazy val controllers_Products_delete7_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"),DynamicPart("ean", """[^/]+""",true))))
private[this] lazy val controllers_Products_delete7_invoker = createInvoker(
controllers.Products.delete(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "delete", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """products/$ean<[^/]+>"""))
        

// @LINE:18
private[this] lazy val controllers_Suppliers_list8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/"))))
private[this] lazy val controllers_Suppliers_list8_invoker = createInvoker(
controllers.Suppliers.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "list", Nil,"GET", """ Supplier routes""", Routes.prefix + """suppliers/"""))
        

// @LINE:19
private[this] lazy val controllers_Suppliers_newSupplier9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/new"))))
private[this] lazy val controllers_Suppliers_newSupplier9_invoker = createInvoker(
controllers.Suppliers.newSupplier(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "newSupplier", Nil,"GET", """""", Routes.prefix + """suppliers/new"""))
        

// @LINE:20
private[this] lazy val controllers_Suppliers_details10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_Suppliers_details10_invoker = createInvoker(
controllers.Suppliers.details(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "details", Seq(classOf[String]),"GET", """""", Routes.prefix + """suppliers/$name<[^/]+>"""))
        

// @LINE:21
private[this] lazy val controllers_Suppliers_save11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/"))))
private[this] lazy val controllers_Suppliers_save11_invoker = createInvoker(
controllers.Suppliers.save(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "save", Nil,"POST", """""", Routes.prefix + """suppliers/"""))
        

// @LINE:22
private[this] lazy val controllers_Suppliers_delete12_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_Suppliers_delete12_invoker = createInvoker(
controllers.Suppliers.delete(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "delete", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """suppliers/$name<[^/]+>"""))
        

// @LINE:26
private[this] lazy val controllers_Supplier_Transactions_newTransaction13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/"),DynamicPart("name", """[^/]+""",true),StaticPart("/transactions/new"))))
private[this] lazy val controllers_Supplier_Transactions_newTransaction13_invoker = createInvoker(
controllers.Supplier_Transactions.newTransaction(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "newTransaction", Seq(classOf[String]),"GET", """""", Routes.prefix + """suppliers/$name<[^/]+>/transactions/new"""))
        

// @LINE:27
private[this] lazy val controllers_Supplier_Transactions_details14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("transactions/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Supplier_Transactions_details14_invoker = createInvoker(
controllers.Supplier_Transactions.details(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "details", Seq(classOf[Long]),"GET", """""", Routes.prefix + """transactions/$id<[^/]+>"""))
        

// @LINE:28
private[this] lazy val controllers_Supplier_Transactions_list15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("transactions/"))))
private[this] lazy val controllers_Supplier_Transactions_list15_invoker = createInvoker(
controllers.Supplier_Transactions.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "list", Nil,"GET", """""", Routes.prefix + """transactions/"""))
        

// @LINE:29
private[this] lazy val controllers_Supplier_Transactions_delete16_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("transactions/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Supplier_Transactions_delete16_invoker = createInvoker(
controllers.Supplier_Transactions.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """transactions/$id<[^/]+>"""))
        

// @LINE:31
private[this] lazy val controllers_Supplier_Transactions_save17_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("suppliers/"),DynamicPart("name", """[^/]+""",true),StaticPart("/transactions/"))))
private[this] lazy val controllers_Supplier_Transactions_save17_invoker = createInvoker(
controllers.Supplier_Transactions.save(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "save", Seq(classOf[String]),"POST", """""", Routes.prefix + """suppliers/$name<[^/]+>/transactions/"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.home()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/""","""controllers.Products.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/new""","""controllers.Products.newProduct()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/$ean<[^/]+>""","""controllers.Products.details(ean:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/$ean<[^/]+>/edit""","""controllers.Products.update(ean:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/""","""controllers.Products.save()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/$ean<[^/]+>""","""controllers.Products.delete(ean:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/""","""controllers.Suppliers.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/new""","""controllers.Suppliers.newSupplier()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/$name<[^/]+>""","""controllers.Suppliers.details(name:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/""","""controllers.Suppliers.save()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/$name<[^/]+>""","""controllers.Suppliers.delete(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/$name<[^/]+>/transactions/new""","""controllers.Supplier_Transactions.newTransaction(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """transactions/$id<[^/]+>""","""controllers.Supplier_Transactions.details(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """transactions/""","""controllers.Supplier_Transactions.list()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """transactions/$id<[^/]+>""","""controllers.Supplier_Transactions.delete(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """suppliers/$name<[^/]+>/transactions/""","""controllers.Supplier_Transactions.save(name:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_home0_route(params) => {
   call { 
        controllers_Application_home0_invoker.call(controllers.Application.home())
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
        

// @LINE:12
case controllers_Products_newProduct3_route(params) => {
   call { 
        controllers_Products_newProduct3_invoker.call(controllers.Products.newProduct())
   }
}
        

// @LINE:13
case controllers_Products_details4_route(params) => {
   call(params.fromPath[String]("ean", None)) { (ean) =>
        controllers_Products_details4_invoker.call(controllers.Products.details(ean))
   }
}
        

// @LINE:14
case controllers_Products_update5_route(params) => {
   call(params.fromPath[String]("ean", None)) { (ean) =>
        controllers_Products_update5_invoker.call(controllers.Products.update(ean))
   }
}
        

// @LINE:15
case controllers_Products_save6_route(params) => {
   call { 
        controllers_Products_save6_invoker.call(controllers.Products.save())
   }
}
        

// @LINE:16
case controllers_Products_delete7_route(params) => {
   call(params.fromPath[String]("ean", None)) { (ean) =>
        controllers_Products_delete7_invoker.call(controllers.Products.delete(ean))
   }
}
        

// @LINE:18
case controllers_Suppliers_list8_route(params) => {
   call { 
        controllers_Suppliers_list8_invoker.call(controllers.Suppliers.list())
   }
}
        

// @LINE:19
case controllers_Suppliers_newSupplier9_route(params) => {
   call { 
        controllers_Suppliers_newSupplier9_invoker.call(controllers.Suppliers.newSupplier())
   }
}
        

// @LINE:20
case controllers_Suppliers_details10_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Suppliers_details10_invoker.call(controllers.Suppliers.details(name))
   }
}
        

// @LINE:21
case controllers_Suppliers_save11_route(params) => {
   call { 
        controllers_Suppliers_save11_invoker.call(controllers.Suppliers.save())
   }
}
        

// @LINE:22
case controllers_Suppliers_delete12_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Suppliers_delete12_invoker.call(controllers.Suppliers.delete(name))
   }
}
        

// @LINE:26
case controllers_Supplier_Transactions_newTransaction13_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Supplier_Transactions_newTransaction13_invoker.call(controllers.Supplier_Transactions.newTransaction(name))
   }
}
        

// @LINE:27
case controllers_Supplier_Transactions_details14_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Supplier_Transactions_details14_invoker.call(controllers.Supplier_Transactions.details(id))
   }
}
        

// @LINE:28
case controllers_Supplier_Transactions_list15_route(params) => {
   call { 
        controllers_Supplier_Transactions_list15_invoker.call(controllers.Supplier_Transactions.list())
   }
}
        

// @LINE:29
case controllers_Supplier_Transactions_delete16_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Supplier_Transactions_delete16_invoker.call(controllers.Supplier_Transactions.delete(id))
   }
}
        

// @LINE:31
case controllers_Supplier_Transactions_save17_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Supplier_Transactions_save17_invoker.call(controllers.Supplier_Transactions.save(name))
   }
}
        
}

}
     