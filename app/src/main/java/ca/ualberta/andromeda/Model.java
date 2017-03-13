/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/03/04.
 *
 * The interface for Model Classes.
 * This defines methods common to all models, dealing with saving and reading affiliated classes to disk.
 */

public interface Model<M> {

    public ArrayList<M> getList();

    public M getItem(int index);

    public void deleteItem(int index);

    public void deleteItem(M item);

    public void addItem(M item);

    public void loadList();

    public void saveList();

}
