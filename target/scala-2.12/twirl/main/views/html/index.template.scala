
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[models.Product],List[models.Category],models.users.User,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: List[models.Product], categories: List[models.Category], user: models.users.User, env: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.121*/("""

"""),_display_(/*3.2*/main("Products", user)/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""     
    """),format.raw/*4.5*/("""<p class="lead">Product Catalogue</p>    
    <div class="row">
        <div class="col-sm-2">
            <h4>Categories</h4>
            <div class="list-group">
                    <!-- A link to display all the products -->
                    <a href=""""),_display_(/*10.31*/routes/*10.37*/.HomeController.index(0)),format.raw/*10.61*/("""" class="list-group-item">All Categories</a>
                    <!-- Start of for loop - for each c in categories add a list item -->
                    <!-- Also show the number of products in each category --> 
                    """),_display_(/*13.22*/for(c <- categories) yield /*13.42*/ {_display_(Seq[Any](format.raw/*13.44*/("""
                        """),format.raw/*14.25*/("""<a href=""""),_display_(/*14.35*/routes/*14.41*/.HomeController.index(c.getId)),format.raw/*14.71*/("""" class="list-group-item">"""),_display_(/*14.98*/c/*14.99*/.getName),format.raw/*14.107*/("""
                            """),format.raw/*15.29*/("""<span class="badge">"""),_display_(/*15.50*/c/*15.51*/.getProducts.size()),format.raw/*15.70*/("""</span>
                        </a>
                    """)))}),format.raw/*17.22*/("""
            """),format.raw/*18.13*/("""</div>
        </div>
        <div class="col-sm-10">
            """),format.raw/*21.77*/("""
            """),_display_(/*22.14*/if(flash.containsKey("success"))/*22.46*/ {_display_(Seq[Any](format.raw/*22.48*/("""
                """),format.raw/*23.17*/("""<div class="alert alert-success">
                    """),_display_(/*24.22*/flash/*24.27*/.get("success")),format.raw/*24.42*/("""
                """),format.raw/*25.17*/("""</div>
            """)))}),format.raw/*26.14*/(""" 
            
            """),format.raw/*28.13*/("""<table class="table table-bordered table-hover table-condensed"> 
                <thead> 
                <!-- The header row--> 
                <tr> 
                    <th>Image</th>
                    <th>ID</th> 
                    <th>Name</th> 
                    <th>Category</th>                                 
                    <th>Description</th>                             
                    <th>Stock</th> 
                    <th>Price</th> 
                </tr> 
                </thead> 
                <tbody> 
                    """),format.raw/*42.72*/("""
                    """),_display_(/*43.22*/for(p<-products) yield /*43.38*/ {_display_(Seq[Any](format.raw/*43.40*/("""
                        """),format.raw/*44.25*/("""<tr> 
                            """),_display_(/*45.30*/if(env.resource("public/images/productImages/thumbnails/" + p.getId + ".jpg").isDefined)/*45.118*/ {_display_(Seq[Any](format.raw/*45.120*/("""
                                """),format.raw/*46.33*/("""<td><img src="/assets/images/productImages/thumbnails/"""),_display_(/*46.88*/(p.getId + ".jpg")),format.raw/*46.106*/(""""/></td>
                            """)))}/*47.31*/else/*47.36*/{_display_(Seq[Any](format.raw/*47.37*/("""
                                """),format.raw/*48.33*/("""<td><img src="/assets/images/productImages/thumbnails/noImage.jpg"/></td>
                            """)))}),format.raw/*49.30*/("""
                            """),format.raw/*50.29*/("""<td>"""),_display_(/*50.34*/p/*50.35*/.getId),format.raw/*50.41*/("""</td> 
                            <td>"""),_display_(/*51.34*/p/*51.35*/.getName),format.raw/*51.43*/("""</td> 
                            <td>"""),_display_(/*52.34*/p/*52.35*/.getCategory.getName),format.raw/*52.55*/("""</td>
                            <td>"""),_display_(/*53.34*/p/*53.35*/.getDescription),format.raw/*53.50*/("""</td> 
                            <td>"""),_display_(/*54.34*/p/*54.35*/.getStock),format.raw/*54.44*/("""</td> 
                            <td class="numeric">&euro; """),_display_(/*55.57*/("%.2f".format(p.getPrice))),format.raw/*55.84*/("""</td> 
                            <!-- Edit product button -->
                            <td> 
                                <a href=""""),_display_(/*58.43*/routes/*58.49*/.HomeController.updateProduct(p.getId)),format.raw/*58.87*/("""" class="button-xs btn-danger">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </td>
                            <!-- Delete product button -->
                            <td> 
                                <a href=""""),_display_(/*64.43*/routes/*64.49*/.HomeController.deleteProduct(p.getId)),format.raw/*64.87*/("""" class="button-xs btn-danger" onclick="return confirmDel();">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </tr> 
                    """)))}),format.raw/*69.22*/(""" """),format.raw/*69.44*/("""
                """),format.raw/*70.17*/("""</tbody> 
            </table> 
            <p>
                <a href=""""),_display_(/*73.27*/routes/*73.33*/.HomeController.addProduct()),format.raw/*73.61*/("""">
                    <button class="btn btn-primary">Add a product</button>
                </a>
            </p>
        </div>
    </div>
""")))}),format.raw/*79.2*/(""" 

"""))
      }
    }
  }

  def render(products:List[models.Product],categories:List[models.Category],user:models.users.User,env:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(products,categories,user,env)

  def f:((List[models.Product],List[models.Category],models.users.User,play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (products,categories,user,env) => apply(products,categories,user,env)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Dec 16 16:06:38 GMT 2017
                  SOURCE: /home/jvk/temp/UploadImageLab_from_LoginLabComplete/app/views/index.scala.html
                  HASH: 57e07893ebbe3ba242db05ddf38dd0aec6ee90fe
                  MATRIX: 1023->1|1238->120|1266->123|1296->145|1335->147|1371->157|1656->415|1671->421|1716->445|1979->681|2015->701|2055->703|2108->728|2145->738|2160->744|2211->774|2265->801|2275->802|2305->810|2362->839|2410->860|2420->861|2460->880|2549->938|2590->951|2684->1081|2725->1095|2766->1127|2806->1129|2851->1146|2933->1201|2947->1206|2983->1221|3028->1238|3079->1258|3134->1285|3725->1899|3774->1921|3806->1937|3846->1939|3899->1964|3961->1999|4059->2087|4100->2089|4161->2122|4243->2177|4283->2195|4340->2234|4353->2239|4392->2240|4453->2273|4587->2376|4644->2405|4676->2410|4686->2411|4713->2417|4780->2457|4790->2458|4819->2466|4886->2506|4896->2507|4937->2527|5003->2566|5013->2567|5049->2582|5116->2622|5126->2623|5156->2632|5246->2695|5294->2722|5461->2862|5476->2868|5535->2906|5885->3229|5900->3235|5959->3273|6260->3543|6289->3565|6334->3582|6435->3656|6450->3662|6499->3690|6672->3833
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|42->10|42->10|42->10|45->13|45->13|45->13|46->14|46->14|46->14|46->14|46->14|46->14|46->14|47->15|47->15|47->15|47->15|49->17|50->18|53->21|54->22|54->22|54->22|55->23|56->24|56->24|56->24|57->25|58->26|60->28|74->42|75->43|75->43|75->43|76->44|77->45|77->45|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|81->49|82->50|82->50|82->50|82->50|83->51|83->51|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|86->54|86->54|87->55|87->55|90->58|90->58|90->58|96->64|96->64|96->64|101->69|101->69|102->70|105->73|105->73|105->73|111->79
                  -- GENERATED --
              */
          