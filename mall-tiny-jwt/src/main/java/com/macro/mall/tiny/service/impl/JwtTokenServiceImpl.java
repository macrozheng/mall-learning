package com.macro.mall.tiny.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.macro.mall.tiny.domain.PayloadDto;
import com.macro.mall.tiny.exception.JwtExpiredException;
import com.macro.mall.tiny.exception.JwtInvalidException;
import com.macro.mall.tiny.service.JwtTokenService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by macro on 2020/6/22.
 */
@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    @Override
    public String generateTokenByHMAC(String payloadStr, String secret) throws JOSEException {
        //创建JWS头，设置签名算法和类型
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).
                type(JOSEObjectType.JWT)
                .build();
        //将负载信息封装到Payload中
        Payload payload = new Payload(payloadStr);
        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //创建HMAC签名器
        JWSSigner jwsSigner = new MACSigner(secret);
        //签名
        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }

    @Override
    public PayloadDto verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException {
        //从token中解析JWS对象
        JWSObject jwsObject = JWSObject.parse(token);
        //创建HMAC验证器
        JWSVerifier jwsVerifier = new MACVerifier(secret);
        if (!jwsObject.verify(jwsVerifier)) {
            throw new JwtInvalidException("token签名不合法！");
        }
        String payload = jwsObject.getPayload().toString();
        PayloadDto payloadDto = JSONUtil.toBean(payload, PayloadDto.class);
        if (payloadDto.getExp() < new Date().getTime()) {
            throw new JwtExpiredException("token已过期！");
        }
        return payloadDto;
    }

    @Override
    public String generateTokenByRSA(String payloadStr, RSAKey rsaKey) throws JOSEException {
        //创建JWS头，设置签名算法和类型
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .type(JOSEObjectType.JWT)
                .build();
        //将负载信息封装到Payload中
        Payload payload = new Payload(payloadStr);
        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //创建RSA签名器
        JWSSigner jwsSigner = new RSASSASigner(rsaKey, true);
        //签名
        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }

    @Override
    public PayloadDto verifyTokenByRSA(String token, RSAKey rsaKey) throws ParseException, JOSEException {
        //从token中解析JWS对象
        JWSObject jwsObject = JWSObject.parse(token);
        RSAKey publicRsaKey = rsaKey.toPublicJWK();
        //使用RSA公钥创建RSA验证器
        JWSVerifier jwsVerifier = new RSASSAVerifier(publicRsaKey);
        if (!jwsObject.verify(jwsVerifier)) {
            throw new JwtInvalidException("token签名不合法！");
        }
        String payload = jwsObject.getPayload().toString();
        PayloadDto payloadDto = JSONUtil.toBean(payload, PayloadDto.class);
        if (payloadDto.getExp() < new Date().getTime()) {
            throw new JwtExpiredException("token已过期！");
        }
        return payloadDto;
    }

    @Override
    public PayloadDto getDefaultPayloadDto() {
        Date now = new Date();
        Date exp = DateUtil.offsetSecond(now, 60*60);
        return PayloadDto.builder()
                .sub("macro")
                .iat(now.getTime())
                .exp(exp.getTime())
                .jti(UUID.randomUUID().toString())
                .username("macro")
                .authorities(CollUtil.toList("ADMIN"))
                .build();
    }

    @Override
    public RSAKey getDefaultRSAKey() {
        //从classpath下获取RSA秘钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
        //获取RSA公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        //获取RSA私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey).privateKey(privateKey).build();
    }

}
