package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/03/04.
 */

public interface Model<M> {

    public ArrayList<M> getList();

    public M getItem(int index);

    public void deleteItem(int index);

    public void addItem(M item);

    public ArrayList<M> loadList();

    public void saveList();


}
