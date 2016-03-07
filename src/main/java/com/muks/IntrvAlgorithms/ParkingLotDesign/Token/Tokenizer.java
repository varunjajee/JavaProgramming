package com.muks.IntrvAlgorithms.ParkingLotDesign.Token;

import com.muks.IntrvAlgorithms.ParkingLotDesign.DateUtils;

import java.util.Queue;

/**
 * Created by mukthar.ahmed on 3/7/16.
 */
public class Tokenizer {
    private int TOKEN_SERIES = 0;
    private int TOKEN_NUMBER;
    private int SLOT;
    private String ENTRY_DATE_TIME;
    private String EXIT_DATE_TIME;


    public Tokenizer getToken() {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.TOKEN_NUMBER = tokenizer.getTokenNumber();
        tokenizer.ENTRY_DATE_TIME = DateUtils.getDateTime();

        return tokenizer;
    }

    public int getTokenNumber() {
        return TOKEN_SERIES++;
    }


}
