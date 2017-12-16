
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jvk/temp/UploadImageLab_from_LoginLabComplete/conf/routes
// @DATE:Sat Dec 16 16:01:48 GMT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
