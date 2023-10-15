
function validation() {
    document.getElementById('submit').addEventListener('click', (e) => {
        let x = [];
        let message = '';
        let alertt = false;

        for (let i = -5; i <= 3; i++) {
            let dataX = document.getElementById(`cb_${i}`);
            if (dataX.checked) {
                x.push(dataX.value);
            }
        }
        if (x.length === 0) {
            message += 'Выберите хотя бы одно значение X!\n';
            alertt = true;
        }

        let y = document.getElementById('inputY').value;
        if (!/\d/.test(y) || y < -5 || y > 3) {
            message += 'Введите Y от -5 до 3!';
            alertt = true;
        }

        let r = document.getElementById('inputR').value;
        if (!/\d/.test(r) || r < 2 || r > 5) {
            message += 'Введите R от 2 до 5!';
            alertt = true;
        }

        if (alertt) {
            alert(message);
            e.preventDefault();
        } else {
            ajax('POST', './controller', x, y, r);
        }
    });
}

validation();