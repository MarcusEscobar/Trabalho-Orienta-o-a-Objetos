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

    public void setUsuario(Usuario user){//Provavemente não será usado
        this.user = user;
    }

    public Canal[] getCanais(){//Provavemente não será usado
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
        String nome = nomeAleatorio.toString();
        nome = nome.substring(0,1).toUpperCase().concat(nome.substring(1));//Primeira letra Maiúscula
        return nome;
    }
    public void preencherComentarios(Video v, int qtdComentarios){
        Comentario[] comentarios = new Comentario[50];
        for(int i = 0; i<qtdComentarios; i++){
            String s = String.valueOf(i+1);
            comentarios[i]= new Comentario("Comentario ".concat(s), new Usuario("user ".concat(s),"user ".concat(s)));}
        v.setComentarios(comentarios);
        v.setQtdComentarios(qtdComentarios);

    }
    
    public void preencherVideos(Canal c, int qtdVideos){
        Video[] videos = new Video[50];
        int v = 0;

        for(int i = 0; i<qtdVideos ;i++){
            String s = String.valueOf(i+1);
            int views = random.nextInt(1, 1000);
            videos[i] = new Video("Video ".concat(s), "Descrição ".concat(s), c, views);
            videos[i].setQtdGostei(random.nextInt(0, 1000));
            videos[i].setQtdNaoGostei(random.nextInt(0, 500));
            preencherComentarios(videos[i],random.nextInt(1, 10) );
            v += views;
        }
        c.setVideos(videos);
        c.setTotalVisualizacoes(v);
        c.setQtdVideos(qtdVideos);

    }

    public void preencherEnquetes(Canal c, int qtdEnquetes){
        Enquete[] enquetes = new Enquete[50];

        for(int i = 0; i < qtdEnquetes; i++){
        	int numOpcoes = random.nextInt(2,10);
        	int[] votosEmCada = new int[numOpcoes];
        	String[] opcoes = new String[numOpcoes];
        	String pergunta = "Pergunta "+ String.valueOf(i +1);
        	
        	for(int j = 0; j < numOpcoes; j++) {
        		votosEmCada[j] = 0;
        		opcoes[j] = "Opções " + String.valueOf(j+1);
        		
        	}
        	enquetes[i] = new Enquete(pergunta, numOpcoes,votosEmCada , opcoes, c);
                   }
        c.setEnqueteS(enquetes);
        c.setQtdEnquetes(qtdEnquetes);
    }

    public void preencherCanais(){
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

    public Canal buscarCanal(String nome){
        for(int i = 0; i<qtdCanais; i++){
            if(canais[i].getNomeCanal().compareToIgnoreCase(nome) == 0){return canais[i];}
        }
        return null;
    }

    public boolean inserirCanal(Canal canal){
        if(qtdCanais<100){
            //possivel inserir
            canais[qtdCanais] = canal;
            qtdCanais++;
            return true;
        }else{
            return false;
        }
    }   

    public void deletarCanal(Canal canal){
        int i = 0;
        while(canais[i]!=canal){i++;}
        for(;i<qtdCanais;i++){
            canais[i] = canais[i+1];
        }
        qtdCanais--;
    }
}
