package InClass;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

    public static void main(String[] args) {
        Person person1 = new Person("John", 25);
        Person person2 = new Person("John", 25);

        System.out.println(person1.equals(person2));  // true

        System.out.println(person1.hashCode());  // 与 person2.hashCode() 相等
        System.out.println(person2.hashCode());
    }
}
