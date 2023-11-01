package youtube;

public class Canal {
    private String nomeCanal;
    private int qtdInscritos;
    private int qtdVideos;
    private int totalVisualizacoes;
    private Usuario proprietario;


    public Canal(String nomeCanal, Usuario proprietario){
        this.nomeCanal = nomeCanal;
        this.proprietario = proprietario;
        qtdInscritos = 0;
        qtdVideos = 0;
        totalVisualizacoes = 0;
    }
}



