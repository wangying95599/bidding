package org.quetzaco.archives.application.biz;

import org.quetzaco.archives.model.FlowNodes;
import org.quetzaco.archives.model.User;

import java.util.List;
import java.util.Map;

public interface FlowNodesService {

    //根据 用户id(assignId)  和flowId ,assignBy获得 flowNode 对象
    List<FlowNodes> getNodesByFlowAndUser(Long FlowId, Long usrId);

    List<Map> getFlowStatus(Long flowId);


}
