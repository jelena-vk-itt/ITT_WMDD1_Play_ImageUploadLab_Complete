
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,models.users.User,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, user: models.users.User)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/(""" 

"""),format.raw/*3.1*/("""<!DOCTYPE html> 
<html lang="en"> 

<head> 
  <meta charset="utf-8"> 
  <title>Online Shop - """),_display_(/*8.25*/title),format.raw/*8.30*/("""</title> 
  <!-- Bootstrap Core CSS --> 
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">  

  <!-- Custom CSS --> 
  <link href=""""),_display_(/*13.16*/routes/*13.22*/.Assets.versioned("stylesheets/main.css")),format.raw/*13.63*/("""" rel="stylesheet"> 
</head> 

<body> 
  <nav class="navbar navbar-inverse"> 
      <div class="container-fluid"> 
        <div class="navbar-header"> 
            <a class="navbar-brand" href="#">Online Shop</a> 
        </div> 
        <ul class="nav navbar-nav"> 
            <li """),_display_(/*23.18*/if(title=="Products")/*23.39*/{_display_(Seq[Any](format.raw/*23.40*/("""class="active"""")))}),format.raw/*23.55*/(""">
                <a href=""""),_display_(/*24.27*/routes/*24.33*/.HomeController.index()),format.raw/*24.56*/("""">Products</a>
            </li>
            <li><a href="#">About</a></li> 
            <li><a href="#">Services</a></li> 
            <li><a href="#">Contact</a></li> 
            <li """),_display_(/*29.18*/if(title=="Login")/*29.36*/{_display_(Seq[Any](format.raw/*29.37*/("""class="active"""")))}),format.raw/*29.52*/(""">
                """),_display_(/*30.18*/if(user != null)/*30.34*/ {_display_(Seq[Any](format.raw/*30.36*/("""
                    """),format.raw/*31.21*/("""<a href=""""),_display_(/*31.31*/routes/*31.37*/.LoginController.logout()),format.raw/*31.62*/("""">Logout """),_display_(/*31.72*/user/*31.76*/.getName()),format.raw/*31.86*/("""</a>
                """)))}/*32.19*/else/*32.24*/{_display_(Seq[Any](format.raw/*32.25*/("""
                    """),format.raw/*33.21*/("""<a href=""""),_display_(/*33.31*/routes/*33.37*/.LoginController.login()),format.raw/*33.61*/("""">Login</a>
                """)))}),format.raw/*34.18*/("""
            """),format.raw/*35.13*/("""</li>            
        </ul> 
      </div> 
  </nav>     
  <container> 
      <row> 
          <div class="col-md-12">             
              """),_display_(/*42.16*/content),format.raw/*42.23*/(""" 
          """),format.raw/*43.11*/("""</div> 
      </row> 
  </container> 
  <container> 
      <row> 
          <div class="col-md-12">             
            <br><br>
            Copyright <strong>Online Shop</strong> 
          </div> 
      </row> 
  </container> 
  <script src=""""),_display_(/*54.17*/routes/*54.23*/.Assets.versioned("javascripts/main.js")),format.raw/*54.63*/(""""></script>
</body> 
</html> 
"""))
      }
    }
  }

  def render(title:String,user:models.users.User,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)

  def f:((String,models.users.User) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => apply(title,user)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Dec 16 16:01:49 GMT 2017
                  SOURCE: /home/jvk/temp/UploadImageLab_from_LoginLabComplete/app/views/main.scala.html
                  HASH: d5ae1cac7d873fb80b8fc508d5ee07504a8e15fb
                  MATRIX: 970->1|1120->56|1149->59|1269->153|1294->158|1502->339|1517->345|1579->386|1890->670|1920->691|1959->692|2005->707|2060->735|2075->741|2119->764|2333->951|2360->969|2399->970|2445->985|2491->1004|2516->1020|2556->1022|2605->1043|2642->1053|2657->1059|2703->1084|2740->1094|2753->1098|2784->1108|2825->1131|2838->1136|2877->1137|2926->1158|2963->1168|2978->1174|3023->1198|3083->1227|3124->1240|3302->1391|3330->1398|3370->1410|3647->1660|3662->1666|3723->1706
                  LINES: 28->1|33->1|35->3|40->8|40->8|45->13|45->13|45->13|55->23|55->23|55->23|55->23|56->24|56->24|56->24|61->29|61->29|61->29|61->29|62->30|62->30|62->30|63->31|63->31|63->31|63->31|63->31|63->31|63->31|64->32|64->32|64->32|65->33|65->33|65->33|65->33|66->34|67->35|74->42|74->42|75->43|86->54|86->54|86->54
                  -- GENERATED --
              */
          