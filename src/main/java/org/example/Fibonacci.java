package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    public Integer validaNumero(String metodo){
        Boolean numeroValido = false;
        int n = -1;
        while (numeroValido==false){
            System.out.print("Digite um numero: ");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            scanner.close();
            if (n>=0){
                numeroValido=true;
                escolheMetodoECalacula(metodo,n);
            }else {
                System.out.println("O algarismo digitado deve ser um número maior ou igual a zero");
            }
        }
        return n;
    }
    public void validaMetodo(){
        String metodo = "";
        while(!metodo.equals("1") && !metodo.equals("2")) {
            System.out.println("Digite 1 para calcular com a função recursiva ");
            System.out.println("Digite 2 para calcular com a função linear ");
            Scanner scanner = new Scanner(System.in);
            metodo = scanner.nextLine();

            if (metodo.equals("1") || metodo.equals("2")) {
                if (metodo.equals("1")) {
                    validaNumero("1");
                } else if (metodo.equals("2")) {
                    validaNumero("2");
                }
            } else {
                System.out.println("Voce deve digitar somente 1 ou 2, conforme opção escolhida");
            }
        }
    }

    public BigInteger fibonacciRecursivo(int n){
        if (n == 0 || n == 1)
            return BigInteger.valueOf(n);

        return fibonacciRecursivo(n-1).add(fibonacciRecursivo(n-2));

    }

    public BigInteger fibonacciLinear(int n){
        if (n == 0 || n == 1)
            return BigInteger.valueOf(n);

        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger fproximo = f0.add(f1);
            f0 = f1;
            f1 = fproximo;
        }
        return f1;
    }

    public void escolheMetodoECalacula(String metodo, int n){
        if(metodo == "1"){
            BigInteger resultadoFibonacci = fibonacciRecursivo(n);
            System.out.println("Fibonacci(" + n + ") = " +  resultadoFibonacci.toString());
        }
        if(metodo == "2"){
            BigInteger resultadoFibonacci = fibonacciLinear(n);
            System.out.println("Fibonacci(" + n + ") = " +  resultadoFibonacci.toString());
        }

    }

}


