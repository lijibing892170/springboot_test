package com.ljb.test.model;

public class UploadPictureResponce {
    public String oldName;
    public String newPath;

    public UploadPictureResponce(String oldName, String newPath) {
        this.oldName = oldName;
        this.newPath = newPath;
    }

    @Override
    public String toString() {
        return "UploadPictureResponce{" +
                "oldName='" + oldName + '\'' +
                ", newPath='" + newPath + '\'' +
                '}';
    }
}
