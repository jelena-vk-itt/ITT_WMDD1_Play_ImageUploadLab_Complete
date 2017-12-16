
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

object addProduct extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[models.Product],models.users.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(productForm: Form[models.Product], user: models.users.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*1.62*/("""

"""),format.raw/*4.1*/("""

"""),_display_(/*6.2*/main("Add product", user)/*6.27*/ {_display_(Seq[Any](format.raw/*6.29*/("""
    """),format.raw/*7.5*/("""<p class="lead">Add or update a product</p>

    <!-- Use the views.html.helpers package to create the form -->
    """),_display_(/*10.6*/form(action=routes.HomeController.addProductSubmit(), 'class -> "form-horizontal", 'role -> "form", 'enctype -> "multipart/form-data")/*10.140*/ {_display_(Seq[Any](format.raw/*10.142*/("""
        """),format.raw/*11.37*/("""
        """),format.raw/*12.99*/("""
        """),_display_(/*13.10*/CSRF/*13.14*/.formField),format.raw/*13.24*/("""

        """),format.raw/*15.9*/("""<!-- Build the form, adding an input for each field --> 
        <!-- Note the label parameter -->
        """),_display_(/*17.10*/inputText(productForm("name"), '_label -> "Name", 'class -> "form-control")),format.raw/*17.85*/("""
        """),_display_(/*18.10*/inputText(productForm("description"), '_label -> "Description", 'class -> "form-control")),format.raw/*18.99*/("""
        """),_display_(/*19.10*/select(
            productForm("category.id"),
            options(Category.options),
            '_label -> "Category", '_default -> "-- Choose a category --", 
            '_showConstraints -> false, 'class -> "form-control"
        )),format.raw/*24.10*/("""
        """),_display_(/*25.10*/inputText(productForm("stock"), '_label -> "Stock", 'class -> "form-control")),format.raw/*25.87*/("""
        """),_display_(/*26.10*/inputText(productForm("price"), '_label -> "Price", 'class -> "form-control")),format.raw/*26.87*/("""

        """),format.raw/*28.9*/("""<!-- Hidden ID field - required for updates -->
        """),_display_(/*29.10*/inputText(productForm("id"), '_label -> "", 'hidden -> "hidden")),format.raw/*29.74*/("""
    
        """),format.raw/*31.9*/("""<label>Image Upload</label>
        <input class="btn-sm btn-default" type="file" name="upload">
        <br><br>
        <!-- Add a submit button -->
        <div class="actions">
            <input type="submit" value="Add/Update Product" class="btn btn-primary">
            <a href=""""),_display_(/*37.23*/routes/*37.29*/.HomeController.index(0)),format.raw/*37.53*/("""">
                <button type="button" class="btn btn-warning">Cancel</button>
            </a>
        </div>
    """)))}),format.raw/*41.6*/(""" """),format.raw/*41.24*/("""
""")))}),format.raw/*42.2*/(""" """))
      }
    }
  }

  def render(productForm:Form[models.Product],user:models.users.User): play.twirl.api.HtmlFormat.Appendable = apply(productForm,user)

  def f:((Form[models.Product],models.users.User) => play.twirl.api.HtmlFormat.Appendable) = (productForm,user) => apply(productForm,user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Dec 16 16:01:49 GMT 2017
                  SOURCE: /home/jvk/temp/UploadImageLab_from_LoginLabComplete/app/views/addProduct.scala.html
                  HASH: cd6e05c29624164039efeeecdb228d72eb902cc3
                  MATRIX: 985->1|1118->64|1163->61|1191->80|1219->83|1252->108|1291->110|1322->115|1465->232|1609->366|1650->368|1687->405|1724->504|1761->514|1774->518|1805->528|1842->538|1977->646|2073->721|2110->731|2220->820|2257->830|2515->1067|2552->1077|2650->1154|2687->1164|2785->1241|2822->1251|2906->1308|2991->1372|3032->1386|3347->1674|3362->1680|3407->1704|3555->1822|3584->1840|3616->1842
                  LINES: 28->1|31->3|34->1|36->4|38->6|38->6|38->6|39->7|42->10|42->10|42->10|43->11|44->12|45->13|45->13|45->13|47->15|49->17|49->17|50->18|50->18|51->19|56->24|57->25|57->25|58->26|58->26|60->28|61->29|61->29|63->31|69->37|69->37|69->37|73->41|73->41|74->42
                  -- GENERATED --
              */
          