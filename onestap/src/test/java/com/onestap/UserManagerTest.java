package com.onestap;

import com.google.gson.Gson;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.domain.entities.BaseResponse;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.model.domain.entities.UserResponse;
import com.onestap.user.model.manager.UserManager;
import com.onestap.user.model.usecase.UserUseCase;
import com.onestap.user.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.VoidAnswer2;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.mockwebserver.MockResponse;
import retrofit2.Response;

/**
 * Created on 20/09/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */
public class UserManagerTest extends BaseTest {


    @Test
    public void get_user_with_error401() throws IOException {

        MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED);
        mockResponse.setBody("{\"success\":false,\"operationReport\":[{\"field\":\"Token de Acesso\",\"message\":\"Este(a) Token de Acesso expirou.\"}]}");

        mMockWebServer.enqueue(mockResponse);

        UserService service = mRetrofit.create(UserService.class);
        Response<AccountResponse> response = service.getUser(Mockito.anyString(), Mockito.any(String[].class)).execute();

        BaseResponse error = new Gson().fromJson(response.errorBody().string(), BaseResponse.class);

        Assert.assertNull(response.body());
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.errorBody());
        Assert.assertNotNull(response.errorBody().string());

        Assert.assertNotNull(error);
        Assert.assertFalse(error.hasSuccess());
        Assert.assertNotNull(error.getOperationReport());

    }

}