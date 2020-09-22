import java.util.*;
import java.io.*;

// do question on comparator and comparablee
class Test {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("hello.txt");
		int ch;
		while((ch=fr.read()) != -1) {
			System.out.print((char)ch);
		}
	}
}
