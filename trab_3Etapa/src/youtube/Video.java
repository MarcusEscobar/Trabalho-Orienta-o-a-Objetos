package youtube;

public class Video extends Publicacao {
    private String titulo;
    private String descricaoVideo;
    private float duracaoVideo;
    private int qtdVisualizacoes;

    public Video(String titulo, String descricao, float duracaoVideo){//Está faltando o atributo Autor, olhar Classe Publicação
        this.titulo = titulo;
        descricaoVideo = descricao;
        this.duracaoVideo = duracaoVideo;
        qtdGostei = 0;
        qtdNaoGostei = 0;
        qtdVisualizacoes = 0;
    }
    
}
