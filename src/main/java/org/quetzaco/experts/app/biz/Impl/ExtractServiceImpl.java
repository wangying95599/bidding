package org.quetzaco.experts.app.biz.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.app.biz.ExtractService;
import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.app.dao.UdexpertMajorMapper;
import org.quetzaco.experts.app.dao.UdexpertMapper;
import org.quetzaco.experts.app.dao.UdmajorMapper;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.app.dao.UdsetmajorMapper;
import org.quetzaco.experts.app.dao.UdsetresultMapper;
import org.quetzaco.experts.app.dao.UdsetwhiteMapper;
import org.quetzaco.experts.enums.ProjectStatus;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetmajor;
import org.quetzaco.experts.model.UdsetmajorExample;
import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.UdsetresultExample;
import org.quetzaco.experts.model.Udsetwhite;
import org.quetzaco.experts.model.UdsetwhiteExample;
import org.quetzaco.experts.util.random.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("extractService")
public class ExtractServiceImpl implements ExtractService {
	
	@Autowired
	UdsetresultMapper resultMapper;
	
	@Autowired
	UdexpertMapper expertMapper;
	
	@Autowired
	UdmajorMapper majorMapper;
	
	@Autowired
	UdsetmajorMapper setmajorMapper;
	
	@Autowired
	UdexpertMajorMapper expertMajorMapper;
	
	@Autowired
	UdsetwhiteMapper whiteMapper;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ExpertService expertService;
	
	@Autowired
	UdprojectsMapper projectMapper;
	
	public List<Udsetresult> getExtractResult(Udset set){
		UdsetresultExample example = new UdsetresultExample();
		example.createCriteria().andProjectIdEqualTo(set.getProjectId());
		return	resultMapper.selectDetailInfo(set.getProjectId());
	}

	
	public void insertExtract(List<Udsetresult> list) {
		if(list !=null && list.size() >0) {
			UdsetresultExample example = new UdsetresultExample ();
			example.createCriteria().andProjectIdEqualTo(list.get(0).getProjectId());
			List resultList = resultMapper.selectByExample(example);
			if(resultList==null ||resultList.size()==0) {
				Udprojects project =new Udprojects();
				project.setId(list.get(0).getProjectId());
				project.setProjectStatus(ProjectStatus.EXTRACTSET.getValue());
				projectMapper.updateByPrimaryKeySelective(project);
			}
		}
		
		for(Udsetresult result:list) {
			resultMapper.insertSelective(result);
		}
		
	}
	
	
	//已确认得名单
	private Set<Integer> getBlackList(Udset set){
		Set<Integer> hashset = new HashSet<Integer>();
		
		return hashset;
	}
	//已确认得名单
	private Set<Integer> getBlackListAgain(Udset set){
		Set<Integer> hashset = new HashSet<Integer>();
		List<Udsetresult> resultList = getExtractResult(set);
		for(Udsetresult result:resultList) {
			if(!"Y".equalsIgnoreCase(result.getConfirmStatus())) {
				hashset.add(result.getExpertId());
			}
		}
		return hashset;
	}
	
	private List<Udsetmajor> getSetmajorList(Udset set){
		/**
		 * 查询 设置要求的专业和对应的人数
		 */
		List<Udsetmajor> setmajorList =  setmajorMapper.selectById(set.getProjectId());
		return setmajorList;
	}
	
	private List<Udsetmajor> getSetmajorListAgain(Udset set){
		/**
		 * 查询 设置要求的专业和对应的人数
		 */
		List<Udsetmajor> setmajorList =  setmajorMapper.selectById(set.getProjectId());
		
		List<Udsetresult> resultList = getExtractResult(set);
		for(Udsetresult result:resultList) {
			if("Y".equalsIgnoreCase(result.getConfirmStatus())) {
				for(Udsetmajor major:setmajorList) {
					if(major.getMajorCode().equals(result.getMajor())) {
						major.setMajorNumber(major.getMajorNumber()-1);
					}
				}
			}
		}
		return setmajorList;
	}
	/**
	 * 
	 */
	@Override
	public List<Udsetresult> extract(Udset set) {
		return extractService(set, getSetmajorList(set),getBlackList(set));
	}
	
