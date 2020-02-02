package com.boot.convertors;

import com.boot.beans.Gender;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class StringToEnumConverter implements Converter<String, Gender> {

    private final Map<String, Gender> genders = new HashMap<>();

    public StringToEnumConverter() {
        initGenderMap();
    }

    public void initGenderMap() {
        genders.put("male", Gender.MALE);
        genders.put("female", Gender.FEMALE);
        genders.put("other", Gender.OTHER);
    }

    @Override
    public Gender convert(String gender) {
        return genders.getOrDefault(gender.toLowerCase(), Gender.OTHER);
    }
}
