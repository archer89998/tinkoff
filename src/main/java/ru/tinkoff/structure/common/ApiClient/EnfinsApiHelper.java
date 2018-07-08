package ru.tinkoff.structure.common.ApiClient;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class EnfinsApiHelper extends AbstractApiHelper {


    public EnfinsApiHelper(){
        super();
    }

    public String getEnfinsUrlWithBillByParameter(final String ident, final String ident_value, final String secret_key, final String secret_key_value, final String currency, final String currency_value, final String amount, final String amount_value, final String description, final String description_value, final String m_order, final String m_order_value, final String payeer, final String payeer_value) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        MultivaluedMap<String, String> data =new MultivaluedMapImpl();
        data.add(ident,ident_value);
        data.add(currency,currency_value);
        data.add(amount,amount_value);
        data.add(description,description_value);
        data.add(m_order,m_order_value);
        data.add(payeer,payeer_value);
        return get(data, secret_key, secret_key_value);
    }
}
