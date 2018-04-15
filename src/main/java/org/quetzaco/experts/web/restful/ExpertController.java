package org.quetzaco.experts.web.restful;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.enums.RecordFlag;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.util.config.ExpertsProperties;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 *
 */
@RestController
public class ExpertController extends BaseRestContoller {

	@Autowired
	ExpertService expertService;
	
	@Autowired
	ExpertsProperties expertsProperties;

	@RequestMapping(value = "/expert/search/{type}/{value}", method = RequestMethod.GET)
	HttpEntity<APIEntity<List<Udexpert>>> getExpertList(@PathVariable String type, @PathVariable String value) {

		Udexpert expert = new Udexpert();
		if ("name".equals(type)) {
			expert.setName(value);
		} else if ("phone".equals(type)) {
			expert.setPhone(value);
		} else if ("company".equals(type)) {
			expert.setCompany(value);
		}

		return buildEntity(APIEntity.create(expertService.selectByExample(expert)), HttpStatus.OK);
	}

	@RequestMapping(value = "expert", method = RequestMethod.POST)
	public HttpEntity<APIEntity> create(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
			@RequestBody Udexpert expert) {
		expert.setRecordFlag(RecordFlag.CREATE.getValue());
		Udexpert created = expertService.createExpert(expert);
		return buildEntity(APIEntity.create(created), HttpStatus.OK);
	}

	@RequestMapping(value = "expert/all", method = RequestMethod.GET)
	public HttpEntity<APIEntity> getAll(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user) {
		Udexpert example = new Udexpert();
		example.setRecordFlag(RecordFlag.CREATE.getValue());
		List<Udexpert> all = expertService.selectByExample(example);
		return buildEntity(APIEntity.create(all), HttpStatus.OK);
	}

	@RequestMapping(value = "expert/{id}", method = RequestMethod.GET)
	public HttpEntity<APIEntity> getExpertById(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
			@RequestParam Integer id) {
		Udexpert expert = expertService.getExpert(id);
		return buildEntity(APIEntity.create(expert), HttpStatus.OK);
	}

	@RequestMapping(value = "expert", method = RequestMethod.PUT)
	public HttpEntity<APIEntity> updateProject(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
			@RequestBody Udexpert expert) {
		Udexpert updated = expert;
		try {
			updated = expertService.updateExpert(expert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buildEntity(APIEntity.create(updated), HttpStatus.OK);
	}

	@RequestMapping(value = "expert", method = RequestMethod.DELETE)
	public HttpEntity<APIEntity> deleteExperts(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
			@RequestBody List<Integer> ids) {
		for (Integer id : ids) {
			expertService.deleteExpert(id);
		}
		return buildEntity(APIEntity.create(null), HttpStatus.OK);
	}
	 
	@RequestMapping("/fileUpload/expert")
	// @ResponseBody
	public HttpEntity<APIEntity<String>> upload(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {


		Calendar now = Calendar.getInstance();
		String ymd = now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/"
				+ now.get(Calendar.DAY_OF_MONTH);
		String reserveLocation = expertsProperties.getFileStorage() + "/" + ymd;
		File reserveLocationFile = new File(reserveLocation);
		if (!reserveLocationFile.exists()) {
			reserveLocationFile.mkdirs();
		}
		// String docId = request.getParameter("docId");
		String fileType = request.getParameter("fileType");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 新建文件

		// 判断 request 是否有文件上传,即多部分请求
		// multipartResolver.setDefaultEncoding("utf-8");
		// LOGGER.debug("------------------" + multipartResolver.isMultipart(request));
		if (multipartResolver.isMultipart(request)) {

			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名

			Map<String, MultipartFile> map = multiRequest.getFileMap();

			for (MultipartFile file : map.values()) {

				// 记录上传过程起始时的时间，用来计算上传时间
				long pre = System.currentTimeMillis();

				if (file != null) {
					// 取得当前上传文件的文件名称
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					// 重命名上传后的文件名
					String fileName = file.getOriginalFilename();
					String suffixName = fileName.substring(fileName.lastIndexOf("."));
					// 定义上传路径
					String fileId = UUID.randomUUID().toString();
					String path = reserveLocation + "/" + fileId + suffixName;
					String location = ymd + "/" + fileId + suffixName;
					File localFile = new File(path);
					file.transferTo(localFile);

				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
				
				//TODO 读取excel信息
			}

		}
		return buildEntity(APIEntity.create(null), HttpStatus.ACCEPTED);
	}

}
