package com.desafio.tqi;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            Locale.setDefault(new Locale("pt", "BR"));


            Cliente cadastro = new Cliente();
            Emprestimo emprestimo = new Emprestimo();
            EmprestimoRN emprestimoRN = new EmprestimoRN();

            System.out.println("******* Cadastre seus dados *******");

            System.out.println("Digite seu nome completo: ");
            cadastro.setNome(sc.nextLine());
            System.out.println("Digite seu email: ");
            cadastro.setEmail(sc.nextLine());
            System.out.println("Cadastre sua senha: ");
            cadastro.setSenha(sc.nextLine());
            System.out.println("Digite seu CPF: ");
            cadastro.setCpf(sc.nextLine());
            System.out.println("Digite seu RG: ");
            cadastro.setRg(sc.nextLine());
            System.out.println("Digite sua rua: ");
            cadastro.setRua(sc.nextLine());
            System.out.println("Digite seu bairro: ");
            cadastro.setBairro(sc.nextLine());
            System.out.println("Digite a cidade: ");
            cadastro.setCidade(sc.nextLine());
            System.out.println("Digite seu numero: ");
            cadastro.setNumero(sc.nextInt());
            System.out.println("Digite sua renda: ");
            cadastro.setRenda(sc.nextDouble());


            boolean loginOk = true;
            boolean senhaOk = true;
            System.out.println("=========================================");

            sc.nextLine();
            do {

                System.out.println("Digite sua senha de acesso: ");
                String senha = sc.nextLine();
                System.out.println("Digite seu email: ");
                String email = sc.nextLine();
                if(!email.equals(cadastro.getEmail())){
                    loginOk = false;
                }else {
                    loginOk = true;
                }
                if (!senha.equals(cadastro.getSenha())){
                    senhaOk = false;
                }else{
                    senhaOk = true;
                }

                if (!senha.equals(cadastro.getSenha()) || !email.equals(cadastro.getEmail())) {
                    System.out.println("Login e ou senha inválida!");

                }

            }while (!loginOk || !senhaOk);

            System.out.println("Você esta logado!");
            System.out.println("Tecle o enter para prosseguir!");

            sc.nextLine();
            System.out.println("============Seja bem vindo a nossa solicitação de empréstimos===============");
            emprestimo.setCliente(cadastro);

            System.out.println("Digite o valor do emprestimo: ");
            emprestimo.setValorEmprestimo(sc.nextDouble());

            do {
                System.out.println("Digite a data da primeira parcela: Por exemplo 01/02/2022");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                emprestimo.setDataPrimeiraParcela(sdf.parse(sc.next()));
                if(!emprestimoRN.validaDataEmprestimo(emprestimo.getDataPrimeiraParcela())){
                    System.out.println("Primeira parcela somente ate 90 dias.");
                }

            }while(!emprestimoRN.validaDataEmprestimo(emprestimo.getDataPrimeiraParcela()));

            do {
                System.out.println("Qual quantidade de parcelas: ");
                emprestimo.setQuantidadeParcelas(sc.nextInt());
                if(!emprestimoRN.validaQuantidadeParcelas(emprestimo.getQuantidadeParcelas())){
                    System.out.println("Quantidade de parcelas nao pode ser maior que 60.");
                }

            }while (!emprestimoRN.validaQuantidadeParcelas(emprestimo.getQuantidadeParcelas()));

            System.out.println("==============Relatório da sua solicitação de empréstimo===============");
            emprestimoRN.imprimeDadosEmprestimo(emprestimo);
        }
        catch (Exception e){
            System.out.println("Ocorreu um erro na aplicação, favor contactar o suporte!");
            e.printStackTrace();

        }finally {
             sc.close();
        }



    }





}
