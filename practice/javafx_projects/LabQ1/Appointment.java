public class Appointment{
    private String patientID;
    private String patientName;
    private String doctorName;
    private String dateTime;

    public Appointment(String patientID, String patientName, String doctorName, String dateTime){
        this.patientID=patientID;
        this.patientName=patientName;
        this.doctorName=doctorName;
        this.dateTime=dateTime;
    }
    //Write getters for TableView to use
public String getPatientId() { return patientID; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDateTime() { return dateTime; }
}