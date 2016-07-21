package colan.com.learnshapes.moregames;

/**
 * Created by KEERTHINI on 7/20/2016.
 */

public class DataModel {

    String name;
    int id;
    int image;

    public DataModel(String name, int id, int image) {
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
