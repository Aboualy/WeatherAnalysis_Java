import java.util.*;

public class Measurements {
    private Map<Integer, List<Measurement>> measurements = new HashMap<>();

    public void add(Measurement m){
        List<Measurement> yearlyMeasurements = measurements.get(m.year);
        if(yearlyMeasurements == null){
            yearlyMeasurements  = new ArrayList<>();
        }
        yearlyMeasurements.add(m);
        measurements.put(m.year, yearlyMeasurements);
    }

    public Float getMidTempYearly(int year) {
        List<Measurement> yearMeasurements = measurements.get(year);
        Float sum = 0f;

        for(Measurement aMeasurement: yearMeasurements){
            sum += aMeasurement.temp;
        }
        return sum / yearMeasurements.size();
    }
}