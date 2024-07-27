package Proyecto;

import Proyecto.Models.Hashtables.AZHashTable;
import Proyecto.Models.Hashtables.HashTablev2;
import Proyecto.Models.normal.Business;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AZHashTable azHashTable = new AZHashTable();
        HashTablev2 nestedHashTable = new HashTablev2();
        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        boolean continueSearching = true;

        try {
            List<Business> businesses = mapper.readValue(new File("src/main/resources/bussines.json"), new TypeReference<List<Business>>(){});

            for (Business business : businesses) {
                azHashTable.put(business);
                nestedHashTable.put(business);
            }

            do {
                System.out.println("Seleccione el método de búsqueda:");
                System.out.println("1. Búsqueda por índice de letras (AZHashTable)");
                System.out.println("2. Búsqueda por nombre completo en una tabla anidada (NestedHashTable)");
                System.out.print("Ingrese el número de opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese la empresa a buscar: ");
                String searchName = scanner.nextLine();

                long startTime = System.nanoTime();
                Business foundBusiness = null;

                switch (option) {
                    case 1:
                        foundBusiness = azHashTable.search(searchName);
                        break;
                    case 2:
                        foundBusiness = nestedHashTable.search(searchName);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

                long endTime = System.nanoTime();
                long searchTimeNanos = endTime - startTime; // Tiempo en nanosegundos y convertirlo en mili
                double searchTimeMillis = searchTimeNanos / 1_000_000.0;

                if (foundBusiness != null) {
                    System.out.println("Found: " + foundBusiness.toString());
                } else {
                    System.out.println("Business not found");
                }

                System.out.println("Search time: " + searchTimeNanos + " nanoseconds");
                System.out.println("Search time: " + searchTimeMillis + " milliseconds");

                System.out.print("¿Quieres buscar otra empresa? (y/n): ");
                String userResponse = scanner.nextLine().trim().toLowerCase();
                if (userResponse.equals("n")) {
                    continueSearching = false;
                }

            } while (continueSearching);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
