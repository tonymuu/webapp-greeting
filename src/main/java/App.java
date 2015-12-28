import static spark.Spark.*;

import java.util.HashMap;
import spark.template.velocity.VelocityTemplateEngine;

import spark.ModelAndView;

public class App {
	public static void main(String[] args) {

		staticFileLocation("/public");
    String layout = "templates/layout.vtl";
		//root page or index page
		get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/hello.vtl");

      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());	

		get("/favorite_photos", (request, response) -> {
          HashMap model = new HashMap();
          model.put("template", "templates/photo.vtl");

          return new ModelAndView (model, layout);
        }, new VelocityTemplateEngine());

    get("/form", (request, response) -> {
      
    });
	}
}