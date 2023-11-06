package youtube;

public abstract class Publicacao {
    protected int qtdGostei;
    protected int qtdNaoGostei;
    /*
     * Não possui mais o atributo Autor
    */

    
    public int getQtdGostei() {
		return qtdGostei;
	}
	public void setQtdGostei(int qtdGostei) {
		this.qtdGostei = qtdGostei;
	}
	public int getQtdNaoGostei() {
		return qtdNaoGostei;
	}
	public void setQtdNaoGostei(int qtdNaoGostei) {
		this.qtdNaoGostei = qtdNaoGostei;
	}

}
