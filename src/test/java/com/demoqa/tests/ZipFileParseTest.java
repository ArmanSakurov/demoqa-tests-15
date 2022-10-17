package com.demoqa.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class ZipFileParseTest {

    ClassLoader cl = FileParseTest.class.getClassLoader();
    String zipName = "zip_files.zip";
    String pathToZip = "src/test/resources/" + zipName;

    @Test
    void parseZipPdfTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File(pathToZip))) {
            ZipInputStream is = new ZipInputStream(Objects.requireNonNull(cl.getResourceAsStream(zipName)));
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        PDF pdf = new PDF(inputStream);
                        System.out.println("File name: " + entry.getName());
                        assertThat(entry.getName()).isEqualTo("pdf-file-for-zip.pdf");
                        assertThat(pdf.author).contains("Vladislav Burmistrov");
                        assertThat(pdf.title).contains("SQL");
                        assertThat(pdf.text).contains("SQL");
                    }
                }
            }
        }
    }


    @Test
    void parseZipXlsTest() throws Exception {
        ZipFile zipFile = new ZipFile(new File(pathToZip));
        try {
            ZipInputStream is = new ZipInputStream(Objects.requireNonNull(cl.getResourceAsStream(zipName)));
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().contains(".xls")) {
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        XLS xls = new XLS(inputStream);
                        System.out.println("File name: " + entry.getName());
                        assertThat(entry.getName()).isEqualTo("excel-file-for-zip.xlsx");
                        assertThat(xls.excel.getSheetAt(0)
                                .getRow(3)
                                .getCell(1)
                                .getStringCellValue())
                                .isEqualTo("Philip");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void parseZipCsvTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File(pathToZip))) {
            ZipInputStream is = new ZipInputStream(Objects.requireNonNull(cl.getResourceAsStream(zipName)));
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().contains(".csv")) {
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
                        List<String[]> content = reader.readAll();
                        System.out.println("File name: " + entry.getName());

                        String[] row = content.get(0);
                        assertThat(row[0]).isEqualTo("user_id");
                        assertThat(row[1]).isEqualTo("level");
                        assertThat(row[2]).isEqualTo("education_form");
                        assertThat(row[3]).isEqualTo("subject_id");

                        row = content.get(1);
                        assertThat(row[0]).isEqualTo("42568");
                        assertThat(row[1]).isEqualTo("Pre-Intermediate");
                        assertThat(row[2]).isEqualTo("group");
                        assertThat(row[3]).isEqualTo("1");
                    }
                }
            }
        }
    }
}
