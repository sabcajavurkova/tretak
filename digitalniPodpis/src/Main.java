import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException {

        String privateKeyRetezec = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAlZL9+h/WrE2cdIgSN1/2s7t0VsMxUrwbIN5lw2azngud+n/5cLuRUmYnTZ6zqVia0BvsYd405O/GLhnGgYqwdQIDAQABAkA7E7TGvx6OLZVXHYt8XaXWNXrs7emkUPGyGMU+2WimSjuFwRXJHvtZRPh+wwrs4UqjKT104WpL4mSp0vrUzeUdAiEAuMrIZx99lUYFox3yaReAUme5OoaV06WGsmLqAzGMk8cCIQDPNg91Lf8wX5FTSIfo0ZfONCX29MKoJTmew68FCHEh4wIgCK8/C9mnBUTtLuVRZy77kOPfCKkakX/N/MQ5Sz0g5jECIQCRoHHOrev6KEAvYvs5kgv5fMbtv+kKWVcckHRxuhQgdwIgc0uxDi7qNc67SL86Ddtgsc340r9IJZaDZdnzIQq55tM=";
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJWS/fof1qxNnHSIEjdf9rO7dFbDMVK8GyDeZcNms54Lnfp/+XC7kVJmJ02es6lYmtAb7GHeNOTvxi4ZxoGKsHUCAwEAAQ==";

        byte[] privatniVBytes = Base64.getDecoder().decode(privateKeyRetezec);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(privatniVBytes));


        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        Signature signGenerator = Signature.getInstance("SHA1withRSA");
        signGenerator.initSign(privateKey);
        signGenerator.update(msg.getBytes());

        System.out.println(msg);
        System.out.println(Base64.getEncoder().encodeToString(signGenerator.sign()));
    }
}