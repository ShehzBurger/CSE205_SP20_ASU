// Assignment #: 11
// Name: Shehzad Anwar
// StudentID: 1216575295
// Lecture: TTh 1:30PM
// Description: This program manages patient queues, assigns patients to doctors,
//              release them to check out, etc.

import java.util.LinkedList;

public class PatientManagement
{
    private LinkedList<Patient> highPriorityQueue; //Requires immediate life-saving intervention
    private LinkedList<Patient> intermediateQueue; //Requires significant intervention within two to four hours.
    private LinkedList<Patient> delayedCareQueue; //Needs medical treatment, but this can safely be delayed.

    private LinkedList<Patient> checkOutQueue; //queue for patients that need to check out

    private Doctor[] doctorList; //an array of doctors

    //Constructor to initialize member variables
    public PatientManagement(int numOfDoctors)
    {
        highPriorityQueue = new LinkedList<Patient>();
        intermediateQueue = new LinkedList<Patient>();
        delayedCareQueue = new LinkedList<Patient>();
        checkOutQueue = new LinkedList<Patient>();

        //creating doctor objects
        doctorList = new Doctor[numOfDoctors];
        for (int i=0; i<doctorList.length; i++)
        {
            doctorList[i] = new Doctor(i);
        }
    }

    //The printQueue prints out the content
    //of the queues and the array of doctors
    public void printPatientQueues()
    {
        System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
        System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
        System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() + "\n\n");
        for (int i = 0; i < doctorList.length; i++)
        {
            System.out.println(doctorList[i].toString());
        }
        System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
    }

    //More Methods need to be added here
    public boolean addPatient(int patientID, String conditionLevel){ //Adds patients to queues
        Patient patient = new Patient(patientID, conditionLevel);
        if(conditionLevel.equals("High Priority")){
            highPriorityQueue.add(patient);
            return true;
        }
        else if(conditionLevel.equals("Intermediate")){
            intermediateQueue.add(patient);
            return true;
        }
        else if(conditionLevel.equals("Delayed Care")){
            delayedCareQueue.add(patient);
            return true;
        }
        else{
            return false;
        }
    }

    Patient assignPatientToDoctor() //Assigns patients to doctors
    {
        Patient newPatient = null;

        if(highPriorityQueue.size() > 0)
        {
            for(int i = 0; i < doctorList.length; i++)
            {
                if(!doctorList[i].hasPatient())
                {
                    newPatient = highPriorityQueue.removeFirst();
                    doctorList[i].assignPatient(newPatient);
                    return newPatient;
                }

            }
            return null;
        }
        else if(intermediateQueue.size() > 0)
        {
            for(int i = 0; i < doctorList.length; i++)
            {
                if(!doctorList[i].hasPatient())
                {
                    newPatient = intermediateQueue.removeFirst();
                    doctorList[i].assignPatient(newPatient);
                    return newPatient;
                }
            }
            return null;
        }
        if(delayedCareQueue.size() > 0)
        {
            for(int i = 0; i < doctorList.length; i++)
            {
                if(!doctorList[i].hasPatient())
                {
                    newPatient = delayedCareQueue.removeFirst();
                    doctorList[i].assignPatient(newPatient);
                    return newPatient;
                }
            }
            return null;
        }
        else
            return null;
    }

    public Patient releasePatientFromDoctorToCheckOutQueue(int doctorID){ //Releases patients and adds to checkout queue
        Patient patient = null;
        if (doctorList[doctorID].hasPatient())
        {
            patient = doctorList[doctorID].releasePatient();
            checkOutQueue.add(patient);
            return patient;
        }
        else{
            return null;
        }
    }

    public Patient checkOutPatient(){ //Checks patients out from the queue.
        if(checkOutQueue.size() > 0){
            return checkOutQueue.removeFirst();
        }
        else{
            return null;
        }
    }


}