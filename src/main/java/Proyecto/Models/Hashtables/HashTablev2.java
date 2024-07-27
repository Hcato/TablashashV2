package Proyecto.Models.Hashtables;

import Proyecto.Models.normal.Business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTablev2 {
    private static final int INITIAL_TABLE_SIZE = 1000;
    private List<LinkedList<Business>> table;
    private int size;

    public HashTablev2() {
        this(INITIAL_TABLE_SIZE);
    }

    public HashTablev2(int tableSize) {
        table = new ArrayList<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            table.add(new LinkedList<>());
        }
        size = 0;
    }
    private static int hash(String name) {
        // Método hash basado en el primer carácter del nombre
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }

        // Tomar el primer carácter y convertirlo a un valor entre 0 y table.size() - 1
        char firstChar = name.toUpperCase().charAt(0);
        return Math.abs(firstChar - 'A') % INITIAL_TABLE_SIZE;
    }

    private void rehash() {
        List<LinkedList<Business>> oldTable = table;
        int newTableSize = table.size() * 2; // Redimensionar el tamaño de la tabla
        table = new ArrayList<>(newTableSize);
        for (int i = 0; i < newTableSize; i++) {
            table.add(new LinkedList<>());
        }

        size = 0;
        for (LinkedList<Business> bucket : oldTable) {
            for (Business business : bucket) {
                put(business); // Reinsertar en la nueva tabla
            }
        }
    }

    public void put(Business business) {
        if (business.getName().length() < 3) {
            return;
        }
        if ((double) size / table.size() > 0.75) {
            rehash();
        }
        int index = hash(business.getName()); // Usar la función hash para obtener el índice
        table.get(index).add(business);
        size++;
    }

    public Business search(String name) {
        if (name.length() < 3) {
            return null;
        }
        int index = hash(name); // Usar la función hash para obtener el índice
        for (Business business : table.get(index)) {
            if (business.getName().equals(name)) {
                return business;
            }
        }
        return null;
    }
}
