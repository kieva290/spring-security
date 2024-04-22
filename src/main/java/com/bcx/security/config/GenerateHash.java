package com.bcx.security.config;

import com.bcx.security.SecurityApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.keygen.Base64StringKeyGenerator;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class GenerateHash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SpringApplication.run(SecurityApplication.class, args);
        String codeVerifier=createCodeVerifier();
        System.out.println("code verifier:"+codeVerifier);
        System.out.println("code_challenge:"+createCodeChallenge(codeVerifier));
    }

    private static String createCodeChallenge(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(value.getBytes(StandardCharsets.US_ASCII));
        return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
    }

    private static String createCodeVerifier(){
        StringKeyGenerator secureKeyGenerator =
                new Base64StringKeyGenerator(Base64.getUrlEncoder().withoutPadding(), 96);
        return secureKeyGenerator.generateKey();
    }

}
