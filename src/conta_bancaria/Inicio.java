package conta_bancaria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanc
 */
public class Inicio {
    
    static Usuarios usuarios = new Usuarios();
    
    static Usuario[] listaUsuarios = {usuarios.usuario1, usuarios.usuario2, usuarios.usuario3, usuarios.usuario4, usuarios.usuario5, usuarios.usuario6, usuarios.usuario7, usuarios.usuario8, usuarios.usuario9, usuarios.usuario10};
    
    
    
    
    
    static Usuario usuarioLogado = null;
    static String[] opcaosn = {"Sim", "Não"};
    
    public static void main(String[] args) {
       
           
       if(usuarioLogado == null){
           
           
           String[] opcoes = {"Login", "Depositar para Outra Pessoa", "Sair"};
           int opcao = JOptionPane.showOptionDialog(null, "Escolha a Função Desejada", "Banco Tech", 0, JOptionPane.QUESTION_MESSAGE, null , opcoes, "Login");
           switch (opcao){
               case 0:
                   usuarioLogado = login();
                   main(opcoes);
                   break;
                case 1:
                    depositoParaOutro();
                    break;
                case 2:
                    System.exit(0);
                case -1:
                    System.exit(0);
                    
           }
       }else {   
           String[] opcoes = {"Saldo", "Depositar", "Sacar", "Logoff"};
           int opcao = JOptionPane.showOptionDialog(null, "Escolha a Função Desejada", "Banco Tech", 0, JOptionPane.QUESTION_MESSAGE, null , opcoes, "Login");
           switch (opcao){
               case 0:
                   usuarioLogado.conta.SaldoDaConta();
                   main(opcoes);
                   break;
                case 1:
                    usuarioLogado.conta.Depositar(Double.parseDouble(JOptionPane.showInputDialog(null, "Qual Valor você deseja Depositar? ", "Banco Tech", 0)));
                    
                    main(opcoes);
                    break;
                case 2:
                    usuarioLogado.conta.Sacar(Double.parseDouble(JOptionPane.showInputDialog(null, "Qual Valor você deseja Sacar? ", "Banco Tech", 0)));
                    main(opcoes);
                case 3: 
                    usuarioLogado = null; 
                    main(opcoes);
                case -1:
                     System.exit(0);
                
           }
       }    
           
        
    }
    
    public static Usuario login(){
        String user = JOptionPane.showInputDialog(null, "Insira seu Acesso Login: ", "Banco Tech", 0);
        if (user.equals("-1")){
            System.exit(0);
        }
        String senha = JOptionPane.showInputDialog(null, "Insira sua senha: ", "Banco Tech", 0);
        if (senha.equals("-1")){
            System.exit(0);
        }
        
        for(int i = 0; i < listaUsuarios.length; i++){
            
            if(listaUsuarios[i].user.equals(user) && listaUsuarios[i].senha.equals(senha)){
                return listaUsuarios[i];
            }
        }
        
        JOptionPane.showMessageDialog(null, "Dados Inseridos Incorretamente. Tente Novamente", "Banco Tech", 0);
        return login();
    }
    
    public static void depositoParaOutro(){
        String destinatario = JOptionPane.showInputDialog(null, "Qual o Destinatário do depósito: ", "Banco Tech", 0);
        
        
        for(int i = 0; i < listaUsuarios.length; i++){
            
            if(listaUsuarios[i].nome.equals(destinatario)){
                int confirm = JOptionPane.showOptionDialog(null, "O depósito é para esta Pessoa: " + listaUsuarios[i].nome, "Banco Tech", 0, JOptionPane.QUESTION_MESSAGE , null, opcaosn, "Sim");
                switch (confirm){
                    case 0:   
                        listaUsuarios[i].conta.DepositarOutro(Double.parseDouble(JOptionPane.showInputDialog(null, "Qual Valor você deseja Depositar? ", "Qual Valor você deseja Depositar? ", 0)));
                        main(opcaosn);
                        break;
                    case 1:
                        String[] opcoes = {"Reinserir Destinatario", "Menu Inicial"};
                        int escolha = JOptionPane.showOptionDialog(null, "OK, Escolha a Opção desejada: ", "Banco Tech", 0, JOptionPane.QUESTION_MESSAGE, null , opcoes, "Reinserir Destinatario");
                        switch (escolha){
                            case 0:
                                depositoParaOutro();
                                break;
                            case 1:
                                main(opcoes);
                                break;
                            case -1:
                                System.exit(0);
                        }
                    case -1:
                        System.exit(0);
                        
            }
            }else {
                JOptionPane.showMessageDialog(null, "Nome Inserido Não Encontado...", "Banco Tech", 0);
                String[] opcoes = {"Reinserir Destinatario", "Menu Inicial"};
                int escolha = JOptionPane.showOptionDialog(null, "OK, Escolha a Opção desejada: ", "Banco Tech", 0, JOptionPane.QUESTION_MESSAGE, null , opcoes, "Reinserir Destinatario");
                switch (escolha){
                    case 0:
                        depositoParaOutro();
                        break;
                    case 1:
                        main(opcoes);
                        break;
                    case -1:
                        System.exit(0);
                }
            }
        }
       
    }
    
    
}
