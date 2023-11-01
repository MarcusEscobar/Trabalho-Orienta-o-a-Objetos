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

    
	public String[] getOpcoes() {
		return opcoes;
	}

    public String getOpcao(int i){
        return opcoes[i];
    }

	public void setOpcoes(String[] opcoes) {
		this.opcoes = opcoes;
	}

    public void setOpcao(int i, String o){
        opcoes[i] = o;
    }

	public int getQtdOpcoes() {
		return qtdOpcoes;
	}
	public void setQtdOpcoes(int qtdOpcoes) {
		this.qtdOpcoes = qtdOpcoes;
	}
	public int getQtdVotos() {
		return qtdVotos;
	}
	public void setQtdVotos(int qtdVotos) {
		this.qtdVotos = qtdVotos;
	}
	public int[] getQtdVotosEmCada() {
		return qtdVotosEmCada;
	}
	public void setQtdVotosEmCada(int[] qtdVotosEmCada) {
		this.qtdVotosEmCada = qtdVotosEmCada;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

}


