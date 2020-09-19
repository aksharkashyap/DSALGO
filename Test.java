import java.util.*;

class Student{
	int a;
	String b;
	Student(int a, String b){
		this.a=a;
		this.b=b;
	}
	@Override
	public String toString(){
		return a +" "+b;
	}
}

class Test {
	public static void main(String[] args){
		List<Student> v = new ArrayList<>();
		Student s = new Student(1,"hi");
		System.out.print(s);
	}
	static int val(char ch){return ch-48;}
}

