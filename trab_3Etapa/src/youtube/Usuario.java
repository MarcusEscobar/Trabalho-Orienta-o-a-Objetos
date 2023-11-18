package youtube;

public class Usuario {
    private String senha;
    private String nomeUsuario;
    private Canal[] inscricoes = new Canal[100];
    private int qtdInscrições = 0;
    
    public Usuario( String senha, String nomeUsuario){
        //this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    
    }
    public String getSenha(){//Remove
        return senha;
    }
    public void setSenha(String senha){//Remove
        this.senha = senha;
    }
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){//Remove
        this.nomeUsuario = nomeUsuario;
    }

    public Canal[] getInscricoes(){//Remove
        return inscricoes;
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

    public void setInscricoes(Canal[] inscricoes){//Remove
        this.inscricoes = inscricoes;
    }

    public void setIncricao(int i, Canal c){//Remove
        inscricoes[i] = c;
    }

    public int getQtdInscricoes(){
        return qtdInscrições;
    }
    public void setQtdInscricoes(int qtdInscrições){//Remove
        this.qtdInscrições = qtdInscrições;

    }
}