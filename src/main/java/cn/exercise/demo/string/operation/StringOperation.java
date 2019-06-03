package cn.exercise.demo.string.operation;

import ch.qos.logback.core.joran.conditional.IfAction;

public class StringOperation {
	public static void main(String[] args) {
		String str1 = new String("123");
		String str2 = "123";
		if (str1.equals(str2)) {
			System.out.println("不相等");
		}
		System.out.println("相等");
	}

}
