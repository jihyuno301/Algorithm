package Test;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String str = "123.123.44.21";
		String[] tmp = str.split("\\.");
		System.out.println(Arrays.toString(tmp));
	}
}
