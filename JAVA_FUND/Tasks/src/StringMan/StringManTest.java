public class StringManTest {
    public static void main(String[] args) {
    	StringManTest manipulator1 = new StringManTest();
        String str = manipulator1.trimAndConcat("    Hello     ", "     World    ");
        System.out.println(str); // HelloWorld

        StringManTest manipulator2 = new StringManTest();
        char letter = 'o';
        Integer a = manipulator2.getIndexOrNull("Coding", letter);
        Integer b = manipulator2.getIndexOrNull("Hello World", letter);
        Integer c = manipulator2.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        StringMan manipulator3 = new StringMan();
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer d = manipulator3.getIndexOrNull(word, subString);
        Integer e = manipulator3.getIndexOrNull(word, notSubString);
        System.out.println(d); // 2
        System.out.println(e); // null

        StringMan manipulator4 = new StringMan();
        String word2 = manipulator4.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word2); // eworld
    }
}
