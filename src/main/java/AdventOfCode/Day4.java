package AdventOfCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class Day4 {
    private final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    private int secretKeyNumberPortion;

    public Day4() throws NoSuchAlgorithmException {
    }

    public int findSecretKeyNumberPortion(String secretKey) throws IOException {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            byte[] hash = messageDigest.digest((secretKey + i).getBytes(StandardCharsets.UTF_8));

            String hex = Hex.encodeHexString(hash);

            int count = 0;

            for(int j = 0; j < hex.length(); j++) {
                if(hex.charAt(j) == '0') {
                    count++;
                    if(count == 5) {
                        secretKeyNumberPortion = i;
                        break;
                    }
                } else {
                    break;
                }
            }

            if(count == 5) {
                break;
            }
        }

        return secretKeyNumberPortion ;
    }
}