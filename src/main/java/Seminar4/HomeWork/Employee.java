package Seminar4.HomeWork;

public class Employee {
    public String Name;
    public String PersonnelNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        PersonnelNumber = personnelNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String PhoneNumber;
    public int Experience;
    public Employee(String name, String personnelNumber, String phoneNumber, int experience) {
        Name = name;
        PersonnelNumber = personnelNumber;
        PhoneNumber = phoneNumber;
        Experience = experience;
    }


}
