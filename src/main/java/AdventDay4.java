import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdventDay4 {
    private final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    private int secretKeyNumberPortion;
    ByteArrayOutputStream hashCreator = new ByteArrayOutputStream();
    private byte[] hash;

    public AdventDay4() throws NoSuchAlgorithmException {
    }

    public int findSecretKeyNumberPortion(String secretKey) throws IOException {
        for(Integer i = 0; i < Integer.MAX_VALUE; i++) {
            hashCreator.reset();

            StringBuilder sb = new StringBuilder(secretKey);
            sb.append(i);

            hashCreator.write(sb.toString().getBytes());

            hash = messageDigest.digest(hashCreator.toByteArray());

            int count = 0;

            for(byte character : hash) {
                if(character == 0) {
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

        return secretKeyNumberPortion;
    }
}
