<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/24
  Time: 17:11
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
            <td>出生日期</td>
        </tr>
        </thead>
        <tbody></tbody>
        <button id="next">下一页</button>
        <button id="last">上一页</button>
    </table>
    <script>
        $(function(){
            var pageNum=1;
            var maxPage;
            $("#next").click(function (){
                pageNum++;
                if(pageNum>maxPage){
                    pageNum=maxPage;
                }
                page(pageNum);
            });
            $("#last").click(function (){
                pageNum--;
                if(pageNum<1){
                    pageNum=1;
                }
                page(pageNum);
            });
            function page(x){
                $.ajax({
                    url:"/user/change",
                    type:"get",
                    data:{pageNum:x},
                    dataType:"json",
                    success:function(result){
                        var str="";
                        $.each(result.records,function (index,value) {
                            str+="<tr><td>"+(index+1)+"</td><td>"+value.userName+"</td><td>"+value.gender+"</td><td>"+value.birthday+"</td></tr>"
                        })
                        $("tbody").html(str);
                    }
                })
            }
            $.ajax({
                url:"/user/change",
                type:"get",
                data:{pageNum:pageNum},
                dataType:"json",
                success:function(result){
                    maxPage=result.pages;
                    var str="";
                    $.each(result.records,function (index,value) {
                        str+="<tr><td>"+(index+1)+"</td><td>"+value.userName+"</td><td>"+value.gender+"</td><td>"+value.birthday+"</td></tr>"
                    })
                    $("tbody").html(str);
                }
            })
        })
    </script>
</body>
</html>
