package main.java.com.redSismica.cierreInspeccion.entity;

public class MotivoFueraServicio {
    private String comentario;
    private MotivoTipo motivoTipo;

    public MotivoFueraServicio(String comentario, MotivoTipo motivoTipo) {
        this.comentario = comentario;
        this.motivoTipo = motivoTipo;
    }

    // getters/setters


    public String getComentario() {
        return comentario;
    }

    public void setComentatio(String comentario) {
        this.comentario = comentario;
    }

    public MotivoTipo getMotivoTipo() {
        return motivoTipo;
    }

    public void setMotivoTipo(MotivoTipo motivoTipo) {
        this.motivoTipo = motivoTipo;
    }
}

