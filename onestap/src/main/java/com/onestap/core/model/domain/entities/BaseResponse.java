/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.domain.entities;

import java.util.List;

/**
 * Created by ltorres on 19/07/2017.
 */

public abstract class BaseResponse {
    protected Boolean success = false;
    protected List<OperationReport> operationReport;

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
