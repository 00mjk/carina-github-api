package com.solvd.api;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.api.repos.*;
import com.solvd.api.users.GetUserMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "askomar")
    public void validateUserGettingTest() {
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethod.callAPI();
        getUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUserMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "askomar")
    public void validateRepoCreatingTest() {
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        createRepoMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        createRepoMethod.callAPI();
        createRepoMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        createRepoMethod.validateResponseAgainstSchema("api/repos/_post/rs.schema");
    }

    @Test
    @MethodOwner(owner = "askomar")
    public void validateRepoGettingTest() {
        GetRepoMethod getUserRepoByNameMethod = new GetRepoMethod();
        getUserRepoByNameMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserRepoByNameMethod.callAPI();
        getUserRepoByNameMethod.validateResponse(JSONCompareMode.LENIENT);
        getUserRepoByNameMethod.validateResponseAgainstSchema("api/repos/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "askomar")
    public void validateRepoTopicsUpdatingTest() {
        PutRepoTopicMethod putUserRepoTopicsMethod = new PutRepoTopicMethod();
        putUserRepoTopicsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUserRepoTopicsMethod.callAPI();
        putUserRepoTopicsMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        putUserRepoTopicsMethod.validateResponseAgainstSchema("api/repos/_put/rs.schema");
    }

    @Test
    @MethodOwner(owner = "askomar")
    public void validateRepoModifyingTest() {
        PatchRepoMethod patchUserRepoMethod = new PatchRepoMethod();
        patchUserRepoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        patchUserRepoMethod.callAPI();
        patchUserRepoMethod.validateResponse(JSONCompareMode.LENIENT);
        patchUserRepoMethod.validateResponseAgainstSchema("api/repos/_patch/rs.schema");
    }

    @Test
    @MethodOwner(owner = "askomar")
    public void validateRepoDeletingTest() {
        DeleteRepoMethod deleteUserRepoByNameMethod = new DeleteRepoMethod();
        deleteUserRepoByNameMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteUserRepoByNameMethod.setProperties(new Properties());
        deleteUserRepoByNameMethod.callAPI();
    }
}
