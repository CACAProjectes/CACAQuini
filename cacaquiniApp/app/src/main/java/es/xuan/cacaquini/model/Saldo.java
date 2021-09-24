package es.xuan.cacaquini.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Saldo implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal saldoInicial = new BigDecimal(0.00);
    private BigDecimal totalAposta = new BigDecimal(0.00);
    private BigDecimal totalPremi = new BigDecimal(0.00);
    private BigDecimal saldoFinal = new BigDecimal(0.00);

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getTotalPremi() {
        return totalPremi;
    }

    public void setTotalPremi(BigDecimal totalPremi) {
        this.totalPremi = totalPremi;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public BigDecimal getTotalAposta() {
        return totalAposta;
    }

    public void setTotalAposta(BigDecimal totalAposta) {
        this.totalAposta = totalAposta;
    }
}
