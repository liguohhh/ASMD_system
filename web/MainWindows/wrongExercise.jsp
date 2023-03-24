<%@ page contentType="text/html;charset=UTF-8"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/MainWindows/";
%>
<!doctype html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>A-S-D-M</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href=<%=basePath+"bootstrap-3.4.1-dist/css/bootstrap.min.css"%>> <!-- integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous"-->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link rel="stylesheet href=<%=basePath+"bootstrap-3.4.1-dist/css/ie10-viewport-bug-workaround.css"%>">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href=<%=basePath+"bootstrap-3.4.1-dist/css/dashboard.css"%>>

</head>

<body style="padding-top: 70px;">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src=<%= basePath+"bootstrap-3.4.1-dist/js/jquery-1.12.4.min.js"%>></script> <%--  integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"   --%>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src=<%= basePath+"bootstrap-3.4.1-dist/js/bootstrap.min.js"%>></script><!-- integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"-->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                <!-- 此处添加点击返回主页面 -->
                <a class="navbar-brand" href="#">项目名称</a>
            </div>
            <div id="navber" class="navbar-collapse collapse">
                <p class="navbar-text">欢迎使用做题系统</p>
                <!-- 退出登录按钮添加退出逻辑 -->
                <button type="button" class="btn btn-danger navbar-btn navbar-right">Sign out</button>
            </div>
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li class="active">
                        <a href=<%=basePath+"home.jsp"%> >首页</a>
                    </li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li>
                        <a href=<%=basePath+"exam.jsp"%>>做题</a>
                    </li>
                    <li>
                        <a href=<%=basePath+"wrongExercise.jsp"%>>错题记录</a>
                    </li>
                    <li>
                        <a href="#">待开发功能3</a>
                    </li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li>
                        <a href="#">待开发功能4</a>
                    </li>
                    <li>
                        <a href="#">待开发功能5</a>
                    </li>

                </ul>
            </div>

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="page-header">错题记录</h1>
                <div class="row placeholders">
                    <table class="table table-bordered">
                        <thead>
                            <th>#</th>
                            <th>你的答案</th>
                            <th>正确答案</th>
                        </thead>
                        <tbody>
                            <!-- 这里使用jsp，循环写入错题 -->
                            <tr>
                                <td>1. </td>
                                <td>1+1=1</td>
                                <td>1+1=2</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>



</body>

</html>