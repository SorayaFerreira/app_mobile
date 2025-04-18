package com.example.ourfirstapp;
import android.os.Parcel;
import android.os.Parcelable;
//Classe Bird implementa Parcelable que permite instancias serem passadas entre fragmentos
public class Bird implements Parcelable {
    private final int imageResId;
    private final int audioResId;
    private final String name;
    private final String scientificName;
    private final String description;

    public Bird(int imageResId, int audioResId, String name, String scientificName, String description) {
        //metodo construtor
        this.imageResId = imageResId;
        this.audioResId = audioResId;
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
    }

    protected Bird(Parcel in) {
        //implementacao parcelable
        imageResId = in.readInt();
        audioResId = in.readInt();
        name = in.readString();
        scientificName = in.readString();
        description = in.readString();
    }

    public static final Creator<Bird> CREATOR = new Creator<>() {
        @Override
        public Bird createFromParcel(Parcel in) {
            return new Bird(in);
        }

        @Override
        public Bird[] newArray(int size) {
            return new Bird[size];
        }
    };

    public int getImageResId() {
        return imageResId;
    }

    public int getAudioResId() {
        return audioResId;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResId);
        dest.writeInt(audioResId);
        dest.writeString(name);
        dest.writeString(scientificName);
        dest.writeString(description);
    }
}
