package Pack1;
/*Create an interface called ""Person"" with a method called ""speak"".
 Create two classes called ""Student"" and "Teacher" that implement the 
 Person interface and implement the "speak"method. Create objects of both 
 the Student and Teacher classes and call their respective ""speak"" methods.*/

interface Person1 {//interface
    void speak();//abstract method
}

class Student implements Person1 {//implementing the interface
    public void speak() {//providing body
        System.out.println("I am a student.");
    }
}

class Teacher implements Person1 {//implementing the interface
    public void speak() {//providing body
        System.out.println("I am a teacher.");
    }
}

public class UsePerson {
    public static void main(String[] args) {
        Student s = new Student();//creating obj
        Teacher t = new Teacher();
        s.speak();//calling method
        t.speak();
    }
}

