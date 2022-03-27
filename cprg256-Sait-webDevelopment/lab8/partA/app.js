 
window.addEventListener("load", registerListeners, false);
var asynchrequest;

function registerListeners() {
	
	var fig;
	fig=document.getElementById("fig1");
	fig.addEventListener("mouseover", function () { getContent("pic1.html");}, false);
	fig.addEventListener("mouseout", clearContent, false);
	fig=document.getElementById("fig2");
	fig.addEventListener("mouseover", function () { getContent("pic2.html");}, false);
	fig.addEventListener("mouseout", clearContent, false);
	fig=document.getElementById("fig3");
	fig.addEventListener("mouseover", function () { getContent("pic3.html");}, false);
	fig.addEventListener("mouseout", clearContent, false);
}

function getContent(infopage) {

		asynchrequest= new XMLHttpRequest();
		asynchrequest.onreadystatechange = function() {
    if (asynchrequest.readyState == 4 && asynchrequest.status == 200) {
      document.getElementById("info").innerHTML = asynchrequest.responseText;
    }
  };
  asynchrequest.open("GET", infopage, true);
  asynchrequest.send();
}


function clearContent() {
	
	document.getElementById("info").innerHTML="";

}