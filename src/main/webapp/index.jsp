<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Point" %>
<%@ page import="org.example.model.DrawDot" %>
<%@ page import="org.example.support.NumberManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Lab 2</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<div id="topbox">
    <div class="topText">Тарасов Иван Сергеевич. Группа: P3230. Вариант: 53124</div>
</div>

<div id="tablebox">
    <div id="canvas">
        <div id="dots">
            <%  List<Point> pointList = (List<Point>) request.getAttribute("points");
                if (pointList != null) {
                    for (Point point: pointList) {
                        DrawDot dot = new DrawDot(point);
                        if (dot.drawX() != -1 & dot.drawY() != -1) {%>
                            <div class="dot" style="margin-left: <%=dot.drawX()%>px; margin-top: <%=dot.drawY()%>px; background: <%=dot.color()%>; position: absolute">
                            </div>
                    <%}
                    }
                }%>
        </div>
        <input type="textarea" id="dotsBuffer" style="display: none;">
        <div id="y" class="coordinate">y</div>
        <div id="x" class="coordinate">x</div>
        <div id="coorRd2_x" class="coordinate">1</div>
        <div id="coorR_x" class="coordinate">2</div>
        <div id="coorRd2_y" class="coordinate">1</div>
        <div id="coorR_y" class="coordinate">2</div>
        <div id="coor-Rd2_x" class="coordinate">-1</div>
        <div id="coor-R_x" class="coordinate">-2</div>
        <div id="coor-Rd2_y" class="coordinate">-1</div>
        <div id="coor-R_y" class="coordinate">-2</div>
        <canvas id="whiteBack" width="400" height="500"></canvas>
    </div>


    <form id="form" action="./controller" method="post" style="text-align: center;">
    <div id="parametersbox">
            <p class="coorhead">Изменение X</p>
            <table id="parametersx">
                <tr>
                    <td>
                        <input type="checkbox" id="cb_-5" name="checkbox(-5)" style="transform:scale(1.3);" value="-5">-5
                    </td>

                    <td>
                        <input type="checkbox" id="cb_-2" name="checkbox(-2)" style="transform:scale(1.3);" value="-2">-2
                    </td>

                    <td>
                        <input type="checkbox" id="cb_1" name="checkbox(1)" style="transform:scale(1.3);" value="1">1
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" id="cb_-4" name="checkbox(-4)" style="transform:scale(1.3);" value="-4">-4
                    </td>

                    <td>
                        <input type="checkbox" id="cb_-1" name="checkbox(-1)" style="transform:scale(1.3);" value="-1">-1
                    </td>

                    <td>
                        <input type="checkbox" id="cb_2" name="checkbox(2)" style="transform:scale(1.3);" value="2">2
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" id="cb_-3" name="checkbox(-3)" style="transform:scale(1.3);" value="-3">-3
                    </td>

                    <td>
                        <input type="checkbox" id="cb_0" name="checkbox(0)" style="transform:scale(1.3);" value="0"> 0
                    </td>

                    <td>
                        <input type="checkbox" id="cb_3" name="checkbox(3)" style="transform:scale(1.3);" value="3">3
                    </td>
                </tr>
            </table>

            <p class="coorhead">Изменение Y</p>
            <input type="text" id="inputY" class="input" name="inputY" placeholder="Число от -3 до 3">

            <p class="coorhead">Изменение R</p>
            <input type="text" id="inputR" class="input" name="inputR" placeholder="Число от 2 до 5" value="2">

            <br>
            <input type="submit" id="submit" value="Отправить">
        </div>
    </form>
</div>
<table id="result-table">
    <thead>
    <tr>
        <th>Параметры</th>
        <th>Факт попадания</th>
        <th>Время отправки</th>
        <th>Затраченное время</th>
    </tr>
    </thead>
    <tbody>
        <% if (pointList != null) {
            for (Point point: pointList) { %>
            <tr>
                <td>R=<%=NumberManager.valueOf(point.getR())%>: (<%=point.getX()%>;<%=NumberManager.valueOf(point.getY())%>)</td>
                <td><%=point.getStatus()%></td>
                <td><%=request.getAttribute("currentTime")%></td>
                <td><%=point.getScriptTime()%> нс</td>
            </tr>
            <%}
            }%>
    </tbody>
</table>

</body>
<script src="js/validation.js"></script>
<script src="js/canvas.js"></script>
<script src="js/dot.js"></script>
</html>