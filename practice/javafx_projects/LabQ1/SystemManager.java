import java.util.*;

// T is a Generic Type. This class can addm get and remove Appointments, Doctors, or Patients for example
public class SystemManager<T> {
    private List<T> records = new ArrayList<>();

    public void addRecord(T record) {
        records.add(record);
    }

    public List<T> getAllRecords() {
        return records;
    }

    public void removeRecord(T record) {
        records.remove(record);
    }
}