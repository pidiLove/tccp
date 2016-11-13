<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>

    <!-- Basic Page Needs
  ================================================== -->
    <meta charset="utf-8">
    <title>未来影院管理系统</title>
    
    <!-- Mobile Specific Metas
  ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS
  ================================================== -->
  <link href="<%=request.getContextPath()%>/css/all.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/zerogrid.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/responsive.css">
    <script src="<%=request.getContextPath()%>/css/js/css3-mediaqueries.js"></script>
    <script src="<%=request.getContextPath()%>/css/js/jquery.min.js"></script>
    <link href="<%=request.getContextPath()%>/css/node_modules/bootstrap/dist/css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/css/node_modules/jquery/dist/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/css/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/css/js/manage-studio.js">
    </script>
   
   
</head>
<body id="add-0">

<header>
   
    <div class="wrap-header zerogrid">
        <div class="row">
            <div id="menu">
                <nav>
                    <div class="wrap-nav">
                       <ul>
                         <li class="active"><a href="home.html">主页</a></li>
                         <li><a href="studio.html">影厅管理</a></li>
                         <li><a href="movie.html">影片管理</a></li>
                         <li><a href="employee.html">员工管理</a></li>
                         <li><a href="#">业务分析</a></li>
                         <li><a href="#">帮助</a></li>
                       </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>

<form action="" id="mainForm" method="post">
<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">影厅管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="#">删 除</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">开始厅号：</td>
								<td>
									<input type="text" class="allInput" value=""/>
								</td>
								<td width="90" align="right">结束厅号：</td>
								<td>
									<input type="text" class="allInput" value=""/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all"/></th>
								    <th>演出厅号</th>
								    <th>演出厅名称</th>
								    <th>演出厅行号</th>
								    <th>演出厅列号</th>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>一号演出厅</td>
									<td>10</td>
									<td>10</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
								<tr style="background-color:#ECF6EE;">
									<td><input type="checkbox" /></td>
									<td>2</td>
									<td>二号演出厅</td>
									<td>10</td>
									<td>10</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>3</td>
									<td>演示值1</td>
									<td>演示值2</td>
									<td>演示值2</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
								<tr style="background-color:#ECF6EE;">
									<td><input type="checkbox" /></td>
									<td>4</td>
									<td>演示值1</td>
									<td>演示值2</td>
									<td>演示值2</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
			</form>
   
<footer>
  
    <div class="bottom-footer">
        <div class="wrap-bottom ">
            <div class="copyright">
                <p>2016.西安-未来影院管理系统</p>
            </div>
        </div>
    </div>
</footer>



</body>

</html>