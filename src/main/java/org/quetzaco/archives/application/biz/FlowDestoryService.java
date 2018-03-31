package org.quetzaco.archives.application.biz;

import com.github.pagehelper.PageInfo;
import org.quetzaco.archives.model.FlowFormDestory;
import org.quetzaco.archives.model.FlowNodeHistories;
import org.quetzaco.archives.model.User;

import java.util.List;
import java.util.Map;

public interface FlowDestoryService {

  void start(FlowFormDestory flowFormDestory,List<Long> docIds,List<Long> recIds);

  PageInfo selectStartByMeList(User contextUser, int pageNum, int pageSize);

  PageInfo getProcessByMe(Long usrId, Boolean isProcessed, int pageNum, int pageSize);

  FlowFormDestory getFormDetail(FlowFormDestory flowFormDestory);

  FlowFormDestory getFlowHistory(FlowFormDestory flowFormDestory);

  void proccess(FlowFormDestory flowFormDestory, FlowNodeHistories flowNodeHistories);

  void end(FlowFormDestory flowFormDestory, FlowNodeHistories flowNodeHistories);

  Map<String,List<User>> getAskUsers();

  FlowFormDestory getFlowDestroyDetail(FlowFormDestory flowFormDestory);

    List<Map> getDeletedFlow(Long deptId);

  FlowFormDestory getFlowDestroyForRemain(Long flowId);

  FlowFormDestory getFlowDestroyDetail(Long flowId);

  int destroy(Long flowId);

  //void proccess(FlowFormDestory flowFormLending, FlowNodeHistories flowNodeHistories);
}