import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<Etudiant> students = new ArrayList<>();
        students.add(new Etudiant(1, "Alice", 20));
        students.add(new Etudiant(2, "Bob", 22));
        students.add(new Etudiant(3, "Charlie", 19));

        StudentManagement management = new StudentManagement();

        // Afficher tous les étudiants
        System.out.println("Tous les étudiants :");
        management.displayStudents(students, System.out::println);

        // Afficher les étudiants avec un filtre (âge > 20)
        System.out.println("\nÉtudiants avec âge > 20 :");
        management.displayStudentsByFilter(students, e -> e.getAge() > 20, System.out::println);

        // Obtenir les noms des étudiants
        String names = management.returnStudentsNames(students, Etudiant::getNom);
        System.out.println("\nNoms des étudiants : " + names);

        // Créer un nouvel étudiant
        Supplier<Etudiant> supplier = () -> new Etudiant(4, "Diane", 21);
        Etudiant newStudent = management.createStudent(supplier);
        students.add(newStudent);
        System.out.println("\nNouvel étudiant ajouté : " + newStudent);

        // Trier les étudiants par ID
        System.out.println("\nÉtudiants triés par ID :");
        management.sortStudentsById(students, Comparator.comparingInt(Etudiant::getId))
                .forEach(System.out::println);

        // Convertir la liste en stream et afficher
        System.out.println("\nÉtudiants (stream) :");
        management.convertToStream(students).forEach(System.out::println);
    }
}
