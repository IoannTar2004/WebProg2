function createDot(r, x, y, color) {
    const w = 123 + x/r*90;
    const h = 124 - y/r*90;
    let canvas = document.getElementById('dots');
    if (w > 0 && w < 250 && h > 0 && h < 250) {
        canvas.innerHTML += `<div class="dot" style="margin-left: ${w}px; margin-top: ${h}px; background: ${color}">`;
    }

}
function changeDot(r) {
    let dots = document.getElementById('dots');
    dots.innerHTML = '';

    let outer = document.querySelector("#result-table tbody");
    let color;

    for (let data of outer.querySelectorAll('tr')) {
        let val = data.querySelector('td').outerHTML.match(/-?\d+\.\d+|-?\d+/g);
        if (data.querySelectorAll('td')[1].outerHTML.match(/<td>(.*)<\/td>/d)[1] === 'Попал!') {
            color = 'lime';
        } else {
            color = 'red';
        }
        createDot(r, val[1], val[2], color);
    }
}