/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.profile.model.domain.entities;

import java.util.List;

/**
 * Created by ltorres on 28/07/2017.
 */

class Data {
    PersonalData personalData;
    List<Vehicle> vehicles;
    List<Address> addresses;
    List<Phone> phones;
    List<Document> documents;
    List<Email> emails;

    Data(PersonalData personalData, List<Vehicle> vehicles, List<Address> addresses, List<Phone> phones, List<Document> documents, List<Email> emails) {
        this.addresses = addresses;
        this.personalData = personalData;
        this.vehicles = vehicles;
        this.phones = phones;
        this.documents = documents;
        this.emails = emails;
    }
}