/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Jeff on 2/27/2017.
 */

public class ElasticSearchManager {

    // TODO we need a function which adds User to elastic search
    public static class AddUserTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... params) {
            return null;
        }
    }

    // TODO we need a function which gets User from elastic search
    public static class GetUserTask extends AsyncTask<String, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(String... search_parameters) {

            return null;
        }
    }

    // TODO we need a function which add Mood from elastic search
    public static class AddMoodTask extends AsyncTask<Mood, Void, Void> {

        @Override
        protected Void doInBackground(Mood... params) {
            return null;
        }
    }

    // TODO we need a function which gets Mood from elastic search
    public static class GetMoodTask extends AsyncTask<String, Void, ArrayList<Mood>> {
        @Override
        protected ArrayList<Mood> doInBackground(String... search_parameters) {

            return null;
        }
    }

    // TODO we need a function which deletes Mood from elastic search
    public static class DeleteMoodTask extends AsyncTask<String, Void, ArrayList<Mood>> {
        @Override
        protected ArrayList<Mood> doInBackground(String... search_parameters) {

            return null;
        }
    }

}