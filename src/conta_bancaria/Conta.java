package conta_bancaria;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanc
 */
public class Conta {
    
    private String tipoDaConta = "Indefinido";
    private double saldo = 0;
    DecimalFormat decimal = new DecimalFormat("0.00");
    
    public void Depositar(double valor){
        try {
            saldo = saldo + valor;
            JOptionPane.showMessageDialog(null, "O valor de R$ " + decimal.format(valor) + " foi inserido com sucesso", "Banco Tech", 0);
            JOptionPane.showMessageDialog(null, "Seu novo saldo agora é de: R$ " + decimal.format(saldo), "Banco Tech", 0);
        }catch(ArithmeticException e){
            System.out.println("Erro");
        }
    }
    
    public void DepositarOutro(double valor){
        try {
            saldo = saldo + valor;
            JOptionPane.showMessageDialog(null, "O valor de R$ " + decimal.format(valor) + " foi inserido com sucesso", "Banco Tech", 0);
        }catch(ArithmeticException e){
            System.out.println("Erro");
        }
    }
    
    public void Sacar(double valor){
        try{
            if(valor > saldo){
                JOptionPane.showMessageDialog(null, "Não se pode realizar o saque pois o valor desejado não consta na conta", "BAnco Tech", 0);
            }else {
                saldo = saldo - valor;
                JOptionPane.showMessageDialog(null, "O valor sacado foi de R$ " + decimal.format(valor), "Banco Tech", 0);
                JOptionPane.showMessageDialog(null, "O valor em saldo restante é de R$ " + decimal.format(saldo), "Banco Tech", 0);
            }
        
        }catch(ArithmeticException e){
            System.out.println("Erro");
        }
    }
    
    public void SaldoDaConta(){
        JOptionPane.showMessageDialog(null, "O seu saldo atual é de: R$ " + decimal.format(saldo), "Banco Tech", 0);
    }
    
    public Conta(String tipoDaConta, double saldo){
        this.saldo = saldo;
        this.tipoDaConta = tipoDaConta;
    }
    

    
    
}
