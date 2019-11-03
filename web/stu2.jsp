<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bootstrap分页</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <style>
        .myTable {
            width: 800px;
            margin: 2px auto;
            text-align: center;
        }
        .pageNum{
            width: 35px;
        }
        span {
            display: inline-block;
            font-size: 18px;
            color: #337ab7;
            text-align: center;
        }

    </style>
</head>
<body>
<div class="table-responsive myTable">
    <table class="table table-striped" >
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>card</th>
            <th>部门</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <nav aria-label="..."  >
        <ul class="pagination pagination-lg " id="fenye">
        </ul>
    </nav>
</div>

<nav aria-label="...">
    <%--<ul class="pagination" id="fenye">
        <li class="disabled"><a href="javascript:stuMgr.getStuList(1,2)" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
        <li class="active"><a href="javascript:stuMgr.getStuList(1,2)">1 <span class="sr-only">(current)</span></a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="javascript:stuMgr.getStuList(1,2)" aria-label="Next"><span aria-hidden="true">»</span></a></li>
    </ul>--%>
</nav>
<script>
    var stuMgr = {
        getStuList : function (pageNum,pageSize) {
            $.ajax({
                url:"${pageContext.request.contextPath}/getStuList",
                type:"post",
                data:{pageNum:pageNum,pageSize:pageSize},
                dataType:"json",
                success :function (data) {
                    var stuList = data.stus;
                    if (stuList!=null||stuList.length>0){
                        var htmlTable  = "";
                        for (var i = 0; i < stuList.length; i++) {
                            htmlTable = htmlTable + "<tr>";
                            htmlTable = htmlTable + "<td>";
                            htmlTable = htmlTable + stuList[i].id;
                            htmlTable = htmlTable + "</td>";
                            htmlTable = htmlTable + "<td>";
                            htmlTable = htmlTable + stuList[i].username;
                            htmlTable = htmlTable + "</td>";
                            htmlTable = htmlTable + "</td>";
                            htmlTable = htmlTable + "<td>";
                            htmlTable = htmlTable + stuList[i].card;
                            htmlTable = htmlTable + "</td>";
                            htmlTable = htmlTable + "</td>";
                            htmlTable = htmlTable + "<td>";
                            htmlTable = htmlTable + stuList[i].department;
                            htmlTable = htmlTable + "</td>";
                            htmlTable = htmlTable + "</tr>";
                        }
                        $("tbody").html(htmlTable)
                        $("#fenye").html(data.pageStr);
                    }else{
                        $("tbody").html("<tr><td colspan='4'>没有查询到数据</td></tr>")
                    }
                }
            });
        },
        gotoStuList : function (pageSize) {
            var pageNum = parseInt($('input').val());
            var pageSize = pageSize;
            stuMgr.getStuList(pageNum,pageSize);
        }
    };
    $(function () {
        stuMgr.getStuList(1,10);
    });


</script>

</body>
</html>
