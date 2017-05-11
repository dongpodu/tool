package com.elisowell.tool.commons.net;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * author duyisong
 * 2017/5/4.
 */
@Data
@Slf4j
public class FTPTest {
    private String host = "123.59.155.238";
    private int port=21;
    private String username="pubimg";
    private String password="2wsx3EDC";
    private FTPClient ftpClient = new FTPClient();


    public void upload(String localFilePath,String remoteFileName) throws IOException {
        ftpClient.connect(host, port);
        ftpClient.login(username, password);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        File firstLocalFile = new File(localFilePath);
        InputStream inputStream = new FileInputStream(firstLocalFile);
        System.out.println("Start uploading file");
        boolean done = ftpClient.storeFile(remoteFileName, inputStream);
        inputStream.close();
        if (done) {
            System.out.println("The file is uploaded successfully.");
        }
        ftpClient.logout();
        ftpClient.disconnect();
    }

    public String upload(InputStream inputStream,String remotePath) {
        String url = null;
        try {
            if(remotePath.startsWith("/")){
                remotePath = remotePath.substring(1,remotePath.length());
            }
            BufferedInputStream stream = new BufferedInputStream(inputStream);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();
            ftpClient.connect(host, port);
            if(ftpClient.login(username, password)){
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                boolean success = false;
                String path = remotePath;
                if (!ftpClient.changeWorkingDirectory(path)) {
                    String[] dirs = path.split("/");
                    String tempPath = "";
                    for (int i=0;i<dirs.length;i++) {
                        if (null == dirs[i] || "".equals(dirs[i])) continue;
                        if(i==dirs.length-1){
                            success = ftpClient.storeFile(remotePath, stream);
                        }else{
                            //如果目录不存在创建目录
                            tempPath += "/" + dirs[i];
                            if (!ftpClient.changeWorkingDirectory(tempPath)) {
                                ftpClient.makeDirectory(tempPath);
                            }
                        }
                    }
                }
                System.out.println("Start uploading file");
                ftpClient.logout();
                ftpClient.disconnect();
                stream.close();
                if(success){
                    url = remotePath;
                }
            }else{
                System.err.println("账号密码错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static void main(String[] args) throws IOException {
        FTPTest ftp = new FTPTest();
        ftp.upload("E:\\data\\licai\\logs\\kzfinance-front.log","kzfinance-front.log");
    }
}
