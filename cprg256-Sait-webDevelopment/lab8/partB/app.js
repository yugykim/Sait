//var xhr;
var xhr = new XMLHttpRequest();

function getRound() {
  xhr.onreadystatechange = function () {
    if (xhr.readyState == 4 && xhr.status == 200) {
      document.getElementById("displayapp").innerHTML = xhr.responseText;
    }
  };
  xhr.open("GET", "index.html", true);
  xhr.send();
}

function getRectangle() {
  xhr.onreadystatechange = function () {
    if (xhr.readyState == 4 && xhr.status == 200) {
      document.getElementById("displayapp").innerHTML = xhr.responseText;
    }
  };
  xhr.open("GET", "index.html", true);
  xhr.send();
}





