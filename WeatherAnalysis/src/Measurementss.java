﻿import java.util.Vector;


public class Measurementss {
    private Vector<Integer> YEAR;
    private Vector<Integer> MONTH;

    private Vector<Float> WIND;
    private Vector<Float> TEMP;
    private int iD;

    public Measurementss() {
    }

    public void setMeasurements(Vector<Integer> year, Vector<Integer> month, Vector<Float> wind, Vector<Float> temp) {
        this.YEAR = year;
        this.MONTH = month;
        this.WIND = wind;
        this.TEMP = temp;
    }



    public void getMinTemp() {
        float min = TEMP.get(0);

        for(int i = 0; i < TEMP.size(); ++i) {
            if(TEMP.get(i) < min) {
                min = TEMP.get(i);
                this.iD = i;
            }
        }
        System.out.println("Mintemperatur : " + this.MONTH.get(this.iD) + "-" + this.YEAR.get(this.iD)+ " "+ min+"°C");
       
    }

    public void getMaxTemp() {
        float max = TEMP.get(0);

        for(int i = 0; i < TEMP.size(); ++i) {
            if(TEMP.get(i) > max) {
                max = TEMP.get(i);
                this.iD = i;
            }
        }

        System.out.println("Maxtemperatur : " + this.MONTH.get(this.iD) + "-" + this.YEAR.get(this.iD)+ " " + max+ "°C" );
        
    }

    public void getMedelTemp() {
        float mid = 0;

        for(int i = 0; i < TEMP.size(); ++i) {
            mid += TEMP.get(i);
        }

        mid /= TEMP.size();
        System.out.println("Medeltemperatur : " + mid + "°C " );
        
    }

    public void getMaxWind() {
        float maxWind = WIND.get(0);

        for(int i = 0; i < WIND.size(); ++i) {
            if(WIND.get(i) > maxWind) {
                maxWind = WIND.get(i);
                this.iD = i;
            }
        }

        System.out.println("Den högst uppmätta vindstyrkan var : " + this.MONTH.get(this.iD) + "." + this.YEAR.get(this.iD)+ " " + maxWind + " " +"Meter per sekund");

    }



}
