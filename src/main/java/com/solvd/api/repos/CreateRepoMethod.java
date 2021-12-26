package com.solvd.api.repos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class CreateRepoMethod extends AbstractApiMethodV2 {

    public CreateRepoMethod() {
        super("api/repos/_post/rq.json", "api/repos/_post/rs.json", "api/repos/repo.properties");
        setHeaders(String.format("%s=Bearer %s", "Authorization", Configuration.getEnvArg("token")));
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
