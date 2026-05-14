package com.bridgelabz.censusanalyser;

import com.bridgelabz.csv.CSVStateCensus;
import com.bridgelabz.csv.CSVStateCode;
import com.bridgelabz.csv.OpenCSVBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    public static void main(String[] args) {
        System.out.println("Welcome to Indian States Census Analyser Problem");
    }

    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        checkFileType(csvFilePath);

        try (Reader reader = new BufferedReader(new FileReader(csvFilePath))) {
            checkDelimiterAndHeader(csvFilePath, "State,Population,AreaInSqKm,DensityPerSqKm");

            Iterator<CSVStateCensus> csvIterator =
                    OpenCSVBuilder.getCSVFileIterator(reader, CSVStateCensus.class);

            int numberOfEntries = 0;
            while (csvIterator.hasNext()) {
                csvIterator.next();
                numberOfEntries++;
            }
            return numberOfEntries;

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    "Unable to load census data",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM
            );
        }
    }

    public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException {
        checkFileType(csvFilePath);

        try (Reader reader = new BufferedReader(new FileReader(csvFilePath))) {
            checkDelimiterAndHeader(csvFilePath, "SrNo,StateName,TIN,StateCode");

            Iterator<CSVStateCode> csvIterator =
                    OpenCSVBuilder.getCSVFileIterator(reader, CSVStateCode.class);

            int numberOfEntries = 0;
            while (csvIterator.hasNext()) {
                csvIterator.next();
                numberOfEntries++;
            }
            return numberOfEntries;

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    "Unable to load state code data",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM
            );
        }
    }

    private void checkFileType(String csvFilePath) throws CensusAnalyserException {
        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Incorrect file type",
                    CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE
            );
        }
    }

    private void checkDelimiterAndHeader(String csvFilePath, String expectedHeader)
            throws CensusAnalyserException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath))) {
            String actualHeader = bufferedReader.readLine();

            if (actualHeader == null) {
                throw new CensusAnalyserException(
                        "File is empty",
                        CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM
                );
            }

            if (actualHeader.contains(";")) {
                throw new CensusAnalyserException(
                        "Incorrect delimiter",
                        CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER
                );
            }

            if (!actualHeader.equals(expectedHeader)) {
                throw new CensusAnalyserException(
                        "Incorrect CSV header",
                        CensusAnalyserException.ExceptionType.INCORRECT_HEADER
                );
            }

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    "File problem",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM
            );
        }
    }
}
