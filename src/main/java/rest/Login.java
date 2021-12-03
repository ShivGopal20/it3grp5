package rest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;



@Path("Login")
@Produces({MediaType.TEXT_PLAIN})
public class Login {
    int x=1;
    Patient p = new Patient();


    @GET
    public String loginValidering(
            @QueryParam("InputBrugernavn") String user,
            @QueryParam("InputKode") String kode) throws URISyntaxException {

        SQL sql = new SQL();

        for (int i = 1; i <= 100; i++) {
            sql.getLoginInfo(i);
            try {
                if (user.matches(sql.Brugernavn) && kode.equals(sql.Adgangskode))
                {
                    String token = JWTHandler.generateJwtToken(new User(user, ""));
                    return token;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}


