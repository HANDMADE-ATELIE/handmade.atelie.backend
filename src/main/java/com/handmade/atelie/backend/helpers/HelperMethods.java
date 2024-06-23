package com.handmade.atelie.backend.helpers;

public class HelperMethods {

    public static String removeNotNumbers(String str) {
        return str.replaceAll("[^0-9]", "");
    }
    
    public static Boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}"))
            return false;

        int[] numbers = new int[11];
        for (int i = 0; i < 11; i++)
            numbers[i] = Integer.parseInt(cpf.substring(i, i + 1));

        int sum = 0;
        for (int i = 0; i < 9; i++)
            sum += numbers[i] * (10 - i);

        int result = sum % 11;
        if (result == 1 || result == 0)
            result = 0;
        else
            result = 11 - result;

        if (result != numbers[9])
            return false;

        sum = 0;
        for (int i = 0; i < 10; i++)
            sum += numbers[i] * (11 - i);

        result = sum % 11;
        if (result == 1 || result == 0)
            result = 0;
        else
            result = 11 - result;

        return result == numbers[10];
    }

    
}
