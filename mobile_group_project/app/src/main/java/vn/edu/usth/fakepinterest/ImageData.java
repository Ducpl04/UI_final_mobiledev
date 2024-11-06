package vn.edu.usth.fakepinterest;

import android.widget.Button;

public class ImageData {
    Integer dataResource;
    String dataName;
    Button button_share;

    public Button getButton_share() {
        return button_share;
    }

    public ImageData(Integer dataresource, String dataName){
        this.dataResource = dataresource;
        this.dataName = dataName;
    }

    public int getImageResources() {
        return dataResource;
    }

    public void setDataResource(Integer dataResource){
        this.dataResource = dataResource;
    }

    public String getImageName() {
        return dataName;
    }

}
