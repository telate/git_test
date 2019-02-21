<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

    <%--把js引入到jsp中--%>
    <script src="js/jquery.min.js"></script>

    <script>
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"user/testAjax",
                    type:"post",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123","age":18}',
                    dataType:"json",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            });
        });
    </script>
</head>
<body>

<h1>response</h1>
<a href="user/testString">testString</a>

<br/>

<a href="user/testVoid">testVoid</a>

<br/>

<a href="/user/testModelAndView">testModelAndView</a>

<br/>

<button id="btn">发送ajax的请求</button>


</body>
</html>