package week1.assignment1.q18;

public class Main {
	public static void main(String[] args) {
		ConcreteExample example = new ConcreteExample();
		System.out.println(example.hasUpper("aHbe"));
		System.out.println(example.hasUpper("abcd"));
		System.out.println(example.toUpper("aBcd"));
		System.out.println(example.addTen("13"));
	}
}
