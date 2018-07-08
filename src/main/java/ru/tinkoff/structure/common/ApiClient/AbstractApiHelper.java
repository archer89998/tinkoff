package ru.tinkoff.structure.common.ApiClient;

import com.sun.jersey.api.client.Client;

import javax.ws.rs.core.MultivaluedMap;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.*;

public abstract class AbstractApiHelper {

    private Client enfinsApiClient;
    private String baseEnfinsApiUrl;
    private String CREATE_BILL = "/create_bill";

    protected AbstractApiHelper() {
        this.baseEnfinsApiUrl = "http://192.168.10.103:9000/v1";
        enfinsApiClient = Client.create();
    }

    public String MakeHASH(String data, String secretKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

      return  HmacSha1Signature.calculateRFC2104HMAC(  data,secretKey);
    }

    public String get(MultivaluedMap<String,String> data, final String secret_key, final  String secret_key_value) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        ArrayList<String> params = new ArrayList<String>();

        Iterator<String> it = data.keySet().iterator();

        while(it.hasNext()){
            String key = (String)it.next();
            if (key=="sign"){
                continue;
            }

            params.add(key+"="+data.getFirst(key));
        }
        String sign =MakeHASH(String.join("&",params), secret_key_value);

        data.add("sign", sign);

        return enfinsApiClient.resource(baseEnfinsApiUrl).path(CREATE_BILL).queryParams(data).get(String.class);

    }
}
