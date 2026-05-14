package com.bridgelabz.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {

    @CsvBindByName(column = "SrNo")
    private int srNo;

    @CsvBindByName(column = "StateName")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "StateCode")
    private String stateCode;

    public CSVStateCode() {
    }

    public CSVStateCode(int srNo, String stateName, int tin, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }

    public int getSrNo() {
        return srNo;
    }

    public String getStateName() {
        return stateName;
    }

    public int getTin() {
        return tin;
    }

    public String getStateCode() {
        return stateCode;
    }
}
