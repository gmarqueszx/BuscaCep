package br.com.viacep.main;

import br.com.viacep.checkzipcode.CheckZipCode;
import br.com.viacep.filegenerator.FileGenerator;
import br.com.viacep.models.Address;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class ViaCepMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao Busca-Cep!");
            System.out.println("=======================");
            System.out.println("\nMenu Principal\n");
            System.out.println("1. Consultar endereço via cep ");
            System.out.println("2. Finalizar aplicação\n");
            System.out.println("Digite a opção desejada:\n");
            int opcaoEscolhida = sc.nextInt();

            if (opcaoEscolhida == 1) {
                System.out.println("Digite seu CEP: ");
                String cep = sc.next();
                try {
                    CheckZipCode checkZipCode = new CheckZipCode();
                    Address address = checkZipCode.addressSearch(cep);
                    System.out.println(address);
                    FileGenerator fileGenerator = new FileGenerator();
                    fileGenerator.saveInJson(address);
                } catch (RuntimeException | IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Tente novamente...");
                }

            } else if (opcaoEscolhida == 2) {
                System.out.println("Finalizando aplicação...");
                break;
            } else {
                System.out.println("Opção incorreta, tente novamente!");
            }
        }



    }
}