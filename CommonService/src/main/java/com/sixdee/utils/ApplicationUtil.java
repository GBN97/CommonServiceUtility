package com.sixdee.utils;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationUtil {

    private static UUID uuid = Generators.timeBasedGenerator().generate();

    /**
     * Generates UUID
     *
     * @return UUID
     */
    public static String getUUID(){
        return String.valueOf(uuid.timestamp());
    }
}
