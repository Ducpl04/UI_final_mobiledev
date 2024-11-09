package vn.edu.usth.fakepinterest;

import android.widget.Button;

public class ImageDataBoard {
    Integer dataResource;
    String dataName;
    Button button_share;
    String pins_quantities;

    public Button getButton_share() {
        return button_share;
    }

    public ImageDataBoard(Integer dataresource, String dataName, String pins_quantities){
        this.dataResource = dataresource;
        this.dataName = dataName;
        this.pins_quantities = pins_quantities;
    }

    public int getImageResources() {
        return dataResource;
    }

    public String getPins_quantities() {
        return pins_quantities;
    }

    public String getImageName() {
        return dataName;
    }

}
