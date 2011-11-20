package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Food extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    public boolean eaten = false;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date expiry;

	@ManyToOne
	public String email;

	public static Model.Finder<Long,Food> find = new Model.Finder(Long.class, Food.class);

	public static List<Food> findFoodFor(String email) {
		return find.where()
			.eq("email", email)
			.eq("eaten", false)
			.findList();
	}

	public static Food create(Food food, String email) {
		food.email = email;
		food.save();
		return food;
	}


    public static boolean isOwner(Long food, String user) {
        return find.where()
            .eq("project.members.email", user)
            .eq("id", food)
            .findRowCount() > 0;
    }
}
