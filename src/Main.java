import java.util.Scanner;

import static challenge.moedas.Conversor.converter;
import static challenge.moedas.Conversor.converter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        while (!(opcao == 0)) {
         try {
             System.out.println("Bem vindo(a) ao app de Guilherme Bifani de câmbio de moedas!");
             System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
             System.out.println("""
                     Digite a opção que queira converter:
                     1) Dólar           =>> Peso Argentino
                     2) Peso Argentino  ==> Dólar
                     3) Dólar           ==> Real Brasileiro
                     4) Real Brasileiro ==> Dólar
                     5) Dólar           ==> Peso Colombiano
                     6) Peso Colombiano ==> Dólar
                     0) SAIR
                     """);
             opcao = sc.nextInt();
             if (opcao == 1) {
                 String resultado = converter("USD","EUR");
                 System.out.println(resultado);
             } else if (opcao == 2) {
                 String resultado = converter("ARS","USD");
                 System.out.println(resultado);
             } else if (opcao == 3) {
                 String resultado = converter("USD","BRL");
                 System.out.println(resultado);
             } else if (opcao == 4) {
                 String resultado = converter("BRL","USD");
                 System.out.println(resultado);
             } else if (opcao == 5) {
                 String resultado = converter("USD","COP");
                 System.out.println(resultado);
             } else if (opcao == 6) {
                 String resultado = converter("COP","USD");
                 System.out.println(resultado);
             } else if(opcao > 6 || opcao < 0) {
                 System.out.println("Ce olhou as opções irmão? Digita certo, faz favô");
             }
             System.out.println("Programa finalizado!");
         } catch (Exception e) {
             throw new RuntimeException("Erro no bgl, sei la oq é parsero, o dev aqui ta com preguiça de descobrir oq é");
         }
         }

    }
}