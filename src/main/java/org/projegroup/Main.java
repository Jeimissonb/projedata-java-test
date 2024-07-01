package org.projegroup;

import org.projegroup.entities.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 Inserindo todos os funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.parse("18/10/2000", dtf), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.parse("12/05/1990", dtf), new BigDecimal("2284.38"), "Coordenador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", dtf), new BigDecimal("9836.14"), "Operador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.parse("14/10/1988", dtf), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.parse("05/01/1995", dtf), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.parse("19/11/1999", dtf), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.parse("31/03/1993", dtf), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.parse("08/07/1994", dtf), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", dtf), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.parse("02/09/1996", dtf), new BigDecimal("2799.93"), "Gerente"));


        System.out.println(funcionarios);
    }
}