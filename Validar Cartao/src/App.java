import javax.swing.JOptionPane;

public class App { 

    public static long SegundoNumero(long number){
        
        long soma=0;

        while(number>0){
            
            long slast;

            slast= number%100; //pegar os dois ultimos digitos
            
            number= (number-slast)/100; //retirar os dois ultimos digitos

            slast= (slast-(slast%10))/10; //pegar apenas o primeiro digito dos dois ultimos digitos

            if((slast*2)>9){
                long first= ((slast*2)-((slast*2)%10))/10;
                long second= (slast*2)%10;;

                soma=soma+first+second;
            } else {
                soma= soma+(slast*2);
            }
        }

        return soma;

    }

    public static long PrimeiroNumero(long number){

        long soma=0;
        long slast;

        while(number>0){

            slast= number%100;
            number= (number-slast)/100;
            slast= slast%10;

            soma= soma+slast;

        }

        return soma;

    }

    public static long DigitosVerificadores(long number){
        long ft=0;

        while(number>99){
            ft= number%10;
            number= (number-ft)/10;
            ft= number;
        }

        return ft;
    }

    public static long QuantidadeDeDigitos(long number){

        long ultimo;
        int count=0;

        while(number>0){

            ultimo=number%10;
            number=(number-ultimo)/10;
            count++;
        }

        return count;

    }
    public static void main(String[] args) throws Exception {
        

        long numero= Long.parseLong(JOptionPane.showInputDialog(null, "Digite o numero do cartão"));

        //algoritmo de Luhn, para verificar se o cartao é valido
        long checksum= SegundoNumero(numero)+ PrimeiroNumero(numero);

        long verificadores= DigitosVerificadores(numero);

        long ndigitos= QuantidadeDeDigitos(numero);

        if((checksum%10)!=0){
            JOptionPane.showMessageDialog(null, "Invalido");
        } else{
            if((verificadores==34 || verificadores==37) & (ndigitos==15)){
                JOptionPane.showMessageDialog(null, "American Express");
            } else if ((verificadores==51 || verificadores==52 || verificadores==53 || verificadores==54 || verificadores==55) & (ndigitos==16)){
                JOptionPane.showMessageDialog(null, "MasterCard");
            } else if ( (((verificadores-(verificadores%10))/10)==4) & (ndigitos>=13 & ndigitos<=16)){
                JOptionPane.showMessageDialog(null, "Visa");
            } else {
                JOptionPane.showMessageDialog(null, "Invalido");
            }
        }


    }
}

