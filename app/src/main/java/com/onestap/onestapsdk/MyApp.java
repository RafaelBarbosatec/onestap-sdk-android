/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestapsdk;

import android.app.Application;

import com.onestap.OST;
import com.onestap.OSTConfiguration;
import com.onestap.core.model.domain.enumerator.OSTEnvironment;
import com.onestap.user.model.domain.entities.Address;
import com.onestap.user.model.domain.entities.Document;
import com.onestap.user.model.domain.entities.Email;
import com.onestap.user.model.domain.entities.PersonalData;
import com.onestap.user.model.domain.entities.Phone;
import com.onestap.user.model.domain.entities.TempProfile;
import com.onestap.user.model.domain.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OSTConfiguration config = new OSTConfiguration();
        config.setClientId("432B08E5-ACDA-4AD0-976F-CC5C323B2A1D");
        config.setClientSecret("FC3E9D34-978B-483B-9CC0-462DFB82A75B");
        config.setHost("onestap");
        config.setSchema("onestap");
        config.setFingerPrintID("c470458e-7845-4380-a5db-e7e28548c243");

        config.setColorPrimary(R.color.colorPrimary);
        config.setColorPrimaryDark(R.color.colorPrimaryDark);
        config.setColorAccent(R.color.colorAccent);

        config.setEnvironment(OSTEnvironment.SANDBOX);

//        config.setTempProfile(feedTempProfile()); // READ THE DOCUMENTATION

        OST.initializer(MyApp.this, config);
    }


    private TempProfile feedTempProfile(){
        PersonalData personalData = new PersonalData("BR", "2017-12-02", 2, "masculine");

        Vehicle vehicle =new Vehicle("BBB 1234", null, "RJ", "BR");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        Address address = new Address("Rua Sem nome", "200", "ap 101", "work", "Ipanema", "Rio de Janeiro", "RJ", "22220-000", "perto do banco", "brasil");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        Phone phone = new Phone("mobile", "+5521998766574");
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);

        Document document = new Document("cpf", "23989146408");
        List<Document> documents = new ArrayList<>();
        documents.add(document);

        Email email = new Email("connect@gmail.com");
        List<Email> emails = new ArrayList<>();
        emails.add(email);
        return new TempProfile(personalData, vehicles, addresses, phones, documents, emails);
    }
}
