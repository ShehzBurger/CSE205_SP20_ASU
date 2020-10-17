import java.util.Comparator;

public class CurrentPresidentComparator implements Comparator<Club> {

    public CurrentPresidentComparator(){

    }

    public int compare(Club first, Club second) {   //Compares the President names based on the arguments given
        String lastName1 = first.getCurrentPresident().getLastName();
        String lastName2 = second.getCurrentPresident().getLastName();
        String firstName1 = first.getCurrentPresident().getFirstName();
        String firstName2 = second.getCurrentPresident().getFirstName();
        if (lastName1.compareTo(lastName2) == 0)
            return firstName1.compareTo(firstName2);
        return lastName1.compareTo(lastName2);
    }
}
