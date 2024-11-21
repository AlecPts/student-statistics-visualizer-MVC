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

