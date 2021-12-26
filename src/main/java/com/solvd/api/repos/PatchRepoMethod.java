package com.solvd.api.repos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PatchRepoMethod extends AbstractApiMethodV2 {

    public PatchRepoMethod() {
        super("api/repos/_patch/rq.json", "api/repos/_patch/rs.json", "api/repos/repo.properties");
        setHeaders(String.format("%s=Bearer %s", "Authorization", Configuration.getEnvArg("token")));
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("username", Configuration.getEnvArg("username"));
        replaceUrlPlaceholder("repo_name", Configuration.getEnvArg("repo_name"));
    }
}
