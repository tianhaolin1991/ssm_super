package cn.itcast.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtils  {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(String password){
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        return encodedPassword;
    }

    public static void main(String[] args) {
        System.out.println(encode("admin"));
    }

}
