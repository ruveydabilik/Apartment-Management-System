import java.util.Date;


class Cleaner {

    private int CleanerID;
    private String name;
    private String middleName;
    private String surname;
    private float salary;
    private Date jobTime;
    private int aptNo;
    private String ibanNo;
    private Date birthDate;
    private int age;
    private char gender;
    Cleaner() {

    }

    Cleaner(String name, String middleName,String surname, float salary, Date jobTime, int aptNo, String ibanNo, Date birthDate, int age, char gender) {
        this.name = name;
        this.middleName = middleName;
        this.surname=surname;
        this.salary = salary;
        this.jobTime=jobTime;
        this.aptNo=aptNo;
        this.ibanNo=ibanNo;
        this.birthDate=birthDate;
        this.age=age;
        this.gender=gender;

    }


    Cleaner(int CleanerID,String name, String middleName,String surname, float salary, Date jobTime, int aptNo, String ibanNo, Date birthDate, int age, char gender) {
        this.CleanerID = CleanerID;
        this.name = name;
        this.middleName = middleName;
        this.surname=surname;
        this.salary = salary;
        this.jobTime=jobTime;
        this.aptNo=aptNo;
        this.ibanNo=ibanNo;
        this.birthDate=birthDate;
        this.age=age;
        this.gender=gender;
    }

    public int getCleanerID() {
        return CleanerID;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getJobTime() {
        return jobTime;
    }

    public void setJobTime(Date jobTime) {
        this.jobTime = jobTime;
    }

    public int getAptNo() {
        return aptNo;
    }

    public void setAptNo(int aptNo) {
        this.aptNo = aptNo;
    }

    public String getIbanNo() {
        return ibanNo;
    }

    public void setIbanNo(String ibanNo) {
        this.ibanNo = ibanNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "CleanerId": return CleanerID;
            case "Name": return name;
            case "MiddleName": return middleName;
            case "Surname": return surname;
            case "Salary": return salary;
            case "JobTime" : return jobTime;
            case "AptNo" : return aptNo;
            case "IbanNo" : return ibanNo;
            case "BirthDate" : return birthDate;
            case "Age" : return age;
            case "Gender" : return gender;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return "Cleaner{" +
                "CleanerID=" + CleanerID +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", jobTime=" + jobTime +
                ", aptNo=" + aptNo +
                ", ibanNo='" + ibanNo + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

