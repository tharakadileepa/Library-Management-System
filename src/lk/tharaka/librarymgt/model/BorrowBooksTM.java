/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.model;

/**
 *
 * @author THARAKA
 */
public class BorrowBooksTM {
    private String membid;
    private String bookid;
    private String date;

    public BorrowBooksTM() {
    }

    public BorrowBooksTM(String membid, String bookid, String date) {
        this.membid = membid;
        this.bookid = bookid;
        this.date = date;
    }

    /**
     * @return the membid
     */
    public String getMembid() {
        return membid;
    }

    /**
     * @param membid the membid to set
     */
    public void setMembid(String membid) {
        this.membid = membid;
    }

    /**
     * @return the bookid
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * @param bookid the bookid to set
     */
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
