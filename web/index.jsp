<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>标题index.jsp</title>
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
  <style>
    #box {
      width: 300px;
      margin: 0 auto;
    }
    #fenye {
      width: 400px;
      margin: 10px auto;
    }
    .bule{
      color: blue;
    }
    .select{
      color: red;
      font-size: 18px;
    }

  </style>
</head>
<body>
<div id="box">
  <table border="1" style="width: 100%;">
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
  <nav aria-label="..." class="myTable"  style="margin: 0 auto;" >
    <ul class="pagination pagination-lg " id="fenye">
    </ul>
  </nav>
</div>

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
        }
    };
    $(function () {
      stuMgr.getStuList(1,10);
    });


  </script>



</body>
</html>
