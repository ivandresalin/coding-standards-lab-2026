class Student:
    def __init__(self, student_id, name):
        if not student_id or not name:
            print("Error: ID y nombre no pueden estar vacíos.")
        self.id = student_id
        self.name = name
        self.grades = []

    def add_grade(self, grade):
        # Valida que sea número y esté entre 0 y 100
        if isinstance(grade, (int, float)) and 0 <= grade <= 100:
            self.grades.append(grade)
        else:
            print(f"Error: Nota inválida '{grade}'. Debe ser un número entre 0 y 100.")

    def calc_average(self):
        if not self.grades:
            return 0.0
        return sum(self.grades) / len(self.grades)

    def get_letter_grade(self):
        avg = self.calc_average()
        if avg >= 90:
            return "A"
        if avg >= 80:
            return "B"
        if avg >= 70:
            return "C"
        if avg >= 60:
            return "D"
        return "F"

    def is_passed(self):
        return self.calc_average() >= 60

    def is_honor_roll(self):
        return self.calc_average() >= 90

    def delete_grade_by_index(self, index):
        if 0 <= index < len(self.grades):
            del self.grades[index]
        else:
            print(f"Error: Índice {index} fuera de rango.")

    def delete_grade_by_value(self, value):
        if value in self.grades:
            self.grades.remove(value)
        else:
            print(f"Error: La nota {value} no existe.")

    def report(self):
        avg = self.calc_average()
        print("----- REPORTE DEL ESTUDIANTE -----")
        print("ID:", self.id)
        print("Nombre:", self.name)
        print("Cantidad de Notas:", len(self.grades))
        print(f"Promedio: {avg:.2f}")
        print("Nota Final (Letra):", self.get_letter_grade())
        print("Estado:", "Aprobado" if self.is_passed() else "Reprobado")
        print("Honor Roll:", "Sí" if self.is_honor_roll() else "No")


def main():
    # Creación del estudiante
    a = Student("ST01", "Andrés Salinas")

    # Agregar notas válidas e inválidas
    a.add_grade(100)
    a.add_grade(85)
    a.add_grade("Cincuenta")  # Error manejado
    a.add_grade(150)          # Error manejado

    # Eliminar notas
    a.delete_grade_by_index(1)
    a.delete_grade_by_index(10)  # Error manejado

    # Reporte
    a.report()


if __name__ == "__main__":
    main()