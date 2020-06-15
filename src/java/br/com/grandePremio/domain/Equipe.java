package br.com.grandePremio.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "equipe")

public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica do MY SQL, dizendo que o ID é grado automaticamente...
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(mappedBy = "id")
    private List<Funcionario> funcionarios;
    
    @OneToMany(mappedBy = "id")
    private List<Piloto> pilotos;



    public Equipe() {
    }

    public Equipe(Integer id) {
        this.id = id;
    }

    public Equipe(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    
    
    
    

//    @XmlTransient;
//    public Collection<Funcionarios> getFuncionariosCollection() {
//        return funcionariosCollection;
//    }
//
//    public void setFuncionariosCollection(Collection<Funcionarios> funcionariosCollection) {
//        this.funcionariosCollection = funcionariosCollection;
//    }
//
//    @XmlTransient
//    public Collection<Piloto> getPilotoCollection() {
//        return pilotoCollection;
//    }
//
//    public void setPilotoCollection(Collection<Piloto> pilotoCollection) {
//        this.pilotoCollection = pilotoCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.grandePremio.domain.Equipe[ id=" + id + " ]";
    }
    
}
