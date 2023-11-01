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

    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricaoVideo() {
		return descricaoVideo;
	}

	public void setDescricaoVideo(String descricaoVideo) {
		this.descricaoVideo = descricaoVideo;
	}

	public float getDuracaoVideo() {
		return duracaoVideo;
	}

	public void setDuracaoVideo(float duracaoVideo) {
		this.duracaoVideo = duracaoVideo;
	}

	public int getQtdVisualizacoes() {
		return qtdVisualizacoes;
	}

	public void setQtdVisualizacoes(int qtdVisualizacoes) {
		this.qtdVisualizacoes = qtdVisualizacoes;
	}
    
    
}
