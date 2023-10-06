<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Lab 1</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<div id="topbox">
    <div class="topText">Тарасов Иван Сергеевич. Группа: P3230. Вариант: 1114</div>
</div>

<div id="tablebox">
    <div id="canvas">
        <div id="dots">
        </div>
        <input type="textarea" id="dotsBuffer" style="display: none;">
        <div id="y" class="coordinate">y</div>
        <div id="x" class="coordinate">x</div>
        <div id="coorRd2_x" class="coordinate">0.5</div>
        <div id="coorR_x" class="coordinate">1</div>
        <div id="coorRd2_y" class="coordinate">0.5</div>
        <div id="coorR_y" class="coordinate">1</div>
        <div id="coor-Rd2_x" class="coordinate">-0.5</div>
        <div id="coor-R_x" class="coordinate">-1</div>
        <div id="coor-Rd2_y" class="coordinate">-0.5</div>
        <div id="coor-R_y" class="coordinate">-1</div>
        <canvas id="whiteBack" width="400" height="500"></canvas>
    </div>


    <div id="parametersbox">
        <div id="form" style="text-align: center;">
            <p class="coorhead">Изменение X</p>
            <div id="parametersx">
                <label class="checkbox">
                    <input type="checkbox" id="cb_-3" name="checkbox[]" style="transform:scale(1.3);" value="-3">-3
                </label>

                <label class="checkbox">
                    <input type="checkbox" id="cb_0" name="checkbox[]" style="transform:scale(1.3);" value="0">0
                </label>

                <label class="checkbox">
                    <input type="checkbox" id="cb_3" name="checkbox[]" style="transform:scale(1.3);" value="3">3
                </label>
                <br>
                <label class="checkbox">
                    <input type="checkbox" id="cb_-2" name="checkbox[]" style="transform:scale(1.3);" value="-2">-2
                </label>

                <label class="checkbox">
                    <input type="checkbox" id="cb_1" name="checkbox[]" style="transform:scale(1.3);" value="1">1
                </label>

                <label class="checkbox">
                    <input type="checkbox" id="cb_4" name="checkbox[]" style="transform:scale(1.3);" value="4">4
                </label>
                <br>
                <label class="checkbox">
                    <input type="checkbox" id="cb_-1" name="checkbox[]" style="transform:scale(1.3);" value="-1">-1
                </label>

                <label class="checkbox">
                    <input type="checkbox" id="cb_2" name="checkbox[]" style="transform:scale(1.3);" value="2">2
                </label>

                <label class="checkbox">
                    <input type="checkbox" id="cb_5" name="checkbox[]" style="transform:scale(1.3);" value="2">5
                </label>
            </div>

            <p class="coorhead">Изменение Y</p>
            <input type="text" id="inputY" name="inputY" style="width: 105px;" placeholder="Число от -3 до 3">

            <p class="coorhead">Изменение R</p>
            <input type="text" id="inputR" name="inputR" style="display: none;" value="1">

            <input type="button" value="1" id="b_1" name="inputR">
            <input type="button" value="1.5" id="b_1.5" name="inputR">
            <input type="button" value="2" id="b_2" name="inputR">
            <input type="button" value="2.5" id="b_2.5" name="inputR">
            <input type="button" value="3" id="b_3" name="inputR">
            <br>
            <input type="button" id="submit" value="Отправить">
        </div>
    </div>
</div>
<table>
    <thead>
    <tr>
        <th>Параметры</th>
        <th>Факт попадания</th>
        <th>Время отправки</th>
        <th>Затраченное время</th>
    </tr>
    </thead>
    <tbody id="tbody">

    </tbody>
</table>

</body>
<script src="javascripts/validation.js"></script>
<script src="javascripts/addToTable.js"></script>
<script src="javascripts/canvas.js"></script>
<script src="javascripts/dot.js"></script>
</html>