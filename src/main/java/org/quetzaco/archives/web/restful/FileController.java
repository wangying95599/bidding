package org.quetzaco.archives.web.restful;

import org.quetzaco.archives.application.biz.DocumentService;
import org.quetzaco.archives.application.biz.FileService;
import org.quetzaco.archives.application.biz.sync.oa.OADocService;
import org.quetzaco.archives.application.search.elastic.content.FileUtil;
import org.quetzaco.archives.model.api.APIEntity;
import org.quetzaco.archives.util.config.ArchiveProperties;
import org.quetzaco.archives.util.excel.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by deya on 2017/7/14.
 */
@RestController
public class FileController extends BaseRestContoller {

   final  static Logger LOGGER = LoggerFactory.getLogger(FileController.class);
  @RequestMapping("/upload" )
  @ResponseBody
  public String upload(HttpServletRequest request,HttpServletResponse response)throws IllegalStateException, IOException{

	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
	//判断 request 是否有文件上传,即多部分请求
	if(multipartResolver.isMultipart(request)){
	  //转换成多部分request
	  MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
	  //取得request中的所有文件名

	 Map<String,MultipartFile> map = multiRequest.getFileMap();
	  LOGGER.debug("------------------"+map.size());
	 for (MultipartFile file : map.values()){
		//记录上传过程起始时的时间，用来计算上传时间
		long pre =  System.currentTimeMillis();
		//取得上传文件
		LOGGER.debug("------------------"+file);
		if(file != null){
		  //取得当前上传文件的文件名称
		  //如果名称不为“”,说明该文件存在，否则说明该文件不存在
			String fileName = "demoUpload" + file.getOriginalFilename();
		  if(fileName.trim() !=""){
			System.out.println(fileName);
			//重命名上传后的文件名
			//定义上传路径
			String path = "D:/" + fileName;
			File localFile = new File(path);
			file.transferTo(localFile);
		  }
		}
		//记录上传该文件后的时间
		int finaltime = (int) System.currentTimeMillis();
		System.out.println(finaltime - pre);
	  }

	}
	return "success";
  }


  //文件下载相关代码
  @RequestMapping("/download")
  public String downloadFile(org.apache.catalina.servlet4preview.http.HttpServletRequest request, HttpServletResponse response){
	String fileName = "FileUploadTests.java";
	if (fileName != null) {
	  //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
	  String realPath = request.getServletContext().getRealPath(
		  "//WEB-INF//");
	  File file = new File(realPath, fileName);
	  if (file.exists()) {
		response.setContentType("application/force-download");// 设置强制下载不打开
		response.addHeader("Content-Disposition",
			"attachment;fileName=" +  fileName);// 设置文件名
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
		  fis = new FileInputStream(file);
		  bis = new BufferedInputStream(fis);
		  OutputStream os = response.getOutputStream();
		  int i = bis.read(buffer);
		  while (i != -1) {
			os.write(buffer, 0, i);
			i = bis.read(buffer);
		  }
		  System.out.println("success");
		} catch (Exception e) {
		  e.printStackTrace();
		} finally {
		  if (bis != null) {
			try {
			  bis.close();
			} catch (IOException e) {
			  e.printStackTrace();
			}
		  }
		  if (fis != null) {
			try {
			  fis.close();
			} catch (IOException e) {
			  e.printStackTrace();
			}
		  }
		}
	  }
	}
	return null;
  }

    /*public HttpEntity<APIEntity> downloadByReelType(HttpServletRequest request, HttpServletResponse response){

    }*/
    @Autowired
    FileService fileService;
    @Autowired
    ArchiveProperties archiveProperties;
    @Autowired
	OADocService oaDocService;

    @RequestMapping("/files/pageCount/{fileId}")
    public HttpEntity<APIEntity> getPageCountById(@PathVariable("fileId") String fileId) {
    	Map map = new HashMap();
    	String reg = "^[0-9]*$";
    	if(fileId.trim().matches(reg)){
			map = fileService.getFilesById(Long.valueOf(fileId));
		}else {
			map = fileService.getFilesByFileId(fileId);
		}
        String location = archiveProperties.getFileStorage() + "/" + map.remove("location");
        int pageCount = FileUtils.getNumberOfPagesOfSWF(location);
        if(pageCount==-1){
			oaDocService.copyAndTranslateFile((Long) map.get("id"));
			pageCount = FileUtils.getNumberOfPagesOfSWF(location);
		}
        map.put("pageCount", pageCount);
        return buildEntity(APIEntity.create(map), HttpStatus.OK);
    }

    /*@RequestMapping("/files/pageStr/fileId")
	public HttpEntity<APIEntity> getPageCountByFileId(@PathVariable("fileId") String fileId) {
		Map map = fileService.getFilesByFileId(fileId);
		String location = archiveProperties.getFileStorage() + "/" + map.remove("location");
		int pageCount = FileUtils.getNumberOfPagesOfSWF(location);
		map.put("pageCount", pageCount);
		return buildEntity(APIEntity.create(map), HttpStatus.OK);
	}*/
}
