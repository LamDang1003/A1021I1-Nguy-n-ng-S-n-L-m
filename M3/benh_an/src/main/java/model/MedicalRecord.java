package model;

public class MedicalRecord {
    private int idMedicalRecord;
    private String nameMedicalRecord;
    private String note;

    public MedicalRecord() {
    }

    public MedicalRecord(int idMedicalRecord, String nameMedicalRecord, String note) {
        this.idMedicalRecord = idMedicalRecord;
        this.nameMedicalRecord = nameMedicalRecord;
        this.note = note;
    }

    public MedicalRecord(String nameMedicalRecord, String note) {
        this.nameMedicalRecord = nameMedicalRecord;
        this.note = note;
    }

    public int getIdMedicalRecord() {
        return idMedicalRecord;
    }

    public void setIdMedicalRecord(int idMedicalRecord) {
        this.idMedicalRecord = idMedicalRecord;
    }

    public String getNameMedicalRecord() {
        return nameMedicalRecord;
    }

    public void setNameMedicalRecord(String nameMedicalRecord) {
        this.nameMedicalRecord = nameMedicalRecord;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
