package com.projects.thebestpiwobackend.piwa;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class RandomIdPairGenerator {
    private final static SecureRandom random = new SecureRandom();

    public PiwoIdPair generate() {
        int id1 = randomId();
        int id2 = generateExcept(id1);
        return new PiwoIdPair(id1,id2);
    }

    private int randomId() {
        return random.nextInt(57) + 1;
    }

    private int generateExcept(int except){
        int id = randomId();
        if(id != except){
            return id;
        }
        return generateExcept(except);
    }
}
