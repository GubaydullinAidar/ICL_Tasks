package ru.ICLTask.service;

import com.ibm.icu.text.Transliterator;

public class TranslitServiceImpl implements TranslitService {

    private static final String NAME = TranslitServiceImpl.class.getName();

    @Override
    public String getName() {
        return NAME;
    }

    public String translitToLatin(String name) {
        return Transliterator.getInstance("Cyrillic-Latin").transliterate(name);
    }

}