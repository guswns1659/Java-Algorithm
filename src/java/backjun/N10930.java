package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class N10930 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(test(br.readLine()));
    }

    public static String test(String word) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(word.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();

        for (byte eachHash : hash) {
            String hex = Integer.toHexString(0xff & eachHash);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex.toLowerCase());
        }

        return hexString.toString();
    }
}
