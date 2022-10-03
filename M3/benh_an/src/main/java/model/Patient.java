package model;

public class Patient {
    private int id;
    private String name;
    private String dateIn;
    private String dateOut;
    private String reason;
    private int medicalRecord;
    private String nameMedicalRecord;

    public Patient() {
    }

    public Patient(int id, String name, String dateIn, String dateOut, String reason, int medicalRecord, String nameMedicalRecord) {
        this.id = id;
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
        this.medicalRecord = medicalRecord;
        this.nameMedicalRecord = nameMedicalRecord;
    }

    public Patient(String name, String dateIn, String dateOut, String reason, int medicalRecord, String nameMedicalRecord) {
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
        this.medicalRecord = medicalRecord;
        this.nameMedicalRecord = nameMedicalRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(int medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getNameMedicalRecord() {
        return nameMedicalRecord;
    }

    public void setNameMedicalRecord(String nameMedicalRecord) {
        this.nameMedicalRecord = nameMedicalRecord;
    }

}
