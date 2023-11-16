package main;

import java.util.*;
import dados.Dados;
import view.*;

public class Main {
    private static Dados dados = new Dados();
    
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        dados.preencherCanais();
        Menu.menu1(dados, entrada);
        
}

    
}