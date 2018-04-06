//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

var ext_col_cor = [
    {
        field: 'projectId',
        visible: false
    },

    {
        title: '回避单位名称',
        field: 'company',
        align: 'center',
        sortable: true
    }
];

var ext_col_person = [
    {
        field: 'expertId',
        visible: false
    },

    {
        title: '专家姓名',
        field: 'name',
        align: 'center',
        sortable: true
    },
    {
        title: '专家电话',
        field: 'phone',
        align: 'center',
        sortable: true
    }
];
var ext_col = [
    {
        field: 'id',
        visible: false
    },

    {
        title: '项目名称',
        field: 'projectName',
        align: 'center',
        sortable: true
    },
    {
        title: '评审专业',
        field: 'major',
        align: 'center',
        sortable: true
    },
    {
        title: '专家姓名',
        field: 'name',
        align: 'center',
        sortable: true
    },
    {
        title: '随机编码',
        field: 'randomNo',
        align: 'center',
        sortable: true
    },
    {
        title: '抽取时间',
        field: 'date',
        align: 'center',
        sortable: true
    }
];
var ext_col_major_to = [
    {
        field: 'id',
        visible: false
    },


    {
        title: '专业名称',
        field: 'majorCode',
        align: 'center',
        sortable: true
    },
    {
        title: '人数',
        field: 'majorNumber',
        align: 'center'
    }
];

function initExtract() {
	console.log("initExtract");

    //
    $('#ext_table_cor').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: ext_col_cor
    });


    $('#ext_table_person').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: ext_col_person
    });
    $('#ext_table').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        uniqueId: 'id',//唯一的标识
        columns: ext_col
    });
    $('#ext_table_major_to').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: ext_col_major_to

    });
   
    console.log("initExtract.end");
}



$(document).ready(function () {

    initExtract();
});

$('#extractExpert').on('show.bs.modal', function (event) {
    console.log("show.bs.modal");
    console.log(event);
	projectId=123;
    $.axx({
        type:'GET',
        url:"/extractset/get/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
            console.log(models.companyList);
            if(models.companyList){
            	$('#ext_table_cor').bootstrapTable("load", models.companyList);
            }
            if(models.expertList){
            	$('#ext_table_person').bootstrapTable("load", models.expertList);
            }
            if(models.majorList){
            	$('#ext_table_major_to').bootstrapTable("load", models.majorList);
            }
            
            if(models.regionList){
	           
	            $.each(models.regionList,function(i,item){	
	            	$("input[name='extract_region'][value="+item.region+"]").attr("checked","checked");	
	            });
            }
        }
    });	
});





//创建抽取设置
function createExtractSet(assigneeId) {
    var deliver = $('#turnOverForm').serializeJson();
    console.log(deliver);
    var docArray = $("#turnFormDoc").bootstrapTable("getData");
    var docIds = $.map(docArray,function (obj) {
        return obj.id;
    });
    var revArray = $("#turnFormRec").bootstrapTable("getData");
    var revIds = $.map(revArray,function (obj) {
        return obj.id;
    });
    if(docArray.length==0&&revArray.length==0){
        alert("请选择要移交的文件");
        return;
    }

    deliver.docIds = docIds;
    deliver.revIds = revIds;
    deliver.assigneeId = assigneeId;
    var data = {flowFormAssist: deliver, docIds: docIds, revIds: revIds};
    $.axx({
        type:'post',
        url:'/flowFormDelivers',
        data:deliver,
        success:function (json) {
            $("#turnOver").removeClass("hidden").hide().fadeIn(500).siblings().addClass("hidden");
            getTurnOverFromMe1();
        }
    })
}
 