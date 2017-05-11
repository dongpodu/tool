package com.elisowell.tool.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

/**
 * author duyisong
 * 2017/4/25.
 */
public class Md5CryptTest {

    public static void main(String [] args){
        System.out.println(Md5Crypt.md5Crypt("9zIJjJv0".getBytes()));
        System.out.println(DigestUtils.getMd5Digest().digest("9zIJjJv0".getBytes()));
    }
}
