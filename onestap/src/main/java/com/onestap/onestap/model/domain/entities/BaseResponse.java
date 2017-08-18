/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.model.domain.entities;

import java.util.List;

/**
 * Created by ltorres on 19/07/2017.
 */

abstract class BaseResponse {
    private Boolean success = false;
    private List<OperationReport> operationReport;

    public Boolean hasSuccess() {
        return success;
    }

    public List<OperationReport> getOperationReport() {
        return operationReport;
    }

    @Override
    public String toString() {
        String aux = "";
        for(OperationReport or : operationReport){
            aux+=or.getMessage();
        }
        return aux;
    }
}
