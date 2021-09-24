package es.xuan.cacaquini.model;

public enum EstatQuiniela {
    //FINAL_PENDENT("Finalitzada-Pdt"),
    //FINAL_COMPLERTA("Finalitzada-Comp"),
    FINALITZADA("Finalitzada"),
    BLOQ("Bloquejada"),
    PDT("Pendent"),
    NOCOMP("Incompleta"),
    ENJOC("En joc");

    private String estat;

    EstatQuiniela(String envEstat) {
        this.estat = envEstat;
    }

    public String getEstat() {
        return estat;
    }
}
