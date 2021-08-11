function task5_1() {
    var arr = document.getElementById('input1').value;
    var arr = arr.split(" ");
    alert(arr[2]);
}

function task5_2() {
    var d = new Date();
    switch (d.getDay() - 1) {
        case 0:
            res = 'Вчора була неділя';
            break;
        case 1:
            res = 'Вчора був понеділок';
            break;
        case 2:
            res = 'Вчора був вівторок';
            break;
        case 3:
            res = 'Вчора була середа';
            break;
        case 4:
            res = 'Вчора був четвер';
            break;
        case 5:
            res = 'Вчора була п\'ятниця';
            break;
        case 6:
            res = 'Вчора була субота';
            break;
    }
    alert(res);
}

function task5_3() {
    var num = document.getElementById('input3').value;
    document.getElementById('p3').innerText = Math.round(Math.sqrt(num));
    button3.onclick = function () {
        document.getElementById('p3').innerText = '';
    }
}