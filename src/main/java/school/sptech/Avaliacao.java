package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

public class Avaliacao {
    private String descricao;
    private Double qtdEstrelas;

    public Avaliacao(String descricao, Double qtdEstrelas) {
        this.descricao = descricao;
        this.qtdEstrelas = qtdEstrelas;
    }

    public Avaliacao() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQtdEstrelas() {
        return qtdEstrelas;
    }

    public void setQtdEstrelas(Double qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }


    @Override public String toString(){
        return "Avaliacao:" +
                "Descrição = " + descricao +
                "Quantidade de estrelas = " + qtdEstrelas;
    }
}



