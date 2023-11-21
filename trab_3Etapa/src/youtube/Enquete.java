package youtube;


public class Enquete extends Publicacao {
    private String[] opcoes;
    private int qtdOpcoes;

    private int[] qtdVotosEmCada; //Rever atributo
    private String pergunta;

	public Enquete(String pergunta,int qtdOpcoes,int[]qtdVotosEmCada,String[] opcoes, Canal autor){//Sem autor, igual Video
        this.pergunta = pergunta;
        this.opcoes = opcoes;//O número de opções é aletorio, gerando um número entre 2 até 10
        this.qtdOpcoes = qtdOpcoes;
        this.qtdVotosEmCada = qtdVotosEmCada;
        qtdGostei =0;
        qtdNaoGostei =0;
		this.autor = autor;
    }

	public int getQtdOpcoes() {
		return qtdOpcoes;
	}

	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}


	public String toString() {
		String enqueteToText = new String("O canal " +autor.getNomeCanal()+ "faz a seguinte pergunta: \n");
		enqueteToText += pergunta + "\n\n";
		String opcoesTextString = "";
		for (int i = 0; i < qtdOpcoes ; i++) {
			String s = String.valueOf(i+1);
			opcoesTextString += s+": "+opcoes[i] + " - Quantidade de votos: " + qtdVotosEmCada[i] + "\n";
		}
		enqueteToText += opcoesTextString;
		
		return enqueteToText;
	}
	
	public void votar(int selecao) {
		qtdVotosEmCada[selecao] ++;
	}

	public void editarEnquete(String pergunta,int numRespostas, String[] resposta, int[] qtdVotosEmCada){
		this.pergunta = pergunta;
		qtdOpcoes = numRespostas;
		opcoes = resposta;
		this.qtdVotosEmCada = qtdVotosEmCada;

	}
}


