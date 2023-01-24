package src;

import java.util.Date;

public class Worker {
    private int workerID;
    private String name;
    private String middleName;
    private String surname;
    private Float salary;
    private int aptNo;
    private Date jobTime;
    private String ibanNo;
    private Date birthdate;
    private String gender;

    Worker(){}

    public Worker(String name, String middleName, String surname, Float salary, int aptNo, Date jobTime, String ibanNo, Date birthdate, String gender) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.salary = salary;
        this.aptNo = aptNo;
        this.jobTime = jobTime;
        this.ibanNo = ibanNo;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Worker(int workerID, String name, String middleName, String surname, Float salary, int aptNo, Date jobTime, String ibanNo, Date birthdate, String gender) {
        this.workerID = workerID;
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.salary = salary;
        this.aptNo = aptNo;
        this.jobTime = jobTime;
        this.ibanNo = ibanNo;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Worker(int workerID, String name, String middleName, String surname, Float salary, int aptNo, Date jobTime, String ibanNo, Date birthdate, String gender, int age) {
        this.workerID = workerID;
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.salary = salary;
        this.aptNo = aptNo;
        this.jobTime = jobTime;
        this.ibanNo = ibanNo;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Worker(String name, String middleName, String surname, Float salary, int aptNo, Date jobTime, String ibanNo, Date birthdate, String gender, int age) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.salary = salary;
        this.aptNo = aptNo;
        this.jobTime = jobTime;
        this.ibanNo = ibanNo;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public int getAptNo() {
        return aptNo;
    }

    public void setAptNo(int aptNo) {
        this.aptNo = aptNo;
    }

    public Date getJobTime() {
        return jobTime;
    }

    public void setJobTime(Date jobTime) {
        this.jobTime = jobTime;
    }

    public String getIbanNo() {
        return ibanNo;
    }

    public void setIbanNo(String ibanNo) {
        this.ibanNo = ibanNo;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "WorkerID":
                return workerID;
            case "Name":
                return name;
            case "MiddleName":
                return middleName;
            case "Surname":
                return surname;
            case "Salary":
                return salary;
            case "AptNo":
                return aptNo;
            case "JobTime":
                return jobTime;
            case "IbanNo":
                return ibanNo;
            case "BirthDate":
                return birthdate;
            case "Gender":
                return gender;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerID=" + workerID +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", aptNo=" + aptNo +
                ", jobTime=" + jobTime +
                ", ibanNo='" + ibanNo + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                '}';
    }
}
