package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static rest.PatientDAO.*;


@Path("Aftaler")
    public class Aftaler {
    SQL sql=new SQL();


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(Patient p) {
        getInstance().getPatienter().add(p);

        sql.opretNyPatient(p.CPR,p.dato,p.startTidspunkt,p.slutTidspunkt,p.name,p.name,p.notater);



        return p;
        }
    }




