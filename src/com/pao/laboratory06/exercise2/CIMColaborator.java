package com.pao.laboratory06.exercise2;
import java.util.Scanner;

public class CIMColaborator extends Colaborator implements PersoanaFizica {
    private boolean bonus;

    @Override public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.venitBrutLunar = in.nextDouble();
        String b = in.next();
        this.bonus = b.equals("DA");
        this.tip = TipColaborator.CIM;
    }

    @Override public double calculeazaVenitNetAnual() {
        double net = venitBrutLunar * 12 * 0.55;
        if(bonus)
            return net * 1.10;
        else
            return net;
    }
}