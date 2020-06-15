package br.com.grandePremio.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


public class PilotosCorridaPk implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "idCorrida", referencedColumnName = "id")
    private Corrida corrida;
    
    
    @NotNull
    @Column(name = "sequencia")
    private Integer sequencia;

    public PilotosCorridaPk() {
    }

    public PilotosCorridaPk(Corrida corrida, Integer sequencia) {
        this.corrida = corrida;
        this.sequencia = sequencia;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }
    
    
    
    
}
