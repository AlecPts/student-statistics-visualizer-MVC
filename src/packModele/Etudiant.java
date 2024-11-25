package packModele;

public class Etudiant {
    String numero;
    String lastName;
    String firstName;
    String departement;
    String bac;

    public Etudiant(String num, String lastName, String firstName, String dpt, String bac) {
        this.numero = num;
        this.lastName = lastName;
        this.firstName = firstName;
        this.departement = dpt;
        this.bac = bac;
    }

    // Getter
    public String getNumero() {
        return numero;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getDepartement() {
        return departement;
    }
    public String getBac() {
        return bac;
    }

    // Setter
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setDepartement(String departement) {
        this.departement = departement;
    }
    public void setBac(String bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numero='" + numero + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", departement='" + departement + '\'' +
                ", bac='" + bac + '\'' +
                '}';
    }
}

