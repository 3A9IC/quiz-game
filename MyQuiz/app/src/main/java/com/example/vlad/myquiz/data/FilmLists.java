package com.example.vlad.myquiz.data;

import android.provider.BaseColumns;

/**
 * Created by pc on 23.12.2017.
 */

public final class FilmLists {

    private FilmLists(){

    };
    public static final class FilmsEz implements BaseColumns{
        public final static String TABLE_NAME = "films_easy";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_URL = "url";
    }
}
