package br.com.fatec.services;

public class StringTools {
    public static boolean isNotEmpty(String... fields) {       
        for (String field : fields) {
            if (field.isEmpty()) return false;
        }
        return true;
    }
}
