package sn.esmt.examendevmobile;

public class OffreEmploi {
    private String titrePoste;
    private String descript;
    private String profileRecherche;
    private String deadline;

    public OffreEmploi(String titrePoste, String descript, String profileRecherche, String deadline) {
        this.titrePoste = titrePoste;
        this.descript = descript;
        this.profileRecherche = profileRecherche;
        this.deadline = deadline;
    }

    public String getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(String titrePoste) {
        this.titrePoste = titrePoste;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getProfileRecherche() {
        return profileRecherche;
    }

    public void setProfileRecherche(String profileRecherche) {
        this.profileRecherche = profileRecherche;
    }

    public String getDaedline() {
        return deadline;
    }

    public void setDaedline(String daedline) {
        this.deadline = daedline;
    }
}
