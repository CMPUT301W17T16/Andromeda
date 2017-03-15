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
    // Removed all the unnecessary public
    /**
     * Gets list.
     *
     * @return the list
     */
    ArrayList<M> getList();

    /**
     * Gets item.
     *
     * @param index the index
     * @return the item
     */
    M getItem(int index);

    /**
     * Delete item.
     *
     * @param index the index
     */
    void deleteItem(int index);

    /**
     * Delete item.
     *
     * @param item the item
     */
    void deleteItem(M item);

    /**
     * Add item.
     *
     * @param item the item
     */
    void addItem(M item);

    /**
     * Load list.
     */
    void loadList();

    /**
     * Save list.
     */
    void saveList();

}
