<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>标题stu.jsp</title>
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
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>card</th>
                    <th>部门</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="stu" items="${pageBean.list}">
                    <tr>
                        <td>${stu.id}</td>
                        <td>${stu.username}</td>
                        <td>${stu.card}</td>
                        <td>${stu.department}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="fenye">
        <c:if test="${pageBean.pageNum!=1}">
            <a href="${pageContext.request.contextPath}/getStuList?pageNum=1&pageSize=${pageBean.pageSize}" >首页</a>
        </c:if>
        <c:if test="${pageBean.pageNum>1&&pageBean.pageNum<=pageBean.totalPage}">
            <a  href="${pageContext.request.contextPath}/getStuList?pageNum=${pageBean.pageNum-1}&pageSize=${pageBean.pageSize}" >上一页</a>
        </c:if>
        <c:forEach begin="${pageBean.startIndex}" end="${pageBean.endIndex}" var="p" >
            <c:if test="${p==pageBean.pageNum}">
                <a class="select" href="${pageContext.request.contextPath}/getStuList?pageNum=${p}&pageSize=${pageBean.pageSize}" >${p}</a>
            </c:if>
            <c:if test="${p!=pageBean.pageNum}">
                <a class="bule" href="${pageContext.request.contextPath}/getStuList?pageNum=${p}&pageSize=${pageBean.pageSize}" >${p}</a>
            </c:if>
        </c:forEach>
        <c:if test="${pageBean.pageNum<pageBean.totalPage}">
            <a href="${pageContext.request.contextPath}/getStuList?pageNum=${pageBean.pageNum+1}&pageSize=${pageBean.pageSize}" >下一页</a>
        </c:if>
        <c:if test="${pageBean.pageNum!=pageBean.totalPage}">
            <a href="${pageContext.request.contextPath}/getStuList?pageNum=${pageBean.totalPage}&pageSize=${pageBean.pageSize}" >尾页</a>
        </c:if>
        <label>共${pageBean.totalPage}页,当前第${pageBean.pageNum}页,共${pageBean.totalCount}条数据</label>
    </div>


</body>
</html>
