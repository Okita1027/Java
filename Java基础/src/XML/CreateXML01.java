package XML;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @time 2022/5/12 20:37 星期四
 * 创建XML配置文件
 */
public class CreateXML01 {
    public static void main(String[] args) throws IOException {
        //创建文档对象
        Document document = DocumentHelper.createDocument();
        //创建一个标签
        Element userElement = document.addElement("user");
        //设置根标签
        document.setRootElement(userElement);
        //在根标签中创建username,password标签
        Element usernameElement = userElement.addElement("username");
        Element passwordElement = userElement.addElement("password");
        //为标签赋值
        usernameElement.addText("admin");
        passwordElement.addText("123456");
        OutputFormat outputFormat = new OutputFormat("  ", true);
        FileOutputStream fos = new FileOutputStream("src\\XML\\user.xml");
        XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
        xmlWriter.write(document);
    }
}
