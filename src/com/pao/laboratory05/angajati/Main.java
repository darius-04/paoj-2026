package com.pao.laboratory05.angajati;
import java.util.Scanner;
/**
 * Exercise 3 — Angajați
 * <p>
 * Cerințele complete se află în:
 * src/com/pao/laboratory05/Readme.md  →  secțiunea "Exercise 3 — Angajați"
 * <p>
 * Creează fișierele de la zero în acest pachet, apoi rulează Main.java
 * pentru a verifica output-ul așteptat din Readme.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AngajatService service = AngajatService.getInstance();

        while (true) {
            System.out.println("\n===== Gestionare Angajați =====");
            System.out.println("1. Adaugă angajat");
            System.out.println("2. Listare după salariu");
            System.out.println("3. Caută după departament");
            System.out.println("0. Ieșire");
            System.out.print("Opțiune: ");
            // citește opțiunea și execută acțiunea

            int optiune = scanner.nextInt();
            scanner.nextLine();

            if (optiune == 0) {
                System.out.println("La revedere!");
                break;
            }
            else if(optiune == 1){
                    System.out.print("Nume: ");
                    String nume = scanner.nextLine();
                    System.out.print("Departament (nume): ");
                    String dNume = scanner.nextLine();
                    System.out.print("Departament (locatie): ");
                    String dLoc = scanner.nextLine();
                    System.out.print("Salariu: ");
                    double sal = scanner.nextDouble();

                    service.addAngajat(new Angajat(nume, new Departament(dNume, dLoc), sal));
                }
            else if(optiune == 2) {
                service.listBySalary();
            }
            else if(optiune == 3){
                    System.out.print("Departament: ");
                    String depts = scanner.nextLine();
                    service.findByDepartament(depts);
                }
            else
                System.out.println("Optiune invalida!");

        }
        scanner.close();
    }

}
