package youtube;

public class Video extends Publicacao {
    private String titulo;
    private String descricaoVideo;
    private int qtdVisualizacoes;
	private boolean estaPausado = false;
	private int velocidade = 1;
	
	public Video(String titulo, String descricao, Canal c, int views){
        this.titulo = titulo;
        descricaoVideo = descricao;
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

	public void setDescricaoVideo(String descricaoVideo) {
		this.descricaoVideo = descricaoVideo;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public boolean getIsPausado() {
		return estaPausado;
	}

	public void setIsPausado(boolean isPausado) {
		this.estaPausado = isPausado;
	}

    public String toString(){
		String textoVideo = new String("Este é o video: "+titulo+", do canal "+autor.getNomeCanal()+"\n");
		if(estaPausado){textoVideo+="O video está pausado\n";}
		else{textoVideo+="O video está passando\n";}
		textoVideo +="Quantidade de visualizações: "+qtdVisualizacoes+"\n";
		textoVideo +="Velocidade atual: "+velocidade+"x\n";
		textoVideo += gosteiNaoGostei();
		textoVideo += "Descição: "+descricaoVideo+"\n";
		return textoVideo;
	
	}
	
	public void addViws(){
		qtdVisualizacoes++;
	}

}
