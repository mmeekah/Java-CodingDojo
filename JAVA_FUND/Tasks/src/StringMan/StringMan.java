package StringMan;

public class StringMan {
	public String trimAndConcat(String str1, String str2){
        return str1.trim().concat(str2.trim());
    }

    public Integer getIndexOrNull(String str, char c) {
        return str.indexOf(c) != -1 ? str.indexOf(c) : null;
    }

    public Integer getIndexOrNull(String str1, String str2) {
        return str1.indexOf(str2) != -1 ? str1.indexOf(str2) : null;
    }

    public String concatSubstring(String str1, int start, int end, String str2) {
        String substring = str1.substring(start, end);
        return substring.concat(str2);
    }

}
