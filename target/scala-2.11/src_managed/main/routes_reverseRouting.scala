// @SOURCE:/Users/mac/Downloads/activator-1.2.12/library/conf/routes
// @HASH:708e01b0251cb5147a3787efad9b08216a88ae25
// @DATE:Sat Jan 10 12:21:00 ICT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:28
// @LINE:26
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
class ReverseAssets {


// @LINE:9
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:28
// @LINE:26
class ReverseSupplier_Transactions {


// @LINE:28
def save(name:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "suppliers/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)) + "/transactions/")
}
                        

// @LINE:26
def newTransaction(name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "suppliers/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)) + "/transactions/new")
}
                        

}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseSuppliers {


// @LINE:19
def newSupplier(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "suppliers/new")
}
                        

// @LINE:20
def details(name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "suppliers/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

// @LINE:18
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "suppliers/")
}
                        

// @LINE:22
def delete(name:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "suppliers/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

// @LINE:21
def save(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "suppliers/")
}
                        

}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseProducts {


// @LINE:13
def details(ean:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/" + implicitly[PathBindable[String]].unbind("ean", dynamicString(ean)))
}
                        

// @LINE:11
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/")
}
                        

// @LINE:16
def delete(ean:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "products/" + implicitly[PathBindable[String]].unbind("ean", dynamicString(ean)))
}
                        

// @LINE:15
def save(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "products/")
}
                        

// @LINE:14
def update(ean:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/" + implicitly[PathBindable[String]].unbind("ean", dynamicString(ean)) + "/edit")
}
                        

// @LINE:12
def newProduct(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/new")
}
                        

}
                          
}
                  


// @LINE:28
// @LINE:26
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:9
class ReverseAssets {


// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:6
class ReverseApplication {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:28
// @LINE:26
class ReverseSupplier_Transactions {


// @LINE:28
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Supplier_Transactions.save",
   """
      function(name) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name)) + "/transactions/"})
      }
   """
)
                        

// @LINE:26
def newTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Supplier_Transactions.newTransaction",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name)) + "/transactions/new"})
      }
   """
)
                        

}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseSuppliers {


// @LINE:19
def newSupplier : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Suppliers.newSupplier",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/new"})
      }
   """
)
                        

// @LINE:20
def details : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Suppliers.details",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:18
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Suppliers.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/"})
      }
   """
)
                        

// @LINE:22
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Suppliers.delete",
   """
      function(name) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:21
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Suppliers.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "suppliers/"})
      }
   """
)
                        

}
              

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseProducts {


// @LINE:13
def details : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.details",
   """
      function(ean) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ean", encodeURIComponent(ean))})
      }
   """
)
                        

// @LINE:11
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/"})
      }
   """
)
                        

// @LINE:16
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.delete",
   """
      function(ean) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ean", encodeURIComponent(ean))})
      }
   """
)
                        

// @LINE:15
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "products/"})
      }
   """
)
                        

// @LINE:14
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.update",
   """
      function(ean) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ean", encodeURIComponent(ean)) + "/edit"})
      }
   """
)
                        

// @LINE:12
def newProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.newProduct",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/new"})
      }
   """
)
                        

}
              
}
        


// @LINE:28
// @LINE:26
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
class ReverseAssets {


// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          

// @LINE:28
// @LINE:26
class ReverseSupplier_Transactions {


// @LINE:28
def save(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Supplier_Transactions.save(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "save", Seq(classOf[String]), "POST", """""", _prefix + """suppliers/$name<[^/]+>/transactions/""")
)
                      

// @LINE:26
def newTransaction(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Supplier_Transactions.newTransaction(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Supplier_Transactions", "newTransaction", Seq(classOf[String]), "GET", """""", _prefix + """suppliers/$name<[^/]+>/transactions/new""")
)
                      

}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReverseSuppliers {


// @LINE:19
def newSupplier(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Suppliers.newSupplier(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "newSupplier", Seq(), "GET", """""", _prefix + """suppliers/new""")
)
                      

// @LINE:20
def details(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Suppliers.details(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "details", Seq(classOf[String]), "GET", """""", _prefix + """suppliers/$name<[^/]+>""")
)
                      

// @LINE:18
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Suppliers.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "list", Seq(), "GET", """ Supplier routes""", _prefix + """suppliers/""")
)
                      

// @LINE:22
def delete(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Suppliers.delete(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "delete", Seq(classOf[String]), "DELETE", """""", _prefix + """suppliers/$name<[^/]+>""")
)
                      

// @LINE:21
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Suppliers.save(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Suppliers", "save", Seq(), "POST", """""", _prefix + """suppliers/""")
)
                      

}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseProducts {


// @LINE:13
def details(ean:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.details(ean), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "details", Seq(classOf[String]), "GET", """""", _prefix + """products/$ean<[^/]+>""")
)
                      

// @LINE:11
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "list", Seq(), "GET", """ Product routes""", _prefix + """products/""")
)
                      

// @LINE:16
def delete(ean:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.delete(ean), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "delete", Seq(classOf[String]), "DELETE", """""", _prefix + """products/$ean<[^/]+>""")
)
                      

// @LINE:15
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.save(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "save", Seq(), "POST", """""", _prefix + """products/""")
)
                      

// @LINE:14
def update(ean:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.update(ean), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "update", Seq(classOf[String]), "GET", """""", _prefix + """products/$ean<[^/]+>/edit""")
)
                      

// @LINE:12
def newProduct(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.newProduct(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "newProduct", Seq(), "GET", """""", _prefix + """products/new""")
)
                      

}
                          
}
        
    