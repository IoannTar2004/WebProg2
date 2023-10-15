function events() {
    function setCoordinates(i) {
        document.getElementById('coorRd2_x').innerHTML = i / 2;
        document.getElementById('coorR_x').innerHTML = i;
        document.getElementById('coorRd2_y').innerHTML = i / 2;
        document.getElementById('coorR_y').innerHTML = i;
        document.getElementById('coor-Rd2_x').innerHTML = -i / 2;
        document.getElementById('coor-R_x').innerHTML = -i;
        document.getElementById('coor-Rd2_y').innerHTML = -i / 2;
        document.getElementById('coor-R_y').innerHTML = -i;
    }

    document.getElementById('inputR').addEventListener('input', () => {
        let i = parseFloat(document.getElementById('inputR').value);
        if (!isNaN(i) && i.toString().length < 5) {
            setCoordinates(i)
            changeDot(i);
        } else if (isNaN(i)) {
            setCoordinates(0)
        }
    });

    window.addEventListener('mousemove', e => {
        const el = document.querySelector('#fixed-dot');
        const target = e.target;
        if (!target) return;

        el.style.left = e.pageX + 'px'
        el.style.top = e.pageY + 'px';
    })

    document.getElementById('canvas').addEventListener('mouseenter', () => {
        document.getElementById('fixed-dot').style.display = 'block';
    })

    document.getElementById('canvas').addEventListener('mouseleave', () => {
        document.getElementById('fixed-dot').style.display = 'none';
    })

    document.getElementById('canvas').addEventListener('click', function (event) {
        let r = document.getElementById("inputR").value;
        let x = r * (event.pageX - 243) / 90;
        let y = r * (event.pageY - 444) / -90;

        if (x - Math.floor(x) >= 0.95 || x - Math.floor(x) <= 0.05) {
            x = Math.round(x);
        }
        if (y - Math.floor(y) >= 0.95 || y - Math.floor(y) <= 0.05) {
            y = Math.round(y);
        }

        if (testCoordinates(x, y) !== '') {
            alert(testCoordinates(x, y));
        } else {
            let arrX = [];
            arrX.push(String(x));
            ajax('POST', './controller',[x], y, r);
        }
    });

    function testCoordinates(x, y) {
        let message = '';
        if (x <= -5 || x >= 3) {
            message += `Точка (${x}; ${y}) не попала в область ОДЗ x!\n`
        }
        if (y <= -5 || y >= 3) {
            message += `Точка (${x}; ${y}) не попала в область ОДЗ y!\n`
        }
        if (document.getElementById("inputR").value < 2 || (document.getElementById("inputR").value > 5)) {
            message += 'Введите R от -5 до 3!';
        }

        return message;
    }

    window.onload =  function () {
        console.log("yes");
        ajax('POST', './controller',0, 0, 0);
    };
}

function ajax(method, action, x, y, r) {
    let data = {
        inputX: x,
        inputY: y,
        inputR: r,
    };

    let xhr = new XMLHttpRequest;

    xhr.open('POST', action, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.send('data=' + JSON.stringify(data));
    xhr.onload = function () {
        document.body.innerHTML = xhr.responseText;
        createCanvas();
        events();
        validation();
    }
}

events();