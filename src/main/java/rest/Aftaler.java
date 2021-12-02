package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static rest.PatientDAO.*;


@Path("Aftaler")
    @Consumes({MediaType.APPLICATION_JSON})
    public class Aftaler {
    SQL sql=new SQL();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getPatienter() {
        return getInstance().getPatienter();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(@HeaderParam("authorization")String token, Patient p) {
        JWTHandler.validate(token);
        getInstance().getPatienter().add(p);
            sql.opretNyPatient(p.CPR,p.dato,p.startTidspunkt,p.slutTidspunkt,p.name,p.name,p.notater);

        return p;
        }
    }




