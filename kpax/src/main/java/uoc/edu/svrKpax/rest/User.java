package uoc.edu.svrKpax.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

import uoc.edu.svrKpax.business.UserBO;
import uoc.edu.svrKpax.business.BadgeBO;
import uoc.edu.svrKpax.vo.Badge;
import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.ResQueryProficiencies;
import uoc.edu.svrKpax.vo.ResQueryAbilities;
import uoc.edu.svrKpax.vo.ResQueryBadges;

import uoc.edu.svrKpax.util.ConstantsKPAX;

import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.api.json.JSONWithPadding;
import com.sun.jersey.spi.inject.Inject;

/**
 * @author juanfrasr
 * 
 *         User class validate other platforms
 * 
 */
@SuppressWarnings("deprecation")

@Path("/user")


public class User {

	@Inject
	private UserBO uBo;;

	@Context HttpContext hc;
	
	
	/**
	 * Function work only servers uoc
	 * @param username
	 * @param password
	 * @return session
	 */
	@POST
	@Path("/auth/uoc")
	public Response validateUser(@FormParam("username") String username,
			@FormParam("password") String password) {
		return uBo.initUserUOC(username, password, ConstantsKPAX.UOC);
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Path("/auth/elgg")
	public Response validateUserElgg(@FormParam("username") String username,@FormParam("password") String password) throws Exception {		
		return uBo.initUserELGG(username,password);
	}
	
	/**
	 * Validate User from elgg plataform
	 * @param username
	 * @param apikey <-- apikey generate to elgg plataform
	 * @return
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Path("/sign/elgg")
	public Response validateSignElgg(@FormParam("username") String username,@FormParam("apikey") String apikey) {
		return uBo.initSignELGG(username,apikey);
	}
	
	@GET
	@Path("/auth/elgg.jsonp")
	@Produces("application/x-javascript")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED })
	public JSONWithPadding elggJSONP(@QueryParam("jsoncallback") String callback,@QueryParam("username") String username,@QueryParam("password") String password) throws JSONException{
		String s = "{\"session\" : "+uBo.initUserELGG(username, password).getEntity()+"}";
		JSONObject o = new JSONObject(s);
		return new JSONWithPadding(o, callback);
	}
	
	@GET
	@Path("/auth/uoc.jsonp")
	@Produces("application/x-javascript")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED })
	public JSONWithPadding uocJSONP(@QueryParam("jsoncallback") String callback,@QueryParam("username") String username,@QueryParam("password") String password) throws JSONException{
		String s = "{\"session\" : "+uBo.initUserUOC(username, password, ConstantsKPAX.UOC).getEntity()+"}";
		JSONObject o = new JSONObject(s);
		return new JSONWithPadding(o, callback);
	}
     
	@GET
	@Path("badges/{session}/getBadgeList/{username}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ResQueryBadges> getUserBadges(@PathParam("username") String username, @PathParam("session") String campusSession ) {
                return uBo.getUserBadges(username, campusSession);
	}
     	
	//@GET
	//@Path("badges/{session}/getBadgeList/{username}")
	//@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	//@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	//public List<Badge> getUserBadges(@PathParam("username") String username, @PathParam("session") String campusSession ) {
        //        return uBo.getUserBadges(username, campusSession);
	//}
	
	@GET
	@Path("abilities/{session}/getAbilityList/{username}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ResQueryAbilities> getUserAbilities(@PathParam("username") String username, @PathParam("session") String campusSession ) {
                return uBo.getUserAbilities(username, campusSession);
	}

	@GET
	@Path("proficiencies/{session}/getProficiencyList/{username}/{ability}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ResQueryProficiencies> getUserProficiencies(@PathParam("username") String username, @PathParam("ability") String ability, @PathParam("session") String campusSession ) {
                return uBo.getUserProficiencies(username, ability, campusSession);
	}	
}
