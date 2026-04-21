package com.pao.laboratory06.exercise2;

public abstract class Colaborator implements IOperatiiCitireScriere {
    protected String nume;
    protected String prenume;
    protected double venitBrutLunar;
    protected TipColaborator tip;

    public abstract double calculeazaVenitNetAnual();

    public TipColaborator getTip() { return tip; }

    @Override public String tipContract() { return tip.toString(); }

    @Override public void afiseaza() {
        System.out.println(tipContract() + ": " + nume + " " + prenume + ", venit net anual: " + String.format("%.2f", calculeazaVenitNetAnual()) + " lei");
    }
}