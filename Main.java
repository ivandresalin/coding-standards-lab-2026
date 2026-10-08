import java.util.ArrayList;
import java.util.List;

class Student {
    String id;
    String name;
    List<Double> grades;

    public Student(String id, String name) {
        if (id == null || name == null || id.isEmpty() || name.isEmpty()) {
            System.out.println("Error: ID y nombre no pueden estar vacíos.");
        }
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Error: Nota " + grade + " fuera de rango (0-100).");
        }
    }

    public double average() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (double g : grades) {
            total += g;
        }
        return total / grades.size();
    }

    public String getLetterGrade() {
        double avg = average();
        if (avg >= 90) return "A";
        if (avg >= 80) return "B";
        if (avg >= 70) return "C";
        if (avg >= 60) return "D";
        return "F";
    }

    public boolean isPassed() {
        return average() >= 60;
    }

    public boolean isHonorRoll() {
        return average() >= 90;
    }

    public void removeGradeByIndex(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        } else {
            System.out.println("Error: Índice " + index + " fuera de rango.");
        }
    }

    public void removeGradeByValue(double value) {
        if (grades.contains(value)) {
            grades.remove(Double.valueOf(value));
        } else {
            System.out.println("Error: La nota " + value + " no existe.");
        }
    }

    public void reportCard() {
        System.out.println("----- REPORTE DEL ESTUDIANTE -----");
        System.out.println("Estudiante: " + name);
        System.out.println("ID: " + id);
        System.out.println("Cantidad de notas: " + grades.size());
        System.out.println("Promedio: " + average());
        System.out.println("Letra: " + getLetterGrade());
        System.out.println("Estado: " + (isPassed() ? "Aprobado" : "Reprobado"));
        System.out.println("Honor Roll: " + (isHonorRoll() ? "Sí" : "No"));
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("abc", "Andrés Salinas");

        s.addGrade(100);
        s.addGrade(85);
        s.addGrade(150); // Error manejado

        s.removeGradeByIndex(1);
        s.removeGradeByIndex(9); // Error manejado

        s.reportCard();
    }
}