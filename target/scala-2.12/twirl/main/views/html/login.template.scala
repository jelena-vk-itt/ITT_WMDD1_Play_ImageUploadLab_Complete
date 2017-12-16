
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[models.users.Login],models.users.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[models.users.Login], user: models.users.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*1.64*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.73*/("""
"""),_display_(/*5.2*/main("Login", user)/*5.21*/ {_display_(Seq[Any](format.raw/*5.23*/("""
    """),format.raw/*6.5*/("""<!-- HTML content for the index view -->
    <div class="col-xs-4">
        <h3>Sign in</h3>
        <!-- Display login errors if they exist -->
        """),_display_(/*10.10*/if(loginForm.hasGlobalErrors)/*10.39*/ {_display_(Seq[Any](format.raw/*10.41*/("""
            """),format.raw/*11.13*/("""<p class="alert alert-warning">
                """),_display_(/*12.18*/loginForm/*12.27*/.globalError.message),format.raw/*12.47*/("""
            """),format.raw/*13.13*/("""</p>
        """)))}),format.raw/*14.10*/("""
        """),_display_(/*15.10*/if(flash.containsKey("error"))/*15.40*/ {_display_(Seq[Any](format.raw/*15.42*/("""
            """),format.raw/*16.13*/("""<p class="alert alert-warning">
                """),_display_(/*17.18*/flash/*17.23*/.get("loginRequired")),format.raw/*17.44*/("""
            """),format.raw/*18.13*/("""</p>
        """)))}),format.raw/*19.10*/("""
        """),format.raw/*20.9*/("""<!-- The login form -->
        """),_display_(/*21.10*/helper/*21.16*/.form(action = controllers.routes.LoginController.loginSubmit())/*21.80*/ {_display_(Seq[Any](format.raw/*21.82*/("""
            """),format.raw/*22.41*/("""
            """),format.raw/*23.103*/("""
            """),_display_(/*24.14*/CSRF/*24.18*/.formField),format.raw/*24.28*/("""
    
            """),format.raw/*26.13*/("""<div class="form-group">
                """),_display_(/*27.18*/inputText(loginForm("email"), '_label -> "", 
                'class -> "form-control input-xs", 'placeholder -> "Email")),format.raw/*28.76*/("""
            """),format.raw/*29.13*/("""</div>
            <div class="form-group">
                """),_display_(/*31.18*/inputPassword(loginForm("password"), '_label -> "", 
                'class -> "form-control input-xs", 'placeholder -> "Password")),format.raw/*32.79*/("""
            """),format.raw/*33.13*/("""</div>
            <div class="form-group">
                <input type="submit" value="Sign In" class="btn btn-primary">
            </div>
        """)))}),format.raw/*37.10*/(""" """),format.raw/*37.28*/("""
    """),format.raw/*38.5*/("""</div>
    <!-- End of content for main -->
""")))}),format.raw/*40.2*/("""


"""))
      }
    }
  }

  def render(loginForm:Form[models.users.Login],user:models.users.User): play.twirl.api.HtmlFormat.Appendable = apply(loginForm,user)

  def f:((Form[models.users.Login],models.users.User) => play.twirl.api.HtmlFormat.Appendable) = (loginForm,user) => apply(loginForm,user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Dec 16 16:01:49 GMT 2017
                  SOURCE: /home/jvk/temp/UploadImageLab_from_LoginLabComplete/app/views/login.scala.html
                  HASH: 47decbab0c40bdf9ce75c399d38268ea7ef66ec0
                  MATRIX: 984->1|1119->65|1164->63|1191->81|1219->154|1246->156|1273->175|1312->177|1343->182|1524->336|1562->365|1602->367|1643->380|1719->429|1737->438|1778->458|1819->471|1864->485|1901->495|1940->525|1980->527|2021->540|2097->589|2111->594|2153->615|2194->628|2239->642|2275->651|2335->684|2350->690|2423->754|2463->756|2504->797|2546->900|2587->914|2600->918|2631->928|2677->946|2746->988|2888->1109|2929->1122|3017->1183|3169->1314|3210->1327|3391->1477|3420->1495|3452->1500|3527->1545
                  LINES: 28->1|31->2|34->1|35->3|36->4|37->5|37->5|37->5|38->6|42->10|42->10|42->10|43->11|44->12|44->12|44->12|45->13|46->14|47->15|47->15|47->15|48->16|49->17|49->17|49->17|50->18|51->19|52->20|53->21|53->21|53->21|53->21|54->22|55->23|56->24|56->24|56->24|58->26|59->27|60->28|61->29|63->31|64->32|65->33|69->37|69->37|70->38|72->40
                  -- GENERATED --
              */
          