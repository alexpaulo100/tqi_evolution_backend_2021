package com.desafio.tqi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/** Classe de regra de negócio do empréstimo
 * @author Alex
 * @since 07/01/2022 */

public class EmprestimoRN {

        public boolean validaQuantidadeParcelas(int quantidadeParcelas){
            if(quantidadeParcelas > 60){
                return false;
            }
            return true;

        }

        public boolean validaDataEmprestimo(Date dataEmprestimo){
            Date dataAtual = new Date();
            long diferenca = dataEmprestimo.getTime() - dataAtual.getTime();
            diferenca = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
            if(diferenca > 90){
                return false;
            }
            return true;

        }

        public void imprimeDadosEmprestimo(Emprestimo emprestimo){
             System.out.println("O codigo do emprestimo é: " + emprestimo.getCodigo());
             System.out.println("Nome Cliente: " + emprestimo.getCliente().getNome());
             System.out.println("O seu email é: " + emprestimo.getCliente().getEmail());
             System.out.println("A renda é: " + emprestimo.getCliente().getRenda());
             System.out.println("A Quantidade de Parcelas é: " + emprestimo.getQuantidadeParcelas());
             System.out.println("O valor do emprestimo é: "+ emprestimo.getValorEmprestimo());
             System.out.println("A data da primeira parcela é: " + emprestimo.getDataPrimeiraParcela());
        }

}
