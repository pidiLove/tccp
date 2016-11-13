<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>EasyUI布局</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
     
<script src="<%=request.getContextPath()%>/css/easyui/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/css/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/easyui/easyui.css" rel="stylesheet"ntype="text/css" />
<link href="<%=request.getContextPath()%>/css/easyui/icon.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="<%=request.getContextPath()%>/css/easyui/easyui-lang-zh_CN.js"></script>
     
  </head>
  <body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <!-- 布局中如果不需要south这个面板，那么可以删掉这个div -->   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div> 
    <!-- 布局中如果不需要east这个面板，那么可以删掉这个div -->   
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
    <!-- 布局中如果不需要west这个面板，那么可以删掉这个div -->  
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
    <!--north，south， east，west这几个面板都可以删掉，唯有这个center面板一定不能删掉，否则使用easyui-layout就会出错 --> 
    <div data-options="region:'center',title:'center title',href:'center.html'" style="padding:5px;"></div>  
 </body>  
  
</html>