// класс студент расширяет класс Human
public class Student extends Human {
private String patronymic;
	
public String GetPatronymic() {
	return patronymic;
}
	
public void SettPatronymic(String patronymic) {
	this.patronymic = patronymic;
}
	
public Student(String name, int age, String sex, String Patronymic) {
	super(name, age, sex); // вызываем конструктор родительского класса
	this.patronymic = patronymic;
}

public String toString() {
	// вызываем реализацию родительского класса	
	return super.toString() + "\t" + patronymic; 
}
}
