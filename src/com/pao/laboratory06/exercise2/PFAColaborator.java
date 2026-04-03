package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class PFAColaborator extends Colaborator implements PersoanaFizica {
    private double cheltuieliLunare;
    // Salariul minim brut lunar în 2026: 4050 lei
    private static final double SALARIU_MINIM_LUNAR = 4050;
    private static final double SALARIU_MINIM_ANUAL = SALARIU_MINIM_LUNAR * 12;

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.venitBrutLunar = in.nextDouble();
        this.cheltuieliLunare = in.nextDouble();
        this.tip = TipColaborator.PFA;
    }

    @Override
    public double calculeazaVenitNetAnual() {
        double venitNetBazaAnual = (venitBrutLunar - cheltuieliLunare) * 12;
        double impozit = 0.10 * venitNetBazaAnual;
        double cass;
        if (venitNetBazaAnual < 6 * SALARIU_MINIM_ANUAL) {
            cass = 0.10 * (6 * SALARIU_MINIM_ANUAL);
        } else if (venitNetBazaAnual <= 72 * SALARIU_MINIM_ANUAL) {
            cass = 0.10 * venitNetBazaAnual;
        } else {
            cass = 0.10 * (72 * SALARIU_MINIM_ANUAL);
        }
        double cas = 0;
        if (venitNetBazaAnual >= 24 * SALARIU_MINIM_ANUAL) {
            cas = 0.25 * (24 * SALARIU_MINIM_ANUAL);
        } else if (venitNetBazaAnual >= 12 * SALARIU_MINIM_ANUAL) {
            cas = 0.25 * (12 * SALARIU_MINIM_ANUAL);
        }
        return venitNetBazaAnual - impozit - cass - cas;
    }
}