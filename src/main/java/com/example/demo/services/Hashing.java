package com.example.demo.services;

import com.example.demo.AppException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    public String hashString(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger bigInt = new BigInteger(1, messageDigest);
            return bigInt.toString(16);
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new AppException("Hashing failed!", e);
        }
    }
}
