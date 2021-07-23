package com.example.bitmapiso8583;

public class Field {


    int numberField;
    int valueField;
    String nameField;

    public Field() {
    }

    public Field(int numberField, int valueField, String nameField) {
        this.numberField = numberField;
        this.valueField = valueField;
        this.nameField = nameField;
    }

    public int getNumberField() {
        return numberField;
    }

    public void setNumberField(int numberField) {
        this.numberField = numberField;
    }

    public int getValueField() {
        return valueField;
    }

    public void setValueField(int valueField) {
        this.valueField = valueField;
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }
}
