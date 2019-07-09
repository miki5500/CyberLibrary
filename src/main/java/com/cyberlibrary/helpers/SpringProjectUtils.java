package com.cyberlibrary.helpers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpringProjectUtils {

    public static boolean checkEmailOrPassword(String pattern, String pStr)
    {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pStr);
        return m.matches();
    }


    public static String getLoggedUser()
    {
        String username = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken))
        {
            username = authentication.getName();
        }
        return username;
    }

}
