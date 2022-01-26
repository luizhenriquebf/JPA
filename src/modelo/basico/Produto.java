package modelo.basico;

import javax.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "pd_name", nullable = false)
    private String name;

    @Column(name = "pd_preço", nullable = false, precision = 11, scale = 2)
    private Double preco;

    public Produto() {
    }

    public Produto(String name, Double preco) {
        this.name = name;
        this.preco = preco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
