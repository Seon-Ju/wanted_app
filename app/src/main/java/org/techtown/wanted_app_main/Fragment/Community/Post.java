package org.techtown.wanted_app_main.Fragment.Community;
//
public class Post {
    String image;
    String title;
    String comment;

    public Post(String image,String title, String comment){
        this.image=image;
        this.title=title;
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void  setImage(String image) {
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public void  setTitle(String title) {
        this.title = title;
    }


    public String getComment() {
        return comment;
    }
    public void  setComment(String comment) {
        this.comment = comment;
    }

}
