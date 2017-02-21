import javax.servlet.ServletContext

import com.ntsdev.api.DevNexusAPI
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new DevNexusAPI, "/*")
  }
}
