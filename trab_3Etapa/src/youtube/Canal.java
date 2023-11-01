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
	public int getTotalVisualizacoes() {
		return totalVisualizacoes;
	}
	public void setTotalVisualizacoes(int totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;//Adicionar metododo viws++
	}
	public Usuario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}
}



