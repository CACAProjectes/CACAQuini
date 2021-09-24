package es.xuan.cacaquini.model;

import java.io.Serializable;
import java.util.Date;

public class UsuariSimple implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dataActualitzacio=new Date();
    private String nickname="";
    private String email="";
    private Perfil perfil = Perfil.USUARI;
    /*
    public UsuariSimple(String p_nickname, String p_email, Perfil p_perfil) {
        nickname = p_nickname;
        email = p_email;
        perfil = p_perfil;
    }
    */
    public Date getDataActualitzacio() {
        return dataActualitzacio;
    }

    public void setDataActualitzacio(Date dataActualitzacio) {
        this.dataActualitzacio = dataActualitzacio;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
