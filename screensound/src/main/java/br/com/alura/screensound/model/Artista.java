package br.com.alura.screensound.model;

import br.com.alura.screensound.principal.TipoArtista;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true, fetch = EAGER)
    private List<Musica> musicas = new ArrayList<>();

    // Construtor padrão
    public Artista() {}

    // Construtor com argumentos
    public Artista(String nome, TipoArtista tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return
                "Artista='" + nome + '\'' +
                ", tipo=" + tipo +
                ", musicas=" + musicas;
    }
}
