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
    public Patient postPatient(Patient p) {

        getInstance().getPatienter().add(p);


        System.out.println("dato: " + p.dato );
        System.out.println("CPR: " + p.CPR );
        System.out.println("name: " + p.name );
        System.out.println("start: " + p.startTidspunkt );
        System.out.println("slut: " + p.slutTidspunkt );
        System.out.println("CPR: " + p.notater );


            sql.opretNyPatient(p.CPR,p.dato,p.startTidspunkt,p.slutTidspunkt,p.name,p.name,p.notater);

        return p;
        }
    }




