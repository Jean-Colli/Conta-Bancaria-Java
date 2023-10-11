package conta_bancaria;

/**
 *
 * @author jeanc
 */
public class Usuario {
    String nome;
    String user;
    String senha;
    Conta conta;
    
    public Usuario(String nome, String user, String senha, Conta conta){
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.conta = conta;
    }
}
