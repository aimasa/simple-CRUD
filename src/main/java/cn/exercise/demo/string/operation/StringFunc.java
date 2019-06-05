package cn.exercise.demo.string.operation;

public class StringFunc {
	/**
	 * 判断两个字符串是否相等
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return 相等返回true，不等返回false
	 */
	public Boolean isEqual(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}

	/**
	 * 把字符串1转换为Integer类型
	 * @return
	 */
	public Integer typeConversion() {

		return Integer.valueOf("1");

	}
	
	
}
