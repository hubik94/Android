package bambus.lab05;

/**
 * Created by hubik_000 on 2016-12-11.
 */

public class PeopleList {
    private String name;
    private String lastName;
    private boolean isMale;
    private String phoneNumber;
    private String nationality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Imię: " + name +
                " Nazwisko: " + lastName +
                " Nr Telefonu: " + phoneNumber;
    }
}
