/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class PasswordUtil {
    public static String convertToSha256(String inputString) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(inputString.getBytes());
            byte[] digest = md.digest();
            String hash = new BigInteger(1, digest).toString(16);
            return hash;
        } catch (NoSuchAlgorithmException ex){
            Logger.getLogger(PasswordUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
