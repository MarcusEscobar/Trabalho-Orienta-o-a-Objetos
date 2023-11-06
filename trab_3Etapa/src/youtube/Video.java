package youtube;

public class Video extends Publicacao {
    private String titulo;
    private String descricaoVideo;
    private float duracaoVideo;//Segundos
    private int qtdVisualizacoes;
	private Canal autor;

	public Video(String titulo, String descricao, float duracaoVideo, Canal c, int views){
        this.titulo = titulo;
        descricaoVideo = descricao;
        this.duracaoVideo = duracaoVideo;
        qtdGostei = 0;
        qtdNaoGostei = 0;
        qtdVisualizacoes = views;
		autor = c;
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

	public Canal getAutor() {
		return autor;
	}

	public void setAutor(Canal autor) {
		this.autor = autor;
	}

    
}
