package com.bridgelabz.censusanalyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH =
            "src/test/resources/IndiaStateCensusData.csv";

    private static final String WRONG_CENSUS_CSV_FILE_PATH =
            "src/test/resources/IndiaStateCensusDataWrong.csv";

    private static final String WRONG_FILE_TYPE =
            "src/test/resources/WrongFile.txt";

    private static final String CENSUS_WRONG_DELIMITER =
            "src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";

    private static final String CENSUS_WRONG_HEADER =
            "src/test/resources/IndiaStateCensusDataWrongHeader.csv";

    private static final String INDIA_STATE_CODE_CSV_FILE_PATH =
            "src/test/resources/IndiaStateCode.csv";

    private static final String WRONG_STATE_CODE_CSV_FILE_PATH =
            "src/test/resources/IndiaStateCodeWrong.csv";

    private static final String STATE_CODE_WRONG_DELIMITER =
            "src/test/resources/IndiaStateCodeWrongDelimiter.csv";

    private static final String STATE_CODE_WRONG_HEADER =
            "src/test/resources/IndiaStateCodeWrongHeader.csv";

    // -------------------- UC1 Test Cases --------------------

    @Test
    public void givenIndiaCensusCSVFile_WhenCorrect_ShouldReturnNumberOfRecords() {
        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            int numberOfRecords = analyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(28, numberOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaCensusCSVFile_WhenFileIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(WRONG_CENSUS_CSV_FILE_PATH)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                exception.type
        );
    }

    @Test
    public void givenIndiaCensusCSVFile_WhenFileTypeIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(WRONG_FILE_TYPE)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE,
                exception.type
        );
    }

    @Test
    public void givenIndiaCensusCSVFile_WhenDelimiterIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(CENSUS_WRONG_DELIMITER)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER,
                exception.type
        );
    }

    @Test
    public void givenIndiaCensusCSVFile_WhenHeaderIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(CENSUS_WRONG_HEADER)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_HEADER,
                exception.type
        );
    }

    // -------------------- UC2 Test Cases --------------------

    @Test
    public void givenIndiaStateCodeCSVFile_WhenCorrect_ShouldReturnNumberOfRecords() {
        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            int numberOfRecords = analyser.loadIndiaStateCodeData(INDIA_STATE_CODE_CSV_FILE_PATH);
            Assertions.assertEquals(28, numberOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenFileIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(WRONG_STATE_CODE_CSV_FILE_PATH)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                exception.type
        );
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenFileTypeIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(WRONG_FILE_TYPE)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE,
                exception.type
        );
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenDelimiterIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(STATE_CODE_WRONG_DELIMITER)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER,
                exception.type
        );
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenHeaderIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(STATE_CODE_WRONG_HEADER)
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_HEADER,
                exception.type
        );
    }
}
