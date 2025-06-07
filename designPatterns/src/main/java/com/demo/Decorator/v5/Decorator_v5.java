package com.demo.Decorator.v5;
import java.io.*;

//decorator pattern is used in java.io package
//an  example her is fileinputstream->bufferedinputstream->zipinputstream
//Inputstream is the component interface
//fileinputstream is the concrete component
//filterinputstream is the decorator abstract class
//bufferedinputstream and zipinputstream are the concrete decorators
//we will create decorator that convert uppercase to lowercase.


public class Decorator_v5 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("src/main/java/com/demo/Decorator/v5/test.txt");
            InputStream bufferedInputStream = new BufferedInputStream(inputStream);
            InputStream lowerCaseInputStream = new LowerCaseInputStream(bufferedInputStream);
            int c;
            while ((c = lowerCaseInputStream.read()) != -1) {
                System.out.print((char) c);
            }
            lowerCaseInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}