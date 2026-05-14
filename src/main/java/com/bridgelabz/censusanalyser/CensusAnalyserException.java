package com.bridgelabz.censusanalyser;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        INCORRECT_FILE_TYPE,
        INCORRECT_DELIMITER,
        INCORRECT_HEADER
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
