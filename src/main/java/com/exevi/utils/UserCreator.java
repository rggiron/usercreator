package com.exevi.utils;

import com.sun.istack.internal.NotNull;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class UserCreator
{
    private static final String  defaultUsername = "pepito";
    private static final int  defaultNumChars = 8;

    public static void main( String[] args )
    {
        String username = defaultUsername;
        int numChars = defaultNumChars;

        if (args != null && args.length > 0) {
            username = args[0];
            if (args.length>1)
                numChars = Integer.parseInt(args[1]);
        }

        String[] nuevaPassword = createPasswordAndHash(username);

        System.out.println(String.format("USUARIO:%s\nPASSWORD:%s\nHASH:%s",username, nuevaPassword[0], nuevaPassword[1]));
    }


    protected static String newPassword()
    {
        return newPassword(defaultNumChars);
    }

    protected static String newPassword(int numChars)
    {
        return RandomStringUtils.randomAlphabetic(numChars);
    }

    protected static String newPasswordHash(String password)
    {
        return DigestUtils.sha256Hex(password);
    }

    public static Map<String, String[]> createPasswordAndHash(List<String> usernames)
    {
        Map<String, String[]> map = new HashMap<String, String[]>();

        usernames.forEach( (username) -> map.put(username, createPasswordAndHash(username)));

        return map;
    }

    public static String[] createPasswordAndHash(String username)
    {
        String password = newPassword();
        String hash = newPasswordHash(password);
        return new String[]{password, hash};
    }




}
