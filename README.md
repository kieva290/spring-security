This tutorial explains the key featirs of OAuth 2.0 and OpenID connect:
----------------
Proof Key for Code Exchange: (PKCE) helps protect the integrity of the Authorization Code,
a server-to-server request to exchange the authorization code,
generate a random value (code-verifier) and associate it with the user's session (e.g. keep in a cookie),
calculate the SHA256 hash of the code verifier (code challenge)
store the code challenge along with authorization code,
exchange the authorization code, and include the code verifier,
authorization-provider, calculates the SHA256 hash of the code verifier and compare to the stored code challenge,
code_challenge: the hash of code verifier,
-------------
the code verifier is a cryptographically secure random string btw 43 and 128 characters of this character set: [A-Z][a-z][0-9]-._~
the code challenge is a base64 urlencoded SHA256 hash of the code-verifier
the hash function uniquely connects the code challenge to the code verifier,
the code-verifier cannot be derived from the code challenge,
PKCE support live in the "spring-security-oauth2-client" module,
-----------------------
used class "GenerateHash", to generate the code_verifier and code_challenge,
code verifier:vlc9d7rAV0ZJlRiCMFOoxBEZ7FRqxHn9LBQAZSu8tXX-wWl9yKsId6O-G67npqtwaj5OOmvVK71SEjYUUhV_pZ4J8syxPcq1MBwHCJob_Z8r5MLhThKDsc_UuhkdHfV5
code_challenge:KdjhFpcsmuulozj9aViEggHNcnVW-aq4O13Rfpn8yig
generated the above, then made below call, to get the athorization code,

http://localhost:8080/oauth2/authorize?
response_type=code&
client_id=client&
scope=openid&
redirect_uri=http://spring.io/auth&
code_challenge=KdjhFpcsmuulozj9aViEggHNcnVW-aq4O13Rfpn8yig&
code_challenge_method=S256

then after getting the authorization-code, ran the below to get the access-token, and id-token:
http://localhost:8080/oauth2/token?
client_id=client&
client_secret=secret&
redirect_uri=http://spring.io/auth&
grant_type=authorization_code&code=Xtgp1svR0d_18fkQtyadiTnGbUpLtghjK3iM2j-9H0mxF0d_PPzT_7qeB8mQ-OqB3C2mepLEpBMbd4md9LvFd5mg3taHfqCMAXkvqetNkQxeB9jz3Y_4JuCQ_BgtQHs8&
code_verifier=vlc9d7rAV0ZJlRiCMFOoxBEZ7FRqxHn9LBQAZSu8tXX-wWl9yKsId6O-G67npqtwaj5OOmvVK71SEjYUUhV_pZ4J8syxPcq1MBwHCJob_Z8r5MLhThKDsc_UuhkdHfV5
------------
see example response with access token below, doe via postman,
{
    "access_token": "eyJraWQiOiIxN2YzNTk3Mi05ZDQ2LTQ4YjktYmJjZi1iMDI1NDJiMzU2MGYiLCJhbGciOiJSUzI1NiJ9.
                     eyJzdWIiOiJraWV2YTI5MCIsImF1ZCI6ImNsaWVudCIsIm5iZiI6MTcxMzgwNzc0MCwic2NvcGUiOlsib
                     3BlbmlkIl0sImlzcyI6Imh0dHA6XC9cL2xvY2FsaG9zdDo4MDgwIiwiZXhwIjoxNzEzODA4MDQwLCJpYX
                     QiOjE3MTM4MDc3NDB9.Uq-HwkDfh1EZ8zTFpl9JQYtDRQWOnLoOoM-SiKJXnSaLfq3U_SCAvJ4pkH0Zsrf
                     KEOU89mAOon4x6uqRtgOrWo55XDGvDC6CBDwZPgGOhH8_AhIQvrfvja70MfrKes0i4WxFR_ZhEfl_6RePJ
                     ULAnDakJFmfQom7-fsmt7784FNBMt29KYop7PT8WEvPIs5bIB1P1S2CZd24PexPOP4-NcktAGOO-djwvfq
                     Wbs8VpFAmRsOB5NCsa_YoSQJU4oVLUW4qmh5PYjtvbeNYtxizBMVCpV9kUopmAPg0EnIMkyKkn10ILjsYR
                     hVtHxc9mbihUFWhP1QOCP2IoI6jF_qEpA",
    "scope": "openid",
    "id_token": "eyJraWQiOiIxN2YzNTk3Mi05ZDQ2LTQ4YjktYmJjZi1iMDI1NDJiMzU2MGYiLCJhbGciOiJSUzI1NiJ9.eyJzdWI
                 iOiJraWV2YTI5MCIsImF1ZCI6ImNsaWVudCIsImF6cCI6ImNsaWVudCIsImlzcyI6Imh0dHA6XC9cL2xvY2FsaG9
                 zdDo4MDgwIiwiZXhwIjoxNzEzODA5NTQwLCJpYXQiOjE3MTM4MDc3NDB9.DQ6EblkjBv5g5F9pQ89CnprYBb7LWT
                 SVMVDTBlZuUoKeIZ1wlBLNB66EXlTGaTruk3uqH45bFA9R66WS3RwGYEnhJNND3HpCF3pIajLL-5FHAi0vGjT63q
                 0Vte1my3hResgiIoXgZieNhj8pOLl7ksCwOpj8GnoBSVPp0NleMEdGURStNZG8vF63KamkGEaRsXp4k2YKyiO3uB
                 Tk5Erj6P_Ga3p_WWA7RHEPPlwv_OcOEnTeaH3fjk2W3P0BKkNtuAzq59z2yFI37019VObju9-A0gH3uM0YPlkkuw
                 gtTeYYbPMh3T_leWTdCGGlRsXBcj-GrX4ns36P__go4RGH7g",
    "token_type": "Bearer",
    "expires_in": 299
}
---------------
steps to initialize and push code after creating the repository on github,
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/kieva290/spring-security.git
git push -u origin main
