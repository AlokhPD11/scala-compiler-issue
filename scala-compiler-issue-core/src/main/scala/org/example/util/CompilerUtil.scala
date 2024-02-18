package org.example.util

import java.io.{PrintWriter, StringWriter}
import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.IMain
import scala.collection.JavaConverters._

case class CompilerResponse(status: Boolean, result: String)

object CompilerUtil {
  private val settings = new Settings()
  settings.usejavacp.value = true
  private val output = new StringWriter()
  private val writer = new PrintWriter(output)
  private val interpreter = new IMain(settings, writer)

  def compileAndLoadFiles(codes: java.util.List[String]): CompilerResponse = {
    val result = codes.asScala.toList.forall(code => interpreter.compileString(code))
    val response: CompilerResponse = CompilerResponse(status = result, result = output.toString)
    output.getBuffer.setLength(0)
    response
  }

}
