package com.bridgelabz.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Population")
    private int population;

    @CsvBindByName(column = "AreaInSqKm")
    private int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private int densityPerSqKm;

    public CSVStateCensus() {
    }

    public CSVStateCensus(String state, int population, int areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    public String getState() {
        return state;
    }

    public int getPopulation() {
        return population;
    }

    public int getAreaInSqKm() {
        return areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return densityPerSqKm;
    }
}
