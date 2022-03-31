package com.example.assignment2;

import javafx.application.Application;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Arrays;

import static javafx.application.Platform.exit;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

            Document newDoc = domBuilder.newDocument();

            // Root element
            Element rootElement = newDoc.createElement("converted_airline_safety");
            newDoc.appendChild(rootElement);
            // Read csv file
            BufferedReader csvReader = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\assignment2\\airline_safety.csv"));
            int fieldCount;
            String[] csvFields = null;
            String[] csvValues = null;


            // Assumes the first line in CSV file is column/field names
            // The column names are used to name the elements in the XML file,
            // avoid the use of Space or other characters not suitable for XML element
            // naming

            String curLine = csvReader.readLine();
            if (curLine != null) {
                csvFields = curLine.split(",", -1);
            }

            String[] newCsvFields  = Arrays.copyOf(csvFields, (csvFields.length + 1));
            newCsvFields[csvFields.length] = "total_number_of_incidents_85_14";

            // At this point the coulmns are known, now read data by lines

            int i = 0;
            while ((curLine = csvReader.readLine()) != null) {
                csvValues = curLine.split(",", -1);
                Element rowElement = newDoc.createElement("record-" + i);
                try {
                    for (fieldCount = 0; fieldCount < csvValues.length; fieldCount++) {
                        String curValue = csvValues[fieldCount];
                        Element curElement = newDoc.createElement(newCsvFields[fieldCount]);
                        curElement.appendChild(newDoc.createTextNode(curValue));
                        rowElement.appendChild(curElement);
                    }
                    int temp = (Integer.parseInt(csvValues[2])) +  (Integer.parseInt(csvValues[5]));
                    String curValue = String.valueOf(temp);
                    Element curElement = newDoc.createElement(newCsvFields[csvValues.length]);
                    curElement.appendChild(newDoc.createTextNode(curValue));
                    rowElement.appendChild(curElement);
                } catch (Exception exp) {
                }
                rootElement.appendChild(rowElement);
                i++;
            }

            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            aTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
            aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            Source src = new DOMSource(newDoc);
            Result result = new StreamResult(new File("src\\main\\java\\com\\example\\assignment2\\converted_airline_safety.xml"));
            aTransformer.transform(src, result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

            Document newDoc = domBuilder.newDocument();

            String[] col = null;
            String line;

            // Read csv file
            BufferedReader csvReader = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\assignment2\\airline_safety.csv"));

            while ((line = csvReader.readLine()) != null) {
                col = line.split(",");
            }


            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            aTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
            aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            Source src = new DOMSource(newDoc);
            Result result = new StreamResult(new File("src\\main\\java\\com\\example\\assignment2\\airline_summary_statistic.xml"));
            aTransformer.transform(src, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(); // ends the program used to generate the files in the desired location because java is weird
    }

    public static void main(String[] args) {
        launch();
    }
}