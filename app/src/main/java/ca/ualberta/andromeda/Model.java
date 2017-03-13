/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/03/04.
 * <p>
 * The interface for Model Classes.
 * This defines methods common to all models, dealing with saving and reading affiliated classes to disk.
 *
 * @param <M> the type parameter
 */
public interface Model<M> {

    /**
     * Gets list.
     *
     * @return the list
     */
    public ArrayList<M> getList();

    /**
     * Gets item.
     *
     * @param index the index
     * @return the item
     */
    public M getItem(int index);

    /**
     * Delete item.
     *
     * @param index the index
     */
    public void deleteItem(int index);

    /**
     * Delete item.
     *
     * @param item the item
     */
    public void deleteItem(M item);

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(M item);

    /**
     * Load list.
     */
    public void loadList();

    /**
     * Save list.
     */
    public void saveList();

}
