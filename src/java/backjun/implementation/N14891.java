package backjun.implementation;

public class N14891 {

    public static void main(String[] args) {
        String a = "10101111"; // 175
        String a2 = "01011110"; // a << 1, 94
        int b = Integer.parseInt(a, 2);
        System.out.println(b << 1);
    }
}
