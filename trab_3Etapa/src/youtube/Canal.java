package youtube;

public class Canal {
    private String nomeCanal;
    private int qtdInscritos;
	private Video[] videos = new Video[50];
    private int qtdVideos;
	private Enquete[] enquetes = new Enquete[50];
	private int qtdEnquetes;
    private int totalVisualizacoes;
    private Usuario proprietario;


    public Canal(String nomeCanal, Usuario proprietario){
        this.nomeCanal = nomeCanal;
        this.proprietario = proprietario;
        qtdInscritos = 0;
        totalVisualizacoes = 0;
		qtdVideos = 0;
		
    }

    
	public String getNomeCanal() {
		return nomeCanal;
	}
	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}
	public int getQtdInscritos() {
		return qtdInscritos;
	}
	public void setQtdInscritos(int qtdInscritos) {
		this.qtdInscritos = qtdInscritos;
	}
	public int getQtdVideos() {
		return qtdVideos;
	}
	public void setQtdVideos(int qtdVideos) {
		this.qtdVideos = qtdVideos;
	}
	public void somarQtdVideos(int i){//Remove
		this.qtdVideos += i;
	}

	public int getTotalVisualizacoes() {//Remove
		return totalVisualizacoes;
	}
	public void setTotalVisualizacoes(int totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;//Adicionar metododo viws++
	}
	public Usuario getProprietario() {//Remove
		return proprietario;
	}
	public void setProprietario(Usuario proprietario) {//Remove
		this.proprietario = proprietario;
	}
	public Video[] getVideos(){//Remove
		return videos;
	}
	public Video getVideo(int i){
		return videos[i];
	}
	public void setVideos(Video[] videos){
		this.videos = videos;
	}
	public void setVideo(int i,Video v){//Remove
		videos[i] = v;
	}
	public Enquete[] getEnquetes(){//Remove
		return enquetes;
	}
	public Enquete getEnquete(int i){//Remove
		return enquetes[i];
	}
	public void setEnqueteS(Enquete[] enquetes){
		this.enquetes = enquetes;
	}
	public void setEnquete(int i,Enquete e){
		enquetes[i] = e;
	}
	public int getQtdEnquetes(){
		return qtdEnquetes;
	}
	public void setQtdEnquetes(int qtdEnquetes){
		this.qtdEnquetes = qtdEnquetes;

	}
	public void somarQtdEnquetes(int i){//Remove
		this.qtdEnquetes += i;
	}

	public boolean adicionarEnquete(Enquete novaEnquete) {
		if (qtdEnquetes >= 50 ) {
			return false;
		}
		else{
			enquetes[qtdEnquetes] = novaEnquete;
			qtdEnquetes++;
			return true;
		}  
	}	

	public Video buscarVideo(String titulo){
		for(int i = 0; i < qtdVideos; i++){
			if(videos[i].getTitulo().compareToIgnoreCase(titulo) == 0){return videos[i];}

		}
		return null;
	}

	public boolean adicionarVideo(Video video){
		if(qtdVideos < 50){
			videos[qtdVideos]=video;
			qtdVideos++;
			return true;
		}else{
			return false;
		}

	}

	public void deleteVideo(Video video){
		int i = 0;
		while (videos[i]!=video){i++;}
		for(;i<qtdVideos;i++){
			videos[i] = videos[i+1];
		}
		qtdVideos--;

	}

	public void deletarEnquete(Enquete enquete){
		int i = 0;
		while (enquetes[i]!=enquete){i++;}
		for(;i<qtdEnquetes;i++){
			enquetes[i] = enquetes[i+1];
		}
		qtdEnquetes--;

	}

	public String canalToString(){
		String textoCanal = new String("Este é o canal: "+nomeCanal+"\n");
		textoCanal+="Proprietario: "+proprietario.getNomeUsuario()+"\n";
		textoCanal+="Quantidade de inscritos: "+qtdInscritos+"\n";
		textoCanal+="Quantidade de videos: "+qtdVideos+"\n";
		textoCanal+="Quantidade de enquetes: "+qtdEnquetes+"\n";
		textoCanal+="Total de visualizações: "+totalVisualizacoes+"\n";

		return textoCanal;
	}

}
