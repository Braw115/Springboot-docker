package com.pitaka.www.utils;



import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class FileUploadUtils {

    private static final String IMAGE_URL = "C:\\web\\images";
    //private static final String FIRMWARE_URL = "E:\\file\\";
    //线上固件文件路径
    private static final String FIRMWARE_URL = "/data/firmware/";
    private static final Integer FILE_SIZE = 5024;
    private static final String stringArray[] = {"jpg", "gpe", "png", "gif", "psd", "jpeg"};

    /**
     * 单文件上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static String upload(MultipartFile file) throws Exception {
        String path = null; //自定义文件名称
        String contentType = file.getContentType(); //获取文件类型
//        if (file.isEmpty()) {
//            throw new CommException(CommonEnum.FILE_NOT_NULL);
//        }
       /* for (int i=0;i<stringArray.length;i++){
            if (!contentType.equals(stringArray[i])){
                throw new CommException(CommonEnum.FILE_FORMAT_EEOR);
            }
        }*/
        String uuid = UUIDUtil.getUniqueIdByUUId().replaceAll("-", "");
        String imageName = contentType.substring(contentType.indexOf("/") + 1);
        path = "/" + uuid + "." + imageName;
        file.transferTo(new File(IMAGE_URL + path));
        return path;
    }

    public static String uploadFirmware(MultipartFile file, String name) throws Exception {

        String contentType = file.getContentType(); //获取文件类型
//        if (file.isEmpty()) {
//            throw new CommException(CommonEnum.FILE_NOT_NULL);
//        }

        String suffixName = contentType.substring(contentType.indexOf("/") + 1);
        String path = FIRMWARE_URL + name;
        file.transferTo(new File(path));
        return path;
    }


    /**
     * 多文件上传
     *
     * @param files
     * @return
     * @throws Exception
     */
    public static String fileUpload( List<MultipartFile> files) throws Exception {

        MultipartFile file = null;
        BufferedOutputStream stream = null;
        String path = null;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            if (!file.isEmpty()) {
                String contentType = file.getContentType(); //获取文件类型
                String uuid = UUIDUtil.getUniqueIdByUUId().replaceAll("-", "");
                String imageName = contentType.substring(contentType.indexOf("/") + 1);
                path = "/" + uuid + "." + imageName;
                file.transferTo(new File(IMAGE_URL + path));
                buffer.append(path).append(",");
            }
        }
        String filePath = buffer.toString();
        return filePath;

    }

    /**
     * 单个文件删除
     *
     * @param imgeName
     * @throws Exception
     */
    @Async
    public void deleteFile(String imgeName) throws Exception {
        File file = new File(IMAGE_URL + imgeName);
//        if (!file.exists()) {
//            throw new CommException(CommonEnum.FILE_NOT_EXISTS);
//        }
        file.delete();
    }

    /**
     * 多文件删除
     *
     * @param imgeName
     * @throws Exception
     */
    @Async
    public void deleteFiles(String imgeName) throws Exception {
        List<String> list = new ArrayList<String>();
        String[] strings = imgeName.split(",");
        list = Arrays.asList(strings);
        for (int i = 0; i < list.size(); i++) {
            File file = new File(IMAGE_URL + list.get(i));
            file.delete();
        }

    }


}
