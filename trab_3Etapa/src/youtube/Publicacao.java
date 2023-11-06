package youtube;

public abstract class Publicacao {
    protected int qtdGostei;
    protected int qtdNaoGostei;
	protected boolean statusGostei = false;
	protected boolean statusNãoGostei = false;
    /*
     * Não possui mais o atributo Autor
    */

	public boolean getStatusGostei() {
		return statusGostei;
	}
	public void setStatusGostei(boolean status) {
		statusGostei = status;
	}
	public boolean getStatusNãoGostei() {
		return statusNãoGostei;
	}
	public void setStatusNãoGostei(boolean status) {
		statusNãoGostei = status;
	}
    public int getQtdGostei() {
		return qtdGostei;
	}
	public void setQtdGostei(int Gostei) {
		qtdGostei = Gostei;
	}
	public int getQtdNaoGostei() {
		return qtdNaoGostei;
	}
	public void setQtdNaoGostei(int NaoGostei) {
		qtdNaoGostei = NaoGostei;
	}

}
