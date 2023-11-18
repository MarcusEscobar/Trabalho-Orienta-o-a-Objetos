package youtube;

public class Video extends Publicacao {
    private String titulo;
    private String descricaoVideo;
    private int qtdVisualizacoes;
	private Canal autor;
	private boolean isPausado = false;
	private int velocidade = 1;
	
	public Video(String titulo, String descricao, Canal c, int views){
        this.titulo = titulo;
        descricaoVideo = descricao;
       	//this.duracaoVideo = duracaoVideo;
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

	public String getDescricaoVideo() {//Remove
		return descricaoVideo;
	}

	public void setDescricaoVideo(String descricaoVideo) {
		this.descricaoVideo = descricaoVideo;
	}
	public int getQtdVisualizacoes() {//Remove
		return qtdVisualizacoes;
	}

	public void setQtdVisualizacoes(int qtdVisualizacoes){//Remove
		this.qtdVisualizacoes = qtdVisualizacoes;
	}

	public Canal getAutor(){
		return autor;
	}

	public void setAutor(Canal autor) {//Remove
		this.autor = autor;
	}
	
	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public boolean getIsPausado() {
		return isPausado;
	}

	public void setIsPausado(boolean isPausado) {
		this.isPausado = isPausado;
	}

    public String videoToString(){
		String textoVideo = new String("Este é o video: "+titulo+" do canal "+autor.getNomeCanal()+"\n");
		if(isPausado){textoVideo+="O video está pausado\n";}
		else{textoVideo+="O video está passando\n";}
		textoVideo +="Quantidade de visualizações: "+qtdVisualizacoes+"\n";
		textoVideo +="Velocidade atual: "+velocidade+"x\n";
		textoVideo += "Quantidade Gostei: "+qtdGostei+"\n";
		textoVideo += "Quantidade Não Gostei: "+qtdNaoGostei+"\n";
		textoVideo += "Descição: "+descricaoVideo+"\n";
		return textoVideo;
	
	}
	
	public void addViws(){
		qtdVisualizacoes++;
	}
}
