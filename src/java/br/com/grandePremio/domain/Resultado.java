package br.com.grandePremio.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "resultado")

public class Resultado implements Serializable {

    @EmbeddedId
    private PilotosCorridaPk pilotosCorridaPk = new PilotosCorridaPk();
    
    @JoinColumn(name = "idPiloto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Piloto piloto;

    public Resultado() {
    }

    public Resultado(Piloto piloto, Integer sequencia, Corrida corrida) {
        this.piloto = piloto;
        this.pilotosCorridaPk.setCorrida(corrida);
        this.pilotosCorridaPk.setSequencia(sequencia);
    }

    public PilotosCorridaPk getPilotosCorridaPk() {
        return pilotosCorridaPk;
    }

    public void setPilotosCorridaPk(PilotosCorridaPk pilotosCorridaPk) {
        this.pilotosCorridaPk = pilotosCorridaPk;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
    
    
    

}
