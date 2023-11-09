package main;

import java.util.*;
import dados.Dados;
import view.*;

public class Main {
    private static Dados dados = new Dados();
    private static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args){
        dados.preencherCanais();
        Menu.menu1(dados, entrada);
        entrada.close();
    }

    
}