	public List<Udsetresult> extractAgain(Udset set) {
		return extractService(set, getSetmajorListAgain(set),getBlackListAgain(set));
	}

	/**
	 * 
	 */
	public List<Udsetresult> extractService(Udset set,List<Udsetmajor> setmajorList, Set<Integer> blackList) {
		/**
		 * 专业 和 抽取专家数量
		 */
		HashMap<String,Long> setmajorMap = new HashMap<String,Long>();
		/**
		 * 专业 和对应的专家列表
		 */
		HashMap<String,List<Udexpert>> mpMap = new HashMap<String,List<Udexpert>>();
		/**
		 * 专业和剩余人数，排序后，哪个 剩余人数少说明哪个紧张，排在前面
		 */
		HashMap<String,Integer> sortMap = new HashMap<String,Integer>();
		/**
		 * 专家和对应的分数。
		 */
		Map<Integer,Integer> expertScoreMap = new HashMap<Integer,Integer>();
		/**
		 * 返回结果，专业 和抽取的 专家列表
		 */
		Map<String,List<Udexpert>> resultMap = new HashMap<String, List<Udexpert>>();
		/**
		 * 所有抽取专家，用于判断重复。
		 */
		Set<Integer> hashset = new HashSet<Integer>();
		/**
		 * 专业 和 抽取专家数量
		 */
		HashMap<String,String> majorCodeNameMap = new HashMap<String,String>();
		
		
		Udprojects project = projectService.getProject(set.getProjectId());
		
		
		/**
		 * 查询 设置要求的专业和对应的人数
		 */
		System.out.println("setmajorList          "+setmajorList);
		
		/**
		 * 查询 设置要求的专业和对应的人数
		 */
		UdsetwhiteExample whiteExample = new UdsetwhiteExample ();
		whiteExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		List<Udsetwhite> whiteList =  whiteMapper.selectByExample(whiteExample);
		List<Udexpert> whiteList2 =  new ArrayList<Udexpert>();
		for(Udsetwhite white:whiteList) {
			Udexpert expert = new Udexpert();
			expert.setExpertId(white.getExpertId());
			List<Udexpert> list = expertService.selectByExample(expert);
			if(list!=null && list.size()==1) {
				expert = list.get(0);
			}
			whiteList2.add(expert);
		}
		
		
		
		for(Udsetmajor setmajor:setmajorList) {
			setmajorMap.put(setmajor.getMajorCode(), setmajor.getMajorNumber());
			majorCodeNameMap.put(setmajor.getMajorCode(), setmajor.getMajorName());
			
			List<Udexpert> expertList =expertMapper.extractExpert(set.getProjectId(), setmajor.getMajorCode()+"%");
			
			sortMap.put(setmajor.getMajorCode(),(int)(expertList.size() - setmajor.getMajorNumber()));
			mpMap.put(setmajor.getMajorCode(), expertList);
			
		}
		
		for (Map.Entry<String, Long> mapping : setmajorMap.entrySet()) {  
			System.out.println("专业：      "+mapping.getKey()+", 抽取的专家数 ："+mapping.getValue()+", 可抽取的专家列表： "+mpMap.get(mapping.getKey()).size());
			System.out.println("专家的列表： "+mpMap.get(mapping.getKey()));
	    }  
		
		sortMapByValue(sortMap);
		
		System.out.println("专业排序后： ");
		for (Map.Entry<String, Integer> mapping : sortMap.entrySet()) {  
			System.out.println("专业：      "+mapping.getKey());
	    }  
		
		
        for (Map.Entry<String, Integer> mapping : sortMap.entrySet()) {  
            System.out.println("开始抽取 专业： "+mapping.getKey());  
            ArrayList<Udexpert> expertList = (ArrayList<Udexpert>) mpMap.get(mapping.getKey());
            
            scoreExpertListByRule(expertList, expertScoreMap, sortMap, mpMap);
          
            for(Udexpert expert:expertList) {
            	if(hashset.contains(expert.getExpertId()) || blackList.contains(expert.getExpertId())) {
            		continue;
            	}
            	List<Udexpert> list = resultMap.get(mapping.getKey());
            	if(list == null) {
            		list = new ArrayList<Udexpert>();
            		resultMap.put(mapping.getKey(), list);
            	}
            	list.add(expert);
            	hashset.add(expert.getExpertId());
            	
            	if(list.size() == setmajorMap.get(mapping.getKey())) {
            		break;
            	}
            }
            
            
        }
        
        System.out.println(" 抽取结果如下：                        ");
        for (Map.Entry<String, List<Udexpert>> mapping : resultMap.entrySet()) {  
            System.out.println(mapping.getKey() + ":" + mapping.getValue());  
        }
        System.out.println(" 随机置换：                        ");
        for(Udexpert white:whiteList2) {
        	if(hashset.contains(white.getExpertId()) || blackList.contains(white.getExpertId())) {
        		continue;
        	}
        	//哪个专家靠后，替换。sortMap key 倒序循环，符合，就去替换。
        	//查询的白名单有所有的专业，然后又包含关系就可以替换。
        	//计算每个人参加了几次，倒序。
        	
    		a:for(UdexpertMajor emajor: white.getMajorList()) {
    			b:for (Map.Entry<String, List<Udexpert>> mapping : resultMap.entrySet()) {  
    				if(emajor.getMajorCode().startsWith(mapping.getKey())) {
    					c:for(Udexpert e:mapping.getValue()){
    						if(!whiteList2.contains(e)) {
    							System.out.println(e.getExpertId() +" replace by " + white.getExpertId());  
    							e.setExpertId(white.getExpertId());
    							break a;
    						}
    					}
    					
    				}
    				
    	            
    			}
    		}
            
        }
        /**
         * 循环列表，不包含，就替换一个。<专家，专业>，进去的出来怎么办，一个属性不能替换。
         */
        List<Udsetresult> resultList = new ArrayList<Udsetresult>();
        for (Map.Entry<String, List<Udexpert>> mapping : resultMap.entrySet()) {  
            System.out.println(mapping.getKey() + ":" + mapping.getValue());  
            for(Udexpert expert:mapping.getValue()) {
	            Udsetresult rs = new Udsetresult();
	            rs.setPurchaseProject(project.getPurchaseProject());
	            rs.setCreatedDt(new Date());
	            rs.setExpertId(expert.getExpertId());
	            rs.setRandomCode(RandomUtil.getRandomValue_DL());
	            rs.setMajor(mapping.getKey());
	            rs.setMajorName(majorCodeNameMap.get(mapping.getKey()));
	            resultList.add(rs);
            }
        }
        
      
        return resultList;
	}
	

	
	private void scoreExpertListByRule(List<Udexpert> expertList, Map<Integer, Integer> expertScoreMap,
			HashMap<String, Integer> sortMap, HashMap<String, List<Udexpert>> mpMap) {
		for (Udexpert expert : expertList) {
			Integer score = expertScoreMap.get(expert.getExpertId());
			if (score == null) {
				score = scoreExpertByRule(expert, sortMap, mpMap);
				expertScoreMap.put(expert.getExpertId(), score);
			}
			expert.setScore(score);
		}
		Collections.sort(expertList, new Comparator<Udexpert>() {
			public int compare(Udexpert m, Udexpert n) {
				return m.getScore() - n.getScore();
			}
		});
	}
	  
