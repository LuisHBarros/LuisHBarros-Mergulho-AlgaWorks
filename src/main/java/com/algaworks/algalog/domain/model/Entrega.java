package com.algaworks.algalog.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private Cliente cliente;
    @OneToMany(mappedBy = "entrega")
    private List<Ocorrencia> ocorrencias;
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusEntrega status;
    @Embedded
    private Destinatario destinatario;
    @NotNull
    private BigDecimal taxa;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPedido;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public OffsetDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(OffsetDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public OffsetDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrega entrega)) return false;

        return getId().equals(entrega.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public Ocorrencia adicionarOcorrencia(String descricao) {
        Ocorrencia nova_ocorrencia = new Ocorrencia();
        nova_ocorrencia.setDestricao(descricao);
        nova_ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.getOcorrencias().add(nova_ocorrencia);

    }
}
