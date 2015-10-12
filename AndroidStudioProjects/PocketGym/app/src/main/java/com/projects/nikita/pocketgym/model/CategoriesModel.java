package com.projects.nikita.pocketgym.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 10/8/2015.
 */
public class CategoriesModel {
    @SerializedName("categories")
    @Expose
    private List<String> categories = new ArrayList<String>();

    /**
     *
     * @return
     * The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
