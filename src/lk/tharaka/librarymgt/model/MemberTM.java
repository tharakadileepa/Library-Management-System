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
public class MemberTM {
    
    private String memberID;
    private String memberName;
    private String memberContact;
    private String memberAddress;

    public MemberTM() {
    }

    public MemberTM(String memberID, String memberName, String memberContact, String memberAddress) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberContact = memberContact;
        this.memberAddress = memberAddress;
    }

    /**
     * @return the memberID
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * @param memberID the memberID to set
     */
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the memberContact
     */
    public String getMemberContact() {
        return memberContact;
    }

    /**
     * @param memberContact the memberContact to set
     */
    public void setMemberContact(String memberContact) {
        this.memberContact = memberContact;
    }

    /**
     * @return the memberAddress
     */
    public String getMemberAddress() {
        return memberAddress;
    }

    /**
     * @param memberAddress the memberAddress to set
     */
    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
    
    
    
    
}