	/**
	 * 计算一个专家的分数
	 * @param expert
	 * @param map
	 * @param mpMap
	 */
	private int scoreExpertByRule(Udexpert expert, HashMap<String,Integer> sortMap,HashMap<String,List<Udexpert>> mpMap) {
		int score = 0;
		  for (Map.Entry<String, Integer> mapping : sortMap.entrySet()) {  
	            //System.out.println(mapping.getKey() + ":" + mapping.getValue());  
	            ArrayList<Udexpert> expertList = (ArrayList<Udexpert>) mpMap.get(mapping.getKey());
	            
	            if(expertList.contains(expert)) {
	            	score+=mapping.getValue();
	            }
	        }
		  return score;
	}
	
	
	
	private void sortMapByValue(HashMap<String,Integer> map) {
		//将map.entrySet()转换成list  
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
            //降序排序  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                //return o1.getValue().compareTo(o2.getValue());  
                return o1.getValue().compareTo(o2.getValue());  
            }  
        });  
  
//        for (Map.Entry<String, Integer> mapping : list) {  
//            System.out.println(mapping.getKey() + ":" + mapping.getValue());  
//        }  
	}
	

	

	public void extract1(Udset set) {
		//1 回避-单位
		//2 回避-专家
		//3 冻结-专家		
		//1 指定-区域
		
		//2 指定-专业 每个还有人数限制，如果不够，上面的统计会看到。
		//3 指定-专家
		//还是应该过滤，专业，map(专业-list).每个专业，查出所有自专业。in（所有自专业。）
	
		
		
		/**
		 * 查询 设置要求的专业
		 */
		UdsetmajorExample setmajorExample = new UdsetmajorExample ();
		setmajorExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		List<Udsetmajor> setmajorList =  setmajorMapper.selectByExample(setmajorExample);
		
		int BIDDING_NUMBER=0;
		HashMap<String,Long> setmajorMap = new HashMap<String,Long>();
		for(Udsetmajor setmajor:setmajorList) {
			setmajorMap.put(setmajor.getMajorCode(), setmajor.getMajorNumber());
			BIDDING_NUMBER+=setmajor.getMajorNumber();
			
			List<Udexpert> expertList =expertMapper.extractExpert(set.getProjectId(), setmajor.getMajorCode());
			System.out.println(expertList);
		}
		
		
/*		*//**
		 * 查询所有的 专家和专业的对应关系，过滤条件majorcode,多对多，用map不合适。
		 * 如何选择的majorcode没有包含关系，那么结果依然可能有重复的人，多专业。
		 *//*
		HashMap<String,List<UdexpertMajor>> mpMap = new HashMap<String,List<UdexpertMajor>>();
		for(Udsetmajor setmajor:setmajorList) {
			UdexpertMajorExample expertMajorExample = new UdexpertMajorExample ();
			expertMajorExample.createCriteria().andMajorCodeLike("'"+setmajor.getMajorCode()+"%'");
			List<UdexpertMajor> list = expertMajorMapper.selectByExample(expertMajorExample);

			mpMap.put(setmajor.getMajorCode(), list);
		}*/
		
		/**
		 * 校验白名单 和 设置减法， 列出 要设置的值。 
		 * setMajorMap - white?
		 * setMajorMap-mpMap(不包含就好计算。************，按这个处理，然后将问题给许巍。）目前mpMap没有过滤。减法，不够最多的先补，依次来。白名单是细分的先补。
		 * 所选专业不应该是包含关系如 03和0304 这样不行。 0304和0305才行。太难了，先实现最简单的
		 * 1 只选了一个专业 030401 5个人 共10个人 白名单2个（没有子专业）
		 * 2只选了两个专业 030401 030402 各 5个， 总数各10个，白名单2个（没有自专业）
		 * 3只选了两个专业 030401 030402 各 5个， 总数4，8个，白名单2个（0304）
		 * 4有自专业
		 * 503和0304
		 * 先实现1.
		 */
		
		
		
		/**
		 * 随机逻辑
		 * 1 加入白名单，边界。白名单可能比总人数还多
		 * 2
		 */
		HashMap<Integer,Udexpert> expertMap = new HashMap<Integer,Udexpert>();
		
//		for(Udexpert expert:expertList) {
//			
//			//已经加入map
//			if(expertMap.get(expert.getExpertId()) !=null) {
//				continue;
//			}
//			
//			// 
//			
//			
//			
//			/**
//			 * 两个退出条件 1：map满员 2 各专业满员
//			 * 其中白名单 可能符合各专业，算哪个呢？ 白名单可能比还多
//			 */
//			if(expertMap.size()==BIDDING_NUMBER) {
//				break;
//			}
//			
//			
//		}
//		System.out.println(expertList);
		
	}
}
