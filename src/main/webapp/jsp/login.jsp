<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录界面</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
    <h1>${test}login.jsp</h1>
    <form action="#" method="post">
        <input type="text" name="username" id="user">
        <input type="text" name="password" id="pass">
        <button id="btn" type="submit">提交</button>
    </form>
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript">
        $('#btn').on('click',function(){
            username = $('#user').val();
            password = $('#pass').val();
            $.ajax({
                type:'POST',
                url:'',
                data:{
                    'username':username,
                    'password':password
                },
                dataType:'json',
                success:function(data){
                    console.log(data);

                },
                error:function(jqXHR){
                    if(jqXHR.status == 400){

                    }
                }
            })
        })

    </script>
    

</body>
</html>
