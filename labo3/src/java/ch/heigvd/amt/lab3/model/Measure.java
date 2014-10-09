package ch.heigvd.amt.lab3.model;

/**
 *
 * @author Righitto Simone
 */
public class Measure {
    
    private String sensorID;
    private long timestamp;
    private double value;

    public Measure(String sensorID, long timestamp, double value) {
        this.sensorID = sensorID;
        this.timestamp = timestamp;
        this.value = value;
    }

    public String getSensorID() {
        return sensorID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    public Measure getMeasures(){
        //we have to get sometinghs...
        
        return null;
    }
}
