package org.projegroup;

import org.projegroup.entities.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.LocalDate.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 Inserindo todos os funcionários
        funcionarios.add(new Funcionario("Maria", parse("18/10/2000", dtf), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", parse("12/05/1990", dtf), new BigDecimal("2284.38"), "Coordenador"));
        funcionarios.add(new Funcionario("Caio", parse("02/05/1961", dtf), new BigDecimal("9836.14"), "Operador"));
        funcionarios.add(new Funcionario("Miguel", parse("14/10/1988", dtf), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", parse("05/01/1995", dtf), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", parse("19/11/1999", dtf), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", parse("31/03/1993", dtf), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", parse("08/07/1994", dtf), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", parse("24/05/2003", dtf), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", parse("02/09/1996", dtf), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 Remover o funcionário “João” da lista
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 Imprimindo todos os funcionários com todas suas informações
        System.out.println("Lista de funcionários:");
        funcionarios.forEach(System.out::println);

        // 3.5 Agrupando os funcionários por função em um MAP
        final Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 Imprimindo os funcionários, agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario fun : entry.getValue()) {
                System.out.println("    " + fun);
            }
            System.out.print("\n");
        }

        // 3.8 Imprimindo os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
        funcionarios.forEach(f -> {
            int mes = f.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                System.out.println(f);
            }
        });

        // 3.9 Imprimindo o funcionário com a maior idade
        final Funcionario maisVelho = min(funcionarios, comparing(Funcionario::getDataNascimento));
        final int idadeMaisVelho = now().getYear() - maisVelho.getDataNascimento().getYear();
        System.out.println("\nFuncionário com a maior idade:");
        System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idadeMaisVelho);

        // 3.10 Imprimindo a lista de funcionários por ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(comparing(Funcionario::getNome));
        funcionariosOrdenados.forEach(System.out::println);


    }
}