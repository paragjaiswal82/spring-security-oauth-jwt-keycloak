# spring-security-oauth-jwt-keycloak
reference - https://docs.github.com/en/developers/apps/building-oauth-apps/authorizing-oauth-apps
            https://developer.okta.com/blog/2019/03/12/oauth2-spring-security-guide

GitHub auth url - https://github.com/login/oauth/authorize?response_type=code&client_id=a784ba219a9b10c869c4&scope=read&state=awwssddee&grant_type=authorization_code

GitHub token url - https://github.comGitHub/login/oauth/access_token

{
  
  "client_id": "a784ba219a9b10c869c4",
  "client_secret": "199f87d4e2794a4b102d50e354cbf5214ee583c1",
  "code": "28337128eefea4a6c31c",
  "redirect_uri": "http://localhost:8080/login/oauth2/code"
}

https://api.github.com/user - GET

"Authorization": Bearer 23u8ewy7ey28372e73y2ewuedh1uieiued

KeyCloak auth url - http://localhost:8080/auth/realms/appsdevelopers/protocol/openid-connect/auth?grant_type=authorization_code&response_type=code&client_id=test-client-id-from-keycloak&scope=openid%20profile&redirect_uri=http://localhost:8083/callback&state=awwssddee

KeyCloak token url - http://localhost:8080/auth/realms/appsdevelopers/protocol/openid-connect/token
{ 
 "client_id": "test-client-id-from-keycloak",
 "client_secret": "d76f5b4b-a3ba-485e-8da1-f5d7fd2770ae",
 "redirect_uri": "http://localhost:8083/callback",
 "scope": "openid profile",
 "code": "59e77305-ca5f-4ba2-af93-caedc3961ef9.b2cb75e0-dbfb-483d-8504-7687e8a04e35.493f2455-0f41-4090-b307-aa65328434f4"
}
