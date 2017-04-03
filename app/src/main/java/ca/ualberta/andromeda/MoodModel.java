
/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Context;
import android.util.Log;

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

    /**
     * Instantiates a new Mood model.
     */
    public MoodModel(){
        this.gson = new Gson();
        this.moodList = new ArrayList<Mood>();
    }

    @Override
    public ArrayList<Mood> getList() {
        return this.moodList;
    }

    @Override
    public Mood getItem(int index) {
        return this.moodList.get(index);
    }

    @Override
    public void deleteItem(int index){
        this.moodList.remove(index);
    }
    public void deleteItem(String id) {
        this.moodList.remove(ModelManager.getMoodController().getMood(id));
        Log.i("Mood Model", "--- Deleting Mood "+ id +"---");
        ElasticSearchManager.DeleteMoodTask deleteMood = new ElasticSearchManager.DeleteMoodTask();
        deleteMood.execute(id);
    }

    @Override
    public void deleteItem(Mood mood) {
        this.moodList.remove(mood);
        Log.i("Mood Model", "--- Deleting Mood "+ mood.getId() +"---");
        ElasticSearchManager.DeleteMoodTask deleteMood = new ElasticSearchManager.DeleteMoodTask();
        deleteMood.execute(mood.getId());
    }

    public void updateItem(Mood mood) {
        Log.i("Mood Model", "--- Editing Mood "+ mood.getId() +"---");
        ElasticSearchManager.EditMoodTask editMood = new ElasticSearchManager.EditMoodTask();
        editMood.execute(mood);
    }

    @Override
    public void addItem(Mood mood) {
        Log.i("Mood Model", "--- Adding Mood ---");

        ElasticSearchManager.AddMoodTask addMood = new ElasticSearchManager.AddMoodTask();
        addMood.execute(mood);
        this.moodList.add(0,mood);
        this.saveList();
    }

    @Override
    public void loadList() {
        Log.i("LOAD", "LIST");
        /* load from disk */
        this.moodList = new ArrayList<Mood>();

        ElasticSearchManager.GetMoodsTask getMoods = new ElasticSearchManager.GetMoodsTask();
        getMoods.execute();
        try {
            this.moodList = getMoods.get();
        } catch(Exception e){
            e.printStackTrace();
        }
        for(int x=0; x<this.moodList.size(); x++){
            System.out.println(this.moodList.get(x).getId() + " | " + this.moodList.get(x).getUser().toString());
        }
        /*
        try {
            FileInputStream fis = ModelManager.getAppInstance().openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            int x = 0;
            while (line != null) {
                this.moodList.add(gson.fromJson(line, Mood.class));
                //this.moodList.get(x).setId(x);
                //x++;
                line = in.readLine();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            File file = new File(ModelManager.getAppInstance().getFilesDir(), FILENAME);
        }
        */
    }

    @Override
    public void saveList() {
        /* save to disk */

        /*
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
        */
    }
}
