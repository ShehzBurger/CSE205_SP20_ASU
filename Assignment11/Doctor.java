// Assignment #: 11
// Name: Shehzad Anwar
// StudentID: 1216575295
// Lecture: TTh 1:30PM
// Description: Checks to see if there are patients, assigns them and releases them.


public class Doctor
{
    private int doctorID;
    private Patient currentPatient;

    //Constructor to initialize member variables
    //Initially no patient is assigned
    public Doctor(int id)
    {
        this.doctorID = id;
        currentPatient = null;
    }

    //toString method returns a string containing
    //the information of a doctor
    public String toString()
    {
        String result = "Doctor id " + doctorID;

        if (currentPatient == null)
            result += " is not seeing any patient";
        else
            result += " is seeing a patient with id " + currentPatient.getPatientID();

        return result;
    }

    //More Methods need to be added here
    public boolean hasPatient(){ //checks to see if there are patients
        if(currentPatient == null){
            return false;
        } else {
            return true;
        }
    }

    public boolean assignPatient(Patient patient1){ //assigns patients
        if(hasPatient() == false){
            currentPatient = patient1;
            return true;
        }
        else{
            return false;
        }
    }

    public Patient releasePatient(){ //releases patients
        Patient patient = currentPatient;
        currentPatient = null;
        return patient;
    }


}
