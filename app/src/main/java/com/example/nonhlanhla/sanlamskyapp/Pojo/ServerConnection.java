package com.example.nonhlanhla.sanlamskyapp.Pojo;

import android.os.Build;
import android.support.annotation.RequiresApi;


import com.example.nonhlanhla.sanlamskyapp.Activities.Mtn;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ServerConnection implements Runnable {


    //SERVER
    private static Socket socket;
    private static PrintWriter printWriter;
    private static InputStream inputStream;
    private final String characterEncoding = "UTF-8";
    Thread t;
    private static final Logger logger = Logger.getLogger(Mtn.class.getName());

    @Override
    public void run() {
/**
 * Initializes Server Connection
 */

        try {

            //Opens the connection to the host and port number
            logger.info("Sockets connections");
            Socket socketConnection = new Socket("196.31.118.146", 3110);
            OutputStream os = socketConnection.getOutputStream();
            DataInputStream is = new DataInputStream(socketConnection.getInputStream());

            /**
             * Checks if there is a connection
             */

            if (socketConnection.isConnected()) {
                logger.info("Connected");

            }
            if (!socketConnection.isConnected()) {
                logger.info("Not connected");
            }


            /**
             * Closes Connection
             */
            os.close();
            is.close();
            socketConnection.close();
        } catch (Exception e) {
            System.err.println("Exception:  " + e);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String sendData(String msg, int length, DataInputStream is, OutputStream os) throws IOException {

        byte[] vTestArray = new byte[2];
        vTestArray[0] = Byte.parseByte(Integer.toHexString(0), 16);
        vTestArray[1] = Byte.parseByte(Integer.toHexString(length + 2), 16);
        byte[] vFuntion = msg.getBytes();
        byte[] vSend = new byte[vTestArray.length + vFuntion.length];

        System.arraycopy(vTestArray, 0, vSend, 0, vTestArray.length);
        System.arraycopy(vFuntion, 0, vSend, vTestArray.length, vFuntion.length);


//        //writes command to server
        os.write(vFuntion);
        os.flush();


        //reads the response
        byte[] data = new byte[2];
        is.read(data, 0, data.length);

        int vByte1 = data[0];// Length Byte
        int vByte2 = data[1];// Length Byte

        //Checks length of message
        if (vByte1 < 0) {
            vByte1 = vByte1 + 256;
        }
        if (vByte2 < 1) {
            vByte2 = vByte2 + 256;
        }
        vByte1 = vByte1 * 256;
        vByte2 += vByte1;

        //Decodes the response and prints it out
        byte[] vMessageDecode = new byte[vByte2 - 2];
        is.read(vMessageDecode, 0, vMessageDecode.length);
        String vEncStringFromServer = new String(vMessageDecode, StandardCharsets.UTF_8);
        return vEncStringFromServer;
    }
}


//import android.os.Build;
//        import android.support.annotation.RequiresApi;
//
//
//        import com.example.nonhlanhla.sanlamskyapp.Activities.Mtn;
//
//        import java.io.DataInputStream;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.io.OutputStream;
//        import java.io.PrintWriter;
//        import java.net.Socket;
//        import java.nio.charset.StandardCharsets;
//        import java.util.logging.Logger;
//
//public class ServerConnection implements Runnable {
//
//
//    //SERVER
//    private static Socket socket;
//    private static PrintWriter printWriter;
//    private static InputStream inputStream;
//    private final String characterEncoding = "UTF-8";
//    Thread t;
//    private static final Logger logger = Logger.getLogger(Mtn.class.getName());
//
//    @Override
//    public void run() {
///**
// * Initializes Server Connection
// */
//
//        try {
//
//            //Opens the connection to the host and port number
//            logger.info("Sockets connections");
//            Socket socketConnection = new Socket("196.31.118.146", 3110);
//            OutputStream os = socketConnection.getOutputStream();
//            DataInputStream is = new DataInputStream(socketConnection.getInputStream());
//
//            /**
//             * Checks if there is a connection
//             */
//
//            if (socketConnection.isConnected()) {
//                logger.info("Connected");
//
//            }
//            if (!socketConnection.isConnected()) {
//                logger.info("Not connected");
//            }
//
//
//            /**
//             * Closes Connection
//             */
//            os.close();
//            is.close();
//            socketConnection.close();
//        } catch (Exception e) {
//            System.err.println("Exception:  " + e);
//        }
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public String sendData(String msg, int length, DataInputStream is, OutputStream os) throws IOException {
//
//        byte[] vTestArray = new byte[2];
//        vTestArray[0] = Byte.parseByte(Integer.toHexString(0), 16);
//        vTestArray[1] = Byte.parseByte(Integer.toHexString(length + 2), 16);
//        byte[] vFuntion = msg.getBytes();
//        byte[] vSend = new byte[vTestArray.length + vFuntion.length];
//
//        System.arraycopy(vTestArray, 0, vSend, 0, vTestArray.length);
//        System.arraycopy(vFuntion, 0, vSend, vTestArray.length, vFuntion.length);
//
//
////        //writes command to server
//        os.write(vSend);
//        os.flush();
//
//
//        //reads the response
//        byte[] data = new byte[2];
//        is.read(data, 0, data.length);
//
//        int vByte1 = data[0];// Length Byte
//        int vByte2 = data[1];// Length Byte
//
//        //Checks length of message
//        if (vByte1 < 0) {
//            vByte1 = vByte1 + 256;
//        }
//        if (vByte2 < 1) {
//            vByte2 = vByte2 + 256;
//        }
//        vByte1 = vByte1 * 256;
//        vByte2 += vByte1;
//
//        //Decodes the response and prints it out
//        byte[] vMessageDecode = new byte[vByte2 - 2];
//        is.read(vMessageDecode, 0, vMessageDecode.length);
//        String vEncStringFromServer = new String(vMessageDecode, StandardCharsets.UTF_8);
//        return vEncStringFromServer;
//    }
//
//
//
//}