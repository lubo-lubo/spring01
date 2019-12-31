<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/24
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/statics/jquery-1.12.4.js"></script>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>序号</td>
                <td>用户名</td>
                <td>性别</td>
                <td>生日</td>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
    <button id="next">下一页</button><br/>
    <button id="last">上一页</button>
</body>
<script>
    $(function () {
        var pageNum=1;
        $.ajax({
            url:"/user/show",
            type:"get",
            // data:{pageNum:1},
            dataType:"json",
            success:function (result) {
                var str = "";
                $.each(result,function (index,value) {
                    str += "<tr><td>"+(index+1)+"</td><td>"+value.userName+"</td>" +
                        "<td>"+value.gender+"</td><td>"+value.birthday+"</td></tr>"
                })
                $("tbody").html(str);
            }
        })
        $("#next").click(function (){
            pageNum++;
            page(pageNum);
        });
        $("#last").click(function () {
            pageNum--;
            page(pageNum);
        });
        function page(x){
            $.ajax({
                url:"/user/show",
                type:"get",
                data:{pageNum:x},
                dataType:"json",
                success:function (result) {
                    var str = "";
                    $.each(result,function (index,value) {
                        str += "<tr><td>"+(index+1)+"</td><td>"+value.userName+"</td>" +
                            "<td>"+value.gender+"</td><td>"+value.birthday+"</td></tr>"
                    })
                    $("tbody").html(str);
                }
            })
        }
    })
</script>
</html>
