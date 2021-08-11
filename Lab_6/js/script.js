// 25.[16, 29, 33, 2, 8]



function task2() {
    var arr = document.getElementById("input1").value;
    var arr = arr.split(",");
    let regexp = /[-.\w]+@([\w-]+\.)+[\w-]+/g;
    for (var i = 0; i < arr.length; i++) {
        document.getElementById('p1').innerText = (arr[i].match(regexp)) + '\n';
    }
    button1.onclick = function () {
        document.getElementById('p1').innerText = '';
    }
}



function task8() {
    var arr = document.getElementById("input2").value;
    var arr = arr.split(",");
    let regexp = /[0-9]{1,12}/;
    document.getElementById('p2').innerHTML = (regexp.test(arr)) + '\n';
    button2.onclick = function () {
        document.getElementById('p2').innerText = '';
    }
}


function task16() {
    var arr = document.getElementById("input3").value;
    var arr = arr.split(" ");
    var array = [];
    var t = 0;
    let regexp = /a[0-9]a/;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].match(regexp)) {
            array[t] = arr[i];
            t++
        }
    }
    document.getElementById('p3').innerHTML = array;
    button3.onclick = function () {
        document.getElementById('p3').innerText = '';
    }
}


function task29() {
    var arr = $("#input4").val();
    var regexp = /\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b/g;
    $("#p4").text("Введені дані є IP : " + regexp.test(arr));
    button4.onclick = function () {
        document.getElementById('p4').innerText = '';
    }
}

function task33() {
    var inputDate = document.getElementById("input5").value;
    var num = inputDate.replace(/\B(?=(\d{3})+(?!\d))/g, "_");
    document.getElementById("p5").innerText = num;
}