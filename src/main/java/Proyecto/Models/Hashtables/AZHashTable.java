package Proyecto.Models.Hashtables;

import Proyecto.Models.normal.Business;

import java.util.HashMap;
import java.util.Map;

public class AZHashTable {
    private static final int FIRST_LEVEL_SIZE = 26; // Tabla Abecesario
    private static final int SECOND_LEVEL_SIZE = 26; // Igual de abecedario
    private static final int THIRD_LEVEL_SIZE = 1000; // tabla de insercion por 3er caracter

    private final Map<Character, Map<Character, Map<String, Business>>> firstLevel;

    public AZHashTable() {
        firstLevel = new HashMap<>();
        // Inicializa la primera tabla hash para cada letra del abecedario
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            firstLevel.put(ch, new HashMap<>());
        }
    }

    public void put(Business business) {
        String name = business.getName();
        if (name == null || name.length() < 3) {
            return;
        }

        name = name.toUpperCase();
        char firstChar = name.charAt(0);
        char secondChar = name.charAt(1);
        String remaining = name.substring(2);

        // Obtener o crear la segunda tabla hash
        Map<Character, Map<String, Business>> secondLevel = firstLevel.computeIfAbsent(firstChar, k -> new HashMap<>());
        // Obtener o crear la tercera tabla hash
        Map<String, Business> thirdLevel = secondLevel.computeIfAbsent(secondChar, k -> new HashMap<>());
        // Insertar el negocio en la tercera tabla
        thirdLevel.put(remaining, business);
    }

    public Business search(String name) {
        if (name == null || name.length() < 3) {
            return null;
        }

        name = name.toUpperCase();
        char firstChar = name.charAt(0);
        char secondChar = name.charAt(1);
        String remaining = name.substring(2);

        Map<Character, Map<String, Business>> secondLevel = firstLevel.get(firstChar);
        if (secondLevel == null) {
            return null;
        }

        Map<String, Business> thirdLevel = secondLevel.get(secondChar);
        if (thirdLevel == null) {
            return null;
        }

        return thirdLevel.get(remaining);
    }
}
