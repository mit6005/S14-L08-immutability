package afterclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MitIdentifiers {

    /**
     * @param username username of person to look up
     * @return the 9-digit MIT identifier for username.
     * @throws NoSuchUserException if nobody with username is in MIT's database
     */
    public static char[] getMitId(String username) throws NoSuchUserException {        
        // look up username in MIT's database and return the 9-digit ID.
        if (cache.containsKey(username)) {
            return cache.get(username);
        }
        
        // for now, let's just randomly generate it.
        Random random = new Random();
        char[] id = new char[9];
        for (int i = 0; i < 9; ++i) {
            id[i] = (char) ('0' + random.nextInt(10));           
        }
        cache.put(username, id);
        return id;
    }
    private static Map<String, char[]> cache = new HashMap<String, char[]>();
    
    
    public static class NoSuchUserException extends Exception {        
    }
    
    public static void main(String[] args) {
        for (String username : args) {
            try {
                char[] id = getMitId(username);
                obscureId(id);
                System.out.println(id);
            } catch (NoSuchUserException e) {
                System.err.println("? unknown user " + username);
            }
        }
    }
    
    /**
     * Replaces the first five digits of an MIT identifier with asterisks,
     * for privacy.
     * @param id a 9-digit MIT identifier.  Requires id.length == 9.
     */
    public static void obscureId(char[] id) {
        for (int i = 0; i < 5; ++i) {
            id[i] = '*';
        }
    }

}
