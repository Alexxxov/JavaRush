package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[1];
        String fileOutputName = args[2];
        try {
            crypt(fileName, fileOutputName);
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public static void crypt(String f1, String f2) throws IOException
    {
        FileInputStream in = new FileInputStream(f1);
        FileOutputStream out = new FileOutputStream(f2);
        while (in.available() > 0) {
            int data = in.read();
            out.write(data^5);
        }
        in.close();
        out.close();
    }

//        String fileNameIn = args[1];
//        String fileNameOut = args[2];
//        switch (args[0])
//        {
//            case "-e":
//            {
//                encryptFile(fileNameIn,fileNameOut);
//                break;
//            }
//            case "-d":
//            {
//                decryptFile(fileNameIn,fileNameOut);
//                break;
//            }
//
//        }
//
//    }
//
//    public static void encryptFile(String fromFile, String intoFile) throws Exception
//    {
//        FileInputStream fileInputStream = new FileInputStream(fromFile);
//        FileOutputStream fileOutputStream = new FileOutputStream(intoFile);
//        byte[] input = new byte[fileInputStream.available()];
//        fileInputStream.read(input);
//
//        byte[] keyBytes = {40,41,42,43,0,1,2,3};
//        byte[] ivBytes = {50,51,52,53,10,11,12,13} ;
//        SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
//        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
//        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//
//        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
//        byte[] encrypted= new byte[cipher.getOutputSize(input.length)];
//        int enc_len = cipher.update(input, 0, input.length, encrypted, 0);
//        cipher.doFinal(encrypted, enc_len);
//
//        fileOutputStream.write(encrypted);
//
//        fileInputStream.close();
//        fileOutputStream.close();
//
//
//    }
//
//    public static void decryptFile(String fromFile, String intoFile) throws Exception
//    {
//        FileInputStream fileInputStream = new FileInputStream(fromFile);
//        FileOutputStream fileOutputStream = new FileOutputStream(intoFile);
//        //TO-DO нужно по байтово читать а не куском иначе OutOfMemoryException при файле овер 3ГБ
//        byte[] input = new byte[fileInputStream.available()];
//        fileInputStream.read(input);
//
//        byte[] keyBytes = {40,41,42,43,0,1,2,3};
//        byte[] ivBytes = {50,51,52,53,10,11,12,13};
//        SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
//        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
//        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//
//        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
//        byte[] decrypted = new byte[cipher.getOutputSize(input.length)];
//        int dec_len = cipher.update(input, 0, input.length, decrypted, 0);
//        cipher.doFinal(decrypted, dec_len);
//
//        fileOutputStream.write(decrypted);
//
//        fileInputStream.close();
//        fileOutputStream.close();
//
//
//    }
}
