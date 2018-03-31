$(function () {  
    $('#datetimepicker1').datetimepicker({  
         autoclose: true,
       todayBtn: true,
       todayHighlight: true,
       showMeridian: true,
       pickerPosition: "bottom-left",
       language: 'zh-CN',//中文，需要引用zh-CN.js包
        startView: 0,//月视图
        minView: 0//日期时间选择器所能够提供的最精确的时间选择视图
       
    });  
     
});  
