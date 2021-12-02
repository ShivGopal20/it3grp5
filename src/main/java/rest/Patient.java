package rest;

public class Patient {
    public String name;
    public String dato;
    public String CPR;
    public String startTidspunkt;
    public String slutTidspunkt;
    public String sundhedsPersonale;
    public String aftaleperson;
    public String notater;

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getStartTidspunkt() {
        return startTidspunkt;
    }

    public void setStartTidspunkt(String startTidspunkt) {
        this.startTidspunkt = startTidspunkt;
    }

    public String getSlutTidspunkt() {
        return slutTidspunkt;
    }

    public void setSlutTidspunkt(String slutTidspunkt) {
        this.slutTidspunkt = slutTidspunkt;
    }

    public String getSundhedsPersonale() {
        return sundhedsPersonale;
    }

    public void setSundhedsPersonale(String sundhedsPersonale) {
        this.sundhedsPersonale = sundhedsPersonale;
    }

    public String getAftaleperson() {
        return aftaleperson;
    }

    public void setAftaleperson(String aftaleperson) {
        this.aftaleperson = aftaleperson;
    }

    public String getNotater() {
        return notater;
    }

    public void setNotater(String notater) {
        this.notater = notater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
