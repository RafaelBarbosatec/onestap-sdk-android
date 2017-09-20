package com.onestap.core.exceptions;

import android.annotation.TargetApi;
import android.os.Build;

import com.google.gson.Gson;
import com.onestap.core.model.domain.entities.BaseResponse;
import com.onestap.core.model.domain.entities.OperationReport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 20/09/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class GlobalException extends Throwable {

    protected List<OperationReport> operationReport = new ArrayList<>();


    public GlobalException(String message) {
        this(message, new Throwable("Global exception!"));
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);

        BaseResponse error = new Gson().fromJson(message, BaseResponse.class);
        if(error != null){
            if(error.getOperationReport() != null ){
                setOperationReport(error.getOperationReport());
            }
        }
    }

    public GlobalException(List<OperationReport> operationReport) {
        this.operationReport = operationReport;

    }

    public List<OperationReport> getOperationReport() {
        return operationReport;
    }

    void setOperationReport(List<OperationReport> operationReport) {
        this.operationReport = operationReport;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        for(OperationReport or : operationReport){
            aux.append(getMessage());
        }
        return aux.toString();
    }
}
