package youtube;

public class Usuario {
    private String senha;
    private String nomeUsuario;
    private Canal[] inscricoes = new Canal[100];
    private int qtdInscrições = 0;
    
    public Usuario( String senha, String nomeUsuario){
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    
    }
    public String getSenha(){
        return senha;
    }
    public String getNomeUsuario(){
        return nomeUsuario;
    }

    public String inscricoesToString(){
        String nomeCanais = new String("");
        for(int i = 0; i < qtdInscrições; i++){
         nomeCanais += new String(" "+inscricoes[i].getNomeCanal());
        }
 
        return nomeCanais;
     }
    
    public void CancelarInscrição(Canal canal){
        int i = 0;
        while(inscricoes[i] != canal){i++;}//Encontrei index do elemento que quero remover
        for(; i<qtdInscrições-1; i++){
            inscricoes[i] = inscricoes[i+1];
        }
        qtdInscrições--;
    }
    
    public void inscreverSe(Canal canal){
        inscricoes[qtdInscrições] = canal;
        qtdInscrições++;
    }

    public Canal getInscricao(int i){
        return inscricoes[i];
    }

    public int getQtdInscricoes(){
        return qtdInscrições;
    }

}