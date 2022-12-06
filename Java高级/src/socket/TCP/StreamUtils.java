package socket.TCP;

import java.io.*;

/**
 * @time 2022/4/23 13:53 星期六
 */
public class StreamUtils
{
    public static byte[] streamToByteArray(InputStream inputStream) throws Exception
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes)) != -1)
        {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String streamToString(InputStream inputStream) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
        {
            builder.append(line).append("\r\n");
        }
        return builder.toString();
    }
}
