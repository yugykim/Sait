let customerlist = {};
const submitButton = document.querySelector("#submit");
const form = document.querySelector("#form");
const edit = document.querySelector("#edit");

let addNewCustomerID = 0;
form.addEventListener("submit", formSubmit);

function formSubmit(event) {
  event.preventDefault();
  addNewDatainObject();
  addNewCustomerID++;
}

function addNewDatainObject(index) {
  let element = {};
  let crateNewCustomerInfoArr = [];
  let newSelectItemString = "";
  index = index === undefined ? addNewCustomerID : index;

  const entries = Object.entries(form);

  for (var i = 0; i < entries.length; i++) {
    if (entries[i][1].type === "radio" && !entries[i][1].checked
      || entries[i][1].type === "checkbox" && !entries[i][1].checked 
      || entries[i][1].value === "Submit") {
    } else {
      if (entries[i][1].id !== "selectItems") {
        element[entries[i][1].name] = entries[i][1].value;
        entries[i][1].value = ""
      } else {
        console.log("test");
        newSelectItemString += entries[i][1].value + " ";
        entries[i][1].value = ""
      }
    }
  }
  element['SelectItems'] = newSelectItemString;
  crateNewCustomerInfoArr.push(element);
  customerlist[index] = crateNewCustomerInfoArr;
  displayInfo();
}

function displayInfo() {
  const dispalyInfo = document.querySelector("#displayInfo");
  const yourInfo = document.querySelector("#yourInfo");

  dispalyInfo.hidden = false;

  yourInfo.innerHTML = "";
  const form = Object.entries(customerlist);
  for (var i = 0; i < form.length; i++) {
    for (var k = 1; k < form[i].length; k++) {
      yourInfo.innerHTML += `<input type="radio" name="userInfoSelect" value="" id="${i}" onclick="checkDisabledButtons()" /><p>INFO : <br /> Date: ${form[i][k][0].Date} 
        <br /> First name: ${form[i][k][0].Firstname} 
        <br /> Last name: ${form[i][k][0].Lastname} 
        <br /> Address: ${form[i][k][0].Address} 
        <br /> PostalCode: ${form[i][k][0].PostalCode} 
        <br /> Home Type: ${form[i][k][0].HomeType} 
        <br /> Income: ${form[i][k][0].Income} 
        <br /> Select Items: ${form[i][k][0].SelectItems} 
        <br /> Are you current clinets?: ${form[i][k][0].currentStatus}
        <br /> Email:  ${form[i][k][0].Email}
        <br /> PhoneType: ${form[i][k][0].PhoneType} 
        <br /> PhoneNumber: ${form[i][k][0].PhoneNumber} 
        <br /> AGE: ${form[i][k][0].age}<p>`;
    }
  }
}

edit.addEventListener("click", setClientObject);

function checkDisabledButtons() {
  submitButton.disabled = !submitButton.disabled;
  edit.disabled = !edit.disabled;
}

function setClientObject() {
  checkDisabledButtons();
  const checkedYourInfoInput = document.querySelectorAll("#yourInfo input[type=radio]:checked");
  let editUserInfoDataIndex = parseInt(checkedYourInfoInput[0].id);
  delete customerlist[editUserInfoDataIndex];
  displayInfo();
}

