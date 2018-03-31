package org.quetzaco.archives.application.search.elastic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.quetzaco.archives.model.Documents;
import org.quetzaco.archives.qarchives.QarchivesApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.searchbox.client.JestResult;
import io.searchbox.core.SearchResult.Hit;

/**
 * @Description Created by dong on 2017/12/13.
 */
public class ElasticSearchDaoTest extends QarchivesApplicationTests {

  @Autowired
  ElasticSearchDao elasticSearchDao;
  @Test
  public void createIndex() throws Exception {
    Documents documents = new Documents();
    documents.setId(198l);
    documents.setFileName("明天");
    JestResult index = elasticSearchDao.createIndex(documents, "archive", "document");
    assertEquals(true,index.isSucceeded());
  }
  protected Gson gson = new GsonBuilder()
          .create();
  @Test
  public void updateIndex() throws Exception {
    Documents documents = new Documents();
    documents.setId(188l);
    documents.setFileName("你1好188 中国");
    Map<String,Documents> map = new HashMap();
    map.put("doc",documents);
    String t = gson.toJson(map);
    JestResult index = elasticSearchDao.updateDocument(t, "archive", "document", ""+188l);
    System.out.println("index                       "+index);
    assertEquals(true,index.isSucceeded());
  }
  
  @Test
  public void searchIndex() throws Exception {
    Documents documents = new Documents();
    documents.setId(2l);
    List<Hit<Documents, Void>> index = elasticSearchDao.searchAll("archive", documents);
    for(Hit<Documents,Void> hit:index) {
    	System.out.println("hit              "+hit.source.getId());
    	System.out.println("hit              "+hit.index);
    	System.out.println("hit              "+hit.type);
    	System.out.println("hit              "+hit.highlight);

    	
    }
    index = elasticSearchDao.createSearch("你好 中国 明天", "archive", documents, "fileName");
    for(Hit<Documents,Void> hit:index) {
    	System.out.println("hit2              "+hit.source.getId());
    	System.out.println("hit              "+hit.index);
    	System.out.println("hit              "+hit.type);
    	System.out.println("hit              "+hit.source.getFileName());
    	System.out.println("hit              "+hit.score);
    	System.out.println("hit              "+hit.highlight);
    	
    }
  }
  
  @Test
  public void deleteIndex() throws Exception{
	  
	  JestResult js = elasticSearchDao.deleteDocument("archive", "document", "AWBPKSlzsdK0h10QBNyn");
	  System.out.println(js.getSourceAsString());
	  
	  elasticSearchDao.deleteIndex("document");
  }
  
  @Test
  public void deleteIndexByType() throws Exception{
	  elasticSearchDao.deleteIndex("document");
  }
  
  public static void main(String[] args) {
	  Documents documents = new Documents();
	    documents.setId(188l);
	    documents.setFileName("你1好188");
	    
	    Map<String,Documents> list = new HashMap();
	    list.put("doc",documents);
	    
	Gson son = new GsonBuilder().create();
	String str= son.toJson(documents);
	System.out.println(str);
	str= son.toJson(list);
	System.out.println(str);
}
}