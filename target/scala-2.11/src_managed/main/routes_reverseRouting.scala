// @SOURCE:/Users/vinh/Desktop/warehouse/conf/routes
// @HASH:a00da631c7962a6f4f6d4717f17775057786a9ab
// @DATE:Sun Jan 04 20:52:55 ICT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
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
                          

// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
class ReverseProducts {


// @LINE:15
def details(ean:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/" + implicitly[PathBindable[String]].unbind("ean", dynamicString(ean)))
}
                        

// @LINE:11
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products")
}
                        

// @LINE:19
def delete(ean:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "products/" + implicitly[PathBindable[String]].unbind("ean", dynamicString(ean)))
}
                        

// @LINE:17
def save(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "products")
}
                        

// @LINE:13
def newProduct(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/new")
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
                          
}
                  


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
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
              

// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
class ReverseProducts {


// @LINE:15
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
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
      }
   """
)
                        

// @LINE:19
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.delete",
   """
      function(ean) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ean", encodeURIComponent(ean))})
      }
   """
)
                        

// @LINE:17
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
      }
   """
)
                        

// @LINE:13
def newProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Products.newProduct",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/new"})
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
              
}
        


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
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
                          

// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
class ReverseProducts {


// @LINE:15
def details(ean:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.details(ean), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "details", Seq(classOf[String]), "GET", """""", _prefix + """products/$ean<[^/]+>""")
)
                      

// @LINE:11
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "list", Seq(), "GET", """""", _prefix + """products""")
)
                      

// @LINE:19
def delete(ean:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.delete(ean), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "delete", Seq(classOf[String]), "DELETE", """""", _prefix + """products/$ean<[^/]+>""")
)
                      

// @LINE:17
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.save(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "save", Seq(), "POST", """""", _prefix + """products""")
)
                      

// @LINE:13
def newProduct(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Products.newProduct(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Products", "newProduct", Seq(), "GET", """""", _prefix + """products/new""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    