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
        String S1, S2, S3, S4, S5, S6, S7, S8, S9, cpfIdeal = cpf;
        int N1, N2, N3, N4, N5, N6, N7, N8, N9, verificador1, verificador2;

        S1 = cpf.substring(0, 1); N1 = Integer.parseInt(S1);
        S2 = cpf.substring(1, 2); N2 = Integer.parseInt(S2);
        S3 = cpf.substring(2, 3); N3 = Integer.parseInt(S3);
        S4 = cpf.substring(3, 4); N4 = Integer.parseInt(S4);
        S5 = cpf.substring(4, 5); N5 = Integer.parseInt(S5);
        S6 = cpf.substring(5, 6); N6 = Integer.parseInt(S6);
        S7 = cpf.substring(6, 7); N7 = Integer.parseInt(S7);
        S8 = cpf.substring(7, 8); N8 = Integer.parseInt(S8);
        S9 = cpf.substring(8, 9); N9 = Integer.parseInt(S9);

        // Definir os dígitos verificadores corretos para esse cpf
        verificador1 = (N1 * 10 + N2 * 9 + N3 * 8 + N4 * 7 + N5 * 6 + N6 * 5 + N7 * 4 + N8 * 3 + N9 * 2);
        if ((verificador1 % 11) < 2){
            verificador1 = 0;
        }
        else {
            verificador1 = 11 - (verificador1 % 11);
        }

        verificador2 = (N1 * 11 + N2 * 10 + N3 * 9 + N4 * 8 + N5 * 7 + N6 * 6 + N7 * 5 + N8 * 4 + N9 * 3 + verificador1 * 2);
        if ((verificador2 % 11) < 2){
            verificador2 = 0;
        }
        else {
            verificador2 = 11 - (verificador2 % 11);
        }

        // Comparar cpf ideal com cpf informado
        cpfIdeal = (S1 + S2 + S3 + S4 + S5 + S6 + S7 + S8 + S9 + verificador1 + "" + verificador2);
        if (!cpfIdeal.equals(cpfRecebido)){
            throw new Exception("Cpf inválido.");
        }

    }

    public static void validarEmail (String email) throws Exception{
        if (!email.contains("@")){
            throw new Exception("Email inválido");
        }
    }
}
