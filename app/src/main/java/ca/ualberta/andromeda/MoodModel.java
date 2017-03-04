package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */

public class MoodModel implements Model<Mood> {
    private ArrayList<Mood> moodList;

    public MoodModel(){
        this.moodList = this.loadList();
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
        this.moodList.add(mood);
        this.saveList();
    }

    @Override
    public ArrayList<Mood> loadList() {
        return this.moodList;
    }

    @Override
    public void saveList() {
        /* save to disk */
    }
}
