package com.example.searchviewontoolbar;

class Movie {
    private int img_id;
    private String names;

    Movie(String names,int img_id) {
        setImg_id(img_id);
        setNames(names);
    }

    String getNames() {
        return names;
    }

    private void setNames(String names) {
        this.names = names;
    }

    int getImg_id() {
        return img_id;
    }

    private void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
