import java.util.Date;


class Controller_ {

    private int Controller_ID;
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
    Controller_() {

    }

    Controller_(String name, String middleName,String surname, float salary, Date jobTime, int aptNo, String ibanNo, Date birthDate, int age, char gender) {
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


    Controller_(int Controller_ID,String name, String middleName,String surname, float salary, Date jobTime, int aptNo, String ibanNo, Date birthDate, int age, char gender) {
        this.Controller_ID = Controller_ID;
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

    public int getController_ID() {
        return Controller_ID;
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
            case "Controller_Id": return Controller_ID;
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
        return "Controller_{" +
                "Controller_ID=" + Controller_ID +
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

