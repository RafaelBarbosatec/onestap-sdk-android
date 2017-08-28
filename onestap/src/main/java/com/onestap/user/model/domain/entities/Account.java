/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.model.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 28/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class Account {

    @SerializedName("accountKey")
    private String accountKey;
    @SerializedName("isEnabled")
    private Boolean isEnabled;
    @SerializedName("isNewsLetterAllowed")
    private Boolean isNewsLetterAllowed;
    @SerializedName("publicProfile")
    private PublicProfile publicProfile;
    @SerializedName("personalData")
    private PersonalData personalData;
    @SerializedName("emails")
    private List<Email> emails = null;
    @SerializedName("phones")
    private List<Phone> phones = null;
    @SerializedName("addresses")
    private List<Address> addresses = null;
    @SerializedName("documents")
    private List<Document> documents = null;

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getIsNewsLetterAllowed() {
        return isNewsLetterAllowed;
    }

    public void setIsNewsLetterAllowed(Boolean isNewsLetterAllowed) {
        this.isNewsLetterAllowed = isNewsLetterAllowed;
    }

    public PublicProfile getPublicProfile() {
        return publicProfile;
    }

    public void setPublicProfile(PublicProfile publicProfile) {
        this.publicProfile = publicProfile;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
