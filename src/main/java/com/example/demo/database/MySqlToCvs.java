package com.example.demo.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySqlToCvs {
        private BufferedWriter fileWriter;
        public void export(String table) {
            String jdbcURL = "jdbc:mysql://localhost:3306/accs";
            String username = "root";
            String password = "163135";

            String csvFileName = getFileName(table.concat("_Export"));

            try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
                String sql = "SELECT * FROM ".concat(table);

                Statement statement = connection.createStatement();

                ResultSet result = statement.executeQuery(sql);

                fileWriter = new BufferedWriter(new FileWriter(csvFileName));

                int columnCount = writeHeaderLine(result);

                while (result.next()) {
                    String line = "";

                    for (int i = 2; i <= columnCount; i++) {
                        Object valueObject = result.getObject(i);
                        String valueString = "";

                        if (valueObject != null) valueString = valueObject.toString();

                        if (valueObject instanceof String) {
                            valueString = "\"" + escapeDoubleQuotes(valueString) + "\"";
                        }

                        line = line.concat(valueString);

                        if (i != columnCount) {
                            line = line.concat(",");
                        }
                    }

                    fileWriter.newLine();
                    fileWriter.write(line);
                }

                statement.close();
                fileWriter.close();

            } catch (SQLException e) {
                System.out.println("Datababse error:");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("File IO error:");
                e.printStackTrace();
            }

        }

        private String getFileName(String baseName) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String dateTimeInfo = dateFormat.format(new Date());
            return baseName.concat(String.format("_%s.csv", dateTimeInfo));
        }

        private int writeHeaderLine(ResultSet result) throws SQLException, IOException {
            // write header line containing column names
            ResultSetMetaData metaData = result.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            String headerLine = "";

            // exclude the first column which is the ID field
            for (int i = 2; i <= numberOfColumns; i++) {
                String columnName = metaData.getColumnName(i);
                headerLine = headerLine.concat(columnName).concat(",");
            }

            fileWriter.write(headerLine.substring(0, headerLine.length() - 1));

            return numberOfColumns;
        }

        private String escapeDoubleQuotes(String value) {
            return value.replaceAll("\"", "\"\"");
        }

        public static void main(String[] args) {
            MySqlToCvs exporter = new MySqlToCvs();
            exporter.export("review");
            exporter.export("product");
        }

    }

