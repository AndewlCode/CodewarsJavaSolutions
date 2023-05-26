package Classes.Patient;

class Patient {
    // переменные
    private String firstName;
    private String lastName;
    private String iin;
    private int age;
    private int weight;
    private int height;
    private boolean isInfected;

    // конструктор
    public Patient(String firstName, String lastName, String iin, int age, int weight, int height, boolean isInfected)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iin = iin;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.isInfected = isInfected;
    }
    public Patient(String firstName, String lastName, String iin, int age, int weight, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iin = iin;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // методы
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIIN() {
        return this.iin;
    }

    public void setIIN(String iin) {
        this.iin = iin;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getIsInfected() {
        return this.isInfected;
    }

    public void setIsInfected(boolean isInfected) {
        this.isInfected = isInfected;
    }

    double getBMI() {
        return (double) this.weight / (this.height * this.height) * 10000;
    }

    @Override
    public String toString() {
        if (isInfected) {
            return "Пациент(" + iin + ", " + firstName + " " + lastName + ", " + age + ", инфицирован)";
        } else
            return "Пациент(" + iin + ", " + firstName + " " + lastName + ", " + age + ", здоров)";
    }
}