package org.panda.provider.user;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        // 跳转到 templates 目录下的 uploadimg.html
        return "uploadImg";
    }

    // 处理文件上传
    @RequestMapping(value = "/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*
         * System.out.println("fileName-->" + fileName);
         * System.out.println("getContentType-->" + contentType);
         */
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            uploadFile(file.getBytes(), "E:\\workspaces\\workspace_xuancai_develop_oxygen\\panda\\panda-provider-user\\imgupload\\", fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        // 返回json
        return "uploadimg success:" + fileName;
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
