package br.com.daphnericardo.diario_estudos.entity;

import br.com.daphnericardo.diario_estudos.enums.PrioridadeEnum;
import br.com.daphnericardo.diario_estudos.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_TAREFA")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    private Long id;

    @Column(name = "TX_TITULO")
    private String titulo;

    @Column(name = "TX_MATERIA")
    private String materia;

    @Column(name = "DT_DATA_ENTREGA")
    private LocalDateTime dataEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_STATUS")
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_PRIORIDADE")
    private PrioridadeEnum prioridade;
}
