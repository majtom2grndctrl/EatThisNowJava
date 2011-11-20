package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;
import views.html.foods.*;

@Security.Authenticated(Secured.class)
public class Foods extends Controller {

	public static Result index() {
		return ok(
			index.render(
				Food.findFoodFor(request().username())
			)
		);
	}
/*
	public static Result add() {
		Food newFood = Food.create(
			"New food",
			form().bindFromRequest().get("group"),
			request().username()
		);
		return ok(item.render(newFood));
	}
*/
}
