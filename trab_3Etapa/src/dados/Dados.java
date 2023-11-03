package dados;

import java.util.*;

import youtube.*;

public class Dados {
    private Usuario user;
    private  Canal[] canais = new Canal[100];
    private  int qtdCanais = 0;
    private  Random random = new Random();

    public Usuario getUsuario(){
        return user;
    }

    public void setUsuario(Usuario user){
        this.user = user;
    }

    public Canal[] getCanais(){
        return canais;
    }
    public Canal getCanal(int i){
        return canais[i];
    }
    public void setCanais(Canal[] canais){
        this.canais = canais;
    }
    public void setCanal(int i,Canal c){
        canais[i] = c;
    }
    public  int getQtdCanais(){
        return qtdCanais;
    }
    public  void setQtdCanais(int qtdCanais){
        this.qtdCanais = qtdCanais;
    }

    public String gerarNomeAleatorio(int tamanho) {
        String alfabeto = "abcdefghijklmnoprstuv"; 
        String vogais = "aeiou";
        StringBuilder nomeAleatorio = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            char letra;
            if (nomeAleatorio.length() > 0 && !vogais.contains(Character.toString(nomeAleatorio.charAt(nomeAleatorio.length() - 1)))) {
                letra = vogais.charAt(random.nextInt(vogais.length()));
            } else {letra = alfabeto.charAt(random.nextInt(alfabeto.length()));}
            nomeAleatorio.append(letra);
        }
        return nomeAleatorio.toString();
    }
    public void preencherVideos(Canal c, int qtdVideos){
        Video[] videos = new Video[qtdVideos];
        int v = 0;

        for(int i = 0; i<qtdVideos ;i++){
            String s = String.valueOf(i);
            int views = random.nextInt(1, 1000);
            videos[i] = new Video("Video".concat(s), "Descrição".concat(s), random.nextFloat(10, 60), c, views);
            v += views;
        }
        c.setVideos(videos);
        c.setTotalVisualizacoes(v);

    }

    public void preencherEnquetes(Canal c, int qtdEnquetes){
        Enquete[] enquetes = new Enquete[qtdEnquetes];

        for(int i = 0; i < qtdEnquetes; i++){
            String s = String.valueOf(i);
            enquetes[i] = new Enquete("Pergunta".concat(s), "Opção 1", "Opção 2", "Opção 3", "Opção 4");
            //Para o atributo pergunta podemos criar templates e selecionar aletatoriamente
        }
        c.setEnqueteS(enquetes);
    }

    public void preencherCanais(){//krl essa função ficou mt grande, mas basicamente cria Objetos aleatorios
        for(int i = 0; i < 10; i++){
            String nomeRandom = gerarNomeAleatorio(random.nextInt(4, 8)); 
            canais[i] = new Canal(nomeRandom , new Usuario(nomeRandom.concat("Senha"), nomeRandom.concat("User")));
            preencherVideos(canais[i], random.nextInt(3,10));
            preencherEnquetes(canais[i], random.nextInt(3,10));
            qtdCanais++;
        }
    }

    public String canaisToString(){
       String nomeCanais = new String("");
       for(int i = 0; i < qtdCanais; i++){
        nomeCanais += new String(" "+canais[i].getNomeCanal());
       }

       return nomeCanais;
    }
    
}  

