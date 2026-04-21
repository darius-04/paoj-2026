package com.pao.laboratory08.exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/com/pao/laboratory08/tests/studenti.txt";

    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String nume = parts[0].trim();
                    int varsta = Integer.parseInt(parts[1].trim());
                    String oras = parts[2].trim();
                    String strada = parts[3].trim();

                    studenti.add(new Student(nume, varsta, new Adresa(oras, strada)));
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String comanda = scanner.nextLine().trim();
        String[] cmdParts = comanda.split(" ", 2);
        String tipComanda = cmdParts[0];

        try {
            if (tipComanda.equals("PRINT")) {
                for (Student s : studenti) {
                    System.out.println(s);
                }
            } else if (tipComanda.equals("SHALLOW") || tipComanda.equals("DEEP")) {
                String numeCautat = cmdParts[1];
                Student target = null;

                for (Student s : studenti) {
                    if (s.getNume().equals(numeCautat)) {
                        target = s;
                        break;
                    }
                }
                if (target != null) {
                    Student clona;
                    if (tipComanda.equals("SHALLOW")) {
                        clona = target.shallowClone();
                    } else {
                        clona = target.deepClone();
                    }
                    clona.getAdresa().setOras("MODIFICAT");
                    System.out.println("Original: " + target);
                    System.out.println("Clona: " + clona);
                }
            }
        } catch (CloneNotSupportedException e) {
            System.err.println("Eroare la clonare: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}