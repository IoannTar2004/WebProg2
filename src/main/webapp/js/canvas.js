function createCanvas() {
    let whiteBack = document.getElementById('whiteBack');
    let ctx = whiteBack.getContext('2d');

    let h = 250;
    let w = 250;
    let label = 45;
//задний фон
    ctx.fillStyle = 'white';
    ctx.fillRect(0, 0, h, w);

//фигуры
    ctx.fillStyle = '#42aaff';
    ctx.fillRect(w / 2, h / 2 - label * 2, label * 2, label * 2);

    ctx.beginPath();
    ctx.strokeStyle = '#42aaff';
    ctx.lineWidth = '1';
    ctx.moveTo(w / 2, h / 2);
    ctx.lineTo(w / 2 - label, h / 2);
    ctx.lineTo(w / 2, h / 2 + label);
    ctx.stroke();
    ctx.closePath();
    ctx.fill();

    ctx.beginPath();
    ctx.arc(w / 2, h / 2, label * 2, 0, Math.PI / 2, false);
    ctx.moveTo(w / 2 + label * 2, h / 2);
    ctx.lineTo(w / 2, h / 2 + label * 2);
    ctx.lineTo(w / 2, h / 2);
    ctx.stroke();
    ctx.closePath();
    ctx.fill();

//координатные оси
    ctx.beginPath();
    ctx.strokeStyle = 'black';
    ctx.lineWidth = '1';
    ctx.moveTo(w / 2, 0);
    ctx.lineTo(w / 2, h);
    ctx.stroke();

    ctx.moveTo(0, h / 2);
    ctx.lineTo(w, h / 2);
    ctx.stroke();

//стрелки
    ctx.moveTo(w / 2, 0);
    ctx.lineTo(w / 2 - 5, 10);
    ctx.stroke();

    ctx.moveTo(w / 2, 0);
    ctx.lineTo(w / 2 + 5, 10);
    ctx.stroke();

    ctx.moveTo(w, h / 2);
    ctx.lineTo(w - 10, h / 2 - 5);
    ctx.stroke();

    ctx.moveTo(w, h / 2);
    ctx.lineTo(w - 10, h / 2 + 5);
    ctx.stroke();

//метки
    ctx.moveTo(w / 2 + label, h / 2 + 4);
    ctx.lineTo(w / 2 + label, h / 2 - 4);
    ctx.stroke();

    ctx.moveTo(w / 2 + label * 2, h / 2 + 4);
    ctx.lineTo(w / 2 + label * 2, h / 2 - 4);
    ctx.stroke();

    ctx.moveTo(w / 2 - 4, h / 2 - label);
    ctx.lineTo(w / 2 + 4, h / 2 - label);
    ctx.stroke();

    ctx.moveTo(w / 2 - 4, h / 2 - label * 2);
    ctx.lineTo(w / 2 + 4, h / 2 - label * 2);
    ctx.stroke();

    ctx.moveTo(w / 2 - label, h / 2 + 4);
    ctx.lineTo(w / 2 - label, h / 2 - 4);
    ctx.stroke();

    ctx.moveTo(w / 2 - label * 2, h / 2 + 4);
    ctx.lineTo(w / 2 - label * 2, h / 2 - 4);
    ctx.stroke();

    ctx.moveTo(w / 2 - 4, h / 2 + label);
    ctx.lineTo(w / 2 + 4, h / 2 + label);
    ctx.stroke();

    ctx.moveTo(w / 2 - 4, h / 2 + label * 2);
    ctx.lineTo(w / 2 + 4, h / 2 + label * 2);
    ctx.closePath();
    ctx.stroke();
}

createCanvas();