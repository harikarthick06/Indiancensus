package com.bridgelabz.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;

public class OpenCSVBuilder {

    public static <E> Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) {
        CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader)
                .withType(csvClass)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.iterator();
    }
}
