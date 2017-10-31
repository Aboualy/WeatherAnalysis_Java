import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Temperatures {
    public static void main(String[] args) {
        File fXmlFile = new File("C:\\Users\\Desktop\\WeatherAnalysis\\weather.xml");
        Measurements allMeasurements = new Measurements();
        Measurementss F = new Measurementss();
        Vector år = new Vector();
        Vector månad = new Vector();

        Vector Vindstyrka  = new Vector();
        Vector Temperatur  = new Vector();


        try {
            DocumentBuilderFactory e = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = e.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList measurements = doc.getElementsByTagName("measurement");

            for(int i = 0; i < measurements.getLength(); ++i) {
                Element elemnet = (Element)measurements.item(i);
                String time = elemnet.getElementsByTagName("time").item(0).getTextContent();
                Float wind = Float.valueOf(elemnet.getElementsByTagName("wind").item(0).getTextContent());
                Float temp = Float.valueOf(elemnet.getElementsByTagName("temp").item(0).getTextContent());
                Float humid = Float.valueOf(elemnet.getElementsByTagName("humid").item(0).getTextContent());
                String[] s1 = time.split(" ");
                String[] s2 = s1[1].split("-");
                Integer year = Integer.valueOf(s2[0]);
                Integer month = Integer.valueOf(s2[1]);
                år.add(year);
                månad.add(month);
                Vindstyrka.add(wind);
                Temperatur.add(temp);
                F.setMeasurements(år, månad, Vindstyrka, Temperatur);

                Measurement measurement = new Measurement(year, month, temp, wind, humid);
                allMeasurements.add(measurement);
            }
            


            System.out.println("Åratal:" + år);
            System.out.println("Månad:" + månad);
            System.out.println("Vindstyrka:" + Vindstyrka);
            System.out.println("Temperatur" + Temperatur);
            F.getMinTemp();
            F.getMaxTemp();
            F.getMedelTemp();
            F.getMaxWind();
            Float midTemp2009 = allMeasurements.getMidTempYearly(2009);
            Float midTemp2010 = allMeasurements.getMidTempYearly(2010);
            Float midTemp2011 = allMeasurements.getMidTempYearly(2011);
            Float midTemp2012 = allMeasurements.getMidTempYearly(2012);
            Float midTemp2013 = allMeasurements.getMidTempYearly(2013);
            Float midTemp2014 = allMeasurements.getMidTempYearly(2014);
            Float midTemp2015 = allMeasurements.getMidTempYearly(2015);
            System.out.println("Mid Temp for 2009 was: " + allMeasurements.getMidTempYearly(2009));
            System.out.println("Mid Temp for 2010 was: " + allMeasurements.getMidTempYearly(2010));
            System.out.println("Mid Temp for 2011 was: " + allMeasurements.getMidTempYearly(2011));
            System.out.println("Mid Temp for 2012 was: " + allMeasurements.getMidTempYearly(2012));
            System.out.println("Mid Temp for 2013 was: " + allMeasurements.getMidTempYearly(2013));
            System.out.println("Mid Temp for 2014 was: " + allMeasurements.getMidTempYearly(2014));
            System.out.println("Mid Temp for 2015 was: " + allMeasurements.getMidTempYearly(2015));
            F.getSannolikhet();





        } catch (Exception e) {
            System.out.println("FELMEDDELANDE: " + e.getMessage());
        }

    }
}