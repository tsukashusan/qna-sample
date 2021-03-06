package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.Play

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(environment: play.api.Environment,configuration: play.api.Configuration) 
extends Controller {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request =>
    Ok(views.html.index())
  }
  
  def hello = Action { implicit request =>
    Ok("Hello World!")
  }
  def bot = Action { implicit request =>
    Ok(views.html.bot.render(configuration.underlying.getString("bot.title"), configuration.underlying.getString("bot.src")))
  }
}
