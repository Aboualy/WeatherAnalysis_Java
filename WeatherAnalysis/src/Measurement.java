public class Measurement {
    Integer year;
    Integer month;
    Float temp;
    Float wind;
    Float humid;
    Integer iD;

    public Measurement(Integer y, Integer m, Float t, Float w, Float h){
        this.year = y;
        this.month = m;
        this.temp = t;
        this.wind = w;
        this.humid = h;
    }
}