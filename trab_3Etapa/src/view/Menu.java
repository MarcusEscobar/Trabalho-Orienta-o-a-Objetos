package view;

import java.util.*;


import youtube.*;
import dados.*;

public abstract class Menu {


    public static void clear(){
        System.out.println("\033c");
    }

    public static void menu1(Dados dados, Scanner entrada){
        clear();
        System.out.println("Bem-Vindo ao Youtube. Faça seu cadastro\n");
        System.out.println("Insira um nome");
        String nome = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Insira uma senha");
        String senha = entrada.nextLine();
        System.out.println(" ");
        Usuario user = new Usuario(senha, nome);
        dados.setUsuario(user);
        clear();
        menu2(dados, entrada);
    }

    public static void menu2(Dados dados, Scanner entrada){
        System.out.println("Olá "+dados.getUsuario().getNomeUsuario()+", o que deseja?\n");
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - sair\n";
        opçoes += "  1 - Listar canais\n";
        opçoes += "  2 - Canais Inscritos\n";
        opçoes += "  3 - Editar usuario\n";
        opçoes += "  4 - Criar canal\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        System.out.println(" ");//Pular uma linha
        switch (valor) {
            case 0:
                clear();
                System.out.println("Obrigado por usar o Youtube!!");
                break;
            case 1:
                clear();
                menu3_Canais(dados, entrada);
                break;
            case 2:
                clear();
                menu3_Inscricoes(dados, entrada);
                break;
            default:
                clear();
                System.out.println("Opção inválida\n");
                menu2(dados, entrada);//Recursividade, simulando loop de repetição
                break;
        }
    }

    public static void menu3_Canais(Dados dados, Scanner entrada){
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - voltar\n\n";
            opçoes +="Canais disponíveis:\n\n";
            for(int i = 1; i<= dados.getQtdCanais(); i++){
                String s = String.valueOf(i);//Transformo j em string
                opçoes += new String("  "+s+" - "+dados.getCanal(i-1).getNomeCanal()+"\n");
            }
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            menu2(dados, entrada);
        }else if(valor >= 1 && valor <= dados.getQtdCanais()){
            clear();
            menu4(dados, entrada, dados.getCanal(valor-1));

        }else{
            System.out.println("Opção inválida");
            clear();
            menu3_Canais(dados, entrada);
        }
    }
    
    public static void menu3_Inscricoes(Dados dados, Scanner entrada){
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - voltar\n\n";
        if(dados.getUsuario().getQtdInscricoes() == 0){
            opçoes+= "Você não está inscrito em nenhum canal!\n";
        }else{
            opçoes +="Canais disponíveis:\n\n";
            for(int i = 1; i<= dados.getUsuario().getQtdInscricoes(); i++){
                String s = String.valueOf(i);//Transformo j em string
                opçoes += new String("  "+s+" - "+dados.getUsuario().getInscricao(i-1).getNomeCanal()+"\n");
            }
        }
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            menu2(dados, entrada);
        }else if(valor >= 1 && valor <= dados.getQtdCanais() && dados.getUsuario().getQtdInscricoes() != 0){
            clear();
            menu4(dados, entrada, dados.getUsuario().getInscricao(valor-1));

        }else{
            System.out.println("Opção inválida");
            clear();
            menu3_Inscricoes(dados, entrada);
        }


    }

    public static void menu4(Dados dados, Scanner entrada, Canal canal){
        System.out.println("Este é o canal: "+canal.getNomeCanal());
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "0 - voltar para pagina principal\n";
        if(dados.getUsuario().inscricoesToString().contains(canal.getNomeCanal())){
            //está inscrito
            opçoes += "1 - Cancelar inscrição\n";
        }else{
            opçoes += "1 - Inscrever-se\n";
        }
        opçoes += "2 - Listar videos\n";
        opçoes += "3 - Listar enquetes\n";
        opçoes += "4 - Editar canal\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menu2(dados, entrada);
                break;
            case 1:
                if(dados.getUsuario().inscricoesToString().contains(canal.getNomeCanal())){
                //está inscrito
                    dados.getUsuario().CancelarInscrição(canal);
                    canal.setQtdInscritos(canal.getQtdInscritos()-1);
                    clear();
                     menu4(dados, entrada, canal);
                }else{
                    dados.getUsuario().inscreverSe(canal);
                    canal.setQtdInscritos(canal.getQtdInscritos()+1);
                    clear();
                     menu4(dados, entrada, canal);
                }
                break;
            default:
                clear();
                System.out.println("opção inválida");
                menu4(dados, entrada, canal);
                break;
        }
            
    }
    
}