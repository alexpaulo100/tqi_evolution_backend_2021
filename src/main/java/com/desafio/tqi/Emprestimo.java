package com.desafio.tqi;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class Emprestimo {

    private double valorEmprestimo;
    private Date dataPrimeiraParcela;
    private int quantidadeParcelas;
    private double codigo = Math.random();
    private Cliente cliente;
    private double taxaJuros = 1.8;


    public double getValorEmprestimo() {

        return valorEmprestimo ;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo * taxaJuros;
    }


}
