package com.pao.laboratory07.exercise2;

import java.util.Locale;

public final class ComandaRedusa extends Comanda {
    private double pret;
    private int discount;

    public ComandaRedusa(String nume, double pret, int discount) {
        super(nume);
        this.pret = pret;
        this.discount = discount;
    }

    @Override
    public double pretFinal() {
        return pret * (1 - discount / 100.0);
    }

    @Override
    public String descriere() {
        return String.format(Locale.US, "DISCOUNTED: %s, pret: %.2f lei (-%d%%) [%s]", nume, pretFinal(), discount, stare);
    }
}