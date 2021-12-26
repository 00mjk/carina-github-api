package com.solvd.api.repos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutRepoTopicMethod extends AbstractApiMethodV2 {

    public PutRepoTopicMethod() {
        super("api/repos/_put/rq.json", "api/repos/_put/rs.json", "api/repos/repo.properties");
        setHeaders(String.format("%s=Bearer %s", "Authorization", Configuration.getEnvArg("token")));
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("username", Configuration.getEnvArg("username"));
        replaceUrlPlaceholder("repo_name", Configuration.getEnvArg("repo_name"));
    }
}
