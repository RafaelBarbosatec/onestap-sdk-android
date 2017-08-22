/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.domain.entities;

class OperationReport {

protected String field;
protected String message;

public String getField() {
return field;
}

public void setField(String field) {
this.field = field;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

}