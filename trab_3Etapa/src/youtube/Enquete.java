package youtube;

public class Enquete extends Publicacao {
    private String[] opcoes;
    private int qtdOpcoes;
    private int qtdVotos;
    private int[] qtdVotosEmCada;
    private String pergunta;

    public Enquete(String pergunta,String opcaoA, String opcaoB, String opcaoC, String opcaoD){//Sem autor, igual Video
        this.pergunta = pergunta;
        opcoes = new String[]{opcaoA, opcaoB, opcaoC, opcaoD};//Somente 4 opçoes de escolha
        qtdOpcoes = 4;
        qtdVotos = 0;
        qtdVotosEmCada = new int[]{0,0,0,0};//Cada opção starta com O votos
        qtdGostei =0;
        qtdNaoGostei =0;
    }
}
