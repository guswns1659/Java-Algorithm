package leetcodeEasy;

public class VaildAnagram {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
		String anotherT = t;
		for (char each : chars) {
			int index = anotherT.indexOf(each);
			if (index == -1) return false;
			anotherT = anotherT.replaceFirst(String.valueOf(anotherT.charAt(index)), "");
		}
		return anotherT.equals("");
	}
}
