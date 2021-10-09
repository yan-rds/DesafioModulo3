package br.com.zup;

public class Validadores {

    public static void validarCpf (String cpf) throws Exception{
        // Receber o CPF
        String cpfRecebido = cpf;
        // Recusar CPFs impossíveis
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") ||
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") ||
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") ||
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") ||
            cpf.equals("99999999999") ||
            cpf.length() != 11){
            throw new Exception("CPF inválido");
        }
        // Transformar os caracteres do cpf em Int
        // Definir os dígitos verificadores para esse cpf
        // Comparar se os digitos verificadores são iguais ao dado pelo usuario
    }
}
