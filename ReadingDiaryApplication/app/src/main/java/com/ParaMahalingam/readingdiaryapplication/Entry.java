package com.ParaMahalingam.readingdiaryapplication;

public class Entry {
    private int ID;
    private String BookTitle;
    private String Date;
    private String PagesRead;
    private String ChildComment;
    private String TPComment;

    public Entry(int ID, String bookTitle, String date, String pagesRead, String childComment, String TPComment) {
        this.ID = ID;
        BookTitle = bookTitle;
        Date = date;
        PagesRead = pagesRead;
        ChildComment = childComment;
        this.TPComment = TPComment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        BookTitle = bookTitle;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPagesRead() {
        return PagesRead;
    }

    public void setPagesRead(String pagesRead) {
        PagesRead = pagesRead;
    }

    public String getChildComment() {
        return ChildComment;
    }

    public void setChildComment(String childComment) {
        ChildComment = childComment;
    }

    public String getTPComment() {
        return TPComment;
    }

    public void setTPComment(String TPComment) {
        this.TPComment = TPComment;
    }
}
