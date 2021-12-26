package com.solvd.api.repos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeleteRepoMethod extends AbstractApiMethodV2 {

    public DeleteRepoMethod() {
        super(null, null, new Properties());
        setHeaders(String.format("%s=Bearer %s", "Authorization", Configuration.getEnvArg("token")));
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("username", Configuration.getEnvArg("username"));
        replaceUrlPlaceholder("repo_name", Configuration.getEnvArg("repo_name"));
    }
}
