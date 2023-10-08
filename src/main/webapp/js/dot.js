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

    let dotsBuffer = document.getElementById('dotsBuffer').value.split('|');
    dotsBuffer.pop();
    console.log(dotsBuffer);
    for(let dots of dotsBuffer) {
        let data = dots.split(',');
        createDot(r, data[0], data[1], data[2]);
    }
}