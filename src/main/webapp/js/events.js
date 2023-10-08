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
    const el = document.querySelector('#fixed-dot')
    const target = e.target
    if (!target) return

    el.style.left = e.pageX + 'px'
    el.style.top = e.pageY + 'px'
})

document.getElementById('canvas').addEventListener('mouseenter', () => {
    document.getElementById('fixed-dot').style.display = 'block';
})

document.getElementById('canvas').addEventListener('mouseleave', () => {
    document.getElementById('fixed-dot').style.display = 'none';
})
