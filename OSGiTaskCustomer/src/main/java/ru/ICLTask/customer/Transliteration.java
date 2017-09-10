package ru.ICLTask.customer;

import java.io.UnsupportedEncodingException;

public interface Transliteration {
    String getLatinName(String name);

    String getNameKyrillic() throws UnsupportedEncodingException;
}
