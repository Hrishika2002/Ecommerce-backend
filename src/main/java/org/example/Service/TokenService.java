package org.example.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {
    public static final String token_sign="qwertyuiopasdfghjklmnbvcxz";
    public String createTokenFunction(Integer id){
        try{
            Algorithm algoObject=Algorithm.HMAC256(token_sign);
            String token= JWT.
                    create().
                    withClaim("userId",id.toString()).
                    withClaim("createdAt",new Date()).sign(algoObject);
            return token;
        }
        catch(UnsupportedEncodingException | JWTCreationException e){
            e.printStackTrace();
        }
        return null;
    }


}
