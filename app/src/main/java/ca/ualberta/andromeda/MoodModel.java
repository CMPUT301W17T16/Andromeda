
/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */

public class MoodModel implements Model<Mood> {
    private Gson gson;
    private ArrayList<Mood> moodList;
    private final String FILENAME = "moods.json";

    public MoodModel(){
        this.gson = new Gson();
        this.loadList();
    }

    @Override
    public ArrayList<Mood> getList() {
        this.loadList();
        return this.moodList;
    }

    @Override
    public Mood getItem(int index) {
        return this.moodList.get(index);
    }

    @Override
    public void deleteItem(int index) {
        this.moodList.remove(index);
        this.saveList();
    }

    @Override
    public void deleteItem(Mood mood) {
        this.moodList.remove(mood);
        this.saveList();
    }

    @Override
    public void addItem(Mood mood) {
        this.moodList.add(0,mood);
        this.saveList();
    }
    
    @Override
    public void loadList() {
        /* load from disk */
        this.moodList = new ArrayList<Mood>();

        try {
            FileInputStream fis = ModelManager.getAppInstance().openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                this.moodList.add(gson.fromJson(line, Mood.class));
                System.out.println(gson.fromJson(line, Mood.class));
                line = in.readLine();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            File file = new File(ModelManager.getAppInstance().getFilesDir(), FILENAME);
        }
    }

    @Override
    public void saveList() {
        /* save to disk */
        try {
            FileOutputStream fos = ModelManager.getAppInstance().openFileOutput(FILENAME, Context.MODE_PRIVATE);
            int length = this.moodList.size();
            for(int x=0; x<length; x++) {
                fos.write((gson.toJson(this.moodList.get(x))+"\n").getBytes());
                System.out.println(gson.toJson(this.moodList.get(x)));
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
