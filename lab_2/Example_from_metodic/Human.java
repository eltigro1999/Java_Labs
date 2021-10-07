// нельзя создать переменную абстрактного класса
public abstract class Human {
	private String name;
	private int age;
	private String sex;

	public String GetName() {
		return name;
	}

	public int GetAge() {
		return age;
	}

	public String GetSex() {
		return sex;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public void SetAge(int age) {
		this.age = age;		
	}

	public void SetSex(String sex) {
		this.sex = sex;
	}

	protected Human(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	// переопределим метод toString
	public String toString() {
		return name + "\t" + age + "\t" + sex;
	}
}
