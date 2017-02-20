import com.ntsdev._
import org.scalatra._
import javax.servlet.ServletContext

import com.ntsdev.api.DevNexusAPI

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new DevNexusAPI, "/*")
  }
}
