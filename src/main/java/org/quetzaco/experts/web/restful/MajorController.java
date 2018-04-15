package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.MajorService;
import org.quetzaco.experts.model.Udmajor;
import org.quetzaco.experts.model.api.APIEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class MajorController extends BaseRestContoller {

	@Autowired
	MajorService majorService;

	@RequestMapping(value = "/major/search/{type}/{value}", method = RequestMethod.GET)
	HttpEntity<APIEntity<List<Udmajor>>> getExpertList(@PathVariable String type, @PathVariable String value) {

		Udmajor major = new Udmajor();
		if ("name".equals(type)) {
			major.setMajorName(value);
		} else if ("code".equals(type)) {
			major.setMajorCode(value);
		}

		return buildEntity(APIEntity.create(majorService.selectByExample(major)), HttpStatus.OK);
	}

	@RequestMapping(value = "/major/tree/{value}", method = RequestMethod.GET)
	HttpEntity<APIEntity<List<Udmajor>>> selectMajorCodeTree(@PathVariable String value) {

		Udmajor major = new Udmajor();
		if ("0".equals(value)) {
			major.setMajorCode(null);
		} else {
			major.setMajorCode(value);
		}
		List<Udmajor> list = majorService.selectMajorCodeTree(major);

		return buildEntity(APIEntity.create(list), HttpStatus.OK);
	}

	// used by expert modal, get expert majors by major codes
	@RequestMapping(value = "/major/codes", method = RequestMethod.POST)
	HttpEntity<APIEntity<List<Udmajor>>> selectMajorByCodeList(@RequestBody List<String> codeList) {
		List<Udmajor> list = majorService.selectMajorByCodeList(codeList);
		return buildEntity(APIEntity.create(list), HttpStatus.OK);
	}
}
