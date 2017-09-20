package com.onestap;

import com.onestap.core.exceptions.GlobalException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created on 20/09/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class GlobalExceptionTest {


    @Test
    public void global_exception_with_any_message_test(){
        GlobalException exception = new GlobalException(Mockito.anyString());
        Assert.assertNotNull(exception);
        Assert.assertNotNull(exception.getMessage());
    }

    @Test
    public void global_exception_with_json_message_test(){
        String json = "{\"success\":false,\"operationReport\":[{\"field\":\"Token de Acesso\",\"message\":\"Este(a) Token de Acesso expirou.\"}]}";
        GlobalException exception = new GlobalException(json);
        Assert.assertNotNull(exception);
        Assert.assertNotNull(exception.getMessage());
        Assert.assertNotNull(exception.getOperationReport());
        Assert.assertEquals(1, exception.getOperationReport().size());
    }
}
