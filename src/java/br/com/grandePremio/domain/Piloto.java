package br.com.grandePremio.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "piloto")

public class Piloto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica do MY SQL, dizendo que o ID é grado automaticamente...
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "pontos")
    private double pontos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piloto")
    private List<Resultado> itensResultado;
    
    
    @ManyToOne // tenho um uúnico serviço para varias categorias
    @JoinColumn(name = "idEquipe", referencedColumnName = "id")
    private Equipe equipe;

    public Piloto() {
    }

    public Piloto(Integer id) {
        this.id = id;
    }

    public List<Resultado> getItensResultado() {
        return itensResultado;
    }

    public void setItensResultado(List<Resultado> itensResultado) {
        this.itensResultado = itensResultado;
    }
    
    

    public Piloto(Integer id, String nome, double pontos) {
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
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

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

   
    
    
}
